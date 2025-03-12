import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Patient {
    private long ID; // shart
    private String fullName;
    private String passport;
    private Integer age;

    public Patient() {
        this.ID = System.currentTimeMillis();
    }

    public long getID() {
        return ID;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "ID = " + ID +
                ", fullName = '" + fullName + '\'' +
                ", passport = '" + passport + '\'' +
                ", age = " + age +
                '}';
    }
}
