import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String category = request.getParameter("groc_cat");

        out.println("<html><head><title>HungryCart</title>");
        out.println("<style>");
        out.println("body { background: linear-gradient(135deg, #C6F5D0 0%, #9AE79D 100%); font-family:'Segoe UI',Arial,sans-serif; margin:0; }");
        out.println(".container { max-width:500px; background:#fff; margin:60px auto; padding:30px; border-radius:14px; box-shadow:0 4px 16px rgba(41,163,163,0.1); text-align:center; }");
        out.println("h1 { color:#2E7D32; margin-bottom:8px; }");
        out.println("h2 { color:#388E3C; font-weight:normal; margin-bottom:24px; }");
        out.println(".output { color:#2E7D32; font-size:18px; margin:20px 0; }");
        out.println("</style></head><body>");
        out.println("<div class='container'><h1>HungryCart</h1>");

        if ("Set Cookie".equals(action) && category != null && !category.isEmpty()) {
            javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("PreferredGrocery", category);
            cookie.setMaxAge(24*60*60); // 1 day
            response.addCookie(cookie);

            out.println("<h2>Cookie Set Successfully!</h2>");
            out.println("<div class='output'>Hello! Your preferred grocery category is: <b>" + category + "</b></div>");
        } else if ("Show Cookie".equals(action)) {
            javax.servlet.http.Cookie[] cookies = request.getCookies();
            boolean found = false;

            out.println("<h2>Your Stored Cookie</h2>");
            if (cookies != null) {
                for (javax.servlet.http.Cookie cookie : cookies) {
                    if ("PreferredGrocery".equals(cookie.getName())) {
                        out.println("<div class='output'>Name: <b>" + cookie.getName() + "</b> | Value: <b>" + cookie.getValue() + "</b></div>");
                        found = true;
                    }
                }
            }
            if (!found) {
                out.println("<div class='output'>No grocery cookie found. Please set your category first!</div>");
            }
        } else {
            out.println("<h2>Invalid Action</h2>");
        }

        out.println("</div></body></html>");
        out.close();
    }
}
