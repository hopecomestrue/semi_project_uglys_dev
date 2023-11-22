package com.veg.seoj.cscenter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/*@WebFilter(
		urlPatterns = {"/inquiry/*","/notice/*"}
)*/
public class EncodingFilter implements Filter{


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

/*		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// 요청과 응답에 대한 인코딩 설정
		httpRequest.setCharacterEncoding("UTF-8");
		httpResponse.setCharacterEncoding("UTF-8");

		// FilterChain 실행
//		chain.doFilter(httpRequest, httpResponse);*/
	}

	@Override
	public void destroy() {

	}


}
