package control;

import dao.UtenteDAO;
import model.Utente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteDAO utenteDAO = new UtenteDAO();

        try {//da rivedere
            Utente utenteLoggato = utenteDAO.login(email, password);

            if (utenteLoggato != null) {
                // LOGIN SUCCESSO
                HttpSession session = request.getSession();
                session.setAttribute("utente", utenteLoggato);

                // DISTINZIONE TRA UTENTE E AMMINISTRATORE
                if (utenteLoggato.getRuolo() == 1) {


                    response.sendRedirect(request.getContextPath() + "/AdminDashboardServlet");

                } else {

                    response.sendRedirect(request.getContextPath() + "/HomeServlet");

                }

            } else {
                // LOGIN FALLITO
                request.setAttribute("errore", "Email o password non validi.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {//da rivedere
            e.printStackTrace();
            request.setAttribute("errore", "Si è verificato un errore. Riprova più tardi.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}