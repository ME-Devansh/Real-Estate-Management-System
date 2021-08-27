package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DB_Interface extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1,b2;
    DB_Interface()
    {
        super("DB interface");
        getContentPane().setBackground(Color.black);

        Font button_font=new Font("Pacifico",Font.BOLD,25);

        l1 = new JLabel("Welcome to DataBase interface");
        l1.setBounds(20,20,1000,50);
        l1.setFont(new Font("Times New Roman", Font.ITALIC, 45));
        l1.setForeground(Color.white);
        add(l1);

        l2 = new JLabel("Please select your user type:");
        l2.setBounds(20,390,1000,30);
        l2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        l2.setForeground(Color.white);
        add(l2);

        b1 = new JButton("Agent");
        b1.setBounds(400,500, 200, 100);
        b1.setForeground(Color.RED);
        b1.setBackground(Color.GRAY);
        b1.setFont(button_font);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("RE Office Employee");
        b2.setBounds(610,500,400,100);
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
        if(e.getSource()==b1)
            new Update_Selection();
        if(e.getSource()==b2) {
            new RE_Office();
        }
    }

    /*public static void main(String[] args)
    {
        new DB_Interface();

    }*/

}