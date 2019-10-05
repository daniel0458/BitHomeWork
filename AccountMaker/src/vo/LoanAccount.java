package vo;

public class LoanAccount extends BankAccount{
	final double INTEREST = 12.5;	//이자율
	int loanAmount;					//대출금액
	double loanAvg;					//월 상환액

	@Override
	public void calc() {
		
		double monthInterest = INTEREST / 1200;						//월이자율
		double avgInterest = Math.pow((1 + monthInterest), term);	//중복되는 계산식을 변수화
		this.loanAvg = loanAmount * monthInterest * (avgInterest / (avgInterest-1));
		this.interestAmount = loanAvg * term - loanAmount;
		
	}
	public LoanAccount() {}
	
	public LoanAccount(String name, int term, String accNum, double interestAmount,int loanAmount, double loanAvg) {
		super(name, term, accNum, interestAmount);
		this.loanAmount = loanAmount;
		this.loanAvg = loanAvg;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getLoanAvg() {
		return loanAvg;
	}

	public void setLoanAvg(double loanAvg) {
		this.loanAvg = loanAvg;
	}

	public double getINTEREST() {
		return INTEREST;
	}

	@Override
	public String toString() {
		return "LoanAccount [name=" + name + ", term=" + term + ", accNum=" + accNum + ", interestAmount=" + 
				interestAmount +", loanAmount=" + loanAmount + ", INTEREST=" + INTEREST + ", loanAvg=" + loanAvg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(INTEREST);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loanAmount;
		temp = Double.doubleToLongBits(loanAvg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanAccount other = (LoanAccount) obj;
		if (Double.doubleToLongBits(INTEREST) != Double.doubleToLongBits(other.INTEREST))
			return false;
		if (loanAmount != other.loanAmount)
			return false;
		if (Double.doubleToLongBits(loanAvg) != Double.doubleToLongBits(other.loanAvg))
			return false;
		return true;
	}

}
