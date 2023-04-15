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
public class Teachers_std {
     private static Teachers_std instance;

    
     public List<List<String>> getAllTeachers()
    {
        String sql = "SELECT TEACHER_ID, (FIRST_NAME||'  '||LAST_NAME)TEACHER_NAME, SUBJECT FROM TEACHERS";
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
                row.add(rs.getString("TEACHER_NAME"));
                row.add(rs.getString("SUBJECT"));
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
