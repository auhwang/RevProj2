package maverick.ogs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import maverick.ogs.beans.Transactions;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.service.TransactionsService;
import maverick.ogs.service.UserService;

/**
 * Servlet implementation class GetTransactionsServlet
 */
public class GetTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(GetTransactionsServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTransactionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		UserAccount user = UserService.getUserById(reader.readLine());
		List<Transactions> trans = TransactionsService.getUserTransactions(user);
		String json = gson.toJson(trans);
		
		logger.debug(GetTransactionsServlet.class.getName() + " is passing " + json.toString());
		
		out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
