package cn.panasonic.ppm.basedata;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext context;
	static{
		context=new ClassPathXmlApplicationContext("cn/panasonic/ppm/spring/applicationContext.xml");
	}
}
