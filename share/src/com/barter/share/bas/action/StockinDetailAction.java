package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.dao.imp.PchStockiImp;
import com.barter.share.bas.dao.imp.PchStockinDetailImp;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.bas.entity.PchStockin;
import com.barter.share.bas.entity.PchStockinDetail;
import com.barter.share.bas.service.IBasProductSkuService;
import com.barter.share.bas.service.imp.BasProductSkuService;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;


/**
 * Servlet implementation class StockinDetailAction
 */
public class StockinDetailAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockinDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");//设置响应编码
		try {
			String method= request.getParameter(METHOD_NAME);
			if(METHOD_NAME_EDIT.equals(method)){
				edit(request, response);
			}else if(METHOD_NAME_SAVE.equals(method)){
				save(request, response);
			}else if(METHOD_NAME_DELETE.equals(method)){
				delete(request, response);
			}else{
				pageList(request, response);
			 }
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");//设置响应编码
	}
	private void pageList(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		String StpageIndex=request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String StpageSize=request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex=StringUtil.isEmpty(StpageIndex)?0:Integer.parseInt(StpageIndex);
		int pageSize=StringUtil.isEmpty(StpageSize)?5:Integer.parseInt(StpageSize);
		String name=request.getParameter("name");
        PchStockinDetailImp pchStockinDetailDao=new PchStockinDetailImp();
		Page  page= pchStockinDetailDao.pageList(pageIndex, pageSize, name);
		
		request.setAttribute("page",page);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/pch/StockinDetail_page_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	private void edit(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		PchStockinDetailImp pchStockinDetailDao=new PchStockinDetailImp();
		PchStockinDetail pchStockinDetail=new PchStockinDetail();
		PchStockiImp pchStockiImp=new PchStockiImp();
		List<PchStockin> pchstoList=pchStockiImp.list();
		request.setAttribute("pchstoList"  ,pchstoList);
		BasProductSkuService basProductSkuService = new BasProductSkuService();
		IBasProductSkuService iBasProductSkuService = (IBasProductSkuService)ServiceProxyFactory.getProxyInstance(basProductSkuService);
		List<BasProductSku> listBasProductSku = iBasProductSkuService.list();
		request.setAttribute("listBasProductSku", listBasProductSku);
		//BasProductSku basProductSku=new BasProductSku();
		//List<PchStockin> pchstoLis=pchStockiImp.list();
		
		if(!StringUtil.isEmpty(request.getParameter("stockinDetailId"))){
			String id=request.getParameter("stockinDetailId");
			pchStockinDetail=pchStockinDetailDao.load(id);
		}
		request.setAttribute("pchStockinDetail"  ,pchStockinDetail);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/pch/StockinDetail_edit.jsp").forward(request, response);
		} catch (Exception e) {
		  e.printStackTrace();
		}
	
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PchStockinDetailImp pchStockinDetailDao=new PchStockinDetailImp();
		
		 if(!StringUtil.isEmpty(request.getParameter("stockinDetailId"))){
			 String id=request.getParameter("stockinDetailId");
			 pchStockinDetailDao.delete(id);
		 }
		 response.sendRedirect("/share/admin/StockinDetailAction.action");
		
	}
	private void save(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		PchStockinDetailImp pchStockinDetailDao=new PchStockinDetailImp();
		PchStockinDetail pchStockinDetail=new PchStockinDetail();
		 if(StringUtil.isEmpty(request.getParameter("name"))){
			throw new DbException("名称");
		 }
		 entity(pchStockinDetail, request);
		// pchStockinDetailDao.validateUnique4Code(pchStockinDetail);
		 if(pchStockinDetail.getStockinDetailId()==null){
			 pchStockinDetail.setStockinDetailId(UUID.randomUUID().toString());
			 pchStockinDetailDao.insert(pchStockinDetail);
		 }else{		 
			 pchStockinDetailDao.update(pchStockinDetail);
		 }
		 response.sendRedirect("/share/admin/StockinDetailAction.action");
	 }
	
private void entity(PchStockinDetail pchStockinDetail ,HttpServletRequest request )throws ServletException,IOException{
		
		if(!StringUtil.isEmpty(request.getParameter("stockinDetailId"))){
			
			pchStockinDetail.setStockinDetailId(request.getParameter("stockinDetailId"));
		 }
		pchStockinDetail.setStockinId(request.getParameter("stockinId"));
		pchStockinDetail.setProductSkuId(request.getParameter("productSkuId"));
		pchStockinDetail.setName(request.getParameter("name"));
		pchStockinDetail.setAmount(StringUtil.db(request.getParameter("amount")));
		pchStockinDetail.setPrice(StringUtil.db(request.getParameter("price")));
		pchStockinDetail.setMoneyReal(StringUtil.db(request.getParameter("moneyReal")));
		pchStockinDetail.setRemark(request.getParameter("remark"));
		
		
	 }
private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//执行查询
	PchStockinDetailImp pchStockinDetailDao=new PchStockinDetailImp();
	List<PchStockinDetail> list =pchStockinDetailDao.list();
	//查询结果放入request,转发到页面
	request.setAttribute("list", "list");
	request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/pch/StockinDetail_list.jsp").forward(request, response);		 
}

}
