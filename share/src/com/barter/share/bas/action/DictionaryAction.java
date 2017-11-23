package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasDict;
import com.barter.share.bas.entity.BasDictDetail;
import com.barter.share.bas.service.IBasDictDetailService;
import com.barter.share.bas.service.IBasDictDetailVoService;
import com.barter.share.bas.service.IBasDictService;
import com.barter.share.bas.service.imp.BasDictDetailService;
import com.barter.share.bas.service.imp.BasDictDetailVoService;
import com.barter.share.bas.service.imp.BasDictService;
import com.barter.share.bas.vo.BasDictDetailVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class DictionaryAction
 */
public class DictionaryAction extends BasAction {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_NAME="pageName";
	private static final String PAGE_NAME_DICTDETAIL="dictDetail";
	private static final String PAGE_NAME_DICT="dict";
	BasDictService basDictService = new BasDictService();
	IBasDictService iBasDictService =(IBasDictService)ServiceProxyFactory.getProxyInstance(basDictService);
	BasDictDetailService basDictDetailService = new BasDictDetailService();
	IBasDictDetailService iBasDictDetailService = (IBasDictDetailService)ServiceProxyFactory.getProxyInstance(basDictDetailService);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionaryAction() {
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
		String pageName = request.getParameter(PAGE_NAME);
		if (PAGE_NAME_DICTDETAIL.equals(pageName)) {
			dictDetail(request,response);
		}else if (PAGE_NAME_DICT.equals(pageName)) {
			dict(request,response);
		}
	}
	private void dict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			dictEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			dictSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			dictDelete(request,response);
		}else {
			dictPageList(request,response);
		}
	}
	private void dictPageList(HttpServletRequest request, HttpServletResponse response) {
		
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String dictCode = request.getParameter("dictCode");
		String dictLabel = request.getParameter("dictLabel");
		Page page = new Page();
		BasDict basDict = new BasDict();
		basDict.setDictCode(dictCode);
		basDict.setDictLabel(dictLabel);
		try {
			page = iBasDictService.pageList(pageIndex, pageSize, basDict);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void dictDelete(HttpServletRequest request, HttpServletResponse response) {
		String dictId = request.getParameter("id");
		iBasDictService.delete(dictId);
		try {
			response.sendRedirect("/share/admin/DictionaryAction.action?pageName=dict");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void dictSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dictId = request.getParameter("id");
		String dictCode = request.getParameter("dictCode");
		String dictLabel = request.getParameter("dictLabel");
		BasDict basDict = new BasDict();
		basDict.setDictCode(dictCode);
		basDict.setDictLabel(dictLabel);
		if (StringUtil.isEmpty(dictId)) {
			dictId = StringUtil.generateUUID();
			basDict.setDictId(dictId);
			try {
				iBasDictService.codeCheck(basDict);
				iBasDictService.insert(basDict);
				response.sendRedirect("/share/admin/DictionaryAction.action?pageName=dict");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basDict.setDictId(dictId);
			try {
//				iBasDictService.codeCheck(basDict);
				iBasDictService.update(basDict);
				response.sendRedirect("/share/admin/DictionaryAction.action?pageName=dict");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}
	private void dictEdit(HttpServletRequest request, HttpServletResponse response) {
		String dictId = request.getParameter("id");
		if (StringUtil.isEmpty(dictId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasDict> list = iBasDictService.load(dictId);
			BasDict basDict = list.get(0);
			request.setAttribute("id", "&id="+dictId);
			request.setAttribute("basDict", basDict);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void dictDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			dictDetailEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			dictDetailSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			dictDetailDelete(request,response);
		}else {
			dictDetailPageList(request,response);
		}
	}
	private void dictDetailPageList(HttpServletRequest request, HttpServletResponse response) {
		BasDictDetailVoService basDictDetailVoService = new BasDictDetailVoService();
		IBasDictDetailVoService iBasDictDetailVoService =(IBasDictDetailVoService)ServiceProxyFactory.getProxyInstance(basDictDetailVoService);
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String dictId = request.getParameter("dictId");
		String optionCode = request.getParameter("optionCode");
		String optionLabel = request.getParameter("optionLabel");
		String seqNum = request.getParameter("seqNum");
		Page page = new Page();
		BasDictDetailVo basDictDetailVo = new BasDictDetailVo();
		basDictDetailVo.setDictId(dictId);
		basDictDetailVo.setOptionCode(optionCode);
		basDictDetailVo.setOptionLabel(optionLabel);
		basDictDetailVo.setSeqNum(StringUtil.strToBigDecimal(seqNum));
		try {
			page = iBasDictDetailVoService.pageList(pageIndex, pageSize, basDictDetailVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_detail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void dictDetailDelete(HttpServletRequest request, HttpServletResponse response) {
		String dictDetailId = request.getParameter("id");
		iBasDictDetailService.delete(dictDetailId);
		try {
			response.sendRedirect("/share/admin/DictionaryAction.action?pageName=dictDetail");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void dictDetailSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dictDetailId = request.getParameter("id");
		String dictId = request.getParameter("dictId");
		String optionCode = request.getParameter("optionCode");
		String optionLabel = request.getParameter("optionLabel");
		String seqNum = request.getParameter("seqNum");
		BasDictDetail basDictDetail = new BasDictDetail();
		basDictDetail.setDictId(dictId);
		basDictDetail.setOptionCode(optionCode);
		basDictDetail.setOptionLabel(optionLabel);
		basDictDetail.setSeqNum(StringUtil.strToBigDecimal(seqNum));
		if (StringUtil.isEmpty(dictDetailId)) {
			dictDetailId = StringUtil.generateUUID();
			basDictDetail.setDictDetailId(dictDetailId);
			try {
				iBasDictDetailService.codeCheck(basDictDetail);
				iBasDictDetailService.insert(basDictDetail);
				response.sendRedirect("/share/admin/DictionaryAction.action?pageName=dictDetail");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basDictDetail.setDictDetailId(dictDetailId);
			try {
//				iBasDictDetailService.codeCheck(basDictDetail);
				iBasDictDetailService.update(basDictDetail);
				response.sendRedirect("/share/admin/DictionaryAction.action?pageName=dictDetail");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}

	@SuppressWarnings("unused")
	private void categorySmallEdit(HttpServletRequest request, HttpServletResponse response) {
		String dictDetailId = request.getParameter("id");
		if (StringUtil.isEmpty(dictDetailId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_detail_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasDictDetail> list = iBasDictDetailService.load(dictDetailId);
			BasDictDetail basDictDetail = list.get(0);
			request.setAttribute("id", "&id="+dictDetailId);
			request.setAttribute("basDictDetail", basDictDetail);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_detail_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void dictDetailEdit(HttpServletRequest request, HttpServletResponse response) {
		String dictDetailId = request.getParameter("id");
		List<BasDict> listBasDict = iBasDictService.list();
		request.setAttribute("listBasDict", listBasDict);
		if (StringUtil.isEmpty(dictDetailId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_detail_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasDictDetail> list = iBasDictDetailService.load(dictDetailId);
			BasDictDetail basDictDetail = list.get(0);
			request.setAttribute("id", "&id="+dictDetailId);
			request.setAttribute("basDictDetail", basDictDetail);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/dictionary/bas_dict_detail_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
