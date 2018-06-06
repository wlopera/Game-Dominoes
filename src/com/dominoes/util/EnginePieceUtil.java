/******************************************************************************/
/*  Clase:   EnginePieceUtil                                                  */
/*  Funcion: Permite general las imagens de los puntos de las ficha  		  */
/*																			  */
/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
/******************************************************************************/
package com.dominoes.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.dominoes.domain.ImagePiece;

public class EnginePieceUtil  {

	/******************************************************************************/
	/*  Metodo:  getBasePiece                                                     */
	/*  Funcion: Genera la ficha base de la pieza de domino                       */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public ImagePiece getBasePiece() {		
		ImageIcon imagenBase = new ImageIcon("image/base.png");		
		return new ImagePiece(imagenBase.getImage(), 0, 0, imagenBase.getIconWidth(), imagenBase.getIconHeight(), null);
	}

	/******************************************************************************/
	/*  Metodo:  getPointOneTop                                                   */
	/*  Funcion: Genera punto uno de la parte superior de la ficha                */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointOneTop() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		
		ImageIcon imagenBase = new ImageIcon("image/base.png");
		ImageIcon imagenPoint = new ImageIcon("image/point.png");
		
		points.add(new ImagePiece(	
					imagenPoint.getImage(),
					imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,
					imagenBase.getIconHeight()/4-10,
					imagenPoint.getIconWidth(),
					imagenPoint.getIconHeight(), 
					null));
		
		return points;
	}

	/******************************************************************************/
	/*  Metodo:  getPointTwoTop                                                   */
	/*  Funcion: Genera los puntos dos de la parte superior de la ficha           */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointTwoTop() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		ImageIcon imagenBase = new ImageIcon("image/base.png");
		ImageIcon imagenPoint = new ImageIcon("image/point.png");

		points.add(new ImagePiece(
					imagenPoint.getImage(),
					imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,
					3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,
					imagenPoint.getIconWidth(),
					imagenPoint.getIconHeight(), 
					null));

		points.add(new ImagePiece(
					imagenPoint.getImage(),
					3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,
					imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,
					imagenPoint.getIconWidth(),
					imagenPoint.getIconHeight(), 
					null));

		return points;
	}

	/******************************************************************************/
	/*  Metodo:  getPointThreeTop                                                 */
	/*  Funcion: Genera los puntos tres de la parte superior de la ficha          */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointThreeTop() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		ImageIcon imagenBase = new ImageIcon("image/base.png");
		ImageIcon imagenPoint = new ImageIcon("image/point.png");

		points.add(new ImagePiece(
					imagenPoint.getImage(),
					imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,
					3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,
					imagenPoint.getIconWidth(),
					imagenPoint.getIconHeight(),
					null));

		points.add(new ImagePiece(
					imagenPoint.getImage(),
					imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,
					imagenBase.getIconHeight()/4-10,
					imagenPoint.getIconWidth(),
					imagenPoint.getIconHeight(),		
					null));

		points.add(new ImagePiece(
					imagenPoint.getImage(),
					3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,
					imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,
					imagenPoint.getIconWidth(),
					imagenPoint.getIconHeight(),
					null));

		return points;
	}
	
	private ImagePiece getPoint_1() {
		ImageIcon imagenBase = new ImageIcon("image/base.png");
		ImageIcon imagenPoint = new ImageIcon("image/point.png");
		
		return new ImagePiece(	
				imagenPoint.getImage(),
				imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,
				imagenBase.getIconHeight()/4-10,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(), 
				null);
	}
	
//	public ImagePiece getOnePointBotton() {
//		return null;
//	}
//	
//	@Override
//	public void paintComponent (Graphics g){
//		super.paintComponent(g);
//		this.setBackground(new Color(0,100,0));
//				
//		// 4 -5 -6
//		g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);
//		
//		// 6
//		g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);
//		
//		// 6 - 5-  4- 3 - 2
//		g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);
//
//		// 1 - 3
//		g.drawImage(imagenPoint.getImage(),200+imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,imagenBase.getIconHeight()/4-10,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);
//		
//		// 6 - 5-  4- 3 - 2
//		g.drawImage(imagenPoint.getImage(),200+3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);
//		
//		// 6
//		g.drawImage(imagenPoint.getImage(),200+3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);		
//		
//		// 4 -5 -6
//		g.drawImage(imagenPoint.getImage(),200+3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,imagenPoint.getIconWidth(),imagenPoint.getIconHeight(), null);
//
//		
//		 //setOpaque(false);	
//	}
	

}