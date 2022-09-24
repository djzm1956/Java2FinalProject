/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2finalproject;

import java.awt.*;
import javax.swing.*;
//for event listeners
import java.awt.event.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Creates GUI Windows for Student Records System
 *
 * @author dejahmurray
 */
public class Java2FinalProject {

    /**
     * Creates JFrame StudentWindow(), creates JPanel buildDisplayPanel(), holds
     * Students variables
     *
     */
    public static class StudentWindow extends JFrame {

        //JRadioButton that allows user to select option: Upload Students
        JRadioButton UploadStudentRB = new JRadioButton();

        //JButton that allows user to select Upload Button;
        JButton UploadButton;

        //JRadioButton that allows user to select option: Add Students
        JRadioButton AddStudentRB = new JRadioButton();

        //JRadioButton that allows user to select option: Download Statistics File
        JRadioButton DownloadStatsRB = new JRadioButton();

        //JRadioButton that allows user to select option: Find Students
        JRadioButton FindStudentRB = new JRadioButton();

        //JRadioButton that allows user to select option: Exit, which exits the program
        JRadioButton ExitRB;

        //public ArrayList<Student> studentsList = new ArrayList<Student>();
        //public ArrayList<Student> StudentArray;
        //builds basic display panel
        //Creates StudentWindow JFrame
        public StudentWindow() {
            //setTitle("Student Records");
            //setSize(600,300);   
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            buildDisplayPanel();
            //buildPanel4();
            //buildPanel2();
            setVisible(true);
        }

        /**
         * Creates buildDisplayPanel() for JFrame StudentWindow() Displays
         * options to user: Upload Students, Add Students, Download Statistics,
         * Find Students, Exit
         */
        public void buildDisplayPanel() {
            setSize(600, 300);
            setBackground(Color.BLUE.brighter());
            setLayout(new GridLayout(6, 1));
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();
            JPanel panel5 = new JPanel();
            JPanel panel6 = new JPanel();

            panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            //setLayout(new FlowLayout(FlowLayout.CENTER));
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

            setTitle("Student Records");
            JLabel WelcomeLabel = new JLabel("Welcome to MCC's Student "
                    + "Record System. Please choose from the following options: ");
            UploadStudentRB = new JRadioButton("Upload Student Records from File");
            AddStudentRB = new JRadioButton("Add New Student");
            DownloadStatsRB = new JRadioButton("Download Statistics");
            FindStudentRB = new JRadioButton("Find Student");
            ExitRB = new JRadioButton("Exit Program");

            WelcomeLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

            ButtonGroup bg = new ButtonGroup();
            bg.add(UploadStudentRB);
            bg.add(AddStudentRB);
            bg.add(DownloadStatsRB);
            bg.add(FindStudentRB);
            bg.add(ExitRB);

            buttonHandler b1 = new buttonHandler();
            UploadStudentRB.addActionListener(b1);
            AddStudentRB.addActionListener(b1);
            DownloadStatsRB.addActionListener(b1);
            FindStudentRB.addActionListener(b1);
            ExitRB.addActionListener(b1);

            panel1.add(WelcomeLabel);
            panel2.add(UploadStudentRB);
            panel3.add(AddStudentRB);
            panel4.add(DownloadStatsRB);
            panel5.add(FindStudentRB);
            panel6.add(ExitRB);

            add(panel1);
            add(panel2);
            add(panel3);
            add(panel4);
            add(panel5);
            add(panel6);

        }

        /**
         * Handles click events for JRadioButtons Displays a new Window
         * depending on the JRadioButton clicked by the user
         */
        private class buttonHandler implements ActionListener {

            public void actionPerformed(ActionEvent e1) {
                JRadioButton button = (JRadioButton) e1.getSource();
                if (ExitRB.isSelected()) {
                    System.exit(0);
                } else if (UploadStudentRB.isSelected()) {
                    new UploadStudentRecordsPanel();
                } else if (DownloadStatsRB.isSelected()) {
                    new DownloadStatsPanel();
                } else if (FindStudentRB.isSelected()) {
                    new FindStudentPanel();
                } else if (AddStudentRB.isSelected()) {
                    new AddStudentPanel();
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner k = new Scanner(System.in);

        //Student.StudentArray.add(new Student());
        StudentWindow win = new StudentWindow();
        //display message screen

    }

}
