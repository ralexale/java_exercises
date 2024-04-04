package entities;

public class Doctor {
    private int id;
    private String name;
    private String lastName;
    private int specialtyId;

    private Specialty specialty;

    public Doctor() {
    }

    public Doctor(int id, String name, String lastName, int specialtyId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialtyId = specialtyId;
    }

    public Doctor(int id, String name, String lastName, int specialtyId, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialtyId = specialtyId;
        this.specialty = specialty;
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

    public int getspecialtyId() {
        return specialtyId;
    }

    public void setspecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialtyId=" + specialtyId +
                '}';
    }
}
