package DataBase.models;


import java.util.Objects;

public class Person {

    public Integer id;
    public String jobTitle;
    public String firstNameLastName;
    public String phone;
    public String email;
    public String numDomains;

    public Person(Integer id, String jobTitle, String firstNameLastName, String phone, String email, String numDomains) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
        this.numDomains = numDomains;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public void setFirstNameLastName(String firstNameLastName) {
        this.firstNameLastName = firstNameLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumDomains() {
        return numDomains;
    }

    public void setNumDomains(String numDomains) {
        this.numDomains = numDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && firstNameLastName.equals(person.firstNameLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstNameLastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", firstNameLastName='" + firstNameLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", numDomains='" + numDomains + '\'' +
                '}';
    }
}
