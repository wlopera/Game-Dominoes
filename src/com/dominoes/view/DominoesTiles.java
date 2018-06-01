package com.dominoes.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dominoes.element.Circle;
import com.dominoes.element.ComplexElement;
import com.dominoes.element.Line;
import com.dominoes.element.Rectangle;

@SuppressWarnings("serial")
public class DominoesTiles extends JPanel {
	private JPanel northPanel;
	private JPanel westPanel;
	private JPanel centerPanel;
	private JPanel eastPanel;	
	private JPanel southPanel;
	private JTextArea text;
	
	private ComplexElement complexElement;

	/**
     * subirInterfax: Metodo que permite subir la ventana del sistema
     */
	public void init(){
		// Agregar paneles al frame
		setPreferredSize(new Dimension(1200,600));		
		
		setLayout(new BorderLayout());
		
		// Crear Paneles
		northPanel = new JPanel();
		westPanel = new JPanel();
		getCenterPanel();
		eastPanel = new JPanel();
		southPanel = new JPanel();

		// Agregar area de mensajes
		southPanel.add(addTextArea());
		// southPanel.setVisible(false);
		
		JScrollPane scroll = new JScrollPane(text);
		southPanel.add(scroll);
		
		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public JScrollPane addTextArea(){
		text = new JTextArea(3,146);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		//text.setEnabled(false);
		text.setDisabledTextColor(Color.BLACK);
		// text.setBackground(Color.CYAN.darker());
		text.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane scroll = new JScrollPane(text);
		return scroll;
	}
	
	public void getCenterPanel() {
		centerPanel = new Component();
		centerPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		Rectangle rectangle = new Rectangle(100.0,100.0, 250.0,250.0);
		List<Circle> circles = new ArrayList<Circle>();
		
		circles.add(new Circle(new Point(180, 180), 10.0));
		circles.add(new Circle(new Point(280, 180), 10.0));
		circles.add(new Circle(new Point(180, 280), 10.0));
		circles.add(new Circle(new Point(280, 280), 10.0));
		
		Line line = new Line(new Point(100, 100), new Point(350, 350));
		
		complexElement = new ComplexElement(rectangle, line, circles, Color.red, Color.gray, new BasicStroke(1f));
		
		complexElement.draw((Graphics2D)centerPanel.getGraphics());

		repaint();
				
	}
	
	/******************************************************************************/
	/*  Clase:  Component                                    				      */
	/*  Funcion: Clase interna para dibujar los elementos a procesar     		  */
	/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
	/******************************************************************************/
	class Component extends JPanel{
		/******************************************************************************/
		/*  Metodo:  paintComponent                                    				  */
		/*  Funcion: Metodo que permite pintar los elementos en la vista     		  */
		/*  OBJETOS: g: Componente grafico d ela vista 								  */
		/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
		/******************************************************************************/
		public void paintComponent(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;	
			super.paintComponent(g);
			complexElement.draw(g2D);
		}  
	}

	
	
}
