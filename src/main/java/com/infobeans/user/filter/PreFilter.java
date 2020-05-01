package com.infobeans.user.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PreFilter.class);

  @Override
  public String filterType() {
	  System.out.println("Pre filter get Called.....");
    return "pre";
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

    
    String token="aa";
    if(token.equals("aa")) {
   //  throw  new  NullPointerException();
    	
    	return  null;
    }else {
    	
    	return null;
    	
    }
  }

}