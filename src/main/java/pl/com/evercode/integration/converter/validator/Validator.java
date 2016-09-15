package pl.com.evercode.integration.converter.validator;

import pl.com.evercode.integration.converter.dto.InputRecordDTO;
import pl.com.evercode.integration.converter.exception.ConverterException;

import java.util.List;

/**
 * Created by macx on 13.09.16.
 */
public interface Validator {

    void validate(List<InputRecordDTO> input) throws ConverterException;
}
