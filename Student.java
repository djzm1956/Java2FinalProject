/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2finalproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 * Creates Student objects
 *
 * @author dejahmurray
 */
public class Student {

    //Student first name example "Dejah"
    public String firstName;

    //public last name of Student
    public String lastName;

    //email address will be auto-generated, used to contact Students and search by email
    public String email;

    //password in plain text 
    public String password;

    //public static int shared between classes, holds available bannerID numbers
    //Used to create unique banner ID
    public static int nextAvailableBannerID = 1;

    //
    public int studentID;

    //public major of Student
    // Ex. "Computer Science", "Biology"
    public String major;

    //public balance of Student
    // Amount Student owes for tuition
    //change to amount owed
    public float amountOwed;

    //For the sake of this exercise, its assumed that Student can only be full time, part time or have no major
    //In real life a Student can have no major and be part time
    public enum StudentType {
        FULLTIME, PARTTIME, NOMAJOR
    };

    //public StudentType of Student
    public StudentType type;

    // List of all Students for whole app, shared between classes
    //rename to Students
    public static ArrayList<Student> StudentArray = new ArrayList<Student>();

    /**
     * Default Student constructor Takes no parameters Updates
     * nextAvailableBannerID and bannerID
     */
    public Student() {
        studentID = nextAvailableBannerID;//5
        nextAvailableBannerID++;//7
    }

    /**
     * Most comprehensive constructor, used by other Student constructors
     * Creates a new Student object and sets first name, last name, password,
     * email, bannerID, StudentType, major, balance
     *
     * @param firstName the Student's first name
     * @param lastName the Student's last name
     * @param password the Student's password
     * @param email the Student's email address
     * @param bID the Student's bannerID
     * @param sType the Student's type: Full Time, Part Time, No Major
     * @param mjr the Student's major
     * @param bal the Student's account balance
     * @throws Exception if there is an error when reading from a file and
     * creating Student object
     */
    //use this.
    public Student(String firstName, String lastName, String password, String email, int bID, StudentType sType, String mjr, float bal)
            throws Exception {
        //e = f.charAt(0)+ l + "@mcc.edu";
        if (firstName == null) {
            throw new NullPointerException("firstName is null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        studentID = bID;
        type = sType;
        studentID = nextAvailableBannerID;
        nextAvailableBannerID++;;
    }

    /**
     * Refers to comprehensive Student constructor to create Student
     *
     * @param f
     * @param l
     * @param p
     * @param e
     * @param b
     * @param sType
     * @param bal
     * @throws Exception
     */
    public Student(String f, String l, String p, String e, int b, StudentType sType, float bal)
            throws Exception {
        this(f, l, p, e, b, sType, null, bal);
    }

    /**
     * Refers to comprehensive Student constructor to create Student
     *
     * @param f
     * @param l
     * @param p
     * @param b
     * @param sType
     * @param bal
     * @throws Exception
     */
    public Student(String f, String l, String p, int b, StudentType sType, float bal)
            throws Exception {
        this(f, l, p, null, b, sType, bal);
    }

    /**
     * Refers to comprehensive Student constructor to create Student
     *
     * @param f
     * @param l
     * @param sType
     * @param pw
     * @param mjr
     * @param bal
     * Email Format: "dmurray@mcc.edu"
     */
    public Student(String f, String l, StudentType sType, String pw, String mjr, float bal) {
        firstName = f;
        lastName = l;
        type = sType;
        email = (f.charAt(0) + l + "@mcc.edu");
        //if pw equals confirm pw, do this          
        password = pw;
        type = sType;
        major = mjr;
        amountOwed = bal;
        studentID = nextAvailableBannerID;
        nextAvailableBannerID++;
    }

    /**
     *
     * @return String str that prints Student information
     */
    public String toString() {
        //%s%n for using enum in printf/ String.format
        String str = String.format("%s, %s, %s, %s , %s, %s, %s, $%.2f ",
                firstName, lastName, email, password, studentID, type, major, amountOwed);
        return str;
    }

    

    //mutator and accessor methods
    /**
     *
     * @return a String containing Student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets Student's first name
     *
     * @param newfn is a String for Student's first name
     */
    public void setFirstName(String newfn) {
        firstName = newfn;
    }

    /**
     *
     * @return String containing Student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets Student's last name
     *
     * @param newln is a String for Student's last name
     */
    public void setLastName(String newln) {
        lastName = newln;
    }

    /**
     *
     * @return String containing Student's password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param newpw is a String for Student's password
     */
    public void setPassword(String newpw) {
        password = newpw;
    }

    /**
     *
     * @return String containing Student's bannerID
     */
    public int getBannerID() {
        return studentID;
    }

    /**
     * Sets Student's bannerID to newBanner
     *
     * @param newBanner is an int for the Student's bannerID
     */
    public void setBannerID(int newBanner) {
        studentID = newBanner;
    }

    /**
     *
     * @return returns a StudentType enumerator for the Student's type
     */
    public StudentType getStudentType() {
        return type;
    }

    /**
     * Sets the Student's StudentType
     *
     * @param newType is a StudentType enumerator containing the Student's type
     */
    public void setStudentType(StudentType newType) {
        type = newType;
    }

    /**
     * Sets the Student's major
     *
     * @param newMajor is a String containing the major of the Student
     */
    public void setMajor(String newMajor) {
        major = newMajor;
    }

    /**
     *
     * @return returns the Student's major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the Student's email
     *
     * @param newEmail is a String containing the email for the student
     */
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    /**
     *
     * @return returns the email of the Student
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Student's remaining balance
     *
     * @param newRemBal is a float containing the remaining balance for the
     * Student
     */
    public void setBalance(float newRemBal) {
        amountOwed = newRemBal;
    }

    /**
     *
     * @return returns a float for the Student's remaining balance
     */
    public float getBalance() {
        return amountOwed;
    }

}
