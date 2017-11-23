package com.barter.share.bas.action;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.barter.share.bas.entity.BasFileUpload;
import com.barter.share.bas.entity.BasSkuColor;
import com.barter.share.bas.entity.BasSkuSize;
import com.barter.share.bas.service.IBasFileUploadService;
import com.barter.share.bas.service.IBasSkuColorService;
import com.barter.share.bas.service.IBasSkuSizeService;
import com.barter.share.bas.service.imp.BasFileUploadService;
import com.barter.share.bas.service.imp.BasSkuColorService;
import com.barter.share.bas.service.imp.BasSkuSizeService;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.FileUtil;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;
import com.sun.istack.internal.logging.Logger;

/**
 * Servlet implementation class ProductSKUAction
 */
public class ProductSKUAction extends BasAction {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_NAME="pageName";
	private static final String PAGE_NAME_SKUSIZE="skuSize";
	private static final String PAGE_NAME_SKUCOLOR="skuColor";
	private static final String PAGE_NAME_FILEUPLOAD="fileUpload";  
	
	private Logger logger = Logger.getLogger(ProductSKUAction.class);
	
	private static final String PATH_FOLDER ="I:/卢翔-学习文件夹/作业/java/第02章01 Java语言基础/share/WebContent/resource/front/image/upload/";
	private static final String TEMP_FOLDER="I:/卢翔-学习文件夹/作业/java/第02章01 Java语言基础/share/WebContent/resource/front/image/upload/";
	private static final String PATH_FILE="/share/resource/front/image/upload/";
	BasFileUploadService basFileUploadService = new BasFileUploadService();
	IBasFileUploadService iBasFileUploadService = (IBasFileUploadService)ServiceProxyFactory.getProxyInstance(basFileUploadService);
	BasSkuColorService basSkuColorService = new BasSkuColorService();
	IBasSkuColorService iBasSkuColorService = (IBasSkuColorService)ServiceProxyFactory.getProxyInstance(basSkuColorService);
	BasSkuSizeService basSkuSizeService = new BasSkuSizeService();
	IBasSkuSizeService iBasSkuSizeService = (IBasSkuSizeService)ServiceProxyFactory.getProxyInstance(basSkuSizeService);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSKUAction() {
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
		if (PAGE_NAME_SKUSIZE.equals(pageName)) {
			skuSize(request,response);
		}else if (PAGE_NAME_SKUCOLOR.equals(pageName)) {
			skuColor(request,response);
		}else if (PAGE_NAME_FILEUPLOAD.equals(pageName)) {
			fileUpload(request,response);
		}
	}
	private void fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			fileUploadEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			fileUploadSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			fileUploadDelete(request,response);
		}else {
			fileUploadPageList(request,response);
		}
	}
	private void fileUploadPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String fileSpec = request.getParameter("fileSpec");
		String fullPath = request.getParameter("fullPath");
		String shortName = request.getParameter("shortName");
		String extName = request.getParameter("extName");
		String fileSize = request.getParameter("fileSize");
		Page page = new Page();
		BasFileUpload basFileUpload = new BasFileUpload();
		basFileUpload.setFileSpec(StringUtil.strToBigDecimal(fileSpec));
		basFileUpload.setFullPath(fullPath);
		basFileUpload.setShortName(shortName);
		basFileUpload.setExtName(extName);
		basFileUpload.setFileSize(StringUtil.strToBigDecimal(fileSize));
		try {
			page = iBasFileUploadService.pageList(pageIndex, pageSize, basFileUpload);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_file_upload.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void fileUploadDelete(HttpServletRequest request, HttpServletResponse response) {
		String fileUploadId = request.getParameter("id");
		List<BasFileUpload> listBasFileUpload =iBasFileUploadService.load(fileUploadId);
		String fullPath = listBasFileUpload.get(0).getFullPath();
		File file = new File(fullPath);
		if (file.exists()) {
			file.delete();
		}
		iBasFileUploadService.delete(fileUploadId);
		
		try {
			response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=fileUpload");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void fileUploadSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileUploadId = request.getParameter("id");
		BasFileUpload basFileUpload = new BasFileUpload();
		if (StringUtil.isEmpty(fileUploadId)) {
			File filefolder = new File(PATH_FOLDER);
			if (!filefolder.exists()) {
				filefolder.mkdirs();
			}
			filefolder = new File(TEMP_FOLDER);
			if (!filefolder.exists()) {
				filefolder.mkdirs();
			}
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024);
			factory.setRepository(new File(TEMP_FOLDER));
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = upload.parseRequest(request);
				FileItem item = FileUtil.getUploadFileItem(list);
				String fileName = FileUtil.getUploadFileName(item);
				int index = fileName.indexOf(".");
				String fullPath = PATH_FILE+fileName;
				String shortName =fileName.substring(0,index);
				String extName =fileName.substring(index+1);
				Long LfileSize =item.getSize();
				String fileSize = String.valueOf(LfileSize);
				String fileSpec = null;
				for(FileItem item2 :list){
					if (item2.isFormField()) {
						if ("fileSpec".equals(item2.getFieldName())) {
							fileSpec = item2.getString();
						}
					}
				}
				System.out.println("文件路径    "+fullPath);
				System.out.println("上传成功   "+fileName);
				basFileUpload.setFileSpec(StringUtil.strToBigDecimal(fileSpec));
				basFileUpload.setFullPath(fullPath);
				basFileUpload.setShortName(shortName);
				basFileUpload.setExtName(extName);
				basFileUpload.setFileSize(StringUtil.strToBigDecimal(fileSize));
				item.write(new File(PATH_FOLDER, fileName));
			} catch (FileUploadException e) {
				System.out.println("上传失败");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			fileUploadId = StringUtil.generateUUID();
			basFileUpload.setFileUploadId(fileUploadId);
			try {
				iBasFileUploadService.codeCheck(basFileUpload);
				iBasFileUploadService.insert(basFileUpload);
				response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=fileUpload");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basFileUpload.setFileUploadId(fileUploadId);
			basFileUpload.setFileSpec(StringUtil.strToBigDecimal(request.getParameter("fileSpec")));
			basFileUpload.setFullPath(request.getParameter("fullPath"));
			basFileUpload.setShortName(request.getParameter("shortName"));
			basFileUpload.setExtName(request.getParameter("extName"));
			basFileUpload.setFileSize(StringUtil.strToBigDecimal(request.getParameter("fileSize")));
			try {
				iBasFileUploadService.update(basFileUpload);
				response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=fileUpload");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}
	private void fileUploadEdit(HttpServletRequest request, HttpServletResponse response) {
		String fileUploadId = request.getParameter("id");
		if (StringUtil.isEmpty(fileUploadId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_file_upload_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasFileUpload> list = iBasFileUploadService.load(fileUploadId);
			BasFileUpload basFileUpload = list.get(0);
			request.setAttribute("id", "&id="+fileUploadId);
			request.setAttribute("basFileUpload", basFileUpload);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_file_upload_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void skuColor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			skuColorEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			skuColorSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			skuColorDelete(request,response);
		}else {
			skuColorPageList(request,response);
		}
	}
	private void skuColorPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		String rgb = request.getParameter("rgb");
		Page page = new Page();
		BasSkuColor basSkuColor = new BasSkuColor();
		basSkuColor.setCode(code);
		basSkuColor.setName(name);
		basSkuColor.setDescr(descr);
		basSkuColor.setRgb(rgb);
		try {
			page = iBasSkuColorService.pageList(pageIndex, pageSize, basSkuColor);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_sku_color.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void skuColorDelete(HttpServletRequest request, HttpServletResponse response) {
		String skuColorId = request.getParameter("id");
		iBasSkuColorService.delete(skuColorId);
		try {
			response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=skuColor");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void skuColorSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skuColorId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		String rgb = request.getParameter("rgb");
		BasSkuColor basSkuColor = new BasSkuColor();
		basSkuColor.setCode(code);
		basSkuColor.setName(name);
		basSkuColor.setDescr(descr);
		basSkuColor.setRgb(rgb);
		if (StringUtil.isEmpty(skuColorId)) {
			skuColorId = StringUtil.generateUUID();
			basSkuColor.setSkuColorId(skuColorId);
			try {
				iBasSkuColorService.codeCheck(basSkuColor);
				iBasSkuColorService.insert(basSkuColor);
				response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=skuColor");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basSkuColor.setSkuColorId(skuColorId);
			try {
//				iBasSkuColorService.codeCheck(basSkuColor);
				iBasSkuColorService.update(basSkuColor);
				response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=skuColor");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}
	private void skuColorEdit(HttpServletRequest request, HttpServletResponse response) {
		String skuColorId = request.getParameter("id");
		if (StringUtil.isEmpty(skuColorId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_sku_color_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasSkuColor> list = iBasSkuColorService.load(skuColorId);
			BasSkuColor basSkuColor = list.get(0);
			request.setAttribute("id", "&id="+skuColorId);
			request.setAttribute("basSkuColor", basSkuColor);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_sku_color_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void skuSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			skuSizeEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			skuSizeSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			skuSizeDelete(request,response);
		}else {
			skuSizePageList(request,response);
		}
	}
	private void skuSizePageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		Page page = new Page();
		BasSkuSize basSkuSize = new BasSkuSize();
		basSkuSize.setCode(code);
		basSkuSize.setName(name);
		basSkuSize.setDescr(descr);
		try {
			page = iBasSkuSizeService.pageList(pageIndex, pageSize, basSkuSize);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_sku_size.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void skuSizeDelete(HttpServletRequest request, HttpServletResponse response) {
		String skuSizeId = request.getParameter("id");
		iBasSkuSizeService.delete(skuSizeId);
		try {
			response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=skuSize");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void skuSizeSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skuSizeId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		BasSkuSize basSkuSize = new BasSkuSize();
		basSkuSize.setCode(code);
		basSkuSize.setName(name);
		basSkuSize.setDescr(descr);
		if (StringUtil.isEmpty(skuSizeId)) {
			skuSizeId = StringUtil.generateUUID();
			basSkuSize.setSkuSizeId(skuSizeId);
			try {
				iBasSkuSizeService.codeCheck(basSkuSize);
				iBasSkuSizeService.insert(basSkuSize);
				response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=skuSize");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basSkuSize.setSkuSizeId(skuSizeId);
			try {
//				iBasSkuSizeService.codeCheck(basSkuSize);
				iBasSkuSizeService.update(basSkuSize);
				response.sendRedirect("/share/admin/ProductSKUAction.action?pageName=skuSize");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}
	private void skuSizeEdit(HttpServletRequest request, HttpServletResponse response) {
		String skuSizeId = request.getParameter("id");
		if (StringUtil.isEmpty(skuSizeId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_sku_size_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasSkuSize> list = iBasSkuSizeService.load(skuSizeId);
			BasSkuSize basSkuSize = list.get(0);
			request.setAttribute("id", "&id="+skuSizeId);
			request.setAttribute("basSkuSize", basSkuSize);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/bas_sku_size_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
