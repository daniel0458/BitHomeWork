package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import service.AccountService;
import service.AccountServiceImpl;
import vo.LoanAccount;
import vo.SavingAccount;

@WebServlet("/searchaccount.do")
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("searchaccount.do 실행");
        AccountDAO dao = new AccountDAO();
        AccountService service = new AccountServiceImpl(dao);
        
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        
        try {
        	switch (type) {
        	case "save":
        		
        		List<SavingAccount> saveList = null;
        		saveList = service.searchSaveAccount(name);
        		
        		request.setAttribute("list", saveList);
        		request.setAttribute("type", type);
        		break;
        		
        	case "loan":
        		
        		List<LoanAccount> loanList = null;
        		loanList = service.searchLoanAccount(name);
        		
        		request.setAttribute("list", loanList);
        		request.setAttribute("type", type);
        		break;
        		
        	default:
        		return;
        	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        String view ="/printSearch.jsp";
	     getServletContext().getRequestDispatcher(view).forward(request, response);
	}

}
