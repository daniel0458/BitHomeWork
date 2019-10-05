package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BankAccount;
import vo.LoanAccount;
import vo.SavingAccount;

public class AccountDAO {

	public int insertSaveAccount(SavingAccount vo) {
		
		String sql = "INSERT INTO saveaccount VALUES ((select nvl( max(accno) , 0)+1 from saveaccount),?,?,?,?,?,?,?) ";
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getTerm());
			ps.setDouble(3, vo.getINTEREST());
			ps.setInt(4, vo.getSaveAvg());
			ps.setDouble(5, vo.getInterestAmount());
			ps.setDouble(6, vo.getSaveAmount());
			ps.setDouble(7, vo.getSaveReturn());
			
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;

	}

	public int insertLoanAccount(LoanAccount vo) {
		String sql = "INSERT INTO loanaccount VALUES ((select nvl( max(accno) , 0)+1 from loanaccount),?,?,?,?,?,?) ";
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getTerm());
			ps.setDouble(3, vo.getINTEREST());
			ps.setDouble(4, vo.getLoanAmount());
			ps.setDouble(5, vo.getInterestAmount());
			ps.setDouble(6, vo.getLoanAvg());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;

	}

	public List<SavingAccount> searchSaveAccount(String name) {
		String sql = "select * from saveaccount where name = ? order by accno ";
		
			List<SavingAccount> list = new ArrayList<SavingAccount>();
		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		
			try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				rs = ps.executeQuery();
		
				while (rs.next()) {
					SavingAccount vo = new SavingAccount();
					
					vo.setAccNum(rs.getString("accno"));
					vo.setName(rs.getString("name"));
					vo.setTerm(rs.getInt("term"));
					vo.setSaveAvg(rs.getInt("saveavg"));
					vo.setInterestAmount(rs.getDouble("interestamount"));
					vo.setSaveAmount(rs.getInt("saveamount"));
					vo.setSaveReturn(rs.getDouble("savereturn"));
					
					list.add(vo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
			JDBCUtil.close(con, ps, rs);
		}
				
		return list;
	}

	public List<LoanAccount> searchLoanAccount(String name) {
		String sql = "select * from loanaccount where name = ? order by accno ";
		
				List<LoanAccount> list = new ArrayList<LoanAccount>();
		
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
		
				try {
					con = JDBCUtil.getConnection();
					ps = con.prepareStatement(sql);
		
					ps.setString(1, name);
					
					rs = ps.executeQuery();
		
					while (rs.next()) {
						LoanAccount vo = new LoanAccount();
						vo.setAccNum(rs.getString("accno"));
						vo.setName(rs.getString("name"));
						vo.setTerm(rs.getInt("term"));
						vo.setLoanAmount(rs.getInt("loanamount"));
						vo.setInterestAmount(rs.getDouble("interestamount"));
						vo.setLoanAvg(rs.getDouble("loanavg"));
						
						list.add(vo);
					}
				} catch (Exception e) {
					e.printStackTrace();;
				} finally {
					JDBCUtil.close(con, ps, rs);
				}
				
				return list;
	}
}
