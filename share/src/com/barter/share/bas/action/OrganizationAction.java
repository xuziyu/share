package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysOrganization;
import com.barter.share.bas.service.ISysOrganizationService;
import com.barter.share.bas.service.imp.SysOrganizationService;
import com.barter.share.bas.vo.SysOrganizationVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class AdminAction
 */
public class OrganizationAction extends BasAction {
	private static final long serialVersionUID = 1L;
    SysOrganizationService sysOrganizationService = new SysOrganizationService();
    ISysOrganizationService iSysOrganizationService = (ISysOrganizationService)ServiceProxyFactory.getProxyInstance(sysOrganizationService);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizationAction() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			organizationEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			organizationSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			organizationDelete(request,response);
		}else {
			organizationPageList(request,response);
		}
    }
	private void organizationPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String parentOrganizationId = request.getParameter("parentOrganizationId");
		String parentName = request.getParameter("parentName");
		SysOrganizationVo sysOrganizationVo = new SysOrganizationVo();
		sysOrganizationVo.setCode(code);
		sysOrganizationVo.setName(name);
		sysOrganizationVo.setOrganizationId(parentOrganizationId);
		sysOrganizationVo.setParentName(parentName);
		Page page = new Page();
		try {
			page = iSysOrganizationService.pageList(pageIndex, pageSize, sysOrganizationVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_organization.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void organizationDelete(HttpServletRequest request, HttpServletResponse response) {
		String organizationId = request.getParameter("id");
		iSysOrganizationService.delete(organizationId);
		try {
			response.sendRedirect("/share/admin/OrganizationAction.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void organizationSave(HttpServletRequest request, HttpServletResponse response) {
		String organizationId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String parentOrganizationId = request.getParameter("parentOrganizationId");
		SysOrganization sysOrganization = new SysOrganization();
		sysOrganization.setCode(code);
		sysOrganization.setName(name);
		sysOrganization.setOrganizationId(parentOrganizationId);
		if (StringUtil.isEmpty(organizationId)) {
			organizationId = StringUtil.generateUUID();
			sysOrganization.setOrganizationId(organizationId);
			try {
				iSysOrganizationService.codeCheck(sysOrganization);
				iSysOrganizationService.insert(sysOrganization);
				response.sendRedirect("/share/admin/OrganizationAction.action");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sysOrganization.setOrganizationId(organizationId);
			try {
				iSysOrganizationService.update(sysOrganization);
				response.sendRedirect("/share/admin/OrganizationAction.action");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void organizationEdit(HttpServletRequest request, HttpServletResponse response) {
		List<SysOrganization> listSysOrganization = iSysOrganizationService.list();
		request.setAttribute("listSysOrganization", listSysOrganization);
		String organizationId = request.getParameter("id");
		if (StringUtil.isEmpty(organizationId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_organization_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<SysOrganization> list = iSysOrganizationService.load(organizationId);
			SysOrganization sysOrganization = list.get(0);
			request.setAttribute("id", "&id="+organizationId);
			request.setAttribute("sysOrganization", sysOrganization);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/sys/sys_organization_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
