package jaxb.model;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)


public class Organization {

    private String orgNo;
    private String orgName;
    private String location;


    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;


    public Organization() {

    }

    public Organization(String orgNo, String orgName, String location) {
        this.orgNo = orgNo;
        this.orgName = orgName;
        this.location = location;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
