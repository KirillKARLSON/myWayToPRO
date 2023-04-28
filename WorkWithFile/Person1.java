package WorkWithFile;

import java.util.Date;

public class Person1 {
    String name;
    Date birthDate;

    public Person1(String name, Date birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
