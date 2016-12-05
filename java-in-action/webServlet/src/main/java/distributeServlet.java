import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zuston on 16-11-10.
 */
@WebServlet(name = "distributeServlet")
public class distributeServlet extends HttpServlet {

    public int count ;
    public void init() throws ServletException {
        count = 0;
    }

    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servlet访问次数:"+count++);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("hello service"+"<br>");
        out.print("路径："+request.getRequestURL()+"<br>");
        out.print("请求url:"+request.getRequestURI()+"<br>");
        out.print("方法："+request.getMethod()+"<br>");
        String contollerString = request.getRequestURI();
        System.out.println(contollerString.split("/").length);
        if(contollerString.split("/").length!=1){
            String [] arr = contollerString.split("/");
            out.print("controller:"+arr[1]);
        }else{
            out.print("base");
        }

        HttpSession session = request.getSession();
        String seesionId = request.getRequestedSessionId();

//        request.getRequestDispatcher("main.jsp").forward(request,response);
        response.sendRedirect("main.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("hello doget");
    }
}
