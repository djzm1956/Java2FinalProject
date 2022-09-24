/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2finalproject;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * Creates DownloadStatsPanel and downloads statistics files
 *
 * @author dejahmurray
 */
public class DownloadStatsPanel extends JFrame {

    //JButton that allows user to initiate download statistics file proccess
    JButton downloadButton;
    //JTextField that allows user to enter statistics file name
    JTextField fileTF;

    /**
     * Creates a new JPanel that: displays a JTextField for user to enter stats
     * file name displays a JButton downloadButton that triggers method
     * createStatsFile() to be called
     */
    public DownloadStatsPanel() {
        setBackground(Color.BLUE);
        setTitle("Download Statistics");
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        setSize(650, 100);

        JLabel fileLabel = new JLabel("Enter statistics file name/path: ");
        fileTF = new JTextField(25);

        panel.add(fileLabel);
        panel.add(fileTF);
        downloadButton = new JButton("Download");
        downloadButton.addActionListener(new downloadButtonHandler());
        panel.add(downloadButton);
        add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Creates a statistics file by retrieving Students from shared ArrayList
     * StudentArray Sorts Students by last name using lambda expression
     */
    public void createStatsFile() {
        try {
            File f = new File(fileTF.getText() + ".txt");
            PrintWriter pw = new PrintWriter(f);
            //WORKS: Collections.sort(Student.StudentArray, Student.lastNameComparator);
            //System.out.println("Sorted by last name: ");
            Collections.sort(Student.StudentArray, Comparator.comparing(a -> a.getFirstName()));

            for (Student s : Student.StudentArray) {
                s.setPassword(null);
                pw.print(s + "\n");
                System.out.println(s);
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("Error creating statistics file");
        }

        JOptionPane.showMessageDialog(null, "Statistics file created: " + fileTF.getText() + ".txt");
    }

    private class downloadButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e2) {
            JButton button = (JButton) e2.getSource();
            if (button == downloadButton) {
                //System.out.println("This button works");
                createStatsFile();
            }
        }
    }

}
