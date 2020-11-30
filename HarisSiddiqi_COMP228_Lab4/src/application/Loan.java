package application;

// Repurpose loan class for investment returns
public class Loan {
	
	// Variables
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;
    private double monthlyContribution;
    private double compoundInterval;
    
    // Methods
    public Loan(){
        //this(2.5,1,1000);
    }

    public Loan(double annualInterestRate,int numberOfYears,double loanAmount, double monthlyContribution){
        this.annualInterestRate = annualInterestRate/100;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
        this.monthlyContribution = monthlyContribution;
        this.compoundInterval = 12;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;

    }


    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;

    }

    public void setNumberOfyears(int numberOfyears){
        this.numberOfYears = numberOfyears;
    }


    public double getLoanAmount(){
        return loanAmount;
    }


    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }
    
    // Compound interest on monthly deposits
    public double getMonthlyPayment(){
    	// Break up terms and calculate
    	double firstTerm = 1 + (annualInterestRate / compoundInterval);
    	double secondTerm = numberOfYears * compoundInterval;
    	double thirdTerm = (Math.pow(firstTerm, secondTerm) - 1);
    	double fourthTerm = annualInterestRate / compoundInterval;
    	
        double total = monthlyContribution * (thirdTerm / fourthTerm);
        return total;
    }
    
    // Compoound interest on principal
    public double calcReturn(){
    	// Break up terms and calculate
    	double firstTerm = 1 + (annualInterestRate / compoundInterval);
    	double secondTerm = numberOfYears * compoundInterval;
    	double thirdTerm = Math.pow(firstTerm, secondTerm);
    	
    	double total = loanAmount * thirdTerm;
    	return total;
    }

    // Return total value of principal and monthly deposits
    public double getTotalPayment(){
        double totalPayment = calcReturn() + getMonthlyPayment();
        return totalPayment;
    }


    public java.util.Date getLoanDate(){
        return loanDate;
    }
}
