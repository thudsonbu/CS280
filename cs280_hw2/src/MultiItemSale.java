import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MultiItemSale {

    // Instance Variables
    public Sale[] cart = new Sale[1000];
    public int itemsInCart = 0;

    // Constructors
    public MultiItemSale() {
        cart = new Sale[1000];
        itemsInCart = 0;
    }

    public MultiItemSale(int totalItems) {
        cart = new Sale[totalItems];
    }

    // Get and Set Methods

    public Sale[] getCart() {
        return cart;
    }

    public void setCart(Sale[] cart) {
        this.cart = cart;
    }

    public int getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(int itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    // Functions

    public void addItems(){
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            // take in items
            try {
                System.out.println("Please Enter the item's name or 'end' to quit.");
                String itemName = keyboard.nextLine();
                if (itemName.equalsIgnoreCase("end")) {
                    break;
                }
                System.out.println("Please Enter the item's price.");
                Double itemPrice = keyboard.nextDouble();
                System.out.println("Please Enter the item's discount. (0 if no discount)");
                int itemDiscount = keyboard.nextInt();
                keyboard.nextLine();
                // instantiate item
                if (itemDiscount == 0){
                    Sale saleItem = new Sale(itemName,itemPrice);
                    System.out.println("Adding item " + saleItem.toString());
                    cart[itemsInCart] = saleItem;
                } else {
                    DiscountSale discountItem = new DiscountSale(itemName,itemPrice,itemDiscount);
                    System.out.println("Adding item " + discountItem.toString());
                    cart[itemsInCart] = discountItem;
                }
                itemsInCart -=-1; // hehe (sophisticated +=)
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input");
            }
        }
        keyboard.close();
    }

    public double checkOut() {
        double totalBill = 0.0;
        DecimalFormat money = new DecimalFormat("##0.00");
        for (int i = 0; i < itemsInCart; i++){
            Sale item = cart[i];
            totalBill += item.bill();
            System.out.println(item.getName()+ " $" + money.format(item.bill()));
        }
        System.out.println("Total: $" + money.format(totalBill));
        return totalBill;
    }

    public static void main(String[] args){
        MultiItemSale newMultiSale = new MultiItemSale(10);
        newMultiSale.addItems();
        newMultiSale.checkOut();
    }
}
