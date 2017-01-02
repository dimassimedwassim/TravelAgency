/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientAuth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.AuthWS_Service;

/**
 *
 * @author zizou
 */
@WebServlet(name = "ClientWSDL", urlPatterns = {"/ClientWSDL"})
public class ClientWSDL extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AuthentificationWS/AuthWS.wsdl")
    private AuthWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {


     }*/
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     //processRequest(request, response);
     }*/
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClientWSDL</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClientWSDL at " + request.getContextPath() + "</h1>");
            out.println("log: " + request.getParameter("login") + "<br/>");
            out.println("pwd: " + request.getParameter("password") + "<br/>");
            try {

                String log = request.getParameter("login");
                String pwd = request.getParameter("password");
                String result = login(log, pwd);
                out.println("resultat : " + result);
                if (result.equals("1")) {//administrateur
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.html");
                    dispatcher.forward(request, response);
                } else {
                    if (result.equals("0")) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
                        dispatcher.forward(request, response);

                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
                        dispatcher.forward(request, response);
                    }

                }

            } catch (Exception ex) {
                out.println("Exception : " + ex);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
                dispatcher.forward(request, response);
            }
            out.println("</body>");

            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String login(java.lang.String login, java.lang.String passwd) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.AuthWS port = service.getAuthWSPort();
        return port.login(login, passwd);
    }

}
