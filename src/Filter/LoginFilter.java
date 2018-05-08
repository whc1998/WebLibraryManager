package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private String charset;

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("filter init");
        charset = filterConfig.getInitParameter("charset");
        System.out.println(charset);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("enter filter");
        servletRequest.setCharacterEncoding(charset);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("userName"));
        if (session.getAttribute("userName") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
