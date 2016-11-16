import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init filter");
    }

}
