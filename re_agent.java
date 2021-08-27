import java.sql.*;
import java.util.Scanner;

public class re_agent{

    public static void main(String[] args) {
        while (true) {
            int trials=0;
            trials++;
            if(trials>=5){
                System.out.println("Connection lost too many times! Ending program");
                break;
            }
            try {
                Scanner sc=new Scanner(System.in);
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_re", "root","0000");
                Statement stmt = conn.createStatement();
                ResultSet rs;
                ResultSetMetaData rm;


                while(true) {
                    System.out.println("Enter desired operation");
                    System.out.print("1 for Agent sales details\n2 for Rented details\n3 to exit\n");
                    int choice=Integer.parseInt(sc.nextLine());
                    switch(choice){
                        case 1:
                            System.out.println("Property sales:");
                            PreparedStatement st=conn.prepareStatement("SELECT * \n" +
                                    "FROM Sold NATURAL JOIN Property\n" +
                                    "ORDER BY agent_id;");
                            rs=st.executeQuery();
                            rm= rs.getMetaData();
                            print_table(rs,rm);

                            System.out.println("Rentals:");
                            st=conn.prepareStatement("SELECT * \n" +
                                    "FROM Rented NATURAL JOIN Rental\n" +
                                    "ORDER BY agent_id;");
                            rs=st.executeQuery();
                            rm= rs.getMetaData();
                            print_table(rs,rm);

                            break;
                        case 2:
                            System.out.println("Number of properties rented per agents");
                            st=conn.prepareStatement("SELECT agent_id,count(reg_no) as num_rented\n" +
                                    "FROM rented\n" +
                                    "GROUP BY agent_id;");
                            rs=st.executeQuery();
                            rm= rs.getMetaData();
                            print_table(rs,rm);

                            System.out.println("Details of properties rented:");
                            st=conn.prepareStatement("SELECT agent_id,reg_no,start_date,end_date,rent,locality,address\n" +
                                    "FROM rented NATURAL JOIN rental;");
                            rs=st.executeQuery();
                            rm= rs.getMetaData();
                            print_table(rs,rm);
                            break;
                        case 3:
                            System.out.println("Exiting RE office interface");
                            break;
                        default:
                            System.out.print("Wrong choice! No Real Estate info for you\n");
                            choice=0;

                    }
                    if(choice==3)
                        break;
                }
                stmt.close();
                conn.close();
                sc.close();
                break;
            } catch (Exception e) {
                System.out.println("Something happened!"+e);
            }
        }
    }
    public static void print_table(ResultSet rs,ResultSetMetaData rm) {
        try{
            int num_col = rm.getColumnCount(), wp_len = 20;
            String str=" ";
            for (int i = 1; i <= num_col; i++) {
                str = rm.getColumnName(i).toUpperCase();
                System.out.print(str);
                for (int i1 = 0; i1 < wp_len - str.length(); i1++)
                    System.out.print(" ");
            }
            System.out.println();
            for (int i = 0; i < num_col * wp_len; i++)
                System.out.print("_");
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= num_col; i++) {
                    str = rs.getString(i);
                    System.out.print(str);
                    for (int i1 = 0; i1 < wp_len - str.length(); i1++)
                        System.out.print(" ");
                }
                System.out.println();
            }
        }catch(Exception e){
            System.out.println("Encountered error while printing table!"+e);
        }
    }
}
