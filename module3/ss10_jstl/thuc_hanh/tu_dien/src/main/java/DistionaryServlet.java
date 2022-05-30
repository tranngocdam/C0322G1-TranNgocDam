import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DistionaryServlet", value = "/distionary")
public class DistionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "xin chào");
        dic.put("hi", "xin chào");
        dic.put("eat", "ăn");
        dic.put("sleep", "ngủ");
        String result ;
//        if (!search.equals("")) {
//            result = dic.get(search);
//        } else {
//            result = "Not Found";
//        }
        if (dic.containsKey(search)) {
            result = dic.get(search);

        } else {
            result = "Not Found";
        }
        request.setAttribute("search", search);
        request.setAttribute("result", result);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
