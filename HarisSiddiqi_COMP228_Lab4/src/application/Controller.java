package application;

// Import JavaFx resources
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller extends Application {
	
	// Create text fields
    private TextField AnnualInterestRateFX = new TextField();
    private TextField NumberOfYearsFX = new TextField();
    private TextField LoanAmountFX = new TextField();
    private TextField MonthlyPaymentFX = new TextField(); // Additional feature
    private TextField TotalPaymentFX = new TextField();
    private Button CalculateFX = new Button("Compute Payment");
    private Button ResetFX = new Button("Reset"); // Reset button
    
    // Set stage
    @Override
    public void start(Stage primaryStage){
    	// Text fields and labels
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Annual Interest Rate (%)*"),0,0);
        gridPane.add(AnnualInterestRateFX, 1, 0);
        gridPane.add(new Label("Number of Years"), 0, 1);
        gridPane.add(NumberOfYearsFX, 1, 1);
        gridPane.add(new Label("Investment Amount"), 0, 2);
        gridPane.add(LoanAmountFX, 1, 2);
        gridPane.add(new Label("Monthly Contribution**"), 0, 3);
        gridPane.add(MonthlyPaymentFX, 1, 3);
        gridPane.add(new Label("Total Payment"), 0, 4);
        gridPane.add(TotalPaymentFX, 1, 4);
        gridPane.add(new Label("*compounded monthly"), 0, 6);
        gridPane.add(new Label("**contributions made at end of month"), 0, 7);
        
        // Buttons
        gridPane.add(CalculateFX, 0, 10);
        gridPane.add(ResetFX, 1, 10); // Place reset button
        
        // Alignment
        gridPane.setAlignment(Pos.CENTER);
        AnnualInterestRateFX.setAlignment(Pos.BOTTOM_RIGHT);
        NumberOfYearsFX.setAlignment(Pos.BOTTOM_RIGHT);
        LoanAmountFX.setAlignment(Pos.BOTTOM_RIGHT);
        MonthlyPaymentFX.setAlignment(Pos.BOTTOM_RIGHT);
        TotalPaymentFX.setAlignment(Pos.BOTTOM_RIGHT);
        //MonthlyPaymentFX.setEditable(false);
        TotalPaymentFX.setEditable(false);
        GridPane.setHalignment(CalculateFX, HPos.RIGHT);
        GridPane.setHalignment(ResetFX, HPos.CENTER);
        
        // Calculate button action
        CalculateFX.setOnAction(e -> {
            calculateLoanPayment();
        });
        
        
        // Reset button action
        ResetFX.setOnAction(e -> {
        	resetMethod();
        });
        
        // Configure scene
        Scene scene = new Scene(gridPane, 500, 300);
        primaryStage.setTitle("Investment Calculator by Haris");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Calculate method
    private void calculateLoanPayment(){

        double interest = Double.parseDouble(AnnualInterestRateFX.getText());
        int year = Integer.parseInt(NumberOfYearsFX.getText());
        double loanAmount = Double.parseDouble(LoanAmountFX.getText());
        double monthlyContribution = Double.parseDouble(MonthlyPaymentFX.getText());

        Loan loan = new Loan(interest, year, loanAmount, monthlyContribution);

        //MonthlyPaymentFX.setText(String.format("$%.2f", loan.getMonthlyPayment()));
        TotalPaymentFX.setText(String.format("$%.2f", loan.getTotalPayment()));

    }
    
    // Reset method
    private void resetMethod() {
    	// Clear text fields
    	AnnualInterestRateFX.clear();
    	NumberOfYearsFX.clear();
    	LoanAmountFX.clear();
    	TotalPaymentFX.clear();
    	MonthlyPaymentFX.clear();
    }
    
    // Launch
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
