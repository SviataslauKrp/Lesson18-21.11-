public class Main {

    final static String sourcePath = "C:\\Users\\user\\Desktop\\Java projects\\Lesson18-21.11-\\src\\xmls\\persons.xml";
    final static String pathTo = "src/xmls/destination.txt";

    public static void main(String[] args) {
        Persons persons = new Persons();
        persons.add(new Person("Игорь", "Иванов", "дворник"));
        System.out.println(persons);
        JAXBreader jaxBreader = new JAXBreader();
        jaxBreader.read(sourcePath);

    }
}