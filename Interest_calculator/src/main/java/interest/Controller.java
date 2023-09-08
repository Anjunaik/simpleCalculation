package interest;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fdate=request.getParameter("fdate");//start date from HTML
		String edate=request.getParameter("ldate");//end date from HTML
		double amount=Double.parseDouble(request.getParameter("amount"));//principal
		double interest_rate=Double.parseDouble(request.getParameter("inrate"));//rate of interest
	   String rate_mode=request.getParameter("rate");// % or rupee's
	   String calculator_type=request.getParameter("calculator");//SI or CI
	   String compound_type=request.getParameter("compound");//annum or Quarterly or half-yearly
	   Calculator cl=new Calculator();
	   cl.DateCalculation(fdate, edate);//passing start and end date to method
	   Data_Setting data;
	   if(calculator_type.equals("simpleinterest"))//if the user want to calculate simple interest
		{
		data=cl.simpleInterest(amount, rate_mode, interest_rate);
		}
		else
		{
			//if the user want to calculate compound  interest
			data=cl.compound_calculator(amount, compound_type, interest_rate);
		}
		request.setAttribute("data", data);//set request scope attribute's
		request.setAttribute("calculator_type",calculator_type);
		request.setAttribute("sdate", fdate);
		request.setAttribute("edate", edate);
		request.setAttribute("Principal", amount);
		request.setAttribute("interest_rate",interest_rate);
		request.setAttribute("rate_type",rate_mode);
		 DecimalFormat decimalFormat = new DecimalFormat("0.##");//managing zero's
		 request.setAttribute("decimal", decimalFormat);
		RequestDispatcher rs=request.getRequestDispatcher("/Result.jsp");//control passing 
		rs.forward(request, response);
	}

}
