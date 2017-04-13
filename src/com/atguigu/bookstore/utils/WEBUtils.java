package com.atguigu.bookstore.utils;

import javax.servlet.http.HttpServletRequest;

public class WEBUtils {

	public static String getPath(HttpServletRequest request){
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		String path=uri+"?"+queryString;
		if(path.contains("&pageNo")){
			path=path.substring(0, path.indexOf("&pageNo"));
		}
		return path;
	}

}
