package com.example.test_1.testappli1;

public class Person {
    private String firstName;
    private String lastName;
    private int avatarColor;

    public Person(String firstName, String lastName, int avatarColor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarColor = avatarColor;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatarColor='" + avatarColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (avatarColor != person.avatarColor) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null)
            return false;
        return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + avatarColor;
        return result;
    }
}