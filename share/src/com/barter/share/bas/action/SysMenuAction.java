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
import com.barter.share.bas.service.ISysMenuService;
import com.barter.share.bas.service.ISysModuleService;
import com.barter.share.bas.service.imp.SysMenuService;
import com.barter.share.bas.service.imp.SysModuleService;
import com.barter.share.bas.vo.SysMenuVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SysMenuAction
 */
public class SysMenuAction extends BasAction {
	private static final long serialVersionUID = 1L;
    SysMenuService sysMenuService = new SysMenuService();
    ISysMenuService iSysMenuService =(ISysMenuService)ServiceProxyFactory.getProxyInstance(sysMenuService);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SysMenuAction() {
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
			menuEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			menuSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			menuDelete(request,response);
		}else {
			menuPageList(request,response);
		}
	}
	private void menuPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String moduleId = request.getParameter("moduleId");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String enabled = request.getParameter("enabled");
		String menuUrl = request.getParameter("menuUrl");
		Page page = new Page();
		SysMenuVo sysMenuVo = new SysMenuVo();
		sysMenuVo.setModuleId(moduleId);
		sysMenuVo.setCode(code);
		sysMenuVo.setName(name);
		sysMenuVo.setEnabled(StringUtil.strToBigDecimal(enabled));
		sysMenuVo.setMenuUrl(menuUrl);
		try {
			page = iSysMenuService.pageList(pageIndex, pageSize, sysMenuVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_menu.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void menuDelete(HttpServletRequest request, HttpServletResponse response) {
		String menuId = request.getParameter("id");
		iSysMenuService.delete(menuId);
		try {
			response.sendRedirect("/share/admin/SysMenuAction.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void menuSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuId = request.getParameter("id");
		String moduleId = request.getParameter("moduleId");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String enabled = request.getParameter("enabled");
		String menuUrl = request.getParameter("menuUrl");
		SysMenu sysMenu = new SysMenu();
		sysMenu.setModuleId(moduleId);
		sysMenu.setCode(code);
		sysMenu.setName(name);
		sysMenu.setEnabled(StringUtil.strToBigDecimal(enabled));
		sysMenu.setMenuUrl(menuUrl);
		if (StringUtil.isEmpty(menuId)) {
			menuId = StringUtil.generateUUID();
			sysMenu.setMenuId(menuId);
			try {
				iSysMenuService.codeCheck(sysMenu);
				iSysMenuService.insert(sysMenu);
				response.sendRedirect("/share/admin/SysMenuAction.action");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			sysMenu.setMenuId(menuId);
			try {
//				iSysMenuService.codeCheck(sysMenu);
				iSysMenuService.update(sysMenu);
				response.sendRedirect("/share/admin/SysMenuAction.action");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}
	private void menuEdit(HttpServletRequest request, HttpServletResponse response) {
		String menuId = request.getParameter("id");
		SysModuleService sysModuleService = new SysModuleService();
		ISysModuleService iSysModuleService = (ISysModuleService)ServiceProxyFactory.getProxyInstance(sysModuleService);
		List<SysModule> listSysModule = iSysModuleService.list();
		request.setAttribute("listSysModule", listSysModule);
		System.out.println(listSysModule.get(0).getName());
		if (StringUtil.isEmpty(menuId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_menu_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<SysMenu> list = iSysMenuService.load(menuId);
			SysMenu sysMenu = list.get(0);
			request.setAttribute("id", "&id="+menuId);
			request.setAttribute("sysMenu", sysMenu);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_menu_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
