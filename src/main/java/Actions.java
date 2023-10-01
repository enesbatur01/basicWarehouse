import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Actions {

    Scanner input = new Scanner(System.in);
    protected int productID = 1000;

    HashMap<Integer, Fields> listProductMap = new HashMap<>();

    public void menu() {

        System.out.println("=".repeat(47) + "\n            Warehouse Application            " + "\n" + "=".repeat(47)
                + "\nPlease select the action you want to do" + "\n1) Product Identification\n2) List Products\n3) Product Entry" +
                "\n4) Put Products on the Shelf\n5) Product Output\n0) Exit ");
        System.out.print("Select: ");
        byte select = 0;

        try {

            select = input.nextByte();
            input.nextLine();
            switch (select) {
                case 1:
                    productIdentification();
                    menu();
                    break;
                case 2:
                    listProducts();
                    menu();
                    break;
                case 3:
                    productEntry();
                    menu();
                    break;
                case 4:
                    putProductsOnShelf();
                    menu();
                    break;
                case 5:
                    productOutput();
                    menu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please select valid action");
            }
        } catch (Exception e) {
            System.err.println(("Invalid data"));
            input.nextLine();
            menu();
        }


    }

    protected void productIdentification() {

        System.out.println("=".repeat(46) + "\n" + " ".repeat(12) + "Product Identification" + "\n" + "=".repeat(46) + "\nPlease enter product information");
        System.out.print("Product Name: ");
        String productName = input.nextLine();
        System.out.print("Producer: ");
        String producer = input.nextLine();
        System.out.print("Unit Type: ");
        String unit = input.nextLine();

        int amount = 0;
        String shelf = "null";

        Fields fields = new Fields(productName, producer, amount, unit, shelf);

        listProductMap.put(productID, fields);

        System.out.println("Product successfully added");
        productID += 10;


    }

    protected void listProducts() {

        Set<Map.Entry<Integer, Fields>> productList = listProductMap.entrySet();

        System.out.println("==========================PRODUCT LIST==========================\nId       Name       Producer       Unit       Amount       Shelf" +
                "\n================================================================");
        for (Map.Entry<Integer, Fields> e : productList) {
            Integer key = e.getKey();
            System.out.printf("%-8d %-12s %-15s %-12s %-12d %-9s\n", key, listProductMap.get(key).getProductName(), listProductMap.get(key).getProducer()
                    , listProductMap.get(key).getUnit(), listProductMap.get(key).getAmount(), listProductMap.get(key).getShelf());
        }


    }

    protected void productEntry() {
        System.out.println("==========================Product Entry==========================");
        System.out.print("Please enter product id: ");
        try {
            int enterProductID = input.nextInt();
            int amountOfEntry = 0;

            if (listProductMap.containsKey(enterProductID)) {
                System.out.print("Please enter product amount: ");
                amountOfEntry = input.nextInt();
                if (amountOfEntry<0){
                   try {
                       throw new NegativeNumberException("Cannot add negative number");
                   }catch (NegativeNumberException e){
                       System.err.println(e.getMessage());
                   }
                }else {
                    listProductMap.get(enterProductID).setAmount(amountOfEntry + listProductMap.get(enterProductID).getAmount());
                    System.out.println("Successfully add amount!\nCurrent amount: "+listProductMap.get(enterProductID).getAmount());
                }


            } else {
                System.err.println(("Invalid product id"));
            }
        } catch (Exception e) {
            System.err.println(("Invalid data"));
            input.nextLine();
            menu();

        }


    }

    protected void putProductsOnShelf() {
        System.out.println("==========================Put In Shelf==========================");
        System.out.print("Please enter product id: ");
        try {
            int enterProductID = input.nextInt();
            String shelf = "null";
            if (listProductMap.containsKey(enterProductID)) {
                System.out.print("Select Shelf: ");
                input.nextLine();
                shelf = input.nextLine();
                if (shelf.matches("[^0-9]")){
                    try {
                        throw new InvalidShelfException("Shelves can only be numbers");
                    }catch (InvalidShelfException e){
                        System.err.println(e.getMessage());
                        putProductsOnShelf();
                    }
                }else {
                    listProductMap.get(enterProductID).setShelf("Shelf " + shelf);
                    System.out.println("Successfully product add on "+listProductMap.get(enterProductID).getShelf());
                }


            } else {
                System.err.println(("Invalid product id"));
            }
        } catch (Exception e) {
            System.err.println(("Invalid data"));
            input.nextLine();
            menu();
        }
    }

    protected void productOutput() {
        System.out.println("==========================Product Output==========================");
        System.out.print("Please enter product id: ");
        try {
            int enterProductID = input.nextInt();
            int amountOfEntry = 0;

            if (listProductMap.containsKey(enterProductID)) {
                System.out.print("Please enter product output amount: ");

                amountOfEntry = input.nextInt();
                if (amountOfEntry < 0) {
                    try {
                        throw new NegativeNumberException("Cannot be negative");
                    } catch (NegativeNumberException e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    if (amountOfEntry <= listProductMap.get(enterProductID).getAmount()) {

                        listProductMap.get(enterProductID).setAmount(listProductMap.get(enterProductID).getAmount() - amountOfEntry);
                        System.out.println("Output is Successfully! \nCurrent amount: "+listProductMap.get(enterProductID).getAmount());

                    } else {
                        System.err.println(("Output amount is bigger than your own"));
                        input.nextLine();
                        productOutput();
                    }
                }


            } else {
                System.err.println(("Invalid product id"));

            }
        } catch (Exception e) {
            System.err.println(("Invalid data"));
            input.nextLine();
            menu();

        }


    }

}
