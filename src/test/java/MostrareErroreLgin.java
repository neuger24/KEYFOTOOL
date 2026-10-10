/*
<%-- Se esiste un attributo "errore" inviato dalla Servlet, lo stampa in un div rosso --%>
<% if (request.getAttribute("errore") != null) { %>
    <div style="color: red; margin-bottom: 15px;">
        <%= request.getAttribute("errore") %>
    </div>
<% } %>

 */