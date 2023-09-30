import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Actions {

    Scanner input = new Scanner(System.in);
    protected int productID=1000;

    HashMap<Integer,Fields> listProductMap=new HashMap<Integer,Fields>();

    public void menu() {

        System.out.println("=".repeat(47) + "\n            Warehouse Application            " + "\n" + "=".repeat(47)
                + "\nPlease select the action you want to do" + "\n1) Product Identification\n2) List Products\n3) Product Entry" +
                "\n4) Put Products on the Shelf\n5) Product Output\n0) Exit ");
        System.out.print("Select: ");
        byte select = input.nextByte();
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
                break;
            case 4:
                putProductsOnShelf();
                break;
            case 5:
                productOutput();
                break;
            case 0:
                break;
            default:
                System.out.println("Please select valid action");
        }

    }

    protected void productIdentification() {

        System.out.println("=".repeat(46)+"\n"+" ".repeat(12)+"Product Identification"+"\n"+"=".repeat(46)+"\nPlease enter product information");
        System.out.print("Product Name: ");
        input.nextLine();
        String productName= input.nextLine();
        System.out.print("Producer: ");
        String producer = input.nextLine();
        System.out.print("Unit Type: ");
        String unit= input.nextLine();

        int amount=0;
        String shelf= "null";

        Fields fields = new Fields(productName,producer,amount,unit,shelf);

        listProductMap.put(productID,fields);

        productID+=10;


    }

    protected void listProducts() {

        Set<Map.Entry<Integer,Fields>> productList = listProductMap.entrySet();

        System.out.println("==========================PRODUCT LIST==========================\nId       Name       Producer       Unit       Amount       Shelf" +
                         "\n================================================================");
        for (Map.Entry<Integer,Fields> e: productList) {
            Integer key= e.getKey();
            System.out.printf("%-8d %-12s %-15s %-12s %-12d %-9s\n",key ,listProductMap.get(key).getProductName(),listProductMap.get(key).getProducer()
            ,listProductMap.get(key).getUnit(), listProductMap.get(key).getAmount(),listProductMap.get(key).getShelf());
        }


    }

    protected void productEntry() {

    }

    protected void putProductsOnShelf() {

    }
    protected void productOutput(){

    }

}
