package model;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return "{" + "\n"+
                "   id: '" + id + "', \n" +
                "   firstName:'" + firstName + "', \n" +
                "   lastName:'" + lastName + "', \n" +
                "   email:'" + email + "', \n" +
                '}';
    }

    public User(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
