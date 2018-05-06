package com.rjgc.rjgcweb.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * create by hejiangping on 2018-5-5 
 */

@Controller
@RequestMapping("/captcha")
public class captchaController {
	  private Color getRandColor(int fc,int bc)
	  {
		  Random random = new Random();
		  if(fc>255) fc=255;
		  if(bc>255) bc=255;
		  int r=fc+random.nextInt(bc-fc);
		  int g=fc+random.nextInt(bc-fc);
		  int b=fc+random.nextInt(bc-fc);
		  return new Color(r,g,b);
	  }
	  
	  @GetMapping("")
	  private void image(HttpServletRequest request,
              HttpServletResponse response) throws IOException{
		  System.out.println("验证码");
		  int width=60, height=20;
		  BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		  Graphics g = image.getGraphics();
		  Random random = new Random();
		  g.setColor(getRandColor(200,250));
		  g.fillRect(0, 0, width, height);
		  g.setFont(new Font("Times New Roman",Font.PLAIN,18));
		  g.setColor(getRandColor(160,200));
		  for (int i=0;i<155;i++){
			  int x = random.nextInt(width);
			  int y = random.nextInt(height);
			  int xl = random.nextInt(12);
			  int yl = random.nextInt(12);
			  g.drawLine(x,y,x+xl,y+yl);
		  }
		  String sRand="";
		  for (int i=0;i<4;i++){
			  String rand=String.valueOf(random.nextInt(10));
			  sRand+=rand;
			  g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			  g.drawString(rand,13*i+6,16);
		  }
	      try {
	      //将图片写出到指定位置（复制图片）
	          OutputStream ops = new FileOutputStream(new File("1.jpg"));
	          ImageIO.write(image, "jpg", ops);         
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      request.getSession().setAttribute("sRand",sRand);
	      ImageIO.write(image, "JPEG", response.getOutputStream());
	      response.setHeader("Pragma","No-cache");
	      response.setHeader("Cache-Control","no-cache");
	      response.setDateHeader("Expires", 0);
	      g.dispose();
	  }
}
