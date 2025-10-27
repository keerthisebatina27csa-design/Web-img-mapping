import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GroceryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null || action.equals("home")) {
            // Redirect to GroceryStore.html
            response.sendRedirect("GroceryStore.html");
        } else if (action.equals("viewCart")) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Your HungryCart Cart</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(135deg, #C6F5D0 0%, #9AE79D 100%); font-family: Arial; margin:0; padding:20px; }");
            out.println("h1 { text-align:center; color:#2E7D32; }");
            out.println("ul { font-size:18px; color:#2E7D32; }");
            out.println("a { color:#388E3C; text-decoration:none; font-weight:bold; }");
            out.println("</style></head>");
            out.println("<body>");
            out.println("<h1>Your Shopping Cart</h1>");

            String[] items = request.getParameterValues("item");
            if (items == null || items.length == 0) {
                out.println("<p>No items selected. <a href='GroceryStore.html'>Go back</a></p>");
            } else {
                out.println("<ul>");
                for (String item : items) {
                    out.println("<li>" + item + "</li>");
                }
                out.println("</ul>");
                out.println("<p><a href='GroceryStore.html'>Continue Shopping</a></p>");
            }

            out.println("</body></html>");
            out.close();
        } else {
            // Unknown action
            response.sendRedirect("GroceryStore.html");
        }
    }
}
