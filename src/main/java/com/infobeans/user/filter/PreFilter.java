package com.infobeans.user.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infobeans.exception.AppExeption;
import com.infobeans.user.config.JWTTokenVerifyerUtility;
import com.infobeans.user.service.JwtUserDetailsService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(PreFilter.class);
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	JWTTokenVerifyerUtility jwttokenVerifyerUtility;

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
		String filterResult = "";
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		final String requestTokenHeader = request.getHeader("Authorization");
	System.out.println("Running service From ....." + request.getMethod() + "" + request.getRequestURL().toString());

		if (!jwttokenVerifyerUtility.verifyToken(request, requestTokenHeader)) {
			new AppExeption("UnAuthorized Request Exception, Please check your token.");
		}

		return filterResult;

	}

}