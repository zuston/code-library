import javafx.application.Application;
import util.PropertyUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by zuston on 16-11-9.
 */
@WebServlet("/fuck")
public class distribute extends HttpServlet {
    private String message;
    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "FUCK Trump";
        System.out.println(message);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");


        System.out.println("url:  "+request.getRequestURI());
        request.setAttribute("name","zuston");
        ServletContext application = request.getServletContext();
        application.setAttribute("age",23);
        HttpSession session = request.getSession();
        session.setAttribute("school","shu");

        Properties pop = PropertyUtil.load("dbConfig.properties");
        request.setAttribute("pwd",pop.getProperty("jdbc.pwd"));
        request.getRequestDispatcher("/WEB-INF/View/index.jsp").forward(request,response);
    }

}
