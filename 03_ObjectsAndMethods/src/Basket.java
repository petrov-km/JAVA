public class Basket {

    private static int totalProductCound = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int allBasketsPrice = 0;
    private static int basketsCount = 0;
    private int productCount = 0;

    public Basket() {
        increaseBasketsCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        increaseAllBasketsPrice(totalPrice);
        increaseProductCount(1);
        increaseTotalProductCount(1);
    }
    private void increaseProductCount(int count){ productCount +=count;}
    private static void increaseBasketsCount(int count){ Basket.basketsCount+=count; }
    public static int getBasketsCount() { return basketsCount; }
    private static void increaseAllBasketsPrice(int price) { Basket.allBasketsPrice += price; }
    public static int getAllBasketsPrice() { return Basket.allBasketsPrice; }

    public static int getTotalProductCound() { return totalProductCound; }
    private static void increaseTotalProductCount(int count) { Basket.totalProductCound = Basket.totalProductCound + count; }

    public void add(String name, int price, int count, double weight) {
        if (add(name, price, count)) {
            return;
        }
        totalWeight += count * weight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void add(String name, int price, double weight) {
        add(name, price, 1, weight);
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public boolean add(String name, int price, int count) {
        if (contains(name)||(totalPrice + count * price >= limit)){
            System.out.println("Error occured :(");
            return true;
        }
        items = items + "\n" + name + " - " + count + " шт. - " + price + "руб";
        totalPrice = totalPrice + count * price;
        increaseProductCount(count);
        increaseAllBasketsPrice(price*count);
        increaseTotalProductCount(count);
        return false;
    }
    public void clear() {
        items = "";
        totalProductCound -= productCount;
        productCount = 0;
        allBasketsPrice-=totalPrice;
        totalPrice = 0;
        totalWeight = 0;

    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
