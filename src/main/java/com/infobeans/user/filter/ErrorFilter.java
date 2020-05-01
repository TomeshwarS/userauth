package com.infobeans.user.filter;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class ErrorFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

  @Override
  public String filterType() {
	  System.out.println("Pre filter get Called.....");
    return "error";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
  System.out.println("Running service From ....."+request.getMethod() + "" +request.getRequestURL().toString());
    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

    return null;
  }

}