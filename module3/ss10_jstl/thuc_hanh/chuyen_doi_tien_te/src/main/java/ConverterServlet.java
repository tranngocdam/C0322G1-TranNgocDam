import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConverterServlet", urlPatterns = "/converter")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double usd =Double.parseDouble(request.getParameter("usd"));
        double result=usd*22000;
        request.setAttribute("usd", usd);
        request.setAttribute("result", result);
        request.getRequestDispatcher("converter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
