package pl.com.evercode.integration.converter.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by macx on 12.09.16.
 */

@XmlRootElement
@XmlType(propOrder={"mobileNumber","fixedNumber"})
public class Phone implements Serializable{

    private String mobileNumber;
    private String fixedNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    @XmlElement
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFixedNumber() {
        return fixedNumber;
    }

    @XmlElement
    public void setFixedNumber(String fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", fixedNumber='" + fixedNumber + '\'' +
                '}';
    }
}
