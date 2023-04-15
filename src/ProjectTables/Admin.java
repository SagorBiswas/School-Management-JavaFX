/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author SAGOR
 */
public class Admin {
    private final SimpleStringProperty userName;
    private final SimpleStringProperty password;

    Admin(String user, String pass) {
        this.userName = new SimpleStringProperty(user);
        this.password = new SimpleStringProperty(pass);

    }
    
//    Admin(List<String> row) {
//        this.userName = new SimpleStringProperty(row.get(0));
//        this.password = new SimpleStringProperty(row.get(1));
//    }

    public String getUserName() {
        return userName.get();
    }
    public void setUserName(String uName) {
        userName.set(uName);
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String pass) {
        password.set(pass);
    }

    public String toString() {
        return userName + ", " + password ;
    }

}
