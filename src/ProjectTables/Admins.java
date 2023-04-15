/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAGOR
 */
public class Admins {
    private static Admins instance; 
    
//    private Admins()
//    {
//    }
    
//    public static Admins getInstance()
//    {
//        if (instance == null)
//        {
//            instance = new Admins();
//        }
//        return instance;
//    }
    public boolean validateLogin(String userName, String password)
    {
        boolean success = false;
        String sql = "SELECT * FROM ADMIN WHERE USER_NAME = ? AND PASSWORD=?";
        
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
            {
                success = true;
            }
            //success = true ;
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
}
