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
 * Creates AddStudentPanel and Adds Students to shared ArrayList
 *
 * @author dejahmurray
 */
public class AddStudentPanel extends JFrame {

    //Allows user to initiate adding Student
    JButton addButton;
    //Creates JTextField for first name
    JTextField firstNameTF;
    //Creates JTextField for last name
    JTextField lastNameTF;
    //Creates JTextField for first password entered
    JTextField password1TF;
    //Creates JTextField for second password entered
    JTextField password2TF;
    //Creates JTextField for major
    JTextField majorTF;
    //Creates JTextField for balance
    JTextField balanceTF;
    //String for Student's email
    String studentEmail;
    //Label for password1TF
    JLabel password1Label;
    //Label for password2TF
    JLabel password2Label;
    //Label for majorTF
    JLabel majorLabel;
    //Label for studentType JRadioButtons: Full Time, Part Time, No Major
    JLabel studentTypeLabel;
    //Label for balanceTF
    JLabel balanceLabel;
    //Label for lastNameTF
    JLabel lastNameLabel;
    //Label for firstNameTf
    JLabel firstNameLabel;
    //Creates new Student object

    //ButtonGroup for StudentType JRadioButtons: Full Time, Part Time, No Major
    ButtonGroup g2;

    //JRadioButton for StudentType FULLTIME
    JRadioButton fullTimeRB;
    //JRadioButton for StudentType PARTTIME
    JRadioButton partTimeRB;
    //JRadioButton for StudentType NOMAJOR
    JRadioButton noMajorRB;

    /**
     * Creates JPanel AddStudentPanel() which holds neccesary JLabels,
     * JTextfields, JRadiobuttons, JButtons needed to create a Student Uses
     * BorderLayout to organize components
     */
    public AddStudentPanel() {
        setBackground(Color.BLUE.brighter());

        setSize(400, 500);

        JPanel centerPanel = new JPanel();
        //JPanel westPanel = new JPanel();

        firstNameTF = new JTextField(20);
        lastNameTF = new JTextField(20);
        password1TF = new JTextField(20);
        password2TF = new JTextField(20);
        majorTF = new JTextField(20);
        balanceTF = new JTextField(20);
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        password1Label = new JLabel("Password:");
        password1Label.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        password2Label = new JLabel("Confirm Password:");
        password2Label.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        studentTypeLabel = new JLabel("Student Type:");
        studentTypeLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        majorLabel = new JLabel("Major:");
        majorLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        balanceLabel = new JLabel("Account Balance:");
        balanceLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        //studentTypeTF = new JTextField(25);
        //radioButtonHandler b2 = new radioButtonHandler();
        g2 = new ButtonGroup();
        fullTimeRB = new JRadioButton("Full Time");
        //fullTimeRB.addActionListener(b2);
        partTimeRB = new JRadioButton("Part Time");
        //partTimeRB.addActionListener(b2);
        noMajorRB = new JRadioButton("No Major");
        //noMajorRB.addActionListener(b2);
        g2.add(fullTimeRB);
        g2.add(partTimeRB);
        g2.add(noMajorRB);

        //add(directionsLabel, BorderLayout.NORTH);
        centerPanel.add(firstNameLabel);
        centerPanel.add(firstNameTF);
        centerPanel.add(lastNameLabel);
        centerPanel.add(lastNameTF);
        centerPanel.add(password1Label);
        centerPanel.add(password1TF);
        centerPanel.add(password2Label);
        centerPanel.add(password2TF);
        centerPanel.add(studentTypeLabel);
        centerPanel.add(fullTimeRB);
        centerPanel.add(partTimeRB);
        centerPanel.add(noMajorRB);
        //centerPanel.add(studentTypeTF);
        centerPanel.add(majorLabel);
        centerPanel.add(majorTF);
        centerPanel.add(balanceLabel);
        centerPanel.add(balanceTF);

        addButton = new JButton("Add Student");
        addButton.addActionListener(new addButtonHandler());
        add(addButton, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void showIncorrectPassword(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage);
        password1TF.setBackground(Color.red);
        password2TF.setBackground(Color.red);
    }

    /**
     * Adds Students by retrieving user input from JTextfields and StudentType
     * JRadioButtons updated to false if user input is not valid
     */
    public void addStudent() {
        Student s = new Student();
        boolean validPW = true;
        boolean validStudent = true;

        //tries to create the Student by retrieving user input
        try {

            if (firstNameTF.getText().length() != 0) {
                try {
                    s.setFirstName(firstNameTF.getText());
                } catch (Exception ex) {
                    firstNameTF.setBackground(Color.red);
                    validStudent = false;
                }

            }

            if (lastNameTF.getText().length() != 0) {
                try {
                    s.setLastName(lastNameTF.getText());
                } catch (Exception ex) {
                    lastNameTF.setBackground(Color.red);
                    validStudent = false;
                }
            }

            //Checks if passwords are empty
            if (password1TF.getText().length() == 0 || password2TF.getText().length() == 0) {//If any passwords are empty 
                showIncorrectPassword("Password is empty.");
                return;
            }
            
            //Checks if passwords match
            String pw1 = password1TF.getText();
            String pw2 = password2TF.getText();
            if (!pw1.equals(pw2)) { //If passwords don't match
                showIncorrectPassword("Passwords don't match.");
                return;
            }

            //Checks if valid password
            if (!PasswordHelper.isValid(pw2)) { //If password is invalid
                showIncorrectPassword("Password is invalid.");
                return;
            }

            //Password is valid and matches here
            s.setPassword(pw1);

            //if @param fullTimeRB is selected, set StudentType to FULLTIME
            if (fullTimeRB.isSelected()) {
                s.setStudentType(Student.StudentType.FULLTIME);
            } else //if @param partTimeRB is selected, set StudentType to PARTTIME
            if (partTimeRB.isSelected()) {
                s.setStudentType(Student.StudentType.PARTTIME);
            } else /* if noMajorRB is selected, set StudentType to NOMAJOR and set major to null*/ if (noMajorRB.isSelected()) {
                s.setStudentType(Student.StudentType.NOMAJOR);
                s.setMajor(null);
            }

            if (!noMajorRB.isSelected() && majorTF.getText().length() != 0) {
                try {
                    s.setMajor(majorTF.getText());
                } catch (Exception ex) {
                    majorTF.setBackground(Color.red);
                    validStudent = false;
                }
            }

            if (balanceTF.getText().length() != 0) {
                try {
                    s.setBalance(Float.parseFloat(balanceTF.getText()));
                } catch (Exception ex) {
                    balanceTF.setBackground(Color.red);
                    validStudent = false;
                }
            } else {
                balanceTF.setBackground(Color.red);
                validStudent = false;
            }

            //Generates the students email by retrieving students first and last name
            studentEmail = (s.getFirstName().charAt(0) + s.getLastName()).toLowerCase() + "@mcc.edu";
            s.setEmail(studentEmail);

            validPW = true;
        } //if there is an error creating the Student, tell the user
        catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, "Please enter all required information");
            //validStudent = false;
        }

        //if the Student is created successfully, reset JTextFields to blank and white
        if (validStudent
                == true) {
            Student.StudentArray.add(s);
            System.out.println(s);
            JOptionPane.showMessageDialog(null, String.format("Student Added Successfully\nEmail: %s\nBanner ID: %s", studentEmail, s.getBannerID()));

            firstNameTF.setText("");
            lastNameTF.setText("");
            password1TF.setText("");
            password2TF.setText("");
            majorTF.setText("");
            balanceTF.setText("");
            firstNameTF.setBackground(Color.WHITE);
            lastNameTF.setBackground(Color.WHITE);
            password1TF.setBackground(Color.WHITE);
            password2TF.setBackground(Color.WHITE);
            g2.clearSelection();
            majorTF.setBackground(Color.WHITE);
            balanceTF.setBackground(Color.WHITE);

        }
    }

    /**
     * Handles JButton addButton // * If addButton is clicked, addStudent()
     * method is called
     */
    private class addButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e3) {
            //System.out.println("Add button works");
            addStudent();
        }
    }
}
