package com.mycompany.jee_jpa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.mycompany.jee_jpa.Constants.*;

/**
 *
 * @author benja
 */
//@WebServlet(name="Controller" urlPatterns={"/Controller"})
public class Controller extends HttpServlet {

    @EJB
    private JeeprjSB jeeprjSB;

    //So that we can access the user type in both welcome and details
    String userLogin = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param session
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest session, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        if (session.getParameter("action") == null) {
            session.getRequestDispatcher(JSP_HOME_PAGE).forward(session, response);
        } else if ("Log In".equals(session.getParameter("action"))) {
            if ("".equals(session.getParameter(FRM_LOGIN_FIELD)) || "".equals(session.getParameter(FRM_PWD_FIELD))) {
                session.setAttribute("errKey", ERR_MISSING_FIELD);
                session.getRequestDispatcher(JSP_HOME_PAGE).forward(session, response);
            }

            ServletContext ctx = this.getServletContext();
            ServletConfig conf = this.getServletConfig();
            String[] loginCtx = ctx.getInitParameter("login").split(","); //in the xml file, values are separated by a comma
            String[] pwdCtx = conf.getInitParameter("password").split(",");

            boolean ok = false;
            for (int i = 0; i < loginCtx.length; i++) {
                if (loginCtx[i].equals(session.getParameter(FRM_LOGIN_FIELD))
                        && pwdCtx[i].equals(session.getParameter(FRM_PWD_FIELD))) {
                    ok = true;
                    userLogin = loginCtx[i];
                    //In the welcome page, the user will be identified by its login and pwd, to display or no the modify and add button
                    session.setAttribute("user", jeeprjSB.getUserByLogin(userLogin));

                    //To display the list of employees in weclome.jsp
                    session.setAttribute("empList", jeeprjSB.getEmployees());
                    session.getRequestDispatcher(JSP_WELCOME_PAGE).forward(session, response);
                }
            }

            if (ok == false) {
                session.setAttribute("errKey", ERR_CONNECTION_FAILED);
                session.getRequestDispatcher(JSP_HOME_PAGE).forward(session, response);
            }
        } else if ("Details".equals(session.getParameter("action"))) {
            session.setAttribute("user", jeeprjSB.getUserByLogin(userLogin));
            session.setAttribute("employee", jeeprjSB.getEmployeeById((session.getParameter("employeeID"))));
            session.getRequestDispatcher(JSP_DETAILS_PAGE).forward(session, response);
        } else if ("Cancel".equals(session.getParameter("action"))) {
            session.setAttribute("user", jeeprjSB.getUserByLogin(userLogin));
            //To display the list of employees
            session.setAttribute("empList", jeeprjSB.getEmployees());
            session.getRequestDispatcher(JSP_WELCOME_PAGE).forward(session, response);
        } else if ("Save".equals(session.getParameter("action"))) {
            if (null != session.getParameter("id")) {
                jeeprjSB.updateEmployee(session.getParameter("id"),
                        session.getParameter("name"),
                        session.getParameter("firstname"),
                        session.getParameter("telhome"),
                        session.getParameter("telmob"),
                        session.getParameter("telpro"),
                        session.getParameter("adress"),
                        session.getParameter("postalcode"),
                        session.getParameter("city"),
                        session.getParameter("email"));
            } else {
                jeeprjSB.addEmployee(session.getParameter("id"),
                        session.getParameter("name"),
                        session.getParameter("firstname"),
                        session.getParameter("telhome"),
                        session.getParameter("telmob"),
                        session.getParameter("telpro"),
                        session.getParameter("adress"),
                        session.getParameter("postalcode"),
                        session.getParameter("city"),
                        session.getParameter("email"));
            }

            session.setAttribute("user", jeeprjSB.getUserByLogin(userLogin));
            //To display the list of employees
            session.setAttribute("empList", jeeprjSB.getEmployees());
            session.getRequestDispatcher(JSP_WELCOME_PAGE).forward(session, response);
        } else if ("Add".equals(session.getParameter("action"))) {
            session.setAttribute("user", jeeprjSB.getUserByLogin(userLogin));
            session.getRequestDispatcher(JSP_ADD_PAGE).forward(session, response);
        } else if ("Delete".equals(session.getParameter("action"))) {
            jeeprjSB.deleteEmployee(session.getParameter("employeeID"));
            session.setAttribute("user", jeeprjSB.getUserByLogin(userLogin));
            //To display the list of employees
            session.setAttribute("empList", jeeprjSB.getEmployees());
            session.getRequestDispatcher(JSP_WELCOME_PAGE).forward(session, response);
        } else if ("Logout".equals(session.getParameter("action"))) {
            session.logout();
            session.getRequestDispatcher(JSP_GOODBYE_PAGE).forward(session, response);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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

}
