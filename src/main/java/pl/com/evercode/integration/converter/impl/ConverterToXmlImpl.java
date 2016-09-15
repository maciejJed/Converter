package pl.com.evercode.integration.converter.impl;

import pl.com.evercode.integration.converter.Converter;
import pl.com.evercode.integration.converter.builder.PersonBuilder;
import pl.com.evercode.integration.converter.exception.ConverterException;
import pl.com.evercode.integration.converter.exception.ExceptionMessages;
import pl.com.evercode.integration.converter.marshaller.Marshaller;
import pl.com.evercode.integration.converter.marshaller.impl.JaxbMarshallerImpl;
import pl.com.evercode.integration.converter.validator.Validator;
import pl.com.evercode.integration.converter.validator.impl.InputRecordsValidatorImpl;
import pl.com.evercode.integration.converter.domain.*;
import pl.com.evercode.integration.converter.dto.InputRecordDTO;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by macx on 12.09.16.
 */
public class ConverterToXmlImpl implements Converter {

    private Validator validator;
    private Marshaller marshaller;

    public ConverterToXmlImpl(){
        validator = new InputRecordsValidatorImpl();
        marshaller = new JaxbMarshallerImpl();
    }

    public String convert(String input) throws ConverterException {
        List<InputRecordDTO> inputRecords = getInputRecords(input);
        validateInputRecords(inputRecords);
        List<Person> personList = getPeople(inputRecords);

        return getXmlOutput(new People(personList));
    }

    private String getXmlOutput(People people) throws ConverterException{
        return marshaller.marshall(people);
    }

    private List<Person> getPeople(List<InputRecordDTO> inputRecords) throws ConverterException{
        List<Person> result = new LinkedList<Person>();
        PersonBuilder personBuilder = null;
        PersonBuilder personBuilderPrevious = null;
        Boolean isFamilyProperty = false;

        Iterator<InputRecordDTO> iter = inputRecords.iterator();
        while(iter.hasNext()){
            InputRecordDTO inputRecord = iter.next();
            switch (inputRecord.getElement()){
                case 'P' : {
                    personBuilderPrevious = personBuilder;
                    personBuilder = new PersonBuilder();
                    isFamilyProperty = false;

                    personBuilder.setFirstName(inputRecord.getValues().get(0));
                    personBuilder.setLastName(inputRecord.getValues().get(1));
                    break;
                }
                case 'F' : {
                    isFamilyProperty = true;
                    FamilyMember familyMember = new FamilyMember();
                    familyMember.setName(inputRecord.getValues().get(0));
                    familyMember.setYearOfBirth(Integer.valueOf(inputRecord.getValues().get(1)));
                    List<FamilyMember> familyMembers = personBuilder.getFamilyMemgbers() == null
                            ? new LinkedList<FamilyMember>()
                            : personBuilder.getFamilyMemgbers();
                    familyMembers.add(familyMember);
                    personBuilder.setFamilyMembers(familyMembers);

                    break;
                }
                case 'T' : {
                    if(isFamilyProperty){
                        FamilyMember familyMember = getLastAddedFamilyMember(personBuilder);
                        familyMember.setPhone(preparePhoneFromInputRecord(inputRecord));
                    }else{
                        personBuilder.setPhone(preparePhoneFromInputRecord(inputRecord));
                    }
                    break;
                }
                case 'A' : {
                    if(isFamilyProperty){
                        FamilyMember familyMember = getLastAddedFamilyMember(personBuilder);
                        familyMember.setAddress(prepareAddressFromInputRecord(inputRecord));
                    }else{
                        personBuilder.setAddress(prepareAddressFromInputRecord(inputRecord));
                    }
                    break;
                }

            }
            if(!iter.hasNext()){
                result.add(personBuilder.build());
            }
            if(inputRecord.getElement().equals('P') && personBuilderPrevious != null){
                result.add(personBuilderPrevious.build());
            }
        }
        return result;
    }

    private Phone preparePhoneFromInputRecord(InputRecordDTO inputRecord){
        Phone phone = new Phone();
        phone.setMobileNumber(inputRecord.getValues().get(0));
        if(inputRecord.getValues().size() == 2){
            phone.setFixedNumber(inputRecord.getValues().get(1));
        }
        return phone;
    }

    private Address prepareAddressFromInputRecord(InputRecordDTO inputRecord){
        Address address = new Address();
        address.setStreet(inputRecord.getValues().get(0));
        address.setCity(inputRecord.getValues().get(1));
        if(inputRecord.getValues().size() == 3){
            address.setPostalCode(inputRecord.getValues().get(2));
        }
        return address;
    }

    private void validateInputRecords(List<InputRecordDTO> inputRecords) throws ConverterException{
        validator.validate(inputRecords);
    }

    private List<InputRecordDTO> getInputRecords(String input) throws ConverterException{
        List<InputRecordDTO> result = new LinkedList<InputRecordDTO>();
        String[] records = input.split(System.getProperty("line.separator"));
        for (String record : records) {
            result.add(getInputRecord(record.trim().split("\\|")));
        }

        return result;
    }

    private InputRecordDTO getInputRecord(String[] rowElements) throws ConverterException{
        String e = rowElements[0].trim();
        if(e.length() != 1){
            throw new ConverterException(ExceptionMessages.WRONG_INPUT_FORMAT_EXCEPTION);
        }
        Character element = e.charAt(0);
        List<String> values = new LinkedList<String>();
        for(int i = 1; i < rowElements.length; ++i){
            values.add(rowElements[i].trim());
        }
        return new InputRecordDTO(element, values);
    }

    private FamilyMember getLastAddedFamilyMember(PersonBuilder personBuilder){
        return personBuilder.getFamilyMemgbers().get(personBuilder.getFamilyMemgbers().size()-1);
    }
}
