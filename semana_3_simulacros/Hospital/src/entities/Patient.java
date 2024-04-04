package entities;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String lastName;
    private Date dateBirth;
    private String identityCard;

    public Patient() {
    }

    public Patient(int id, String name, String lastName, Date dateBirth, String identityCard) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.identityCard = identityCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }
}
