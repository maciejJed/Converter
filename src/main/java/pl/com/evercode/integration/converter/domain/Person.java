package pl.com.evercode.integration.converter.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by macx on 12.09.16.
 */

@XmlRootElement
@XmlType(propOrder={"firstName","lastName", "address", "phone", "familyMembers"})
public class Person implements Serializable{

    private String firstName;
    private String lastName;
    private Address address;
    private Phone phone;
    private List<FamilyMember> familyMembers;

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    @XmlElement
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    @XmlElement(name = "family")
    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", familyMembers=" + familyMembers +
                '}';
    }
}
