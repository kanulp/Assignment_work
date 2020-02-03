package java_culminating;

import javax.swing.*;
import java.awt.*;

public class StudentFrame extends JFrame{

	private JMenu fileMenu,helpMenu;
	private JMenuBar mb;

	public StudentFrame() {
		createMenuBar();
		this.setTitle("Basic Application Exmaple");
		this.add(mb);
		this.setLayout(new BorderLayout());
		this.add(new StudentPanel(), BorderLayout.CENTER);
		this.setSize(400, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createMenuBar(){
		mb=new JMenuBar(); 
		fileMenu = JMenu("File");
		helpMenu = JMenu("Help");
		mb.add(fileMenu);
		mb.add(helpMenu);
	}

}