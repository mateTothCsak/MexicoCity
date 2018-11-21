public class Item {
    private int id;
    private String name;
    private String description;
    private int price;
    private String image;
    private Category category;

    public Item() {}

    public Item(String name, String description, int price, String image, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

}
