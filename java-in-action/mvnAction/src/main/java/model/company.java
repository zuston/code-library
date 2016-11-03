package model;

import tool.ORM;

/**
 * Created by zuston on 16-11-3.
 */
public class company extends ORM{
    public int id;
    public String name;
    public String number;
    public int patent_number;

    public company(int id, String name, String number, int patent_number) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.patent_number = patent_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPatent_number(int patent_number) {
        this.patent_number = patent_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getPatent_number() {
        return patent_number;
    }

    public static void main(String[] args) throws IllegalAccessException {
        company com = new company(1,"zuston","909080",209);
        com.save();
    }
}
