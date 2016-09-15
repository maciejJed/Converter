package pl.com.evercode.integration.converter.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by macx on 12.09.16.
 */

@XmlRootElement
@XmlType(propOrder={"name","yearOfBirth", "phone", "address"})
public class FamilyMember implements Serializable {

    private String name;
    private Integer yearOfBirth;
    private Phone phone;
    private Address address;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    @XmlElement
    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Phone getPhone() {
        return phone;
    }

    @XmlElement
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }
}
