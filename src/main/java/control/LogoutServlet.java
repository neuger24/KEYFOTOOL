package control;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/Logout") // URL per richiamare questa servlet
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Recupera la sessione senza crearne una nuova
        HttpSession s = request.getSession(false);

        if (s != null) {
            s.invalidate(); // Distrugge la sessione (rimuovendo token utente e carrello)
        }

        // Reindirizza l'utente a una rotta gestita da una Servlet, non direttamente a una JSP
        // getContextPath() garantisce che il path sia corretto a prescindere da come hai nominato il progetto in Tomcat
        response.sendRedirect(request.getContextPath() + "/LoginServlet");
    }
}