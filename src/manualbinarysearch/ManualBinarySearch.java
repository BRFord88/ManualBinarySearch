package manualbinarysearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 * @author Brett
 * Date: 14 Jan 2018
 * ManualBinarySearch.java
 */
public class ManualBinarySearch {

    public static void main(String[] args) {
        Searcher search;
        try {
            search = new Searcher();
        } catch (Exception ex) {
            System.out.println("Exception:\n" + ex);
        } // end t/c
    } // end main method
    
} // end ManualBinarySearch class

class Searcher implements ActionListener{
    // GUI components
    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JButton lowerBtn, higherBtn, resetBtn;
    JLabel lowerLbl, higherLbl, recommendedTryLbl;
    JTextField lowValueTxt, highValueTxt, recommendedTryTxt;
    
    // Variables for Calculations
    int lowValue, highValue, recommendedTry;
    
    public Searcher(){
        // *** Initialization of GUI Objects ***
        // frame
        frame = new JFrame("Manual Binary Search");
        
        // panels
        topPanel = new JPanel();
        midPanel = new JPanel();
        bottomPanel = new JPanel();
        
        // buttons
        lowerBtn = new JButton("Lower");
        lowerBtn.addActionListener(this);
        higherBtn = new JButton("Higher");
        higherBtn.addActionListener(this);
        resetBtn = new JButton ("Reset");
        resetBtn.addActionListener(this);
        
        // labels
        lowerLbl = new JLabel("Low", SwingConstants.CENTER);
        higherLbl = new JLabel("High", SwingConstants.CENTER);
        recommendedTryLbl = new JLabel("Recommended Try:");
        
        // text fields
        lowValueTxt = new JTextField(3);
        lowValueTxt.setHorizontalAlignment(JTextField.CENTER);
        lowValueTxt.addActionListener(this);
        highValueTxt = new JTextField(3);
        highValueTxt.setHorizontalAlignment(JTextField.CENTER);
        highValueTxt.addActionListener(this);
        recommendedTryTxt = new JTextField(3);
        recommendedTryTxt.setEditable(false);
        recommendedTryTxt.setHorizontalAlignment(JTextField.CENTER);
        
        // *** Set Initial Variable Values and Text Fields ***
        reset();
        updateTextFields();
        
        // *** Configuration of GUI Components ***
        // borders
        Border paddedBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border lineBorder = BorderFactory.createLineBorder(Color.black);
        Border paddedLineBorder = BorderFactory.createCompoundBorder(lineBorder
                , paddedBorder);
        Border padLinePadBorder = BorderFactory.createCompoundBorder(paddedBorder
                , paddedLineBorder);
        
        // configure panels
        topPanel.setLayout(new GridLayout(2, 2, 50, 10));
        topPanel.add(lowerLbl);
        topPanel.add(higherLbl);
        topPanel.add(lowValueTxt);
        topPanel.add(highValueTxt);
        topPanel.setBorder(paddedBorder);
        
        midPanel.setLayout(new GridLayout(1, 2, 25, 20));
        midPanel.add(recommendedTryLbl);
        midPanel.add(recommendedTryTxt);
        midPanel.setBorder(padLinePadBorder);
        
        bottomPanel.setLayout(new GridLayout(1, 3, 20, 20));
        bottomPanel.add(higherBtn);
        bottomPanel.add(lowerBtn);
        bottomPanel.add(resetBtn);
        bottomPanel.setBorder(paddedBorder);

        // configure frame
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 1, 10, 10));
        frame.add(topPanel);
        frame.add(midPanel);
        frame.add(bottomPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        System.out.println(highValueTxt.getText().toString());
    } // end constructor

    private void lower() {
        highValue = Integer.parseInt(highValueTxt.getText());
        lowValue = Integer.parseInt(lowValueTxt.getText());
        recommendedTry = ((highValue - lowValue) / 2) + lowValue;
        highValue = recommendedTry;
        recommendedTry = highValue - ((highValue - lowValue) / 2);
    } // end lower
    
    private void higher() {
        highValue = Integer.parseInt(highValueTxt.getText());
        lowValue = Integer.parseInt(lowValueTxt.getText());
        recommendedTry = ((highValue - lowValue) / 2) + lowValue;
        lowValue = recommendedTry;
        recommendedTry = ((highValue - lowValue) / 2) + lowValue;
    } // end higher
    
    private void recalcRecommendedTry() {
        highValue = Integer.parseInt(highValueTxt.getText());
        lowValue = Integer.parseInt(lowValueTxt.getText());
        recommendedTry = ((highValue - lowValue) / 2) + lowValue;
    } // end recalcRecommendedTry
    
    private void reset() {
        lowValue = 10;
        highValue = 99;
        recommendedTry = 54;
    } // end reset

    private void updateTextFields() {
        lowValueTxt.setText("" + lowValue);
        highValueTxt.setText("" + highValue);
        recommendedTryTxt.setText("" + recommendedTry);
    } // end updateTextFields
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // perform action on text field update
        if (e.getSource() == lowValueTxt || e.getSource() == highValueTxt) {
            recalcRecommendedTry();
        } // end if/elseif

        // perform action based on button press
        switch (e.getActionCommand()) {
            case("Lower"): {
                lower();
                break;
            } // end lower case
            case("Higher"): {
                higher();
                break;
            } // end higher case
            case("Reset"): {
                reset();
                break;
            } // end reset case
        } // end switch
        
        updateTextFields();
    } // end actionPerformed method
} // end Searcher
