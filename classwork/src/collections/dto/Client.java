package collections.dto;

import java.util.Date;
import java.util.Objects;

public class Client {
    private String id;
    private String name;
    private Date startDay;
    private Gender gender;

    public Client(Passport passport) {
        this.id = passport.getId();
        this.name = passport.getName();
        this.startDay = passport.getStartDay();
        this.gender = passport.getGender();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDay=" + startDay +
                ", gender=" + gender +
                '}';
    }
}
