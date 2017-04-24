package cn.panasonic.ppm.basedata.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.panasonic.ppm.domain.basedata.User;


/**
 * 设置用户过滤器，记得设置web.xml文件
 * @author KL
 *
 */
public class UserFilter implements Filter {

	private Set<String> paths=new HashSet<String>();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		//获取访问链接
		String path=request.getServletPath();
		System.out.println("访问路径:"+path);
		//判断用户是否登录，如果登录则可以访问所有页面
		User user=(User) request.getSession().getAttribute("user");
		if (null!=user) {
			chain.doFilter(request, response);
		}else {
			//用户没有登录只能访问部分页面,如果该用户访问的页面被包含在初始化的Set中，则可以访问，否则跳转到登录界面
			if (path.startsWith("/static")||path.startsWith("/css")||path.startsWith("/js")||path.startsWith("/assets")||paths.contains(path)) {
				chain.doFilter(request, response);
			}else {
				response.sendRedirect("login/login.jsp");
			}
		}
	}
	/**
	 * 对非登录用户可登录页面设置
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		paths.add("/login.jsp");
		paths.add("/login/login.jsp");
		paths.add("/userAction_login.action");
		paths.add("/loginAction_login.action");
		paths.add("/projectAction_showPageResult.action");
	}

}
