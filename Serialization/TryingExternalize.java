package Serialization;

/*Реализуй интерфейс Externalizable в классе Apartment.

Требования:
•	Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
•	В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
•	В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
•	В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
•	В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
•	Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
•	Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year*/

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;



public class TryingExternalize {
    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

            out.writeObject(address);
            out.writeInt(year);

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();

        }
    }

    public static void main(String[] args) {

    }
}
