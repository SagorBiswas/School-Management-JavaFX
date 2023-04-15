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
public class Fees_Std {
    private static Fees_Std instance;

    
     public List<List<String>> getAllFees(String std_id)
    {
        System.out.println("Get All Fees Called "+std_id);
        String sql = "SELECT F.FEE_ID, F.FEE_DESCRIPTION, F.FEE_AMOUNT, F.LAST_PAYMENT_DATE FROM FEES F JOIN FEES_PAYMENT FP ON (F.FEE_ID = FP.FEE_ID AND FP.STUDENT_ID = ?)";
        //String sql = "SELECT * FROM FEES";
        List<List<String>> resultList = new ArrayList<>();
        try{
            Connection con = new OracleDBMS("SB","sb").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, std_id);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next())
            {
                List<String> row = new ArrayList<>();
                row.add(rs.getString("FEE_ID"));
                row.add(rs.getString("FEE_DESCRIPTION"));
                row.add(rs.getString("FEE_AMOUNT"));
                row.add(rs.getString("LAST_PAYMENT_DATE"));
            System.out.println("connected");
                resultList.add(row);
            }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured");
            e.printStackTrace();
        }
        return resultList;
    }
}
