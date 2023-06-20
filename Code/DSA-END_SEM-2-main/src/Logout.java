//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Stack;
//
//public class Logout {
//    public void logout() throws IOException {
//        Stack s = new Stack<>();  // creating stack  object as stack class is predefined here
//        FileReader gFileReader = new FileReader("qotes"); // reading quotation file
//        BufferedReader c = new BufferedReader(gFileReader);  // reads line by line
//        String line;  // stores file line in variable line
//        while((line=c.readLine())!=null) {
//            s.push(line); // addding line by line in satck
//        }
//        Random rand = new Random();   // using random class to get random quotation from qotes file
//        String string = (String) s.get(rand.nextInt(s.size()));
//        // by random method we are getting randomly one number from 0 to size of stack so u will get random number and using .get method you will get that index's value from stack
//        System.out.println(ConsoleColors.BLACK_BOLD+"----------------------------------------------------------------------------------------------------"+"\u001B[0m");
//        System.out.println(ConsoleColors.ORANGE_BACKGROUND+ConsoleColors.BLACK_BOLD+string);
//        System.out.println("\u001B[0m");
//c.close();
//    }
//}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Logout extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Logout frame = new Logout();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Logout() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1164, 674);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Logout...");
        lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 36));
        lblNewLabel.setBounds(111, 11, 172, 48);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("amrita7.jpg"));
        lblNewLabel_1.setBounds(37, 373, 1138, 262);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Successfull ");
        lblNewLabel_2.setForeground(Color.GREEN);
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 36));
        lblNewLabel_2.setBounds(293, 11, 205, 48);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("031.png"));
        lblNewLabel_3.setBounds(808, 22, 340, 340);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblNewLabel_4.setBounds(42, 149, 738, 153);
        contentPane.add(lblNewLabel_4);
    }
}
