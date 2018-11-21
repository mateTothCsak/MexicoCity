import java.util.ArrayList;
import java.util.List;

public class Admin {

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.createShop();
        admin.createServer();
    }

    private void createServer() {
        MyServer myServer = new MyServer();
    }


    private List<Item> addItemsToFreeShop() {
        List<Item> items = new ArrayList();
        items.add(new Item("Pimp Stick", "Nice pimp stick", 100, "image/pimpStick.jpg", Category.FEATHER));
        return items;

    }

    private void createShop() {
        FreeShop freeShop = new FreeShop();
        freeShop.addShopItems(addItemsToFreeShop());
    }



}
