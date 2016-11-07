package model.uml;

import sun.security.provider.MD5;
import tool.ORM;

/**
 * Created by zuston on 16/11/7.
 */
public class admin extends ORM {
    public String name;
    public String password;
    public String permission;

    public admin(String name, String password, String permission) {
        this.name = name;
        this.password = password;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPermission() {
        return permission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


    public static void main(String[] args) throws IllegalAccessException {
        admin am = new admin("ann","ad25f4dc0e6833dc383b2c4f5a80011e","root");
        am.save();
    }
}
