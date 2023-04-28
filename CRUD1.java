import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CRUD1 {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        if (args == null || args.length < 1){
            throw new RuntimeException();
        }

        Person person;
        Date birthDate;

        switch (args[0]){
            case "-c":
                birthDate = simpleDateFormat.parse(args[3]);

                if (args[2].equals("м")) person = Person.createMale(args[1],birthDate);
                else person = Person.createFemale(args[1], birthDate);

                allPeople.add(person);
                System.out.println(allPeople.size() - 1);
                break;

            case "-r":
                person = allPeople.get(Integer.parseInt(args[1]));

                if (person != null){
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE? "м":"ж")+ " "+simpleDateFormat2.format(person.getBirthDate()));
                }
                break;

            case "-u":
                birthDate = simpleDateFormat.parse(args[4]);
                int id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                if (person == null) throw new IllegalArgumentException();
                person.setBirthDate(birthDate);
                person.setName(args[2]);
                person.setSex(args[3] == "м"? Sex.MALE : Sex.FEMALE);
                allPeople.set(id,person);
                break;

            case "-d":
                Person currentPerson = allPeople.get(Integer.parseInt(args[1]));
                currentPerson.setName(null);
                currentPerson.setSex(null);
                currentPerson.setBirthDate(null);
                break;


        }


    }

    /*public static Sex getSex(String sexParam){

    }*/
}
