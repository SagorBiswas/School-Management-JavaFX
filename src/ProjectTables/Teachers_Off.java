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
public class Teachers_Off {
    private static Teachers_Off instance;

    
     public List<List<String>> getAllTeachers()
    {
        String sql = "SELECT * FROM TEACHERS";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Connected");
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("TEACHER_ID"));
                row.add(rs.getString("FIRST_NAME"));
                row.add(rs.getString("LAST_NAME"));
                row.add(rs.getString("SUBJECT"));
                row.add(rs.getString("JOIN_DATE"));
                row.add(rs.getString("BIRTH_DATE"));
                row.add(rs.getString("SALARY"));
                row.add(rs.getString("BLOOD_GROUP"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultList;
    }
     
     public List<List<String>> getSomeTeachers(String Attribute, String Value)
    {
        System.out.println("getSomeTeachers called with attribute "+Attribute+" & Value "+Value);
        String sql = "SELECT * FROM TEACHERS WHERE "+Attribute+" = ?";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Value);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Connected");
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("TEACHER_ID"));
                row.add(rs.getString("FIRST_NAME"));
                row.add(rs.getString("LAST_NAME"));
                row.add(rs.getString("SUBJECT"));
                row.add(rs.getString("JOIN_DATE"));
                row.add(rs.getString("BIRTH_DATE"));
                row.add(rs.getString("SALARY"));
                row.add(rs.getString("BLOOD_GROUP"));
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultList;
    }
     
}
