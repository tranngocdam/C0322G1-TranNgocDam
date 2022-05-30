import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double first = Double.parseDouble(request.getParameter("first"));
        double second = Double.parseDouble(request.getParameter("second"));
        char operator = request.getParameter("operator").charAt(0);
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Result:</h1>");
//        try{
//            double result = Calculate.calculate(first, second, operator);
//            writer.println(first + " " + operator + " " + second + " = " + result);
//        }catch (Exception ex){
//            writer.println("Error: " + ex.getMessage());
//        }
//        writer.println("</html>");
        double result = Calculate.calculate(first, second, operator);
        request.setAttribute("first", first);
        request.setAttribute("operator", operator);
        request.setAttribute("second", second);
        request.setAttribute("result", result);
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }
}