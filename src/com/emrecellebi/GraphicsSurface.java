package com.emrecellebi;

import java.io.File;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.imageio.ImageIO;

import java.util.Date;

public class GraphicsSurface extends JComponent
{
	File digits_file = null;
	File dots_file = null;
	BufferedImage[] digits;
	BufferedImage[] dots;
	
	public GraphicsSurface()
	{
		String subdirectory = System.getProperty("parent.directory");
		if(subdirectory != null) digits_file = new File( subdirectory + "res/img/digits.png"); else digits_file = new File("res/img/digits.png");
		if(subdirectory != null) dots_file = new File(subdirectory + "res/img/dots.png"); else dots_file = new File("res/img/dots.png");
		
		try
		{
			BufferedImage digits_board = ImageIO.read(digits_file);
			BufferedImage dots_board = ImageIO.read(dots_file);
		
			digits = new BufferedImage[10];
			dots = new BufferedImage[2];
			
			int digit_width = digits_board.getWidth() / 5;
			int digit_height = digits_board.getHeight() / 2;
			
			int current = 0;
			for(int y = 0; y < digits_board.getHeight(); y += digit_height)
			{
				for(int x = 0; x < digits_board.getWidth(); x += digit_width)
				{
					digits[current] = digits_board.getSubimage(x, y, digit_width, digit_height);
					
					current++;
				}
			}
			
			int dot_width = dots_board.getWidth() / 2;
			int dot_height = dots_board.getHeight() / 1;
			
			current = 0;
			for(int y = 0; y < dots_board.getHeight(); y += dot_height)
			{
				for(int x = 0; x < dots_board.getWidth(); x += dot_width)
				{
					dots[current] = dots_board.getSubimage(x, y, dot_width, dot_height);
					
					current++;
				}
			}
			
			
		}catch(Exception e){}
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(255, 255, 255, 255));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		Date d = new Date();
		String hour = "" + d.getHours();
		String min = "" + d.getMinutes();
		String sec = "" + d.getSeconds();
		
		if(hour.length() == 1)
			hour = "0" + hour;
		if(min.length() == 1)
			min = "0" + min;
		if(sec.length() == 1)
			sec = "0" + sec;
		
		System.out.print("\r" + hour + ":" + min + ":" + sec);
		
		int x = 0;
		g2d.drawImage(digits[Integer.parseInt(hour.substring(0, 1))], null, x, 0);
		x += digits[0].getWidth();
		
		g2d.drawImage(digits[Integer.parseInt(hour.substring(1, 2))], null, x, 0);
		x += digits[0].getWidth();
		
		if(Integer.parseInt(sec) % 2 == 0)
			g2d.drawImage(dots[0], null, x, 0);
		else
			g2d.drawImage(dots[1], null, x, 0);
		
		x += dots[0].getWidth();
		
		g2d.drawImage(digits[Integer.parseInt(min.substring(0, 1))], null, x, 0);
		x += digits[0].getWidth();
		
		g2d.drawImage(digits[Integer.parseInt(min.substring(1, 2))], null, x, 0);
		x += digits[0].getWidth();
		
		if(Integer.parseInt(sec) % 2 == 0)
			g2d.drawImage(dots[0], null, x, 0);
		else
			g2d.drawImage(dots[1], null, x, 0);
		
		x += dots[0].getWidth();
		
		g2d.drawImage(digits[Integer.parseInt(sec.substring(0, 1))], null, x, 0);
		x += digits[0].getWidth();
		
		g2d.drawImage(digits[Integer.parseInt(sec.substring(1, 2))], null, x, 0);
		x += digits[0].getWidth();
		
		repaint();
	}
}