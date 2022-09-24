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
 * Creates UploadStudentRecordsPanel Uploads Files to shared ArrayList
 *
 * @author dejahmurray
 */
public class UploadStudentRecordsPanel extends JFrame {

    //takes file
    //file format last, first, email, pw, banner, studentType, major, balance
    //only ft and pt students can choose major
    //Strings for Student's info
    String first, last, email, pass, ban, maj;
    //float for Student's balance
    float balance;
    //JButton that allows user to initiate upload proccess
    JButton UploadButton;
    //JTextField that allows user to enter file name
    JTextField filePathTextField;
    //creates StudentType variable from Student class
    public Student.StudentType sType;
    //public enum StudentType {FULLTIME, PARTTIME, NOMAJOR};
    //public ArrayList<Student> studentsList = new ArrayList<Student>();

    /**
     * Creates a JPanel that displays a JTextField for entering file name,
     * displays a JButton uploadButton that triggers method uploadRecords()
     */
    public UploadStudentRecordsPanel() {
        setBackground(Color.BLUE.brighter());
        JPanel panel = new JPanel();

        setTitle("Upload Student Records");
        setLayout(new FlowLayout());
        setSize(650, 100);

        JLabel filePathLabel = new JLabel("Enter file name/path: ");
        filePathTextField = new JTextField(30);

        UploadButton = new JButton("Upload");

        //adds action listener to upload button
        UploadButton.addActionListener(new uploadButtonHandler());
        //adds upload button handler
        //UploadButton.addActionListener(new buttonHandler());
        panel.add(filePathLabel);
        panel.add(filePathTextField);
        panel.add(UploadButton);

        add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        //display success message when doone reading file
        //can enter as many files as they want
        //if error occurs, use correct error msg
        //skip 'bad' lines, keep processing file

    }

    /**
     * Reads the file entered by the user line by line Adds 'bad' lines to a
     * String ArrayList Adds 'good' lines to shared ArrayList StudentArray
     *
     * @throws IOException when file name entered by user cannot be found
     */
    public void uploadRecords() throws IOException {

        File f = new File(filePathTextField.getText());
        Scanner input = new Scanner(f);

        ArrayList<String> badLines = new ArrayList<>();

        boolean validString = false;
        while (input.hasNext()) {

            String line = input.nextLine();
            String[] studentArray = line.split(", ");
            Student s = new Student();
            try {
                s.setLastName(studentArray[0]);
                s.setFirstName(studentArray[1]);
                s.setEmail(studentArray[2]);
                s.setPassword(studentArray[3]);
                s.setBannerID(Integer.parseInt(studentArray[4]));

                //replaces space with empty no space ""
                String type = (studentArray[5].replace(" ", "").toUpperCase());
                s.setStudentType(Student.StudentType.valueOf(type));

                if (s.getStudentType() == Student.StudentType.NOMAJOR) {
                    s.setMajor(null);
                    s.setBalance(Float.parseFloat(studentArray[6]));
                } else {
                    s.setMajor(studentArray[6]);
                    s.setBalance(Float.parseFloat(studentArray[7]));
                }

                Student.StudentArray.add(s);
                validString = true;
            } catch (Exception ex1) {
                validString = false;
                badLines.add(line + "\n");
                //JOptionPane.showMessageDialog(null, "Missing info on line: " + line);
                //ex1.printStackTrace();
            }

            //file format last, first, email, pw, banner, studentType, major, balance
        }
        System.out.println(Student.StudentArray);
        if (badLines.size() > 0) {
            JOptionPane.showMessageDialog(null, "Missing info on line: " + badLines);
        } else {
            JOptionPane.showMessageDialog(null, "Done uploading file: " + "\"" + filePathTextField.getText() + "\"");
        }
    }

    private class uploadButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e1) {
            boolean validFile = false;
            JButton button = (JButton) e1.getSource();
            if (button == UploadButton) {
                //System.out.println("I work");
                try {
                    uploadRecords();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ran into a problem: " + ex.getMessage());
                }

            }
        }
    }

}
