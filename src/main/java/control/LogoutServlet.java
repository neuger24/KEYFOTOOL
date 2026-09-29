package control;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession s = request.getSession(false);

        if (s != null) {
            s.invalidate();
        }


        response.sendRedirect(request.getContextPath() + "/LoginServlet");
    }
}