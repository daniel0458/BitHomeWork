package service;

import java.util.List;

import vo.LoanAccount;
import vo.SavingAccount;

public interface AccountService {
	
	public int insertSaveAccount(SavingAccount vo);
	public int insertLoanAccount(LoanAccount vo);
	public List<SavingAccount> searchSaveAccount(String name);
	public List<LoanAccount> searchLoanAccount(String name);
	
}
