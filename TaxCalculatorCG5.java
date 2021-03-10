package com.CPS2C_G5;
/**
 * This is our project work for the mid-sem
 * Members:
 * Names                           ID
 * Joshua Nyarko Boateng           01194083D
 * Frank Baides Ayi                01192129D
 * Edmund Ofori Darteh             01190273D
 * Emmanuel Larbi                  01191385D
 * Esther Addo                     01191350D
 *
 *
 * @author Group 5
 * @since  20210310
 * @version 1.0.0
 * */

//imports from java libraries
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxCalculatorCG5 {
    // setting  application components by using the 'private' access modifier
    // buttons
    private JButton calculateButton;
    private JButton resetButton;
    // frames
    private JPanel taxAppMainFrame; //panel to hold all components of application
    private JLabel appTitleLabel;  //label to hold application title
    private JPanel mainPanel;      //panel to hold sub components of application (JTextField,JLabel,JButton)
    // text fields
    private JTextField grossSalaryInputField;
    private JTextField taxInputField;
    private JTextField outputNetSalaryField;
    // labels
    private JLabel grossSalaryFieldLabel;
    private JLabel taxFieldLabel;
    private JLabel netSalaryFieldLabel;
    // labels for handling exceptions
    private JLabel taxError;
    private JLabel grossError;

    // declaring variables
    private double grossSalary, taxPercentage, tax, netSalary;

    //method for holding functionalities of application
    public TaxCalculatorCG5() {
        //adding actionListener on button to get inputs from the input fields to be calculated and displayed
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setting labels for handling exceptions to not visible
                grossError.setVisible(false);
                taxError.setVisible(false);
                //incorporating exceptions to handle error inputs
                try {
                    //getting gross salary input from user
                    grossSalary = Double.parseDouble(grossSalaryInputField.getText());
                }catch (Exception ex){ //exception to display error message
                    grossError.setVisible(true);
                }
               try {
                   //getting tax input from user
                   tax = Double.parseDouble(taxInputField.getText());
                   //formula to express tax input as percentage
                   taxPercentage = tax/100;
               }catch (Exception ex){ //exception to display error message
                   taxError.setVisible(true);
               }

               //formula to calculate for net salary
                netSalary =  grossSalary - (grossSalary*taxPercentage);
               //displaying net salary
                outputNetSalaryField.setText(String.valueOf(netSalary));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset button to set all input fields to null on click
                grossSalaryInputField.setText(null);
                taxInputField.setText(null);
                outputNetSalaryField.setText(null);
                grossError.setVisible(false);
                taxError.setVisible(false);
            }
        });
        outputNetSalaryField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setting output field to not editable
                outputNetSalaryField.setEditable(false);
            }
        });
    }

    public static void main(String[] args) {
        //setting components of application to be displayed on run
        JFrame app = new JFrame("Tax Calculator C G5");
        //constructor to add various components to frame
        app.setContentPane(new TaxCalculatorCG5().taxAppMainFrame);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setSize(400,300);
        app.setVisible(true);
    }
}
