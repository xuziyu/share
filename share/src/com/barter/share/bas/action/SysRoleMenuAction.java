package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysMenu;
import com.barter.share.bas.entity.SysModule;
import com.barter.share.bas.entity.SysRole;
import com.barter.share.bas.entity.SysRoleMenu;
import com.barter.share.bas.service.ISysMenuService;
import com.barter.share.bas.service.ISysModuleService;
import com.barter.share.bas.service.ISysRoleMenuService;
import com.barter.share.bas.service.ISysRoleService;
import com.barter.share.bas.service.imp.SysMenuService;
import com.barter.share.bas.service.imp.SysModuleService;
import com.barter.share.bas.service.imp.SysRoleMenuService;
import com.barter.share.bas.service.imp.SysRoleService;
import com.barter.share.bas.vo.SysRoleMenuVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SysRoleMenuAction
 */
public class SysRoleMenuAction extends BasAction {
	private static final long serialVersionUID = 1L;
    SysRoleMenuService sysRoleMenuService = new SysRoleMenuService();
    ISysRoleMenuService iSysRoleMenuService = (ISysRoleMenuService)ServiceProxyFactory.getProxyInstance(sysRoleMenuService);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SysRoleMenuAction() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			roleMenuEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			roleMenuSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			roleMenuDelete(request,response);
		}else {
			roleMenuPageList(request,response);
		}
	}
	private void roleMenuPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String roleId = request.getParameter("roleId");
		String moduleId = request.getParameter("moduleId");
		String menuId = request.getParameter("menuId");
		SysRoleMenuVo sysRoleMenuVo = new SysRoleMenuVo();
		sysRoleMenuVo.setRoleId(roleId);
		sysRoleMenuVo.setModuleId(moduleId);
		sysRoleMenuVo.setMenuId(menuId);
		Page page = new Page();
		try {
			page = iSysRoleMenuService.pageList(pageIndex, pageSize, sysRoleMenuVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_role_menu.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void roleMenuDelete(HttpServletRequest request, HttpServletResponse response) {
		String roleMenuId = request.getParameter("id");
		iSysRoleMenuService.delete(roleMenuId);
		try {
			response.sendRedirect("/share/admin/SysRoleMenuAction.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void roleMenuSave(HttpServletRequest request, HttpServletResponse response) {
		String roleMenuId = request.getParameter("id");
		String roleId = request.getParameter("roleId");
		String moduleId = request.getParameter("moduleId");
		String menuId = request.getParameter("menuId");
		SysRoleMenu sysRoleMenu = new SysRoleMenu();
		sysRoleMenu.setRoleId(roleId);
		sysRoleMenu.setModuleId(moduleId);
		sysRoleMenu.setMenuId(menuId);
		if (StringUtil.isEmpty(roleMenuId)) {
			roleMenuId = StringUtil.generateUUID();
			sysRoleMenu.setRoleMenuId(roleMenuId);
			try {
//				iSysRoleMenuService.codeCheck(crtCart);
				iSysRoleMenuService.insert(sysRoleMenu);
				response.sendRedirect("/share/admin/SysRoleMenuAction.action");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sysRoleMenu.setRoleMenuId(roleMenuId);
			try {
//				iSysRoleMenuService.codeCheck(crtCart);
				iSysRoleMenuService.update(sysRoleMenu);
				response.sendRedirect("/share/admin/SysRoleMenuAction.action");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void roleMenuEdit(HttpServletRequest request, HttpServletResponse response) {
		SysRoleService sysRoleService =new SysRoleService();
		SysModuleService sysModuleService = new SysModuleService();
		SysMenuService sysMenuService = new SysMenuService();
		ISysRoleService iSysRoleService = (ISysRoleService)ServiceProxyFactory.getProxyInstance(sysRoleService);
		ISysModuleService iSysModuleService = (ISysModuleService)ServiceProxyFactory.getProxyInstance(sysModuleService);
		ISysMenuService iSysMenuService = (ISysMenuService)ServiceProxyFactory.getProxyInstance(sysMenuService);
		List<SysRole> listSysRole = iSysRoleService.list();
		List<SysModule> listSysModule = iSysModuleService.list();
		List<SysMenu> listSysMenu = iSysMenuService.list();
		request.setAttribute("listSysRole", listSysRole);
		request.setAttribute("listSysModule", listSysModule);
		request.setAttribute("listSysMenu", listSysMenu);
		String roleMenuId = request.getParameter("id");
		if (StringUtil.isEmpty(roleMenuId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_role_menu_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<SysRoleMenu> list = iSysRoleMenuService.load(roleMenuId);
			SysRoleMenu sysRoleMenu = list.get(0);
			request.setAttribute("id", "&id="+roleMenuId);
			request.setAttribute("sysRoleMenu", sysRoleMenu);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_role_menu_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
