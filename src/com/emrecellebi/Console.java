package com.emrecellebi;

import javax.swing.JFrame;

public class Console
{	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Digital Clock");
		
		f.add(new GraphicsSurface());
		
		f.setSize(210, 82);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}