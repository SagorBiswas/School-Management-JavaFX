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
public class Students_Off {
    private static Students_Off instance;

    
     public List<List<String>> getAllStudents()
    {
        String sql = "SELECT * FROM STUDENTS";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("STUDENT_ID"));
                row.add(rs.getString("FIRST_NAME"));
                row.add(rs.getString("LAST_NAME"));
                row.add(rs.getString("GRADE"));
                row.add(rs.getString("SECTION"));
                row.add(rs.getString("SESSIONS"));
                row.add(rs.getString("ADDRESS"));
                row.add(rs.getString("CONTACT_NUMBER"));
                row.add(rs.getString("REMARKS"));
                row.add(rs.getString("BLOOD_GROUP"));
                row.add(rs.getString("BIRTH_DATE"));
            System.out.println("connected");
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured");
        }
        return resultList;
    }
     
      public List<List<String>> getSomeStudents(String Attribute, String Value)
    {
        System.out.println("Get some students called with attribute "+Attribute+" & Value "+Value);
        String sql = "SELECT * FROM STUDENTS WHERE "+Attribute+" = ?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, Attribute);
            pst.setString(1, Value);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("STUDENT_ID"));
                row.add(rs.getString("FIRST_NAME"));
                row.add(rs.getString("LAST_NAME"));
                row.add(rs.getString("GRADE"));
                row.add(rs.getString("SECTION"));
                row.add(rs.getString("SESSIONS"));
                row.add(rs.getString("ADDRESS"));
                row.add(rs.getString("CONTACT_NUMBER"));
                row.add(rs.getString("REMARKS"));
                row.add(rs.getString("BLOOD_GROUP"));
                row.add(rs.getString("BIRTH_DATE"));
            System.out.println("connected");
                resultList.add(row);
            }
            System.out.println("No Problem Here 3");
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured");
        }
        return resultList;
    }
     
}
