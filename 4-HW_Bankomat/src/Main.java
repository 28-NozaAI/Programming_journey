import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double balance = 500000;
        String password = "3333";

        System.out.println(" Language: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1. English");
        System.out.println(" 2. Uzbek");
        System.out.println(" Choose the language: ");
        int language, countPassword = 0;
        language = scanner.nextInt();


            switch (language){
                case 1 -> {
                    System.out.println("---------Password---------");
                    System.out.println(" Enter Password: ");
                    String myPassword;
                    myPassword = scanner.next();
                    countPassword++;
                    if(countPassword==3){
                        System.out.println(" Ohirgi urinish!");
                    }
                    if(countPassword>3){
                        System.out.println(" Bloklandi!");
                        return;
                    }
                    System.out.println(" Parolni kiriting: ");
                    myPassword = scanner.next();

                    while (true){

                    if(Objects.equals(myPassword, password)){
                        System.out.println("---------Main Menu---------");
                        System.out.println(" 1. Check the Balance");
                        System.out.println(" 2. Add money to Account");
                        System.out.println(" 3. Withdrawal");
                        System.out.println(" 4. Change the Password");
                        System.out.println(" 5. Exit");

                        System.out.println(" Choose Menu: ");
                        int menu;
                        menu = scanner.nextInt();

                        switch (menu){
                            case 1 -> {
                                System.out.println(" Your Balance: " + balance + " sum");

                                System.out.println(" Do you have any other actions?");
                                System.out.println(" 1. Yes");
                                System.out.println(" 2. No");
                                int repeat;
                                repeat = scanner.nextInt();

                                switch (repeat){
                                    case 1 -> {

                                    }
                                    case 2 -> {
                                        return;
                                    }
                                }
                            }
                            case 2 -> {
                                System.out.println(" Add Cash: ");
                                int cash;
                                cash = scanner.nextInt();
                                balance = cash + balance;
                                System.out.println(" Total balance: " + balance + " sum");

                                System.out.println(" Do you have any other actions?");
                                System.out.println(" 1. Yes");
                                System.out.println(" 2. No");
                                int repeat;
                                repeat = scanner.nextInt();

                                switch (repeat){
                                    case 1 -> {

                                    }
                                    case 2 -> {
                                        return;
                                    }
                                }
                            }
                            case 3 -> {
                                System.out.println(" Withdraw a cash: ");
                                int cash2;
                                cash2 = scanner.nextInt();

                                if(balance<cash2){
                                    System.out.println(" Not enough money");
                                    System.out.println(" Do you have any other actions?");
                                    System.out.println(" 1. Yes");
                                    System.out.println(" 2. No");
                                    int repeat;
                                    repeat = scanner.nextInt();

                                    switch (repeat){
                                        case 1 -> {

                                        }
                                        case 2 -> {
                                            return;
                                        }
                                    }
                                }
                                else {
                                    balance = balance - cash2;
                                    System.out.println(" Total balance: " + balance + " sum");
                                    System.out.println(" Do you have any other actions?");
                                    System.out.println(" 1. Yes");
                                    System.out.println(" 2. No");
                                    int repeat;
                                    repeat = scanner.nextInt();

                                    switch (repeat){
                                        case 1 -> {

                                        }
                                        case 2 -> {
                                            return;
                                        }
                                    }
                                }
                            }
                            case 4 -> {
                                System.out.println(" Confirm previous password: ");
                                myPassword = scanner.next();

                                if(Objects.equals(myPassword, password)){
                                    System.out.println(" Enter new password: ");
                                    myPassword = scanner.next();
                                    password = myPassword;
                                    System.out.println(" Password updated");
                                }
                                else {
                                    countPassword++;
                                    if(countPassword==3){
                                        System.out.println(" Last chance!");
                                    }
                                    if(countPassword>3){
                                        System.out.println(" Blocked!");
                                        return;
                                    }
                                    System.out.println(" Enter Password: ");
                                    myPassword = scanner.next();
                                }
                            }
                            case 5 -> {
                                return;
                            }
                            }
                        }
                    else {
                        countPassword++;
                        if(countPassword==3){
                            System.out.println(" Last chance!");
                        }
                        if(countPassword>3){
                            System.out.println(" Blocked!");
                            return;
                        }
                        System.out.println(" Enter Password: ");
                        myPassword = scanner.next();
                    }
                    }
                }
                case 2 -> {
                    System.out.println("---------Parol---------");
                    System.out.println(" Parolni kiriting: ");
                    String myPassword;
                    myPassword = scanner.next();

                    while (true){

                        if(Objects.equals(myPassword, password)){
                            System.out.println("---------Asosiy Menu---------");
                            System.out.println(" 1. Balansni tekshirish");
                            System.out.println(" 2. Pul o'tkazish");
                            System.out.println(" 3. Pul yechib olish");
                            System.out.println(" 4. Parolni o'zgartirish");
                            System.out.println(" 5. Chiqish");

                            System.out.println(" Menuni tanlang ");
                            int menu;
                            menu = scanner.nextInt();

                            switch (menu){
                                case 1 -> {
                                    System.out.println(" Sizning balansingiz " + balance + " sum");

                                    System.out.println(" Boshqa amal bajarasizmi?");
                                    System.out.println(" 1. Ha");
                                    System.out.println(" 2. Yo'q");
                                    int repeat;
                                    repeat = scanner.nextInt();

                                    switch (repeat){
                                        case 1 -> {

                                        }
                                        case 2 -> {
                                            return;
                                        }
                                    }
                                }
                                case 2 -> {
                                    System.out.println(" Pul qo'shish: ");
                                    int cash;
                                    cash = scanner.nextInt();
                                    balance = cash + balance;
                                    System.out.println(" Umumiy balans " + balance + " sum");

                                    System.out.println(" Boshqa amal bajarasizmi?");
                                    System.out.println(" 1. Ha");
                                    System.out.println(" 2. Yo'q");
                                    int repeat;
                                    repeat = scanner.nextInt();

                                    switch (repeat){
                                        case 1 -> {

                                        }
                                        case 2 -> {
                                            return;
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.println(" Pul yechib olish: ");
                                    int cash2;
                                    cash2 = scanner.nextInt();

                                    if(balance<cash2){
                                        System.out.println(" Yetarli mablag' mavjud emas!");
                                        System.out.println(" Boshqa amal bajarasizmi?");
                                        System.out.println(" 1. Ha");
                                        System.out.println(" 2. Yo'q");
                                        int repeat;
                                        repeat = scanner.nextInt();

                                        switch (repeat){
                                            case 1 -> {

                                            }
                                            case 2 -> {
                                                return;
                                            }
                                        }
                                    }
                                    else {
                                        balance = balance - cash2;
                                        System.out.println(" Umumiy hisob: " + balance + " sum");
                                        System.out.println(" Boshqa amal bajarasizmi?");
                                        System.out.println(" 1. Ha");
                                        System.out.println(" 2. Yo'q");
                                        int repeat;
                                        repeat = scanner.nextInt();

                                        switch (repeat){
                                            case 1 -> {

                                            }
                                            case 2 -> {
                                                return;
                                            }
                                        }
                                    }
                                }
                                case 4 -> {
                                    System.out.println(" Oldingi parolni kiriting: ");
                                    myPassword = scanner.next();

                                    if(Objects.equals(myPassword, password)){
                                        System.out.println(" Yangi parolni kiriting: ");
                                        myPassword = scanner.next();
                                        password = myPassword;
                                        System.out.println(" Parol yangilandi");
                                    }
                                    else {
                                        countPassword++;
                                        if(countPassword==3){
                                            System.out.println(" Ohirgi urinish!");
                                        }
                                        if(countPassword>3){
                                            System.out.println(" Bloklandi!");
                                            return;
                                        }
                                        System.out.println(" Parolni kiriting: ");
                                        myPassword = scanner.next();
                                    }
                                }
                                case 5 -> {
                                    return;
                                }
                            }
                        }
                        else {
                            countPassword++;
                            if(countPassword==3){
                                System.out.println(" Ohirgi urinish!");
                            }
                            if(countPassword>3){
                                System.out.println(" Bloklandi!");
                                return;
                            }
                            System.out.println(" Parolni kiriting: ");
                            myPassword = scanner.next();
                        }
                    }
                }
                }
            }
        }

