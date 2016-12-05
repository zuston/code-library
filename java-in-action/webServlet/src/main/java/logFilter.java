import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println(config.getInitParameter("site"));
        visitCount = 0;
    }

}
