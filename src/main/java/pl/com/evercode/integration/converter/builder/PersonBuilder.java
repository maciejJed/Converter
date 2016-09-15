package pl.com.evercode.integration.converter.builder;

import pl.com.evercode.integration.converter.domain.Address;
import pl.com.evercode.integration.converter.domain.FamilyMember;
import pl.com.evercode.integration.converter.domain.Person;
import pl.com.evercode.integration.converter.domain.Phone;

import java.util.List;

/**
 * Created by macx on 13.09.16.
 */
public class PersonBuilder {

    private String firstName;
    private String lastName;
    private Address address;
    private Phone phone;
    private List<FamilyMember> familyMembers;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<FamilyMember> getFamilyMemgbers(){
        return familyMembers;
    }

    public Person build(){
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        person.setAddress(this.address);
        person.setPhone(this.phone);
        person.setFamilyMembers(this.familyMembers);

        return person;
    }


}
