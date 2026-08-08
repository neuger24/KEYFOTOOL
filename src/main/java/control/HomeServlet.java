package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Usa il DAO per prendere i prodotti (le key) dal database
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        List<Prodotto> listaKeys = prodottoDAO.getProdottiInEvidenza();

        //Salva i prodotti nella "request" per passarli alla JSP
        request.setAttribute("prodottiHome", listaKeys);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
        dispatcher.forward(request, response);
    }
}