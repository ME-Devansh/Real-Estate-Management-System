import java.sql.*;
import java.util.Scanner;

public class agent{
    public static void main(String[] args) {
        System.out.println("Accessing the database as agent");
        System.out.println("Enter agent id:");
        Scanner sc=new Scanner(System.in);
        int agent_id,reg_no;
        agent_id=Integer.parseInt(sc.nextLine().trim());

        int trials=0;
        while (true) {
            trials++;
            if(trials>=5){
                System.out.println("Connection lost too many times! Ending agent interface");
                break;
            }
            try {

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_re", "root","0000");



                while(true) {
                    System.out.println("Enter desired operation:");
                    System.out.print("1 for adding selling details\n2 for adding rented details\n3 for exiting agent interface\n");
                    int choice=Integer.parseInt(sc.nextLine());

                    switch(choice){
                        case 1:
                            String date;
                            System.out.println("Enter sales details:");
                            System.out.println("Enter property reg_no:");
                            reg_no=Integer.parseInt(sc.nextLine().trim());
                            System.out.println("Enter sales date as dd/mm/yy");
                            date=sc.nextLine().trim();

                            PreparedStatement st=conn.prepareStatement("insert into sold values (?,?,?);");
                            st.setInt(1,agent_id);
                            st.setInt(2,reg_no);
                            st.setString(3,date);
                            st.execute();
                            st = conn.prepareStatement("update Property\n" +
                                    "set status='taken'\n" +
                                    "where reg_no = ?;");
                            st.setInt(1, reg_no);
                            st.execute();
                            System.out.println("Updated");
                        break;
                        case 2:
                            String st_date,end_date;
                            System.out.println("Enter sales details:");
                            System.out.println("Enter rental reg_no:");
                            reg_no=Integer.parseInt(sc.nextLine().trim());
                            System.out.println("Enter start date as dd/mm/yy");
                            st_date=sc.nextLine().trim();
                            System.out.println("Enter send date as dd/mm/yy");
                            end_date=sc.nextLine().trim();

                            st=conn.prepareStatement("insert into rented values (?,?,?,?);");
                            st.setInt(1,agent_id);
                            st.setInt(2,reg_no);
                            st.setString(3,st_date);
                            st.setString(4,end_date);
                            st.execute();
                            conn.prepareStatement("update Rental\n" +
                                    "set status='taken'\n" +
                                    "where reg_no = ?;");
                            st.setInt(1, reg_no);
                            st.execute();
                            System.out.println("Updated");
                        break;
                        case 3:
                            System.out.println("Exiting Agent interface");
                        break;
                        default:
                            System.out.println("Choice doesnt exist");
                    }
                    if(choice==3)
                        break;
                }
                conn.close();
                sc.close();
                break;
            } catch (Exception e) {
                System.out.println("Something happened!"+e);
            }
        }
    }

}
