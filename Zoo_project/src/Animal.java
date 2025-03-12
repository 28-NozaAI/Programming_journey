import java.util.UUID;
import java.lang.reflect.GenericArrayType;
import java.util.Date;

public class Animal {

    private String id;
    private String name;
    private Integer age;
    private AnimalGender gender;
    private AnimalType type;

    public Animal() {
        this.id = UUID.randomUUID().toString().replace("-", "");
    }

    public Animal(String name, Integer age, AnimalGender gender, AnimalType type) {
        this();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.type = type;
    }

    public void eat() {
        System.out.printf(Templates.EAT, name, type);
    }

    public void sound() {
        System.out.printf(Templates.SOUND, name, type, " aaa ");
    }

    public void move() {
        System.out.printf(Templates.MOVE, name, type);

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AnimalGender getGender() {
        return gender;
    }

    public void setGender(AnimalGender gender) {
        this.gender = gender;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", type=" + type +
                '}';
    }
}
