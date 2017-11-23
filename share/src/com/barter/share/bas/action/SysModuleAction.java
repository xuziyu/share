package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysModule;
import com.barter.share.bas.service.ISysModuleService;
import com.barter.share.bas.service.imp.SysModuleService;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SysModule
 */
public class SysModuleAction extends BasAction {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SysModuleAction() {
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
			}  else { //其余为查询列表
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
		String enabled = request.getParameter("enabled");
		SysModule sysModule = new SysModule();
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		request.setAttribute("enabled", enabled);
		Page page = new Page();
		SysModuleService sysModuleService = new SysModuleService();
		ISysModuleService iSysModuleService = (ISysModuleService)ServiceProxyFactory.getProxyInstance(sysModuleService);
		sysModule.setCode(code);
		sysModule.setName(name);
		sysModule.setEnabled(StringUtil.strToBigDecimal(enabled));
		try {
			page = iSysModuleService.pageList(pageIndex, pageSize, sysModule);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_module.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response) {
		String moduleId = request.getParameter("id");
		SysModuleService sysModuleService = new SysModuleService();
		ISysModuleService iSysModuleService = (ISysModuleService)ServiceProxyFactory.getProxyInstance(sysModuleService);
		iSysModuleService.delete(moduleId);
		try {
			response.sendRedirect("/share/SysModuleAction.action?pageName=sysModule");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Save(HttpServletRequest request, HttpServletResponse response) {
		SysModuleService sysModuleService = new SysModuleService();
		ISysModuleService iSysModuleService = (ISysModuleService)ServiceProxyFactory.getProxyInstance(sysModuleService);
		String moduleId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String enabled = request.getParameter("enabled");
		SysModule sysModule = new SysModule();
		sysModule.setCode(code);
		sysModule.setName(name);
		sysModule.setEnabled(StringUtil.strToBigDecimal(enabled));
		if (StringUtil.isEmpty(moduleId)) {
			moduleId = StringUtil.generateUUID();
			sysModule.setModuleId(moduleId);
			try {
				iSysModuleService.codeCheck(sysModule);
				iSysModuleService.insert(sysModule);
				response.sendRedirect("/share/SysModuleAction.action?pageName=sysModule");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sysModule.setModuleId(moduleId);
			try {
				iSysModuleService.codeCheck(sysModule);
				iSysModuleService.update(sysModule);
				response.sendRedirect("/share/SysModuleAction.action?pageName=sysModule");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void Edit(HttpServletRequest request, HttpServletResponse response) {
		String moduleId = request.getParameter("id");
		SysModuleService sysModuleService = new SysModuleService();
		ISysModuleService iSysModuleService = (ISysModuleService)ServiceProxyFactory.getProxyInstance(sysModuleService);
		if (StringUtil.isEmpty(moduleId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_module_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<SysModule> list = iSysModuleService.load(moduleId);
			SysModule sysModule = list.get(0);
			request.setAttribute("id", "&id="+moduleId);
			request.setAttribute("sysModule", sysModule);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_module_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}