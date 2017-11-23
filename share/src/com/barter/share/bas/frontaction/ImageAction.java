package com.barter.share.bas.frontaction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int IMG_HEIGHT = 100;
    private static final int IMG_WIDTH = 30;
    private static final int CODE_LEN = 4;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageAction() {
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
	        // 用于绘制图片，设置图片的长宽和图片类型（RGB)
	        BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
	        // 获取绘图工具
	        Graphics graphics = bi.getGraphics();
	        graphics.setColor(new Color(100, 230, 200)); // 使用RGB设置背景颜色
	        graphics.fillRect(0, 0, 100, 30); // 填充矩形区域
	        // 验证码中所使用到的字符
	        char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
	        String captcha = ""; // 存放生成的验证码
	        Random random = new Random();
	        for(int i = 0; i < CODE_LEN; i++) { // 循环将每个验证码字符绘制到图片上
	            int index = random.nextInt(codeChar.length);
	            // 随机生成验证码颜色
	            graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(255)));
	            // 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
	            graphics.drawString(codeChar[index] + "", (i * 20) + 15, 20);
	            captcha += codeChar[index];
	        }
	        // 将生成的验证码code放入sessoin中
	        request.getSession().setAttribute("code", captcha);
	        // 通过ImageIO将图片输出
	        ImageIO.write(bi, "JPG", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
