import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zuston on 16-11-9.
 */
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
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        for(String value:request.getParameterValues()){
            System.out.println();
        }
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + request.getParameter("name") + "</h1>");
        out.println("<h1>" + request.getMethod() + "</h1>");
        out.println("<h2>"+request.getPathInfo()+"</h2>");
        out.println("<h2>"+request.getAuthType()+"</h2>");
        out.println(request.getPathInfo());
    }

    public void service(){

    }


    public void destroy()
    {
        // 什么也不做
    }
}
