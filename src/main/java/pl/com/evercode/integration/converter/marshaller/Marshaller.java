package pl.com.evercode.integration.converter.marshaller;

import pl.com.evercode.integration.converter.exception.ConverterException;
import pl.com.evercode.integration.converter.domain.People;

/**
 * Created by macx on 14.09.16.
 */
public interface Marshaller{

    String marshall(People people) throws ConverterException;

}
