package pl.com.evercode.integration.converter.marshaller.impl;

import pl.com.evercode.integration.converter.exception.ConverterException;
import pl.com.evercode.integration.converter.exception.ExceptionMessages;
import pl.com.evercode.integration.converter.marshaller.Marshaller;
import pl.com.evercode.integration.converter.domain.People;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringWriter;

/**
 * Created by macx on 14.09.16.
 */
public class JaxbMarshallerImpl implements Marshaller {

    public String marshall(People people) throws ConverterException {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(people, sw);
            String xmlString = sw.toString();
            return xmlString;

        }catch(JAXBException e){
            throw new ConverterException(ExceptionMessages.XML_PARSING_EXCEPTION, e);
        }
    }
}
