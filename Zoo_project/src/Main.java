import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Animal[] ANIMALS = new Animal[100];
    private static Scanner SCANNER;

    public static void main(String[] args) {
        boolean run = true;
        SCANNER = new Scanner(System.in);
        while (run) {
            try {
                run = run();
            } catch (Throwable e) {
                System.out.printf((Templates.ERROR) + "%n", new Date(), e.getMessage());
                SCANNER = new Scanner(System.in);
            }
        }
    }

    private static boolean run() {
        showMenu();
        int choice = SCANNER.nextInt();
        switch (choice) {
            case 1 -> {
                showAnimals();
            }
            case 2 -> {

                addAnimal();

            }
            case 3 -> {
                choiceAnimal();
            }
            case 4 -> {
                System.out.printf("INFO: %s: Hayr%n", new Date());
                return false;
            }
            default -> {
                throw new RuntimeException(Templates.ERROR.formatted(new Date(), " Noto'g'ri tanlov"));
            }
        }

        return true;
    }

    private static void choiceAnimal() {
        showAnimals();
        String id = SCANNER.next();
        Animal animal = findById(id);
        showSubMenu(animal);

    }

    private static void showSubMenu(Animal animal) {
        System.out.printf(Templates.SUB_MENU, animal.getName(),animal.getType());
        int choice = SCANNER.nextInt();
        switch (choice) {
            case 1 -> {
                animal.sound();
            }
            case 2 -> {
                animal.eat();
            }
            case 3 -> {
                animal.move();
            }
            case 4 -> {
                return;
            }
            default -> {
                throw new RuntimeException("Wrong choice");
            }
        }
        showSubMenu(animal);
    }

    private static Animal findById(String id) {
        for (Animal animal : ANIMALS) {
            if (animal != null && animal.getId().equals(id)) {
                return animal;
            }
        }
        throw new RuntimeException("Animal not found");
    }

    private static void addAnimal() {
        System.out.println(" ======= Animals =======");
        System.out.print("Name: ");
        String name = SCANNER.next();

        System.out.print("Age: ");
        Integer age = SCANNER.nextInt();

        System.out.printf("Gender(%s): ", Arrays.toString(AnimalGender.values()));
        String gender = SCANNER.next();

        System.out.printf("AnimalType(%s): ", Arrays.toString(AnimalType.values()));
        String type = SCANNER.next();

        Animal animal = validateAddAnimal(name, age, gender, type);

        for (int i = 0; i < ANIMALS.length; i++) {
            if (ANIMALS[i] == null) {
                ANIMALS[i] = animal;
                System.out.printf(Templates.INFO, new Date(), "Qo'shildi");
                return;
            }
        }
        throw new RuntimeException("Zoo is full");
    }

    private static Animal validateAddAnimal(String name, Integer age, String gender, String type) {

        if (age < 0) {
            throw new RuntimeException("Age is negative");
        }
        AnimalGender animalGender = AnimalGender.valueOf(gender);
        AnimalType animalType = AnimalType.valueOf(type);
        return new Animal(name, age, animalGender, animalType);
    }

    private static void showAnimals() {
        System.out.println(" ======= Animals =======");
        for (Animal animal : ANIMALS) {
            if (animal != null) {
                System.out.println(animal);
            }
        }
        System.out.println();
    }

    private static void showMenu() {
        System.out.print(Templates.MAIN_MENU);
    }
}