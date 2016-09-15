package pl.com.evercode.integration.converter.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by macx on 14.09.16.
 */

@XmlRootElement
public class People {

    public People(){

    }

    public People(List<Person> people) {
        this.people = people;
    }

    private List<Person> people;

    public List<Person> getPeople() {
        return people;
    }

    @XmlElement(name="person")
    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
