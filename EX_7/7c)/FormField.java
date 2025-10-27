import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class FormField extends HttpServlet {  

    public void doGet(HttpServletRequest request, HttpServletResponse response) {  
        try {  
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  

            // Determine which step to show
            String step = request.getParameter("step");  

            if (step == null || step.equals("1")) {
                // === Step 1: Show confirmation page ===
                String userName = request.getParameter("userName");  
                String groceryItem = request.getParameter("itemName");  
                String qty = request.getParameter("quantity");

                out.print("<html><head><style>");
                out.print("body {background: linear-gradient(to right, #d4fc79, #96e6a1);"
                        + "font-family: 'Poppins', sans-serif;display:flex;justify-content:center;"
                        + "align-items:center;height:100vh;margin:0;}");
                out.print(".container {background:white;border-radius:15px;width:400px;padding:40px;"
                        + "box-shadow:0px 4px 20px rgba(0,0,0,0.1);text-align:center;}");
                out.print("h1 {color:#2e7d32;margin-bottom:10px;}");
                out.print("h3 {color:#388e3c;margin-bottom:30px;}");
                out.print("input[type=submit] {background-color:#43a047;color:white;padding:10px 20px;"
                        + "border:none;border-radius:5px;cursor:pointer;font-weight:bold;transition:0.3s;}");
                out.print("input[type=submit]:hover {background-color:#2e7d32;}");
                out.print("</style></head><body>");
                
                out.print("<div class='container'>");
                out.print("<h1>HungryCart</h1>");
                out.print("<h3>Welcome, " + userName + "!</h3>");
                out.print("<p>You’ve selected <b>" + groceryItem + "</b> - Quantity: <b>" + qty + "</b>.</p>");
                
                out.print("<form action='FormField' method='POST'>");  
                out.print("<input type='hidden' name='uname' value='" + userName + "'>");
                out.print("<input type='hidden' name='item' value='" + groceryItem + "'>");
                out.print("<input type='hidden' name='qty' value='" + qty + "'>");
                out.print("<input type='hidden' name='step' value='2'>");
                out.print("<input type='submit' value='Confirm Order'>");  
                out.print("</form>");  
                out.print("</div></body></html>");

            } 
            else if (step.equals("2")) {
                // === Step 2: Show thank-you page ===
                String userName = request.getParameter("uname");  
                String groceryItem = request.getParameter("item");
                String quantity = request.getParameter("qty");

                out.print("<html><head><style>");
                out.print("body {background: linear-gradient(to right, #d4fc79, #96e6a1);"
                        + "font-family: 'Poppins', sans-serif;display:flex;justify-content:center;"
                        + "align-items:center;height:100vh;margin:0;}");
                out.print(".container {background:white;border-radius:15px;width:400px;padding:40px;"
                        + "box-shadow:0px 4px 20px rgba(0,0,0,0.1);text-align:center;}");
                out.print("h1 {color:#2e7d32;margin-bottom:20px;}");
                out.print("p {color:#388e3c;font-size:16px;margin-bottom:20px;}");
                out.print("a {text-decoration:none;background-color:#43a047;color:white;padding:10px 20px;"
                        + "border-radius:5px;font-weight:bold;transition:0.3s;}");
                out.print("a:hover {background-color:#2e7d32;}");
                out.print("</style></head><body>");

                out.print("<div class='container'>");
                out.print("<h1>Thank You for Shopping!</h1>");
                out.print("<p>Hello <b>" + userName + "</b>,</p>");
                out.print("<p>Your order for <b>" + quantity + "</b> unit(s) of <b>" + groceryItem + "</b> has been confirmed.</p>");
                out.print("<p style='color:green;font-weight:bold;'>We’re preparing your items for delivery!</p>");
                out.print("<a href='HungryCart.html'>Go Back</a>");
                out.print("</div></body></html>");
            }

            out.close();  
        } catch (Exception e) {  
            System.out.println(e);  
        }  
    }  

    public void doPost(HttpServletRequest request, HttpServletResponse response) {  
        doGet(request, response);  
    }  
}
