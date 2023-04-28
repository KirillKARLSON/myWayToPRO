package WorkWithFile.NullObjectPattern;

/*Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.

Требования:
•	Конструктор Solution должен инициализировать поле fileData объектом ConcreteFileData.
•	Если в конструкторе Solution возникла ошибка, нужно инициализировать поле fileData объектом NullFileData.
•	Конструктор Solution должен корректно устанавливать значение поля hidden у объекта ConcreteFileData.
•	Конструктор Solution должен корректно устанавливать значение поля executable у объекта ConcreteFileData.
•	Конструктор Solution должен корректно устанавливать значение поля directory у объекта ConcreteFileData.
•	Конструктор Solution должен корректно устанавливать значение поля writable у объекта ConcreteFileData*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sol {
    private FileData fileData;

    public Sol(String pathToFile) {
        try{

            Path path = Paths.get(pathToFile);

            fileData = new ConcreteFileData(Files.isHidden(path), Files.isExecutable(path), Files.isDirectory(path), Files.isWritable(path));
        }catch (Exception e){
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
