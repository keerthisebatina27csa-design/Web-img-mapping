import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginDetailsServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        String name = request.getParameter("userName");
        String password = request.getParameter("userPassword");

        // Green theme CSS
        String style = "<style>"
                + "body {background: linear-gradient(to right, #d4fc79, #96e6a1);"
                + "font-family: 'Poppins', sans-serif;display:flex;justify-content:center;"
                + "align-items:center;height:100vh;margin:0;}"
                + ".container {background:white;border-radius:15px;width:400px;padding:40px;"
                + "box-shadow:0px 4px 20px rgba(0,0,0,0.1);text-align:center;}"
                + "h2 {color:#2e7d32;margin-bottom:20px;}"
                + "p {color:#388e3c;font-size:16px;margin-bottom:20px;}"
                + "a, input[type=submit] {background-color:#43a047;color:white;padding:10px 20px;"
                + "border:none;border-radius:5px;cursor:pointer;font-weight:bold;text-decoration:none;transition:0.3s;}"
                + "a:hover, input[type=submit]:hover {background-color:#2e7d32;}"
                + "</style>";

        if (name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("uname", name);
            session.setAttribute("upass", password);

            pwriter.println("<html><head><title>Login Success</title>" + style + "</head><body>");
            pwriter.println("<div class='container'>");
            pwriter.println("<h2>Welcome, " + name + "!</h2>");
            pwriter.println("<p>Your password is: <b>" + password + "</b></p>");
            pwriter.println("<form action='LoginDetailsServlet' method='GET'>");
            pwriter.println("<input type='submit' value='View Details'/>");
            pwriter.println("</form>");
            pwriter.println("</div></body></html>");
        } else {
            pwriter.println("<html><head><title>Login Error</title>" + style + "</head><body>");
            pwriter.println("<div class='container'>");
            pwriter.println("<h2>Login Failed</h2>");
            pwriter.println("<p>Please enter both username and password.</p>");
            pwriter.println("<a href='login.html'>Go Back</a>");
            pwriter.println("</div></body></html>");
        }

        pwriter.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        HttpSession session = request.getSession(false);

        // Same green theme style
        String style = "<style>"
                + "body {background: linear-gradient(to right, #d4fc79, #96e6a1);"
                + "font-family: 'Poppins', sans-serif;display:flex;justify-content:center;"
                + "align-items:center;height:100vh;margin:0;}"
                + ".container {background:white;border-radius:15px;width:400px;padding:40px;"
                + "box-shadow:0px 4px 20px rgba(0,0,0,0.1);text-align:center;}"
                + "h2 {color:#2e7d32;margin-bottom:20px;}"
                + "p {color:#388e3c;font-size:16px;margin-bottom:20px;}"
                + "a {background-color:#43a047;color:white;padding:10px 20px;border-radius:5px;"
                + "text-decoration:none;font-weight:bold;transition:0.3s;}"
                + "a:hover {background-color:#2e7d32;}"
                + "</style>";

        pwriter.println("<html><head><title>Session Details</title>" + style + "</head><body>");
        pwriter.println("<div class='container'>");

        if (session != null) {
            String myName = (String) session.getAttribute("uname");
            String myPass = (String) session.getAttribute("upass");

            pwriter.println("<h2>User Details</h2>");
            pwriter.println("<p><b>Name:</b> " + myName + "</p>");
            pwriter.println("<p><b>Password:</b> " + myPass + "</p>");
            pwriter.println("<a href='login.html'>Logout</a>");
        } else {
            pwriter.println("<h2>No Session Found</h2>");
            pwriter.println("<p>Session expired or not found. Please login again.</p>");
            pwriter.println("<a href='login.html'>Login</a>");
        }

        pwriter.println("</div></body></html>");
        pwriter.close();
    }
}
