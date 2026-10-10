/*
HttpSession session = request.getSession(false);
Utente utente = (session != null) ? (Utente) session.getAttribute("utente") : null;

if (utente == null || utente.getRuolo() != 1) {
    response.sendRedirect(request.getContextPath() + "/LoginServlet");
    return;
}


HttpSession session = request.getSession(false);
Utente utente = (session != null) ? (Utente) session.getAttribute("utente") : null;

if (utente == null) {
    response.sendRedirect(request.getContextPath() + "/LoginServlet");
    return;
}

*/
