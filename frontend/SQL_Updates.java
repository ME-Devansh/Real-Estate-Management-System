package frontend;
import java.sql.*;

public class SQL_Updates {
    SQL_Updates(String agent_id,String reg_num,String sell_date){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_re","root","0000");
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt;
            System.out.println(reg_num + " " + sell_date);
            ResultSet rs;
            ResultSetMetaData rm;
            pstmt=conn.prepareStatement("insert into Sold values (?,?,?);");
            pstmt.setString(1,agent_id);
            pstmt.setString(2,reg_num);
            pstmt.setString(3,sell_date);
            pstmt.execute();
            pstmt = conn.prepareStatement("update Property set status='taken' where reg_no = ?;");
            pstmt.setString(1, reg_num);
            pstmt.execute();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    SQL_Updates(String agent_id,String reg_num,String sell_date,String end_date){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_re","root","0000");
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt;
            ResultSet rs;
            ResultSetMetaData rm;
            pstmt=conn.prepareStatement("insert into Rented values (?,?,?,?);");
            pstmt.setString(1,agent_id);
            pstmt.setString(2,reg_num);
            pstmt.setString(3,sell_date);
            pstmt.setString(4,end_date);
            pstmt.execute();
            pstmt = conn.prepareStatement("update Rental set status='taken' where reg_no = ?;");
            pstmt.setString(1, reg_num);
            pstmt.execute();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}