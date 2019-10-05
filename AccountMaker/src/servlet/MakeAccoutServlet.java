package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import service.AccountService;
import service.AccountServiceImpl;
import vo.BankAccount;
import vo.LoanAccount;
import vo.SavingAccount;

@WebServlet("/account.do")
public class MakeAccoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("account.do 실행");
        AccountDAO dao = new AccountDAO();
        AccountService service = new AccountServiceImpl(dao);
        PrintWriter out=response.getWriter();

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int term = Integer.parseInt(request.getParameter("term"));
        
        try {
        	switch (type) {
        	case "save":
        		
        		int savemoney = Integer.parseInt(request.getParameter("save-money"));
        		SavingAccount saveAccount = new SavingAccount();
        		
        		saveAccount.setName(name);
        		saveAccount.setTerm(term);
        		saveAccount.setSaveAvg(savemoney);
        		saveAccount.calc();
        		
        		service.insertSaveAccount(saveAccount);
        		
        		break;
        		
        	case "loan":
        		
        		int loanmoney =Integer.parseInt(request.getParameter("loan-money"));
        		LoanAccount loanAccount = new LoanAccount();
        		
        		loanAccount.setName(name);
        		loanAccount.setTerm(term);
        		loanAccount.setLoanAmount(loanmoney);
        		loanAccount.calc();
        		
        		service.insertLoanAccount(loanAccount);

        		break;
        		
        	default:
        		return;
        	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        out.print("<script>alert('"+type+"계좌생성 완료')</script>");
        String view ="/makeAccount.jsp";
	     getServletContext().getRequestDispatcher(view).forward(request, response);
	}
}
