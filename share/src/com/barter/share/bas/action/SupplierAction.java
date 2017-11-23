package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasSupplier;
import com.barter.share.bas.service.ISerSupplier;
import com.barter.share.bas.service.imp.SerSupplier;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class BasSupplierAction
 */
public class SupplierAction extends BasAction {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierAction() {
        super();
     }
     @Override
     public void init(ServletConfig config) throws ServletException {
     	super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String method = request.getParameter(METHOD_NAME);//返回操作名称
			if (METHOD_NAME_EDIT.equals(method)) {//编辑操作,包括:新增、修改的编辑
				Edit(request, response);
			} else if (METHOD_NAME_SAVE.equals(method)) {//保存操作,包括:新增、修改的保存
				Save(request, response);
			} else if (METHOD_NAME_DELETE.equals(method)) {//删除操作
				Delete(request, response);
			} else { //其余为查询列表
				PageList(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	}

	private void PageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String needPayMoney = request.getParameter("needPayMoney");
		String contactName = request.getParameter("contactName");
		String contactMobile = request.getParameter("contactMobile");	
		String address = request.getParameter("address");
		BasSupplier Supplier =new BasSupplier();
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		request.setAttribute("needPayMoney", needPayMoney);
		request.setAttribute("contactName", contactName);
		request.setAttribute("contactMobile", contactMobile);
		request.setAttribute("address", address);
		Page page = new Page();
		SerSupplier serSupplier = new SerSupplier();
		ISerSupplier iSerSupplier = (ISerSupplier)ServiceProxyFactory.getProxyInstance(serSupplier);
		Supplier.setCode(code);
		Supplier.setName(name);
		Supplier.setNeedPayMoney(StringUtil.strToBigDecimal(needPayMoney));
		Supplier.setContactName(contactName);
		Supplier.setContactMobile(contactMobile);
		Supplier.setAddress(address);
		try {
			page = iSerSupplier.pageList(pageIndex, pageSize, Supplier);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/supplier/Supplier.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("id");
		SerSupplier serSupplier = new SerSupplier();
		ISerSupplier iSerSupplier = (ISerSupplier)ServiceProxyFactory.getProxyInstance(serSupplier);
		iSerSupplier.delete(customerId);
		try {
			response.sendRedirect("/share/admin/SupplierAction.action?pageName=Supplier");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Save(HttpServletRequest request, HttpServletResponse response) {
		SerSupplier serSupplier = new SerSupplier();
		ISerSupplier iSerSupplier = (ISerSupplier)ServiceProxyFactory.getProxyInstance(serSupplier);
		String supplierId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String needPayMoney = request.getParameter("needPayMoney");
		String contactName = request.getParameter("contactName");
		String contactMobile = request.getParameter("contactMobile");
		String address = request.getParameter("address");
		BasSupplier Supplier =new BasSupplier();
		Supplier.setCode(code);
		Supplier.setName(name);
		Supplier.setNeedPayMoney(StringUtil.strToBigDecimal(needPayMoney));
		Supplier.setContactName(contactName);
		Supplier.setContactMobile(contactMobile);
		Supplier.setAddress(address);
		if (StringUtil.isEmpty(supplierId)) {
			supplierId = StringUtil.generateUUID();
			Supplier.setSupplierId(supplierId);
			try {
				iSerSupplier.codeCheck(Supplier);
				iSerSupplier.insert(Supplier);
				response.sendRedirect("/share/admin/SupplierAction.action?pageName=Supplier");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Supplier.setSupplierId(supplierId);
			try {
				iSerSupplier.codeCheck(Supplier);
				iSerSupplier.update(Supplier);
				response.sendRedirect("/share/admin/SupplierAction.action?pageName=Supplier");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void Edit(HttpServletRequest request, HttpServletResponse response) {
		String supplierId = request.getParameter("id");
		SerSupplier serSupplier = new SerSupplier();
		ISerSupplier iserSupplier = (ISerSupplier)ServiceProxyFactory.getProxyInstance(serSupplier);
		if (StringUtil.isEmpty(supplierId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/supplier/Supplier_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasSupplier> list = iserSupplier.load(supplierId);
			BasSupplier supplier = list.get(0);
			request.setAttribute("id", "&id="+supplierId);
			request.setAttribute("supplier", supplier);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/supplier/Supplier_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
