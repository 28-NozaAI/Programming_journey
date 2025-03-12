import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner SCANNER = new Scanner(System.in);
    static Scanner NUM_SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Car[] cars = new Car[10];

        showPark(cars);
        while (true) {
            System.out.println("""
                    1. See auto park
                    2. Add automobile
                    3. Remove automobile
                    4. Automobile info
                    5. Exit   \s
                   \s""");
            System.out.print(" Choose a menu: ");
            int choice = NUM_SCANNER.nextInt();
            switch (choice) {
                case 1 -> {
                    showPark(cars);
                }
                case 2 -> {
                    inCar(cars);
                }
                case 3 -> {
                    outCar(cars);
                }
                case 4 -> {
                    carInfo(cars);
                }
                case 5 -> {
                    System.out.println(" Bye!");
                    return;
                }
            }
        }
    }

    private static void carInfo(Car[] cars) {
        showPark(cars);
        System.out.print(" Place num: ");
        int place = NUM_SCANNER.nextInt();
        Car car = cars[place - 1];

        System.out.println(" Car number: " + car.getCarNum());
        System.out.println(" Car model: " + car.getModel());
        System.out.println(" Car in time: " + car.getCarTime());
        System.out.println(" Spent time: " + (LocalDateTime.now().getMinute() - car.getCarTime().getMinute()) + " minute(s)");
    }

    private static void inCar(Car[] cars) {
        System.out.print(" Place num: ");
        int placeNum = NUM_SCANNER.nextInt();

        // validate place num
        if (placeNum < 1 || placeNum > cars.length) {
            System.out.println(" Wrong place number! Please, choose from one to  " + cars.length + ".");
            return;
        }

        if (cars[placeNum - 1] == null) {
            System.out.print(" Car number: ");
            String carNum = SCANNER.next();
            System.out.print(" Car model: ");
            String model = SCANNER.next();
            putCar(cars, placeNum, carNum, model);

        } else {
            System.out.println(placeNum + " - not empty!!");
        }
    }

    private static void outCar(Car[] cars){
        System.out.print(" Place num: ");
        int placeNum = NUM_SCANNER.nextInt();

        if (placeNum < 1 || placeNum > cars.length) {
            System.out.println(" Wrong place number! Please, choose from one to  " + cars.length + ".");
            return;
        }

        if (cars[placeNum - 1] == null) {
            System.out.println(" No car in this spot!");
        } else {
            cars[placeNum - 1] = null;
            System.out.println(" Car removed from spot " + placeNum);
        }
    }

    private static void putCar(Car[] cars, int placeNum, String carNum, String model) {
        Car car = new Car();

        car.setCarNum(carNum);
        car.setModel(model);
        car.setCarTime(LocalDateTime.now());

        for (int i = 0; i < cars.length; i++) {
            if (i == placeNum - 1) {
                cars[i] = car;
                System.out.println(" Placed!!");
                return;
            }
        }
    }

    private static void showPark(Car[] cars) {
        for (int i = 1; i <= cars.length; i++) {
            System.out.print(" " + i + "   ");
        }

        System.out.println();
        for (Car car : cars) {
            System.out.print(((car == null) ? "✅" : "🚗") + " | ");
        }
        System.out.println();
    }
}