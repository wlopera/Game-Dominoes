package com.dominoes.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dominoes.element.ComplexElement;
import com.dominoes.engine.EnginePiece;
import com.dominoes.util.Constantes;

@SuppressWarnings("serial")
public class Tablet extends JPanel implements Constantes {
	private JPanel northPanel;
	private JPanel westPanel;
	private EnginePiece centerPanel;
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
		eastPanel = new JPanel();
		southPanel = new JPanel();

		// Agregar area de mensajes
		southPanel.add(addTextArea());
		// southPanel.setVisible(false);
		
		JScrollPane scroll = new JScrollPane(text);
		southPanel.add(scroll);
		
		// Agregar panel de la mesa
		getCenterPanel();

		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	public JScrollPane addTextArea(){
		text = new JTextArea(4,146);
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
		centerPanel = new EnginePiece(getSize(), this, imagePointNameScale, scale);
	}
	
	public void showPieceModal(boolean visible){
		centerPanel.getModalPanel().setVisible(true);
	}	
	
	public void setText(String text, boolean clear) {
		if(clear) {
			this.text.setText(text);
		} else {
			this.text.setText(this.text.getText() + "\n" + text);
		}
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
