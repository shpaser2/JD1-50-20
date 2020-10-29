package streamapi;

import annotation.Version;

@Version(info = "Данный класс предназначен для хранения информации о пользователе")
public class Person {

    @Version(info = "Поле для хранение пароля")
    private final String password;

    public Person(@Version(info = "blabla") String password) {
        this.password = password;
    }

    protected String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "password='" + password + '\'' +
                '}';
    }
}
