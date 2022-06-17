import java.sql.*;
import java.util.Scanner;

import frontend.agent;
import frontend.re_agent;

public class Main{
    public static void main(String[] args) {
        int trials=0,choice=0;
        while (true) {
            trials++;
            if(trials>=5){
                System.out.println("Connection lost too many times! Ending program");
                break;
            }
            try {
                Scanner sc=new Scanner(System.in);
                while(true) {
                    System.out.println("Enter your user type");
                    System.out.print("Users are: \n1 real estate office\n2 agent\n3 exit\n");
                    choice = Integer.parseInt(sc.nextLine());
                    switch(choice){
                        case 1:
                            re_agent.main(null);
                            break;
                        case 2:
                            agent.main(null);
                            break;
                        case 3:
                            System.out.println("Exiting program");
                            break;
                        default:
                            System.out.print("Wrong choice! No Real Estate info for you\n");
                            choice=0;

                    }
                    if(choice!=0)
                        break;
                }
                sc.close();
                break;
            } catch (Exception e) {
                System.out.println("Something happened!"+e);
            }
        }
    }

}
