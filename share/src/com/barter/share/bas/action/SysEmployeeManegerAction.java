package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.dao.ISysemployeeRoleDao;
import com.barter.share.bas.dao.imp.SysemployeeRoleDaoIMP;
import com.barter.share.bas.entity.SysEmployeeManegeVO;
import com.barter.share.bas.service.ISysEMeRoleService;
import com.barter.share.bas.service.imp.SysEMRoleServiceIMP;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SysEmployeeManegerAction
 */
public class SysEmployeeManegerAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SysEmployeeManegerAction() {
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
		HttpSession session=request.getSession();
		session.getAttribute("roleId");
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
		private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

		private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

		private void delete(HttpServletRequest request, HttpServletResponse response) {
			ISysemployeeRoleDao de5=new SysemployeeRoleDaoIMP();
			de5.delete(request, response);
			adminQueryList(request,response);
	}

		private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

		private void adminQueryList(HttpServletRequest request, HttpServletResponse response) {
			try {
				ISysEMeRoleService eMeRoleService=new SysEMRoleServiceIMP();
				List<SysEmployeeManegeVO> list =eMeRoleService.AdminList(1, 2, request.getParameter("code"), "");
				HttpSession session=request.getSession();
				session.setAttribute("s_list", list);
//				request.setAttribute("list", list);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/Sysemployee/SysEMManege.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
