/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2finalproject;

import javax.swing.JOptionPane;

/**
 *
 * @author dejahmurray
 */
public class PasswordHelper {

    /**
     * Compares passwords to determine if they match, and are valid passwords
     * with length 8-10 characters, at least 1 digit, at least 1 uppercase
     * letter, at least 1 lowercase letter
     *
     * @param pw1 the first password entered by the user
     * @param pw2 the second password entered by the user to confirm password
     * @return true if password if valid and false if password is invalid
     */
    //Checks password: must have length 8-10 characters, 1 upper/lower case, 1 digit
    public boolean equals(String pw1, String pw2) {
        return pw1.equals(pw2);
    }

    public static boolean isValid_UNUSED(String pass) {
        boolean hasDigit = false;
        boolean validLength = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        if (pass.length() >= 8 && pass.length() <= 10) {
            validLength = true;
        }
        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            }
        }
        if (hasDigit == true && hasUpper == true
                && hasLower == true && validLength == true) {
            return true;
        } else {
            /*JOptionPane.showMessageDialog(null, "Password must have at least 1 upper case letter, "
                    + "1 lower case letter, 1 digit");
             */
            return false;
        }
    }

    public static boolean isValid(String pass) {
        if (pass.length() < 8 || pass.length() > 10) { //If password length is invalid
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            }
        }
        
        return hasDigit && hasUpper && hasLower;
    }
}
