import java.time.LocalDate;
import java.time.LocalDateTime;

public class Car {
    private String number;
    private String model;
    private LocalDateTime inTime;

    public Car(){

    }

    public Car(String number, String model){
        this.number = number;
        this.model = model;
    }

    public Car(String model, LocalDateTime inTime){
        this.model = model;
        this.inTime = inTime;
    }

    public Car(String number, String model, LocalDateTime inTime){
        this.number = number;
        this.model = model;
        this.inTime = inTime;
    }

    public String getCarNum() {
        return number;
    }

    public void setCarNum(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getCarTime() {
        return inTime;
    }

    public void setCarTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

}
