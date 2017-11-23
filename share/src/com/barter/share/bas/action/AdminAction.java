package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.dao.imp.AdminManegeImp;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.service.AdminManege;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class AdminAction
 */
public class AdminAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		String method=request.getParameter(METHOD_NAME);
		System.out.println(method);
		if(method==null){
			adminQueryList(request, response);
		}else if(method.equals(METHOD_NAME_EDIT)){
			edit(request, response);
		}else if(method.equals(METHOD_NAME_DELETE)){
			delete(request, response);
		}else if(method.equals(METHOD_NAME_SAVE)){
			save(request, response);
		}else if(method.equals("insert")){
			try {
				request.setAttribute("list", null);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/Sysemployee/AdminManegeInsert.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("insert2")){
			insert(request, response);
		}else{
			adminQueryList(request, response);
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String employeeId=request.getParameter("employeeId");
		BaseDao adminManege=new AdminManegeImp();
		StringBuffer sql=new StringBuffer("select * from sys_employee where employee_id=? ");
		Object[] objects=new Object[1];
		objects[0]=employeeId;
		List<SysEmployee> list=adminManege.query(sql, objects, SysEmployee.class);
		try {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/Sysemployee/AdminManegeEdio.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminManege adminManege=new AdminManegeImp();
		adminManege.delete(request, response);
		adminQueryList(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		AdminManege adminManege=new AdminManegeImp();
		adminManege.update(request, response);
		try {
			adminQueryList(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		AdminManege adminManege=new AdminManegeImp();
		adminManege.insert(request, response);
		adminQueryList(request, response);
	}
      
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void adminQueryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX) ;
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE) ;
		
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex) ;
		int pageSize = StringUtil.isEmpty(strPageSize)?5:Integer.parseInt(strPageSize) ;

		String code = request.getParameter("code") ;
		String name = request.getParameter("name") ;

		request.setAttribute("code", code);
		request.setAttribute("name", name);
		
		AdminManege adminManege=new AdminManegeImp();
		List<SysEmployee> list=adminManege.AdminList(pageIndex,pageSize,code,name);
		Page page=new Page();
		page.setResult(list);
		
		int rowCount =adminManege.pageCount(code,name);
		int pageCount =(rowCount-1)/pageSize+1;
		
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setPageCount(pageCount);
		page.setRowCount(rowCount);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/Sysemployee/AdminManege.jsp").forward(request, response);
		
	}
}
