import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zuston on 16-11-10.
 */
@WebFilter(filterName = "logFilter")
public class logFilter implements Filter {
    public int visitCount;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        System.out.println("session ID :"+request.getRequestedSessionId());

        System.out.println("登陆站点："+ (new Date().toLocaleString()));
        visitCount++;
        System.out.println("访问次数:"+visitCount);
=======
import java.io.IOException;

/**
 * Created by zuston on 16/11/12.
 */
@WebFilter(filterName = "logFilter")
public class logFilter implements Filter {
    public void destroy() {
        System.out.println("close filter");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter process");
>>>>>>> a268548de22cf315aaad6b1c54b10998dcc2f1f4
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
<<<<<<< HEAD
        System.out.println(config.getInitParameter("site"));
        visitCount = 0;
=======
        System.out.println("init filter");
>>>>>>> a268548de22cf315aaad6b1c54b10998dcc2f1f4
    }

}
