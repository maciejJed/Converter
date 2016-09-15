package pl.com.evercode.integration.converter;

import pl.com.evercode.integration.converter.exception.ConverterException;

/**
 * Created by macx on 12.09.16.
 */
public interface Converter {

    String convert(String input) throws ConverterException;
}
