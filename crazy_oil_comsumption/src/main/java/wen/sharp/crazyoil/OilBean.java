package wen.sharp.crazyoil;

/**
 * Created by wenyugang_91 on 2015/6/16.
 */
public class OilBean {
    private int price;
    private int id;
    private int money;
    private int kilometer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public static final String TABLE_NAME = "t_oil_info";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_MONEY = "money";
    public static final String COLUMN_KELOMETER = "kelometer";
}
