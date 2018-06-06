package com.dominoes.motor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

import com.dominoes.component.MouseControl;
import com.dominoes.domain.ImagePiece;
import com.dominoes.domain.Piece;
import com.dominoes.util.Constantes;
import com.dominoes.util.EnginePieceUtil;

@SuppressWarnings("serial")
public class EnginePiece extends javax.swing.JPanel implements Constantes {
	private JTextArea text;
	private EnginePieceUtil pieceUtil;
	
	public EnginePiece(Dimension dimension, JTextArea text){
		this.setSize(dimension);
		this.text = text;
		getMouseController();
		pieceUtil = new EnginePieceUtil();
	}
	
	@Override
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		this.setBackground(new Color(0,100,0));
		
		Piece piece = new Piece();
		
		piece.setBasePiece(pieceUtil.getBasePiece());
		
		piece.setImagesPointTop(pieceUtil.getPointSix());
		piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointSix()));
		
		g.drawImage(piece.getBasePiece().getImage(), 
					0, 
					0, 
					piece.getBasePiece().getWidth(), 
					piece.getBasePiece().getHeight(), 
					null);
		for(ImagePiece point : piece.getImagesPointTop()) {
			g.drawImage(point.getImage(), 
					point.getX(), 
					point.getY(), 
					point.getWidth(), 
					point.getHeight(), 
					null);
		}
		for(ImagePiece point : piece.getImagesPointBotton()) {
			g.drawImage(point.getImage(), 
					point.getX(), 
					point.getY(), 
					point.getWidth(), 
					point.getHeight(), 
					null);
		}
	}
	
	/******************************************************************************/
	/*  Metodo:  crearScrollPanel                                                 */
	/*  Funcion:Genera el control scroll Panel asociado a control del mouse.      */
	/*			 Para size scroll  					  							  */
	/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
	/******************************************************************************/
	private void getMouseController(){
		// Asociar el manejo del mouse al scroll
		MouseControl mouse  = new MouseControl(this);
		this.addMouseMotionListener(mouse);
		this.addMouseListener(mouse);		
	}

	
	/******************************************************************************/
	/*  Metodo:  clickMouse                                                       */
	/*  Funcion: Control de eventos del mouse sobre la vista  					  */
	/*  OBJETOS: e: Eventos del mouse 											  */
	/*           tipoEvento: Tipo de evento (CLICK-PRESS_MOVED...)     			  */
	/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
	/******************************************************************************/
	public void clickMouse(MouseEvent e, int tipoEvento){
		Point pto = e.getPoint();
		switch (tipoEvento) {
		case MOUSE_CLICK:
			text.setText(pto.toString());
			break;
		case MOUSE_MOVED:
			// System.out.println(pto);
			break;
		default:
			break;
		}
	}

}