package model.uml;

import tool.ORM;

/**
 * Created by zuston on 16/11/7.
 */
public class books extends ORM {
    public String type;
    public String title;
    public int price;
    public String author;
    public int number;
    public int broken;

    public books(String type, String title, int price, String author, int number, int broken) {
        this.type = type;
        this.title = title;
        this.price = price;
        this.author = author;
        this.number = number;
        this.broken = broken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBroken() {
        return broken;
    }

    public void setBroken(int broken) {
        this.broken = broken;
    }

    public static void main(String[] args) throws IllegalAccessException {
        books bk = new books("文学","风雨张居正",200,"张文君",30,1);
        bk.save();
    }
}
