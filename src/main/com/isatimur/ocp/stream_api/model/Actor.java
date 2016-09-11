package com.isatimur.ocp.stream_api.model;

/**
 * Created by Isa Timur on 7/12/16.
 */
public class Actor {
    public String lastName, firstName;

    public Actor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Actor actor = (Actor)o;

        if (lastName != null ? !lastName.equals(actor.lastName) : actor.lastName != null)
            return false;
        return firstName != null ? firstName.equals(actor.firstName) : actor.firstName == null;

    }

    @Override public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "Actor{" +
            "lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
    }
}
