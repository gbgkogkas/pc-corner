import com.sample.Cart;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.HashMap;

@WebServlet(
        name = "cart",
        urlPatterns ="/cart/*"
)

public class CartServlet extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONParser parser = new JSONParser();
        JSONArray products = null;

        try {
            products = (JSONArray) parser.parse(new String(Files.readAllBytes(Paths.get(getServletContext().getRealPath("products.json")))));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getRequestURI().contains("add")) {
            Cart cart = (Cart) session.getAttribute("cart");

            HashMap<String, String[]> parameterMap = (HashMap<String, String[]>) req.getParameterMap();

            if (cart == null) {
                JSONParser parser = new JSONParser();
                JSONArray products = null;

                try {
                    products = (JSONArray) parser.parse(new String(Files.readAllBytes(Paths.get(getServletContext().getRealPath("products.json")))));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                cart = new Cart(products);
            }

            JSONObject response = cart.add(Integer.valueOf(parameterMap.get("product_id")[0]));
            session.setAttribute("cart", cart);

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.print(response);
            writer.flush();
        } else if (req.getRequestURI().contains("update")) {
            Cart cart = (Cart) session.getAttribute("cart");

            HashMap<String, String[]> parameterMap = (HashMap<String, String[]>) req.getParameterMap();
            JSONObject response = cart.update(Integer.valueOf(parameterMap.get("product_id")[0]), Integer.valueOf(parameterMap.get("quantity")[0]));

            session.setAttribute("cart", cart);

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.print(response);
            writer.flush();
        } else if (req.getRequestURI().contains("remove")) {
            Cart cart = (Cart) session.getAttribute("cart");

            HashMap<String, String[]> parameterMap = (HashMap<String, String[]>) req.getParameterMap();
            JSONObject response = cart.remove(Integer.valueOf(parameterMap.get("product_id")[0]));

            session.setAttribute("cart", cart);

            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.print(response);
            writer.flush();
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
