import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discountAmount = price*discount*0.01;
        double discountPrice = price - discountAmount;
        request.setAttribute("productDescription", description);
        request.setAttribute("productDiscount", discount);
        request.setAttribute("productDiscountAmount", discountAmount);
        request.setAttribute("productDiscountPrice", discountPrice);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
