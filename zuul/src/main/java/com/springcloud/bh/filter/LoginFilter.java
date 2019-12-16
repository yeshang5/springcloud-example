package com.springcloud.bh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 返回一个字符串代表过滤器的类型，zuul中定义了4种不同生命周期的过滤器类型
     * pre(路由之前)， routing(路由之时) ， post(路由之后)， error(发生错误调用)
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext=RequestContext.getCurrentContext();
        HttpServletRequest request=currentContext.getRequest();
        String token=request.getParameter("token");
        if (StringUtils.isEmpty(token))
        {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                HttpServletResponse response=currentContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("非法请求，请携带token参数后再尝试请求！");
            }catch (Exception e)
            {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
}
