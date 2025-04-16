package com.ssafy.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class MyFilter2 extends HttpFilter implements Filter {
      
	private FilterConfig fConfig;
    public MyFilter2() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("서블릿 가기전2!");
		
		///////////////////////////////////////
		//서블릿으로 보내는 코드
		//더이상 보낼 필터가 없다면...
		chain.doFilter(request, response);
		
		
		///////////////////////////////////////
		System.out.println("서블릿 다녀온 후2!");
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
