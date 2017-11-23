package com.barter.share.bas.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.group.Response;
import org.apache.jasper.tagplugins.jstl.core.If;
import com.barter.share.bas.dao.IBasSupplierDao;
import com.barter.share.bas.dao.imp.PchStockiImp;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.bas.entity.BasSupplier;
import com.barter.share.bas.entity.PchStockin;
import com.barter.share.bas.service.IBasProductSkuService;
import com.barter.share.bas.service.ISerCustomer;
import com.barter.share.bas.service.ISerSupplier;
import com.barter.share.bas.service.imp.BasProductSkuService;
import com.barter.share.bas.service.imp.SerCustomer;
import com.barter.share.bas.service.imp.SerSupplier;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;






/**
 * Servlet implementation class StockinsysAction
 */
public class StockinsysAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockinsysAction() {
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
		doGet(request, response);
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");//设置响应编码
	}
	/**
	 * 页面查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void pageList(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		String StpageIndex=request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String StpageSize=request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex=StringUtil.isEmpty(StpageIndex)?0:Integer.parseInt(StpageIndex);
		int pageSize=StringUtil.isEmpty(StpageSize)?5:Integer.parseInt(StpageSize);
		String createEmployeeId=request.getParameter("createEmployeeId");
        PchStockiImp pchStockinDao=new PchStockiImp();
		Page  page= pchStockinDao.pageList(pageIndex, pageSize, createEmployeeId);
		
		request.setAttribute("page",page);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/pch/Stockin_page_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * 编辑
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void edit(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		PchStockiImp pchStockinDao=new PchStockiImp();
		PchStockin pchStockin=new PchStockin();
		SerSupplier serSupplier=new SerSupplier();
		ISerSupplier iSerSupplier=(ISerSupplier)ServiceProxyFactory.getProxyInstance(serSupplier);
		List<BasSupplier> listbsBasSuppliers=iSerSupplier.list();
		request.setAttribute("listbsBasSuppliers", listbsBasSuppliers);
		SerCustomer serCustomer=new SerCustomer();
		ISerCustomer iSerCustomer=(ISerCustomer)ServiceProxyFactory.getProxyInstance(serCustomer);
		List<BasCustomer> lisBasCustomers=iSerCustomer.list();
		request.setAttribute("lisBasCustomers", lisBasCustomers);
		if(!StringUtil.isEmpty(request.getParameter("stockinId"))){
			String id=request.getParameter("stockinId");
			//System.out.println(id+"主键id4444");
			pchStockin=pchStockinDao.load(id);
		}
		request.setAttribute("pchStockin"  ,pchStockin);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/pch/Stockin_edit.jsp").forward(request, response);
		} catch (Exception e) {
		  e.printStackTrace();
		}
	
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PchStockiImp pchStockindao=new PchStockiImp();
		PchStockin pchStockin=new PchStockin();
		 if(!StringUtil.isEmpty(request.getParameter("stockinId"))){
			 String id=request.getParameter("stockinId");
			 pchStockindao.delete(id);
		 }
		 response.sendRedirect("/share/admin/StockinsysAction.action");
		
	}
	
	/**
	 * 查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PchStockiImp pchStockindao=new PchStockiImp();
		//执行查询
		//List<PchStockin> li =pchStockindao.list();
		List<PchStockin> list =pchStockindao.list();
		
		//查询结果放入request,转发到页面
		request.setAttribute("list", "list");
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/pch/Stockin_list.jsp").forward(request, response);
		
		 
	}
	/**
	 * 储存
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void save(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		PchStockiImp pchStockindao=new PchStockiImp();
		PchStockin pchStockin=new PchStockin();
		 if(StringUtil.isEmpty(request.getParameter("createEmployeeId"))){
			throw new DbException("管理者ID不能为空");
		 }
		 
		 entity(pchStockin, request);
		// pchStockindao.validateUnique4Code(pchStockin);
		 
	
		 
		 if(pchStockin.getStockinId()==null){
			 pchStockin.setStockinId(UUID.randomUUID().toString());
			
			 pchStockindao.insert(pchStockin);
			 
		 }else{
			 
			 pchStockindao.update(pchStockin);
		 }
		 response.sendRedirect("/share/admin/StockinsysAction.action");
	 }
	/**
	 * 获取存入的数据
	 * @param stockin
	 * @param request
	 * @throws ServletException
	 * @throws IOException
	 */
	private void entity(PchStockin pchStockin ,HttpServletRequest request )throws ServletException,IOException{
		
		if(!StringUtil.isEmpty(request.getParameter("stockinId"))){
			
			 pchStockin.setStockinId(request.getParameter("stockinId"));
		 }
		
		
		//System.out.println(pchStockin.getStockinId()+"1232131324132456526");
		pchStockin.setSupplierId(request.getParameter("supplierId"));
		pchStockin.setPurchaseDate(DateUtility.getDate(request.getParameter("purchaseDate")));		
		pchStockin.setTatalMoney(StringUtil.db(request.getParameter("tatalMoney")));
		pchStockin.setThisPayMoney(StringUtil.db(request.getParameter("thisPayMoney")));
		pchStockin.setBillStatus(StringUtil.db(request.getParameter("billStatus")));
		pchStockin.setPayStatus(StringUtil.db(request.getParameter("payStatus ")));
		pchStockin.setCreateEmployeeId(request.getParameter("createEmployeeId"));
		pchStockin.setCreateDatetime(DateUtility.getDate(request.getParameter("createDatetime")));
		
	 }

}
