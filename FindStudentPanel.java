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
import java.util.ArrayList;
import java.awt.event.*;

/**
 * Creates FindStudentPanel and finds students in shared ArrayList StudentArray
 *
 * @author dejahmurray
 */
public class FindStudentPanel extends JFrame {

    //Label for bannerTF
    JLabel bannerLabel;
    //JTexField that allows user to enter bannerID
    JTextField bannerTF;
    //Button that allows user to initiate find Student process        
    JButton findButton;

    /**
     * Creates Panel that displays JTextField for user to enter bannerID and
     * JButton findButton
     */
    public FindStudentPanel() {
        setBackground(Color.BLUE.brighter());
        setTitle("Find Student");
        setSize(420, 100);
        setLayout(new FlowLayout());
        JPanel panel = new JPanel();

        //tf for banner id
        bannerLabel = new JLabel("Banner ID: ");
        bannerTF = new JTextField(15);
        findButton = new JButton("Find Student");
        findButton.addActionListener(new findButtonHandler());
        //JOptionPane.showMessageDialog(null, "Student Info:");
        panel.add(bannerLabel);
        panel.add(bannerTF);
        panel.add(findButton);

        add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Retrieves bannerID from JTextField bannerTF, searches shared ArrayList
     * StudentArray to find matching bannerID, if a match is found, the
     * Student's name is displayed if no match is found an error message is
     * displayed to the user
     */
    public void searchForStudent() {
        boolean validBanner = false;
        int searchBanner = Integer.parseInt(bannerTF.getText());
        //goes into an array list
        //for each str in Student ArrayList, if str == banner return that Student
        //ArrayList<Student> studentList = Student.StudentArray;
        for (Student myStudent : Student.StudentArray) {
            //gets each students bannerID
            int myStudentID = myStudent.getBannerID();
            //if the students banner id equals search banner, display that student

            if (myStudentID == searchBanner) {
                validBanner = true;
                JOptionPane.showMessageDialog(null, "Student: " + myStudent.getFirstName() + " " + myStudent.getLastName());
                return;
            }
        }

        validBanner = false;
        JOptionPane.showMessageDialog(null, "Invalid Banner ID: " + searchBanner);
    }

    private class findButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e4) {
            JButton button = (JButton) e4.getSource();
            if (button == findButton) {
                //System.out.println("testing");
                searchForStudent();
            }

        }
    }
}
