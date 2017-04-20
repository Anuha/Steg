package com.example.anuhachera.myapplication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by anuhachera on 10/03/2016.
 */
public class Encode extends Thread {

    // Hash Algorithm
    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

                  //Netbeans tested - works!!!

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Practial 4 - Task 1 Bruteforce decoder

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // get string from user
        String rawString = jTextField6.getText();
        try {
            jTextArea1.append("SHA1 hash of string: " + PasswordDemo.SHA1(rawString)); // call SHA 1 from Password Demo applying string to text field
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
}
