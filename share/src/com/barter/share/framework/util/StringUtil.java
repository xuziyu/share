package com.barter.share.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * 功能描述:字符串工具类
 * @author Administrator
 * @version 1.0
 * 创建日期:2017年5月12日
 */
public class StringUtil {
	/**
	 * 判断是否为空
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s){
		if(s == null){
			return true ;
		}else if(s.trim().equals("")){
			return true ;
		}else{
			return false ;
		}
	}
	/**
	 * 
	 * @param boolean1
	 * @return
	 */
	public static boolean isEmpty(Boolean boolean1){
		if (boolean1==null) {
			return true;
		}else {
			return isEmpty(String.valueOf(boolean1));
		}
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
    public static boolean isEmpty(Date date){
    	if (date ==null) {
			return true;
		}else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	return isEmpty(simpleDateFormat.format(date));
		}
    }
    /**
     * 
     * @param double1
     * @return
     */
    public static boolean isEmpty(Double double1){
    	if (double1==null) {
			return true;
		}else {
			return isEmpty(String.valueOf(double1));
		}
    }
    /**
     * 
     * @param integer
     * @return
     */
    public static boolean isEmpty(Integer integer){
    	if (integer==null) {
			return true;
		}else {
			return isEmpty(String.valueOf(integer));
		}
    }
    /**
     * 
     * @param float1
     * @return
     */
    public static boolean isEmpty(Float float1){
    	if (float1==null) {
			return true;
		}else {
			return isEmpty(String.valueOf(float1));
		}
    }
    /**
     * 
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object){
    	if (object==null) {
			return true;
		}else {
			return isEmpty(String.valueOf(object));
		}
    }
	/**
	 * 功能：随机生成一个UUID
	 * @return
	 */
	public static String generateUUID(){
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}
	/**
	 * 功能：通过一个实体对象 得到属性对应值的集合；
	 * @param entity
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object [] reflectValue(Object entity) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Field [] fields = entity.getClass().getDeclaredFields();
		Object [] paramsValue = new Object[fields.length];
		for (int i = 0; i < fields.length; i++) {
			String name =fields[i].getName();
			name = name.substring(0,1).toUpperCase()+name.substring(1);
			String fieldType = fields[i].getGenericType().toString();
			if (fieldType.equals("class java.lang.String")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (String)method.invoke(entity);
			}else if (fieldType.equals("class java.lang.Integer")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (Integer)method.invoke(entity);
			}else if (fieldType.equals("class java.lang.Short")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (Short)method.invoke(entity);
			}else if (fieldType.equals("class java.lang.Double")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (Double)method.invoke(entity);
			}else if (fieldType.equals("class java.lang.Boolean")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (Boolean)method.invoke(entity);
			}else if (fieldType.equals("class java.util.Date")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (Date)method.invoke(entity);
			}else if (fieldType.equals("class java.math.BigDecimal")) {
				Method method = entity.getClass().getMethod("get" + name);
				paramsValue[i] = (BigDecimal)method.invoke(entity);
			}
		}
		return paramsValue;
	} 
	/**
	 * 功能 ：数组向左移一位；
	 * @param objects
	 * @return
	 */
	public static Object [] leftOne(Object [] objects){
		Object object = objects[0];
		for (int i = 0; i < objects.length-1; i++) {
			objects[i] =objects[i+1];
		}
		objects[objects.length-1]=object;
		return objects;
	}
	/**
	 * 判断一个object对象是否为空  为空的话  返回true
	 * 否则如果不为空判断是否为空
	 * @param object
	 * @return
	 */
	public static boolean objectFromString(Object object){
		if (object==null) {
			return true;
		}else {
			return isEmpty(object.toString());
		}
	}
	/**
	 * 通过数据库中的字段名称  或者 Java中相对应的  java类型
	 * @param sqlType
	 * @return
	 */
	public static String sqlType2JavaType(String sqlType) {
        if(sqlType.equalsIgnoreCase("bit")){
            return "Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "Short";
        }else if(sqlType.equalsIgnoreCase("int")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") 
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") 
                || sqlType.equalsIgnoreCase("smallmoney")){
            return "BigDecimal";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") 
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") 
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime")){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }
        return null;
    }
	
	public static BigDecimal strToBigDecimal(String string){
		if (!isEmpty(string)) {
			return new BigDecimal(string);
		}else {
			return null;
		}
	}
	public static BigDecimal db(String string){
		if (!isEmpty(string)) {
			return new BigDecimal(string);
		}else {
			return null;
		}
	}
	public static String getRandomString(int length){
	    String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<length;i++){
	      int number=random.nextInt(62);
	      sb.append(str.charAt(number));
	    }
	    return sb.toString();
	 }
}
