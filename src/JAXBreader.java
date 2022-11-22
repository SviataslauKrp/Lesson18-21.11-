import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class JAXBreader {

    public void read(String file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(new File(file));
            System.out.println(persons);

        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void write() {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Marshaller m = context.createMarshaller();
            Persons st = new Persons() {
                {
                    Person s = new Person("gochette", "Klimenko", "mmf");
                    this.add(s);
                    // добавление второго студента
                    Person a = new Person("ivette", "Teran", "mmf");
                    this.add(s);
                }
            };
            m.marshal(st, new FileOutputStream("C:\\Users\\user\\Desktop\\Java projects\\Lesson18-21.11-\\src\\xmls\\studs_marsh.xml"));
            m.marshal(st, System.out); // копия на консоль
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
