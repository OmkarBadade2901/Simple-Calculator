package com.example.simplecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
    @FXML
    private Label output,history;
    private long number1=0;
    private String operator="";
    private boolean start = true;
    private  String termCollection ="";


    @FXML
    public void numpadprocess(ActionEvent e){
        if(start){
            output.setText("");
            start=false;
        }
        output.setText(output.getText()+((Button)e.getSource()).getText());
    }

    @FXML
    public void operatorProcess(ActionEvent e){
        String value = ((Button)e.getSource()).getText();
        if(!start) {
            if (!value.equals("=")) {
                operator = value;
                number1 = Long.parseLong(output.getText());
                termCollection=number1+value;
                showHistory();
                output.setText("");
            } else {
                if (!operator.isEmpty()) {
                    long number2 = Long.parseLong(output.getText());
                    output.setText(Long.toString(Model.calculate(number1, number2, operator)));
                    start = true;
                    termCollection="";
                    showHistory();
                }
            }
        }
    }

    @FXML
    public  void clearScreen(ActionEvent e){
        number1=0;
        output.setText("0");
        termCollection="";
        showHistory();
        start=true;
    }

    public void showHistory(){
        history.setText(termCollection);
    }
}