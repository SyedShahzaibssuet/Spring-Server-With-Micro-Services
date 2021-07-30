package org.java.avanza.Model;

public class RegistrationUpdateModel {
    private Integer ID;
    private String firstname;
    private String lastname;
    public String getFirstname() {
        return firstname;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
