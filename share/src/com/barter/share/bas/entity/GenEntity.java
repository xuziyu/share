package com.barter.share.bas.entity;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GenEntity {
     
    private String tablename = "";//表名
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*
     
    //数据库连接
     private static final String URL ="jdbc:mysql://10.2.40.70:3306/share";
     private static final String NAME = "root";
     private static final String PASS = "root";
     private static final String DRIVER ="com.mysql.jdbc.Driver";
 
    /*
     * 构造函数
     */
    public GenEntity(String tablename){
    	this.tablename = tablename;
        //创建连接
        Connection con;
        //查要生成实体类的表
        String sql = "select * from " + tablename;
        PreparedStatement pStemt = null;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            con = DriverManager.getConnection(URL,NAME,PASS);
            pStemt = con.prepareStatement(sql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            int size = rsmd.getColumnCount();   //统计列
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                 
                if(colTypes[i].equalsIgnoreCase("datetime")){
                    f_util = true;
                }
                if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){
                    f_sql = true;
                }
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }
             
            String content = parse(colnames,colTypes,colSizes);
             
            try {
                File directory = new File("");
                //System.out.println("绝对路径："+directory.getAbsolutePath());
                //System.out.println("相对路径："+directory.getCanonicalPath());
                String path=this.getClass().getResource("").getPath();
                System.out.println(path);
                System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );
                FileWriter fw = new FileWriter(directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java");
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
//          try {
//              con.close();
//          } catch (SQLException e) {
//              // TODO Auto-generated catch block
//              e.printStackTrace();
//          }
        }
    }
 
    /**
     * 功能：生成实体类主体代码
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.barter.share.bas.entity;\r\n");
        //判断是否导入工具包
        if(f_util){
            sb.append("import java.util.Date;\r\n");
        }
        if(f_sql){
            sb.append("import java.sql.*;\r\n");
        }
        sb.append("\r\n");
        //注释部分
        sb.append("   /**\r\n");
        sb.append("    * "+tablename+" 实体类\r\n");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        java.util.Date date = new java.util.Date();
        sb.append("    * "+simpleDateFormat.format(date)+"  Lu Xiang\r\n");
        sb.append("    */ \r\n");
        //实体部分
        sb.append("\r\n\r\npublic class " + initcap(tablename) + "{\r\n");
        processAllAttrs(sb);//属性
        processAllMethod(sb);//get set方法
        sb.append("}\r\n");
         
        //System.out.println(sb.toString());
        return sb.toString();
    }
     
    /**
     * 功能：生成所有属性
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
         
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + fieldProperty(colnames[i]) + ";\r\n");
        }
         
    }
 
    /**
     * 功能：生成所有方法
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
         
        for (int i = 0; i < colnames.length; i++) {
        	//set方法
            sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " + 
            		fieldProperty(colnames[i]) + "){\r\n");
            sb.append("\t\tthis." + fieldProperty(colnames[i]) + "=" + fieldProperty(colnames[i]) + ";\r\n");
            sb.append("\t}\r\n");
            //get方法
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
            sb.append("\t\treturn " + fieldProperty(colnames[i]) + ";\r\n");
            sb.append("\t}\r\n");
        }
         
    }
     
    /**
     * 功能：filed 字段  属性
     * @param str
     * @return
     */
    private StringBuffer initcap(String colnames) {
    	StringBuffer property = new StringBuffer(colnames.toLowerCase());
    	int a [] =new int [10];
    	int j =0;
    	for (int i = 0; i < property.length(); i++) {
			if ('_'==(property.charAt(i))) {
				a[j] = i;
				j++;
			}
		}
    	if (j>=1) {
    		for (int i = j-1; i>=0; i--) {
        		char ch =property.charAt(a[i]+1);
        		ch=(char)(ch-32);
        		property.deleteCharAt(a[i]);
        		property.setCharAt(a[i], ch);
    		}
    		char b = property.charAt(0);
    		b=(char)(b-32);
    		property.setCharAt(0, b);
    		return property;
		}else{
			char ch = property.charAt(0);
			ch=(char)(ch-32);
			property.setCharAt(0, ch);
			return property;
		}
    }
 
    /**
     * 功能：获得列的数据类型
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {
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
            return "Double";
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
    /**
     * filed 字段  属性
     * @param property
     */
    public StringBuffer fieldProperty(String colnames){
    	StringBuffer property = new StringBuffer(colnames.toLowerCase());
    	int a [] =new int [10];
    	int j =0;
    	for (int i = 0; i < property.length(); i++) {
			if ('_'==(property.charAt(i))) {
				a[j] = i;
				j++;
			}
			
		}
    	System.out.println(j);
    	if (j>=1) {
    		for (int i = j-1; i>=0; i--) {
        		char ch =property.charAt(a[i]+1);
        		ch=(char)(ch-32);
        		property.deleteCharAt(a[i]);
        		property.setCharAt(a[i], ch);
    		}
    		return property;
		}else{
			return property;
		}
    }
     
    /**
     * 出口
     * TODO
     * @param args
     */
    public static void main(String[] args) {
         //参数表名
        new GenEntity("sys_role_menu");
         
    }
 
}
