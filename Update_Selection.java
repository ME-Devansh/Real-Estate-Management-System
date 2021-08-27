package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update_Selection extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2;
    Update_Selection()
    {
        super("Update Selection");
        getContentPane().setBackground(Color.black);

        Font button_font=new Font("Pacifico",Font.BOLD,25);

        l1 = new JLabel("Please select the property sales type:");
        l1.setBounds(20,200,1000,50);
        l1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        l1.setForeground(Color.white);
        add(l1);

        b1 = new JButton("Property sold");
        b1.setBounds(400,500, 300, 100);
        b1.setForeground(Color.RED);
        b1.setBackground(Color.GRAY);
        b1.setFont(button_font);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Property rented");
        b2.setBounds(710,500,300,100);
        b2.setForeground(Color.RED);
        b2.setBackground(Color.GRAY);
        b2.setFont(button_font);
        b2.addActionListener(this);
        add(b2);



        setLocation(200, 300);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1) {
            new Property_Update();
        }
        if(e.getSource()==b2) {
            new Rental_Change();
        }
    }

    /*public static void main(String[] args)
    {
        new Update_selection();
    }*/

}