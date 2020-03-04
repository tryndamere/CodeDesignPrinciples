package com.jiker.unit3;

import javax.swing.*;
import java.awt.*;

public class CaloriesCalculator extends JFrame {

    private JRadioButton rBtnMale;
    private JRadioButton rBtnFemale;
    private JTextField txtFeet;
    private JTextField txtInches;
    private JTextField txtWeight;
    private JTextField txtAge;
    private JTextField txtCalories;
    private JButton btnCalculate;

    public static void main(String[] args) {
        new CaloriesCalculator();
    }

    public CaloriesCalculator() throws HeadlessException {
        super("CaloriesCalculator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(this.initVerticalBox());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private Box initVerticalBox() {
        Box vBox = Box.createVerticalBox();
        vBox.add(this.initGenderPanel());
        vBox.add(this.initHeightPanel());
        vBox.add(this.initWeightPanel());
        vBox.add(this.initAgePanel());
        vBox.add(this.initCalcPanel());
        vBox.add(this.initCaloriesPanel());
        return vBox;
    }

    private JPanel initCaloriesPanel() {
        JPanel panelCalories = createFlowLayoutPanel();
        panelCalories.add(new JLabel("Recommended Daily Amount:"));
        this.txtCalories = new JTextField(8);
        panelCalories.add(txtCalories);
        return panelCalories;
    }

    private JPanel createFlowLayoutPanel() {
        return new JPanel(new FlowLayout(FlowLayout.LEFT));
    }

    private JPanel initCalcPanel() {
        JPanel panelCalc = createFlowLayoutPanel();
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(arg0 -> Calculate());
        panelCalc.add(btnCalculate);
        return panelCalc;
    }

    private JPanel initAgePanel() {
        JPanel panelAge = createFlowLayoutPanel();
        panelAge.add(new JLabel("      Age:"));
        txtAge = new JTextField("12", 8);
        panelAge.add(txtAge);
        panelAge.add(new JLabel("year"));
        return panelAge;
    }

    private JPanel initWeightPanel() {
        JPanel panelWeight = createFlowLayoutPanel();
        panelWeight.add(new JLabel("Weight:"));
        txtWeight = new JTextField("110", 8);
        panelWeight.add(txtWeight);
        panelWeight.add(new JLabel("lb"));
        return panelWeight;
    }

    private JPanel initHeightPanel() {
        JPanel panelHeight = createFlowLayoutPanel();
        panelHeight.add(new JLabel(" Height:"));
        txtFeet = new JTextField("5", 8);
        panelHeight.add(txtFeet);
        panelHeight.add(new JLabel("ft"));
        txtInches = new JTextField("1", 8);
        panelHeight.add(txtInches);
        panelHeight.add(new JLabel("in"));
        return panelHeight;
    }

    private JPanel initGenderPanel() {
        JPanel panelRadio = createFlowLayoutPanel();
        ButtonGroup btnGroup = new ButtonGroup();
        rBtnMale = new JRadioButton("Male");
        rBtnFemale = new JRadioButton("Female");
        rBtnMale.setSelected(true);
        btnGroup.add(rBtnMale);
        btnGroup.add(rBtnFemale);
        panelRadio.add(rBtnMale);
        panelRadio.add(rBtnFemale);
        return panelRadio;
    }

    private void Calculate() {
        String value = new Calories.Builder()
                .isMale(this.rBtnMale.isSelected())
                .weight(this.txtWeight.getText())
                .feet(this.txtFeet.getText())
                .inches(this.txtInches.getText())
                .age(this.txtAge.getText())
                .build()
                .calc();
        this.txtCalories.setText(value);
    }
}
