package homework9;

import java.io.Serializable;

public class Student implements Serializable {
    private static StringBuffer strBuf = new StringBuffer();
    private String firstName;
    private String surname;
    private String fathersName;
    private int mark;
    private String fio;

    public Student(String firstName, String surname,
                   String fathersName, int mark) {
        this.firstName = firstName == null ? "" : firstName;
        this.surname = surname == null ? "" : surname;
        this.fathersName = fathersName == null ? "" : fathersName;
        this.mark = mark;

        strBuf.append(this.surname).append(" ")
                .append(this.firstName)
                .append(" ").append(this.fathersName);
        this.fio = strBuf.toString();
        strBuf.delete(0, strBuf.length());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFathersName() {
        return fathersName;
    }

    public int getMark() {
        return mark;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mark=" + mark +
                ", fio='" + fio + '\'' +
                '}';
    }
}
