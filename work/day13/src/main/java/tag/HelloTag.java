package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 	标签类的要求：
 * 		a.继承SimpleTagSupport类。
 *		b.override doTag方法(实现处理逻辑)。
 *		c.标签有哪些属性，标签类也得有对应的属性，
 *		属性名要相同，类型要匹配，并且有对应的set方法。
 *	
 *	标签的执行过程:
 *		step1.容器依据标签的命名空间找到标签的描述文件(.tld文件),
 *	然后依据标签名找到标签类，接下来将标签类实例化。
 *      step2.容器将标签的属性值赋给标签对象(通过调用标签
 *    对象的set方法，如果标签的属性值需要计算，容器会事先计算)。
 *      step3.容器调用标签对象的doTag方法。
 *  
 */
public class HelloTag extends SimpleTagSupport{
	
	private String msg;
	private int qty;
	
	public HelloTag(){
		System.out.println("HelloTag's constructor...");
	}
	
	public void setMsg(String msg) {
		System.out.println("HelloTag's setMsg...");
		this.msg = msg;
	}

	public void setQty(int qty) {
		System.out.println("HelloTag's setQty...");
		this.qty = qty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("HelloTag's dotag...");
		/*
		 * 通过继承自SimpleTagSupport类的方法来
		 * 获得pageContext。该对象提供了获得其它所有
		 * 隐含对象的方法。
		 */
		PageContext pctx = 
				(PageContext)getJspContext();
		JspWriter out = pctx.getOut();
		
		for(int i = 0; i < qty; i ++){
			out.println(msg + "<br/>");
		}
	}
	
	
	
	
	
	
	
}



