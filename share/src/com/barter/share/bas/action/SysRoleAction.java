package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysRole;
import com.barter.share.bas.service.ISysRoleService;
import com.barter.share.bas.service.imp.SysRoleService;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SysRoleAction
 */
public class SysRoleAction extends BasAction {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SysRoleAction() {
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
		String name = request.getParameter("name");
		SysRole sysRole = new SysRole();
		request.setAttribute("name", name);
		Page page = new Page();
		SysRoleService sysRoleService = new SysRoleService();
		ISysRoleService iSysRoleService = (ISysRoleService)ServiceProxyFactory.getProxyInstance(sysRoleService);
		sysRole.setName(name);
		try {
			page = iSysRoleService.pageList(pageIndex, pageSize, sysRole);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_role.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response) {
		String roleId = request.getParameter("id");
		SysRoleService sysRoleService = new SysRoleService();
		ISysRoleService iSysRoleService = (ISysRoleService)ServiceProxyFactory.getProxyInstance(sysRoleService);
		iSysRoleService.delete(roleId);
		try {
			response.sendRedirect("/share/SysRoleAction.action?pageName=sysRole");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Save(HttpServletRequest request, HttpServletResponse response) {
		SysRoleService sysRoleService = new SysRoleService();
		ISysRoleService iSysRoleService = (ISysRoleService)ServiceProxyFactory.getProxyInstance(sysRoleService);
		String roleId = request.getParameter("id");
		String name = request.getParameter("name");
		SysRole sysRole = new SysRole();
		sysRole.setName(name);
		if (StringUtil.isEmpty(roleId)) {
			roleId = StringUtil.generateUUID();
			sysRole.setRoleId(roleId);
			try {
				iSysRoleService.codeCheck(sysRole);
				iSysRoleService.insert(sysRole);
				response.sendRedirect("/share/SysRoleAction.action?pageName=sysRole");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sysRole.setRoleId(roleId);
			try {
				iSysRoleService.codeCheck(sysRole);
				iSysRoleService.update(sysRole);
				response.sendRedirect("/share/SysRoleAction.action?pageName=sysRole");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void Edit(HttpServletRequest request, HttpServletResponse response) {
		String roleId = request.getParameter("id");
		SysRoleService sysRoleService = new SysRoleService();
		ISysRoleService iSysRoleService = (ISysRoleService)ServiceProxyFactory.getProxyInstance(sysRoleService);
		if (StringUtil.isEmpty(roleId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_role_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<SysRole> list = iSysRoleService.load(roleId);
			SysRole sysRole = list.get(0);
			request.setAttribute("id", "&id="+roleId);
			request.setAttribute("sysRole", sysRole);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_role_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	}