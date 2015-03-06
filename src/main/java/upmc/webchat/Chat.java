/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.webchat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *k
 * @author Licence
 */
@WebServlet(name = "Chat", urlPatterns = {"/Chat"})
public class Chat extends HttpServlet {
    private ArrayList<String> conversation = new ArrayList<String>();
    
    @Override
    public void init(){
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {     
            
        String name = request.getParameter("name");
        String comment = request.getParameter("comment");
                if (name != null) {
                if (comment !=null){
                    this.conversation.add(request.getParameter("comment"));
                }
                request.setAttribute("conversation",conversation);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Chat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Chat at " + request.getContextPath() + "</h1>");
            if (request.getParameter("comment")!=null){
            //out.println("<h2>Your comment is : " + request.getParameter("comment") + "</h2>");
                this.conversation.add(request.getParameter("comment"));
            }
           if (this.conversation.size()>0){
               for(String comment : this.conversation){
                  out.println(comment+"<br />");
               }
            }
            out.println("<form id =\"msg\" method=\"POST\">");
            out.println("<textarea rows = \"4\" cols =\"50\" name =\"comment\">");
            //out.println("Enter your message here ...");
            out.println("</textarea>");
            out.println("<input type =\"submit\">");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");*/
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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

}
