package cn.itlaobing.yzm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCode {
	public static final String RANDOMCODEKEY="RANDOMVALIDATECODE";
	private Random random=new Random();
	private String randString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int width=80;
	private int height=50;
	private int lineSize=100;
	private int stringNum=4;
	/**
	 * 获得字体格式
	 * @return
	 */
	private Font getFont() {
		return new Font("Times New Roman",Font.ROMAN_BASELINE,18);
	}
	/**
	 * 随机颜色
	 * 	 @return
	 */
	private Color getRandColor() {
		int r=random.nextInt(256);
		int g=random.nextInt(256);
		int b=random.nextInt(256);
		return new Color(r,g,b);
	}
	/**
	 * 生成图片
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void getRandcode(HttpServletRequest request,HttpServletResponse response ) throws IOException {
		//创建HttpSession对象
		HttpSession session=request.getSession();
		//创建一个基础绘图模板
		BufferedImage image =new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//创建画笔进行绘画
		Graphics graphics=image.getGraphics();
		//设置画笔格式
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(getRandColor());
		//绘制干扰线
		for (int i = 0; i <=lineSize; i++) {
			drawLine(graphics);
		}
		//绘制验证码
		String randomString="";
		for (int i = 0; i <=stringNum; i++) {
			randomString = drawString(graphics,randomString,i);
		}
		//保存验证码
		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, randomString);
		//将图片发送给服务器
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	/**
	 * 绘制验证码
	 * @param graphics
	 * @param randomString
	 * @param i 
	 * @return
	 */
	private String drawString(Graphics graphics, String randomString, int i) {
		//获取字体
		graphics.setFont(getFont());
		//设置画笔颜色
		graphics.setColor(getRandColor());
		//设置随机变化的xy
		graphics.translate(random.nextInt(3), random.nextInt(3));
		//生成验证码字符
		String rand=String.valueOf(getRandomString(random.nextInt(randString.length())));
		//连接验证码
		randomString+=rand;
		//绘制验证码到图形
		graphics.drawString(rand, 13*i, 16);
		//返回字符串
		return randomString;
	}
	/**
	 * 获取随机字符
	 * @param nextInt
	 * @return
	 */
	private String getRandomString(int nextInt) {
		
		return String.valueOf(randString.charAt(nextInt));
	}
	/**
	 * 绘制干扰线
	 * @param graphics
	 */
	private void drawLine(Graphics graphics) {
		int x=random.nextInt(width);
		int y=random.nextInt(height);
		int xl=random.nextInt(13);
		int yl=random.nextInt(15);
		graphics.drawLine(x, y, x+xl, y+yl);
	}
}
