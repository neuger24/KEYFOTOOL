package filtri;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utente;

@WebFilter({"/AdminDashboard", "/AdminModificaProdotto", "/AdminEliminaProdotto", "/AdminAggiungiProdotto",})

public class FAdmin implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);


        Utente utente = (session != null) ? (Utente) session.getAttribute("utente") : null;

        if (utente == null || utente.getRuolo() != 1) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/LoginServlet");
        }

    }
    public void destroy() {}

}
