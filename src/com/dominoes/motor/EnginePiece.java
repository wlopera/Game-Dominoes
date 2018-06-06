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
		piece.setImagesPoint(pieceUtil.getPointThreeTop());
		
		g.drawImage(piece.getBasePiece().getImage(), 
					0, 
					0, 
					piece.getBasePiece().getWidth(), 
					piece.getBasePiece().getHeight(), 
					null);
		for(ImagePiece point : piece.getImagesPoint()) {
			g.drawImage(point.getImage(), 
					point.getX(), 
					point.getY(), 
					point.getWidth(), 
					point.getHeight(), 
					null);
		}
		
		// ImageIcon imagenFicha = new ImageIcon("image/ficha.png");
		//
		// text.setText(""+imagenFicha.getIconHeight());
		//
		// g.drawImage(imagenFicha.getImage(),0,0,imagenFicha.getIconWidth(),imagenFicha.getIconHeight(),
		// null);
		//
		// g.drawImage(imagenFicha.getImage(),400,40,imagenFicha.getIconWidth()/2,imagenFicha.getIconHeight()/2,
		// null);
		//
		// ImageIcon imagenBase = new ImageIcon("image/base.png");
		// g.drawImage(imagenBase.getImage(),200,0,imagenBase.getIconWidth(),imagenBase.getIconHeight(),
		// null);
		//
		//
		//
		// ImageIcon imagenPoint = new ImageIcon("image/point.png");
		//
		// // Primer valor
		// g.drawImage(imagenPoint.getImage(),imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		// // segundo valor
		// g.drawImage(imagenPoint.getImage(),imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		// // tercer valor
		// g.drawImage(imagenPoint.getImage(),imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// g.drawImage(imagenPoint.getImage(),imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,imagenBase.getIconHeight()/4-10,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // Cuarto valor
		// g.drawImage(imagenPoint.getImage(),3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		// // quinto valor
		// g.drawImage(imagenPoint.getImage(),3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		// // sexto valor
		// g.drawImage(imagenPoint.getImage(),3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 4 -5 -6
		// g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 6
		// g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 6 - 5- 4- 3 - 2
		// g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 1 - 3
		// g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,imagenBase.getIconHeight()/4-10,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 6 - 5- 4- 3 - 2
		// g.drawImage(imagenPoint.getImage(),200+3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 6
		// g.drawImage(imagenPoint.getImage(),200+3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		// // 4 -5 -6
		// g.drawImage(imagenPoint.getImage(),200+3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(),
		// null);
		//
		//
		// //setOpaque(false);
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