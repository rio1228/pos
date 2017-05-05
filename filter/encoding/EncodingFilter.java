package encoding;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="EncodingFilter", urlPatterns="/*")
public class EncodingFilter implements Filter
{
    public void init(FilterConfig fConfig) throws ServletException
    {
    }
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws java.io.IOException, ServletException
    {
        // place your code here
        request.setCharacterEncoding("UTF-8");
        //System.out.println("aiu");
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
    public void destroy(){}
}