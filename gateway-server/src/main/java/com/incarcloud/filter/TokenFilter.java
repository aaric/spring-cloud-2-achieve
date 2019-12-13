package com.incarcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TokenFilter
 *
 * @author Aaric, created on 2019-12-13T09:12.
 * @version 0.0.5-SNAPSHOT
 */
@Slf4j
public class TokenFilter extends ZuulFilter {

    /**
     * Zuul支持的过滤器：
     * <u>
     * <li>pre-路由前</li>
     * <li>route-路由时</li>
     * <li>post-路由完毕</li>
     * <li>error-发生错误时</li>
     * </u>
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        // 获取token字符串
        String token = request.getParameter("token");
        log.info("token: {}", token);

        // 简单验证token字符串
        if (StringUtils.isEmpty(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            context.setResponseBody("token is required.");
        }

        return null;
    }
}
