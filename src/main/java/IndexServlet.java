import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;

@WebServlet (
        name = "index",
        urlPatterns =""
)

public class IndexServlet extends HttpServlet {

    public IndexServlet(){
        super();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();

        Cookie cookie = new Cookie("JSESSIONID", req.getSession().getId());
        cookie.setPath("/pc-corner");
        resp.addCookie(cookie);

        JSONParser parser = new JSONParser();
        JSONArray products = null;

        try {
            products = (JSONArray) parser.parse(new String(Files.readAllBytes(Paths.get(getServletContext().getRealPath("products.json")))));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
