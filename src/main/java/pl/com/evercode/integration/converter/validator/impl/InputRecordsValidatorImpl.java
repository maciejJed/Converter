package pl.com.evercode.integration.converter.validator.impl;

import pl.com.evercode.integration.converter.dto.InputRecordDTO;
import pl.com.evercode.integration.converter.exception.ConverterException;
import pl.com.evercode.integration.converter.exception.ExceptionMessages;
import pl.com.evercode.integration.converter.validator.Validator;
import java.util.List;

/**
 * Created by macx on 13.09.16.
 */
public class InputRecordsValidatorImpl implements Validator {

    public void validate(List<InputRecordDTO> inputRecords) throws ConverterException {
        validatePersonElement(inputRecords);

    }

    private void validatePersonElement(List<InputRecordDTO> inputRecords) throws ConverterException {
        InputRecordDTO inputRecordDTO = inputRecords.get(0);
        if (!inputRecordDTO.getElement().equals('P')) {
            throw new ConverterException(ExceptionMessages.INPUT_MUST_START_WITH_PERSON_ELEMENT);
        }

        for(InputRecordDTO inputRecord : inputRecords){
            if(inputRecord.getElement().equals('P') && inputRecord.getValues().size() != 2){
                throw new ConverterException(ExceptionMessages.PERSON_MUST_HAVE_NAME_AND_SURNAME);
            }
        }
    }
}
