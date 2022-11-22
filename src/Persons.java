import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
class Persons {
    @XmlElement(name="person")
    private List<Person> personList = new ArrayList<>();

    public Persons() {
    }

    public Persons(List<Person> personList) {
        this.personList = personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void add(Person person) {
        this.personList.add(person);
    }

    @Override
    public String toString() {
        return this.personList.toString();
    }
}
