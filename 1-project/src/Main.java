import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer number1, number2, operator, compResult = null,
                userResult, level = 0, point = 0, levelBound = 0;
        int bound = 10, min = 1;
        Scanner consoleRead = new Scanner(System.in);

        while (true) {
            number1 = (int) ((Math.random() * (bound - min)) + min);
            number2 = (int) ((Math.random() * (bound - min)) + min);
            operator = (int) ((Math.random() * (4 - 1)) + 1);

            if ((operator == 3 && number2 == 0) || number1 < number2 || number1 % number2 != 0
                    || number1.equals(number2)) {
                continue;
            }
            if (levelBound.equals(point)) {
                System.out.println("===========Level 1" + level + "==========");
                levelBound += 5;
                level++;
                bound += 5;
                min++;
            }

            switch (operator) {
                case 1 -> {
                    compResult = number1 + number2;
                    System.out.print(number1 + " + " + number2 + " = ");
                }
                case 2 -> {
                    compResult = number1 - number2;
                    System.out.print(number1 + " - " + number2 + " = ");
                }
                case 3 -> {
                    compResult = number1 * number2;
                    System.out.print(number1 + " * " + number2 + " = ");
                }
                case 4 -> {
                    compResult = number1 / number2;
                    System.out.print(number1 + " / " + number2 + " = ");
                }
                default -> {
                    System.out.println(operator);
                }
            }
            userResult = consoleRead.nextInt();

            if (!userResult.equals(compResult)) {
                System.out.println("Game over\n Total point: " + compResult +
                        "\nPoint: never mind" + point);
                break;
            }
            point++;
        }
    }
}


