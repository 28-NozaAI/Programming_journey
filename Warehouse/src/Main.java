import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products1 = {"12#apple#130", "1#notebook#10" };

        while (true) {
            System.out.println("""
                    -------------Main Menu------------
                    1. View products in warehouse
                    2. Add new product
                    3. Search product
                    4. Remove product
                    5. Exit
                    """);

            System.out.print(" Choose a menu: ");
            String choice = scanner.next();


            switch (choice) {
                case "1" -> {
                    System.out.println("ID   | Name        | Amount");

                    for (String product : products1) {
                        String[] parts = product.split("#");

                        if (parts.length != 3) continue;

                        int ID = Integer.parseInt(parts[0].trim());
                        String names = parts[1].trim();
                        int Amount = Integer.parseInt(parts[2].trim());

                        String formattedId = String.format("%04d", ID);

                        String formattedName;

                        if (names.length() > 10) {
                            formattedName = names.substring(0, 9) + "…";
                        } else {
                            formattedName = names;
                        }

                        String formattedAmount = String.format("%4d", Amount);

                        System.out.printf("%-4s | %-11s | %-5s%n", formattedId, formattedName, formattedAmount);
                    }
                }
                case "2" -> {
                    System.out.print(" Add product: ");
                    String addProduct;
                    addProduct = scanner.next();
                    String[] newArray = new String[products1.length + 1];

                    for (int i = 0; i < products1.length; i++) {
                        newArray[i] = products1[i];
                    }

                    newArray[products1.length] = addProduct;
                    products1 = newArray;

                }

                case "3" -> {
                    System.out.print(" Enter searching product name: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String searchTerm = scanner1.nextLine().toLowerCase();

                    boolean found = false;

                    for (String newProduct : products1) {
                        String[] details = newProduct.split("#");

                        if (details[1].toLowerCase().equals(searchTerm)) {
                            System.out.println("ID: " + details[0] + ", Name: " + details[1] + ", Amount: " + details[2]);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println(" Product not found.");
                    }
                }
                case "4" -> {
                    System.out.print(" Enter product's ID: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String deleteId = scanner2.nextLine();

                    ArrayList<String> productList = new ArrayList<>();
                    Collections.addAll(productList, products1);

                    boolean found = false;

                    for (int i = 0; i < productList.size(); i++) {
                        String[] separate = productList.get(i).split("#");
                        if (separate[0].equals(deleteId)) {
                            productList.remove(i);
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println(" The product has deleted!");
                        products1 = productList.toArray(new String[0]);

                        System.out.println(" Remaining products: ");
                        for (String deletedProduct : products1) {
                            System.out.println(deletedProduct);
                        }
                    } else {
                        System.out.println(" Product not found!");
                    }
                }
                case "5" -> {
                    System.out.println(" Bye!");
                    return;
                }
            }
        }
    }
}