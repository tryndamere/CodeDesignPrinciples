package com.jiker.unit3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CaloriesCalculator extends JFrame {

    private JRadioButton rBtnMale;
    private JRadioButton rBtnFemale;
    private JRadioButton rBtnX1;
    private JRadioButton rBtnX2;
    private JTextField txtFeet;
    private JTextField txtInches;
    private JTextField txtWeight;
    private JTextField txtAge;
    private JTextField txtCalories;

    private java.util.List<JRadioButton> jRadioButtonList = new ArrayList(4);

    public CaloriesCalculator() throws HeadlessException {
        super("CaloriesCalculator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(this.initVerticalBox());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CaloriesCalculator();
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
        JButton btnCalculate = new JButton("Calculate");
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
        rBtnX1 = new JRadioButton("x1");
        rBtnX2 = new JRadioButton("x2");
        rBtnMale.setSelected(true);
        btnGroup.add(rBtnMale);
        btnGroup.add(rBtnFemale);
        btnGroup.add(rBtnX1);
        btnGroup.add(rBtnX2);
        panelRadio.add(rBtnMale);
        panelRadio.add(rBtnFemale);
        panelRadio.add(rBtnX1);
        panelRadio.add(rBtnX2);
        jRadioButtonList.add(rBtnMale);
        jRadioButtonList.add(rBtnFemale);
        jRadioButtonList.add(rBtnX1);
        jRadioButtonList.add(rBtnX2);
        return panelRadio;
    }

    private Factors getFactors() {
        String genderName = this.jRadioButtonList.stream()
                .filter(btn -> btn.isSelected())
                .map(btn -> btn.getText()).collect(Collectors.toList())
                .get(0);
        return Gender.getFactors(genderName);
    }

    private void Calculate() {
        String value = new Calories.Builder()
                .factors(this.getFactors())
                .weight(this.txtWeight.getText())
                .feet(this.txtFeet.getText())
                .inches(this.txtInches.getText())
                .age(this.txtAge.getText())
                .build()
                .calc();
        this.txtCalories.setText(value);
    }
}
