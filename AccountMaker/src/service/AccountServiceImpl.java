package service;

import java.util.List;

import dao.AccountDAO;
import vo.LoanAccount;
import vo.SavingAccount;

public class AccountServiceImpl implements AccountService{
	
	AccountDAO dao;

	public AccountServiceImpl() {}

	public AccountServiceImpl(AccountDAO dao) {
		super();
		this.dao = dao;
	}

	public AccountDAO getDao() {
		return dao;
	}

	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public int insertSaveAccount(SavingAccount vo) {
		return dao.insertSaveAccount(vo);
	}

	@Override
	public int insertLoanAccount(LoanAccount vo) {
		return dao.insertLoanAccount(vo);
	}

	@Override
	public List<SavingAccount> searchSaveAccount(String name) {
		return dao.searchSaveAccount(name);
	}

	@Override
	public List<LoanAccount> searchLoanAccount(String name) {
		return dao.searchLoanAccount(name);
	}

	
	
}
