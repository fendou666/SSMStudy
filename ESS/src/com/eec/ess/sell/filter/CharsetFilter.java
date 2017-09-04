/**
 * 
 * 程序名称：字符编码过滤器
 * 功能说明：对get/post 所有字符编码进行过滤设置
 * 做成者： eec.sell.lius 2017/07/20 (组织名称.所属.自己的姓名简拼)
 * 更新者： eec.sell.lius 2017/07/20 修复错误XXX
 * 更新者： eec.sell.lius 2017/07/20 修复错误XXX
 * 更新者： eec.sell.lius 2017/07/20 修复错误XXX
 * @author  刘帅
 * @since   JDK1.8(支持的版本)
 * @since   Tomcat8.0(支持的版本)
 */


package com.eec.ess.sell.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
