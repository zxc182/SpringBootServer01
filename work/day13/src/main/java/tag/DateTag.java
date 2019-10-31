package tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	private String pattern;
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat(pattern);
		
		PageContext pctx = 
				(PageContext)getJspContext();
		JspWriter out = 
				pctx.getOut();
		
		out.println(sdf.format(date));
	}
	
}


