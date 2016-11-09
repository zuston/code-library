package model;

import tool.ORM;

/**
 * Created by zuston on 16-11-3.
 */
public class company extends ORM{
    public int id;
    public String cname;
    public String cnumber;
    public int ctag;
    public int patent_number;

    public company(int id, String cname, String cnumber, int ctag, int patent_number) {
        this.id = id;
        this.cname = cname;
        this.cnumber = cnumber;
        this.ctag = ctag;
        this.patent_number = patent_number;
    }

    public company(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public int getCtag() {
        return ctag;
    }

    public void setCtag(int ctag) {
        this.ctag = ctag;
    }

    public int getPatent_number() {
        return patent_number;
    }

    public void setPatent_number(int patent_number) {
        this.patent_number = patent_number;
    }

    public static void main(String[] args) throws IllegalAccessException {
        company com = new company(9999,"zuston","909080",1,100);
        com.save();
    }
}
