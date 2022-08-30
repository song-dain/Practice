package com.greedy.mvc.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.greedy.mvc.common.config.ConfigLocation;

@WebFilter("/*")
public class ContextConfigFilter extends HttpFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
			String root = request.getServletContext().getRealPath("/");
			String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");
			
			ConfigLocation.CONNECTION_CONFIG_LOCATION = root + connectionInfoPath;
			
			System.out.println("DB 접속 경로 설정 완료 : " + ConfigLocation.CONNECTION_CONFIG_LOCATION);
		}
		
		if(ConfigLocation.MAPPER_LOCATION == null) {
			String root = request.getServletContext().getRealPath("/");
			String mapperLocation = request.getServletContext().getInitParameter("mapper-location");
			
			ConfigLocation.MAPPER_LOCATION = root + mapperLocation;
			
			System.out.println("매퍼 경로 설정 완료 : " + ConfigLocation.MAPPER_LOCATION);
		}
		
		chain.doFilter(request, response);
	}

}
