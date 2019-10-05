package vo;

public abstract class BankAccount {
	String name;			//사용자 이름
	int term;				//기간
	String accNum;			//계좌번호
	double interestAmount;	//총 이자액
	
	//각  vo의 이자관련 변수들을 계산하는 메소드
	public abstract void calc();
	
	public BankAccount() {}

	public BankAccount(String name, int term, String accNum, double interestAmount) {
		super();
		this.name = name;
		this.term = term;
		this.accNum = accNum;
		this.interestAmount = interestAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", term=" + term + ", accNum=" + accNum + ", interestAmount="
				+ interestAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(interestAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + term;
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
		BankAccount other = (BankAccount) obj;
		if (accNum == null) {
			if (other.accNum != null)
				return false;
		} else if (!accNum.equals(other.accNum))
			return false;
		if (Double.doubleToLongBits(interestAmount) != Double.doubleToLongBits(other.interestAmount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (term != other.term)
			return false;
		return true;
	}

}
