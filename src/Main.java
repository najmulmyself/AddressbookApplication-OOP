import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.io.*;
import  javax.swing.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Address address = new Address("Najmul","25","Dhaka","Bangladesh");
        JFrame frame = new JFrame();
        JButton button = new JButton(address.getName());
        button.setBounds(150,200,220,50);
        frame.add(button);
        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked");
            }
        });

    }


}