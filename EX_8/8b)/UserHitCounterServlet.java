import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class UserHitCounterServlet extends HttpServlet {
    private int totalUniqueUsers;
    private Set<String> uniqueSessions;

    public void init() throws ServletException {
        totalUniqueUsers = 0;
        uniqueSessions = new HashSet<>();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String sessionId = session.getId();

        // Check if this session is new (unique user)
        synchronized (this) {
            if (!uniqueSessions.contains(sessionId)) {
                uniqueSessions.add(sessionId);
                totalUniqueUsers++;
            }
        }

        // Track individual user hits
        Integer userHits = (Integer) session.getAttribute("userHits");
        if (userHits == null) {
            userHits = 1;
        } else {
            userHits++;
        }
        session.setAttribute("userHits", userHits);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>User Hits</title>");
        out.println("<style>");
        out.println("body { background: linear-gradient(135deg, #C6F5D0 0%, #9AE79D 100%); font-family: Tahoma, sans-serif; text-align:center; padding:50px; }");
        out.println("h1 { color:#2E7D32; }");
        out.println("p { font-size:22px; color:#388E3C; }");
        out.println("a { padding: 12px 25px; background: #2E7D32; color: white; text-decoration: none; border-radius: 12px; font-weight: bold; display: inline-block; margin-top: 25px; }");
        out.println("a:hover { background: #388E3C; }");
        out.println("</style></head><body>");
        out.println("<h1>HungryCart - User Page Access</h1>");
        out.println("<p>Total unique users visited: <b>" + totalUniqueUsers + "</b></p>");
        out.println("<p>Your visits (this session): <b>" + userHits + "</b></p>");
        out.println("<a href='hitcount_uniqueuser.html'>Back</a>");
        out.println("</body></html>");
        out.close();
    }
}
