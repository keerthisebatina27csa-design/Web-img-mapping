import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TotalHitCounterServlet extends HttpServlet {
    private int totalHits;

    public void init() throws ServletException {
        totalHits = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        totalHits++;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Total Hits</title>");
        out.println("<style>");
        out.println("body { background: linear-gradient(135deg, #C6F5D0 0%, #9AE79D 100%); font-family: Arial, sans-serif; text-align:center; padding:50px; }");
        out.println("h1 { color:#2E7D32; }");
        out.println("p { font-size:22px; color:#388E3C; }");
        out.println("a { padding: 12px 25px; background: #2E7D32; color: white; text-decoration: none; border-radius: 12px; font-weight: bold; display:inline-block; margin-top: 25px; }");
        out.println("a:hover { background: #388E3C; }");
        out.println("</style></head><body>");
        out.println("<h1>HungryCart - Total Page Hits</h1>");
        out.println("<p>This page has been accessed (by all users): <b>" + totalHits + "</b> times</p>");
        out.println("<a href='hitcount_anyuser.html'>Back</a>");
        out.println("</body></html>");
        out.close();
    }
}
