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
	 * ��������ʽ
	 * @return
	 */
	private Font getFont() {
		return new Font("Times New Roman",Font.ROMAN_BASELINE,18);
	}
	/**
	 * �����ɫ
	 * 	 @return
	 */
	private Color getRandColor() {
		int r=random.nextInt(256);
		int g=random.nextInt(256);
		int b=random.nextInt(256);
		return new Color(r,g,b);
	}
	/**
	 * ����ͼƬ
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void getRandcode(HttpServletRequest request,HttpServletResponse response ) throws IOException {
		//����HttpSession����
		HttpSession session=request.getSession();
		//����һ��������ͼģ��
		BufferedImage image =new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//�������ʽ��л滭
		Graphics graphics=image.getGraphics();
		//���û��ʸ�ʽ
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(getRandColor());
		//���Ƹ�����
		for (int i = 0; i <=lineSize; i++) {
			drawLine(graphics);
		}
		//������֤��
		String randomString="";
		for (int i = 0; i <=stringNum; i++) {
			randomString = drawString(graphics,randomString,i);
		}
		//������֤��
		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, randomString);
		//��ͼƬ���͸�������
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	/**
	 * ������֤��
	 * @param graphics
	 * @param randomString
	 * @param i 
	 * @return
	 */
	private String drawString(Graphics graphics, String randomString, int i) {
		//��ȡ����
		graphics.setFont(getFont());
		//���û�����ɫ
		graphics.setColor(getRandColor());
		//��������仯��xy
		graphics.translate(random.nextInt(3), random.nextInt(3));
		//������֤���ַ�
		String rand=String.valueOf(getRandomString(random.nextInt(randString.length())));
		//������֤��
		randomString+=rand;
		//������֤�뵽ͼ��
		graphics.drawString(rand, 13*i, 16);
		//�����ַ���
		return randomString;
	}
	/**
	 * ��ȡ����ַ�
	 * @param nextInt
	 * @return
	 */
	private String getRandomString(int nextInt) {
		
		return String.valueOf(randString.charAt(nextInt));
	}
	/**
	 * ���Ƹ�����
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
