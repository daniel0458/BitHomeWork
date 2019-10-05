package vo;

public class SavingAccount extends BankAccount{
	final double INTEREST = 5.7;	//이자율
	int saveAvg;					//월입금액
	int saveAmount;					//총 납입금액
	double saveReturn;				//만기시 환금액
	
	@Override
	public void calc() {
		this.saveAmount = saveAvg * term;
		this.interestAmount = INTEREST * saveAmount/100;
		this.saveReturn = saveAmount + this.interestAmount; 
	}
	
	public SavingAccount() {}

	public SavingAccount(String name, int term, String accNum, double interestAmount,int saveAvg, int saveAmouont, double saveReturn) {
		super(name, term, accNum, interestAmount);
		this.saveAvg = saveAvg;
		this.saveAmount = saveAmouont;
		this.saveReturn = saveReturn;
		
	}
	public String getName() {
		return name;
	}
	public int getTerm() {
		return term;
	}
	public String getAccNum() {
		return accNum;
	}
	public double getInterestAmount() {
		return interestAmount;
	}
	public int getSaveAvg() {
		return saveAvg;
	}

	public void setSaveAvg(int saveAvg) {
		this.saveAvg = saveAvg;
	}

	public int getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(int saveAmount) {
		this.saveAmount = saveAmount;
	}

	public double getSaveReturn() {
		return saveReturn;
	}

	public void setSaveReturn(double saveReturn) {
		this.saveReturn = saveReturn;
	}

	public double getINTEREST() {
		return INTEREST;
	}

	@Override
	public String toString() {
		return "SavingAccount [name=" + name + ", term=" + term + ", accNum=" + accNum + ", interestAmount=" + 
				interestAmount +", saveAvg=" + saveAvg + ", saveAmouont=" + saveAmount + ", saveReturn=" + saveReturn
				+ ", INTEREST=" + INTEREST + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(INTEREST);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saveAmount;
		result = prime * result + saveAvg;
		temp = Double.doubleToLongBits(saveReturn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavingAccount other = (SavingAccount) obj;
		if (Double.doubleToLongBits(INTEREST) != Double.doubleToLongBits(other.INTEREST))
			return false;
		if (saveAmount != other.saveAmount)
			return false;
		if (saveAvg != other.saveAvg)
			return false;
		if (Double.doubleToLongBits(saveReturn) != Double.doubleToLongBits(other.saveReturn))
			return false;
		return true;
	}

}
