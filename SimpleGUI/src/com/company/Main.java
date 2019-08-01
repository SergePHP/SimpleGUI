package com.company;

import java.awt.*;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		SimpleGUI app = new SimpleGUI();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = app.getSize();
		
		if(frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if(frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		
		app.setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);

	}

}
