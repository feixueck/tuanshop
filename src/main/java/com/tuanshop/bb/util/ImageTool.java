package com.tuanshop.bb.util;

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

public class ImageTool {

	public ImageTool() {
	}

	private static Random random = new Random();

	public static Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r = s + random.nextInt(e - s);
		int g = s + random.nextInt(e - s);
		int b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}

	public static void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(80, 30,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

//		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, 80, 30);

		g.setFont(new Font("Times New Roman", Font.PLAIN, 22));

//		g.setColor(getRandColor(160, 200));
//		for (int i = 0; i < 30; i++) {
//			int x = random.nextInt(60);
//			int y = random.nextInt(20);
//			int xl = random.nextInt(12);
//			int yl = random.nextInt(12);
//			g.drawLine(x, y, x + xl, y + yl);
//		}
		
		StringBuffer randCode = new StringBuffer();
		int itmp1 = random.nextInt(10);
		int itmp2 = random.nextInt(10);
		
		String temp = "";
		if(itmp1 > itmp2) {
			temp = itmp2 + "+" +"?"+"="+itmp1;
			randCode.append(itmp1-itmp2);
		} else {
			temp = itmp1 + "+" +"?"+"="+itmp2;
			randCode.append(itmp2-itmp1);
		}
		
		/**** 随机缩放文字并将文字旋转指定角度 
			// 将文字旋转指定角度
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 15 * i + 10, 7);
			// 缩放文字
			float scaleSize = random.nextFloat() + 0.8f;
			if (scaleSize > 1.1f)
				scaleSize = 1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
		**/
		
		g.setColor(Color.BLACK);
		g.drawString(temp, 10, 25);
		
		// 将生成的验证码保存到Session中
		HttpSession session = request.getSession(true);
		session.setAttribute("randCode", randCode.toString());
		//System.out.println(session.getAttribute("randCode"));
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	System.out.println("------------" + session.getAttribute("randCode"));
	}

}
