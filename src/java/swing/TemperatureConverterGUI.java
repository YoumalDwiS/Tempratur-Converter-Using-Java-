package java.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TemperatureConverterGUI extends  JFrame{
    private JPanel TemperatureConverter;
    private JTextField temptextField;
    private JButton convertButton;
    private JComboBox temp1Cmb;
    private JComboBox temp2Cmb;
    private JLabel convertedLabel;
    private JLabel temp2Label;

    public static void main(String[] args){
        JFrame tcGUI = new TemperatureConverterGUI();
        tcGUI.setVisible(true);

    }

    public void convertCelsiustoFahrenheit(){
        int tempFahr = (int) ((Double.parseDouble(temptextField.getText()))*1.8+32);
        convertedLabel.setText(Integer.toString(tempFahr));
    }
    public void convertCelsiustoReamur(){
        int tempFahr = (int) ((Double.parseDouble(temptextField.getText()))*0.8);
        convertedLabel.setText(Integer.toString(tempFahr));
    }
    public void convertFahrenheittoCelsius(){
        int tempFahr = (int) ((Double.parseDouble(temptextField.getText())-32)*0.55556);
        convertedLabel.setText(Integer.toString(tempFahr));
    }
    public void convertFahrenheittoReamur(){
        int tempFahr = (int) ((Double.parseDouble(temptextField.getText())-32)*0.444444);
        convertedLabel.setText(Integer.toString(tempFahr));
    }
    public void convertReamurtoCelsius(){
        int tempFahr = (int) ((Double.parseDouble(temptextField.getText()))*1.25);
        convertedLabel.setText(Integer.toString(tempFahr));
    }
    public void convertReamurtoFahrenheit(){
        int tempFahr = (int) ((Double.parseDouble(temptextField.getText()))*2.25+32);
        convertedLabel.setText(Integer.toString(tempFahr));
    }

    public TemperatureConverterGUI() {
        this.setSize(450,300);
        this.setContentPane(TemperatureConverter);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Temperatur Converter");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(temp1Cmb.getSelectedItem() == temp2Cmb.getSelectedItem()){
                    convertedLabel.setText(temptextField.getText());
                }
                else if(temp1Cmb.getSelectedItem() == "Celcius" && temp2Cmb.getSelectedItem() == "Fahreinheit") {
                    convertCelsiustoFahrenheit();
                }
                else if(temp1Cmb.getSelectedItem() == "Celcius" && temp2Cmb.getSelectedItem() == "Reamur") {
                    convertCelsiustoReamur();
                }
                else if(temp1Cmb.getSelectedItem() == "Fahreinheit" && temp2Cmb.getSelectedItem() == "Celcius") {
                    convertFahrenheittoCelsius();
                }
                else if(temp1Cmb.getSelectedItem() == "Fahreinheit" && temp2Cmb.getSelectedItem() == "Reamur") {
                    convertFahrenheittoReamur();
                }
                else if(temp1Cmb.getSelectedItem() == "Reamur" && temp2Cmb.getSelectedItem() == "Celcius") {
                    convertReamurtoCelsius();
                }
                else if(temp1Cmb.getSelectedItem() == "Reamur" && temp2Cmb.getSelectedItem() == "Fahreinheit") {
                    convertReamurtoFahrenheit();
                }

            }
        });
        temp1Cmb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                convertedLabel.setText("");
            }
        });
        temp2Cmb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                convertedLabel.setText("");
            }
        });
    }
}
