package action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import dao.PayDao;
import dao.YiDianDao;

public class BaseAction implements Serializable {

	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	protected HttpSession session = ServletActionContext.getRequest()
			.getSession();

	public YiDianDao yiDianDao;
	public PayDao payDao;

	public String toUtf8(String s) {
		String result = "";
		if (request.getParameter(s) == "" | request.getParameter(s) == null) {
			return "";
		}
		try {
			result = new String(request.getParameter(s).getBytes("iso-8859-1"),
					"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public YiDianDao getYiDianDao() {
		return yiDianDao;
	}

	public void setYiDianDao(YiDianDao yiDianDao) {
		this.yiDianDao = yiDianDao;
	}

	public PayDao getPayDao() {
		return payDao;
	}

	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}

}
