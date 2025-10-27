    /* URL Rewriting Combined Example - Green Theme */
    import java.io.*;
    import javax.servlet.*;
    import javax.servlet.http.*;

    public class URLRewriteForm extends HttpServlet {
        
        public void doGet(HttpServletRequest request, HttpServletResponse response) {
            try {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                // Check if a username is already passed (second step)
                String name = request.getParameter("userName");
                String uname = request.getParameter("uname");

                out.print("<html><body style='background-color:#ccffcc;font-family:Arial;text-align:center;'>");

                // Step 1: User entered their name in HTML form
                if (name != null && !name.isEmpty() && uname == null) {
                    out.print("<h2 style='color:green;'>Welcome " + name + "!</h2>");
                    out.print("<p>Proceed to the next page:</p>");
                    out.print("<a href='URLRewriteForm?uname=" + name + "' "
                            + "style='text-decoration:none;background-color:#2e8b57;color:white;"
                            + "padding:10px 20px;border-radius:5px;font-weight:bold;'>Visit Next Page</a>");
                } 
                // Step 2: Link clicked, show next page
                else if (uname != null) {
                    out.print("<h2 style='color:green;'>Hello " + uname + "!</h2>");
                    out.print("<p>You have successfully reached the second page using URL Rewriting.</p>");
                    out.print("<a href='URLRewriteForm.html' "
                            + "style='text-decoration:none;background-color:#2e8b57;color:white;"
                            + "padding:10px 20px;border-radius:5px;'>Go Back</a>");
                } 
                // If accessed directly
                else {
                    out.print("<h2 style='color:red;'>No user name provided.</h2>");
                    out.print("<a href='URLreWriteForm.html' "
                            + "style='text-decoration:none;background-color:#2e8b57;color:white;"
                            + "padding:10px 20px;border-radius:5px;'>Try Again</a>");
                }

                out.print("</body></html>");
                out.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
