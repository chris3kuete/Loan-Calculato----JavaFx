/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loancalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sa
 */
public class LoanCalculator extends Application {

    private TextField AnnualInterestRate = new TextField();
    private TextField NumberOfYears = new TextField();
    private TextField LoanAmount = new TextField();
    private TextField MonthlyPayment = new TextField();
    private TextField TotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        
        GridPane g = new GridPane();
        g.setHgap(5);
        g.setVgap(5);
        g.add(new Label("Annual Interest Rate:"), 0, 0);
        g.add(AnnualInterestRate, 1, 0);
        g.add(new Label("Number of Years:"), 0, 1);
        g.add(NumberOfYears, 1, 1);
        g.add(new Label("Loan Amount:"), 0, 2);
        g.add(LoanAmount, 1, 2);
        g.add(new Label("Monthly Payment:"), 0, 3);
        g.add(MonthlyPayment, 1, 3);
        g.add(new Label("Total Payment:"), 0, 4);
        g.add(TotalPayment, 1, 4);
        g.add(btCalculate, 1, 5);
        
        //Set the properties for UI
        g.setAlignment(Pos.CENTER);
        AnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        NumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        LoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        MonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        TotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        MonthlyPayment.setEditable(false);
        TotalPayment.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        
        //Process events
        btCalculate.setOnAction(e -> calculateLoanPayment());
        

        Scene scene = new Scene(g, 300, 250);

        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    private void calculateLoanPayment(){
        //Get values from text fields
        double interest= Double.parseDouble(AnnualInterestRate.getText());
        int year = Integer.parseInt(NumberOfYears.getText());
        double loanAmount = Double.parseDouble(LoanAmount.getText());
        
        //Create a Loan Object
        Loan loan = new Loan(interest, year, loanAmount);
        
        //Display monthly payment and total payment
        MonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
        TotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
