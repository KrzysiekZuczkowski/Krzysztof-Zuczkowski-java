package com.kodilla.testing.library;

public class LibraryUser {

    private String firstname;
    private String lastname;
    private String peselId;

    public LibraryUser(String firstname, String lastname, String peselId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    public String getFirstname() {
        return firstname;
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

    public String getPeselId() {
        return peselId;
    }

    public void setPeselId(String peselId) {
        this.peselId = peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryUser)) return false;

        LibraryUser that = (LibraryUser) o;

        if (getFirstname() != null ? !getFirstname().equals(that.getFirstname()) : that.getFirstname() != null)
            return false;
        if (getLastname() != null ? !getLastname().equals(that.getLastname()) : that.getLastname() != null)
            return false;
        return getPeselId() != null ? getPeselId().equals(that.getPeselId()) : that.getPeselId() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstname() != null ? getFirstname().hashCode() : 0;
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getPeselId() != null ? getPeselId().hashCode() : 0);
        return result;
    }
}
