import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String player1;
        String player2;
        boolean player1Turn = true;
        int choice1;
        int choice2;

        char[][] sched = {
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };

        System.out.print(" 1st Player name: ");
        player1 = scanner.next();
        System.out.print(" 2st Player name: ");
        player2 = scanner.next();
        while (true){
            printSched(sched);
            System.out.println(" Choose the star: ");

            choice1 = scanner.nextInt();
            choice2 = scanner.nextInt();

            if (player1Turn){
                putSign(sched, choice1, choice2, 'x');
                player1Turn = false;
            }else {
                putSign(sched, choice1, choice2, 'o');
                player1Turn = true;
            }

            if (isGameEnd(sched)) {
                printSched(sched);
                System.out.println(" End!");

                if (!player1Turn) {
                    System.out.println(player1 + " won!");
                } else {
                    System.out.println(player2 + " won!");
                }
                main(args);
            }
        }
    }

    static void putSign(char[][] arr, int i, int j, char sign) {

        if (i > arr.length || j > arr[0].length) {
            return;
        }

        for (int g = 0; g < arr.length; g++) {
            for (int k = 0; k < arr[g].length; k++) {
                if (i == g && j == k) {
                    if (arr[g][k] == '*') {
                        arr[g][k] = sign;
                    }
                }
            }
        }
    }
    static void printSched(char[][] arr) {
        for (int g = 0; g < arr.length; g++) {
            for (int k = 0; k < arr[g].length; k++) {
                System.out.print(arr[g][k] + "  ");
            }
            System.out.println();
        }
    }
    static boolean isGameEnd(char[][] arr) {
        return checkCols(arr) || checkRows(arr) || checkDiagonal(arr);
    }



    static boolean checkDiagonal(char[][] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int g = 0; g < arr.length; g++) {
                if ((arr[0][2] == 'x' && arr[1][1] == 'x' && arr[2][0] == 'x')
                        || (arr[0][2] == 'o' && arr[1][1] == 'o' && arr[2][0] == 'o')
                        || (arr[0][0] == 'x' && arr[1][1] == 'x' && arr[2][2] == 'x')
                        || (arr[0][0] == 'o' && arr[1][1] == 'o' && arr[2][2] == 'o'))
                        {
                    return true;
                }
            }
        }
        return false;
    }



    static boolean checkRows(char[][] arr) {
        for (int k = 0; k < arr.length; k++) {
            if (arr[k][0] == arr[k][1] && arr[k][0] == arr[k][2] && arr[k][0] != '*') {
                return true;
            }

        }
        return false;
    }

    static boolean checkCols(char[][] arr) {
        for (int k = 0; k < arr.length; k++) {
            if (arr[0][k] == arr[1][k] && arr[0][k] == arr[2][k] && arr[0][k] != '*') {
                return true;
            }
        }
        return false;
    }
}