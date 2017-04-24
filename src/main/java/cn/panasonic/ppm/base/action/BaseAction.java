package cn.panasonic.ppm.base.action;

import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;

import org.apache.struts2.ServletActionContext;

import cn.panasonic.ppm.basedata.util.Json;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	private Class classt;
	private T t;
	
	public BaseAction(){
		
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		
		this.classt=(Class) type.getActualTypeArguments()[0];
		
		try {
			this.t=(T) this.classt.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 模型驱动，把getModel返回的对象压入值栈栈顶，struts框架就会根据表单的name属性，调用对应
	 * 栈顶对象的setter方法，从而把请求参数封装进来
	 * 子类继承，便可以调用this.getModel(),来对数据操作
	 */
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
	
	public static final String ADDUI = "addUI";//跳转到添加页面的字符串
	
	public String addUI = ADDUI;
	
	public static final String UPDATEUI = "updateUI";//跳转到修改页面的字符串
	
	public String updateUI = UPDATEUI;
	
	public static final String LISTACTION = "listAction";//跳转到列表页面的字符串
	
	public String listAction = LISTACTION;
	
	public static final String ACTION2ACTION = "action2action";//action跳转到action
	
	public String action2action = ACTION2ACTION;
	
	// 保存session值
    protected final static void saveSessionValue(String name, Object objValue) {
        ServletActionContext.getContext().getSession().put(name, objValue);
    }
  //把元素放到值栈
    protected final static void putValuetoStack(String name, Object objValue){
    	ActionContext.getContext().put(name, objValue);
    }
    //把元素放到栈顶
    protected final static void pushValueStack(Object objValue){
    	ActionContext.getContext().getValueStack().push(objValue);
    }
    // 获取session值
    protected final static Object loadSessionValue(String name) {
        Object obj = ServletActionContext.getContext().getSession().get(name);
        return obj;
    }

    protected final static void removeSessionValue(String name) {
        ServletActionContext.getContext().getSession().remove(name);
    }
   
    protected Json json=new Json();
    protected int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void jsonUtil(Object obj){
    	try {
    		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			PrintWriter out=ServletActionContext.getResponse().getWriter();
			out.write(JSON.toJSONString(obj));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
