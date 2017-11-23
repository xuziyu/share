package com.barter.share.framework.util;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileUtil {
	public static FileItem getUploadFileItem(List<FileItem> list){
		for(FileItem item:list){
			if (!item.isFormField()) {
				return item;
			}
		}
		return null;
	}
	public static String getUploadFileName(FileItem item){
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String fileName = value.substring(start + 1);
		
		return fileName;
	} 
	public static FileItem getUploadFormName(List<FileItem> list){
		for(FileItem item:list){
			if (item.isFormField()) {
				return item;
			}
		}
		return null;
	}
}
