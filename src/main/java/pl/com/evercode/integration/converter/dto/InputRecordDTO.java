package pl.com.evercode.integration.converter.dto;

import java.util.List;

/**
 * Created by macx on 13.09.16.
 */
public class InputRecordDTO {

    private Character element;
    private List<String> values;

    public InputRecordDTO(Character element, List<String> values) {
        this.element = element;
        this.values = values;
    }

    public Character getElement() {
        return element;
    }

    public void setElement(Character element) {
        this.element = element;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "InputRecordDTO{" +
                "element=" + element +
                ", values=" + values +
                '}';
    }
}
