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
	
	private ImageIcon imagenBase;
	private ImageIcon imagenPoint;
	
	public EnginePieceUtil(String imageBaseName, String imagePointName) {
		imagenBase = new ImageIcon(imageBaseName);
		imagenPoint = new ImageIcon(imagePointName);
	}

	/******************************************************************************/
	/*  Metodo:  getBasePiece                                                     */
	/*  Funcion: Genera la ficha base de la pieza de domino                       */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public ImagePiece getBasePiece() {		
		return new ImagePiece(imagenBase.getImage(), 0, 0, imagenBase.getIconWidth(), imagenBase.getIconHeight(), null);
	}

	/******************************************************************************/
	/*  Metodo:  getPointOne                                                      */
	/*  Funcion: Genera punto uno de la parte superior de la ficha                */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointOne() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();		
		points.add(getPoint_1_3_5());
		return points;
	}

	/******************************************************************************/
	/*  Metodo:  getPointTwo                                                      */
	/*  Funcion: Genera los puntos dos de la parte superior de la ficha           */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointTwo() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		points.add(getPoint_2_3_4_5_6_First());
		points.add(getPoint_2_3_4_5_6_Second());
		return points;
	}

	/******************************************************************************/
	/*  Metodo:  getPointThree                                                    */
	/*  Funcion: Genera los puntos tres de la parte superior de la ficha          */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointThree() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		points.add(getPoint_1_3_5());
		points.add(getPoint_2_3_4_5_6_First());
		points.add(getPoint_2_3_4_5_6_Second());
		return points;
	}
	
	/******************************************************************************/
	/*  Metodo:  getPointFour                                                     */
	/*  Funcion: Genera los puntos cuatro de la parte superior de la ficha        */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointFour() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		points.add(getPoint_2_3_4_5_6_First());
		points.add(getPoint_2_3_4_5_6_Second());
		points.add(getPoint_4_5_6_First());
		points.add(getPoint_4_5_6_Second());
		return points;
	}

	/******************************************************************************/
	/*  Metodo:  getPointFive                                                     */
	/*  Funcion: Genera los puntos cinco de la parte superior de la ficha         */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointFive() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		points.add(getPoint_1_3_5());
		points.add(getPoint_2_3_4_5_6_First());
		points.add(getPoint_2_3_4_5_6_Second());
		points.add(getPoint_4_5_6_First());
		points.add(getPoint_4_5_6_Second());
		return points;
	}

	/******************************************************************************/
	/*  Metodo:  getPointSix                                                      */
	/*  Funcion: Genera los puntos seis de la parte superior de la ficha          */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> getPointSix() {
		List<ImagePiece> points = new ArrayList<ImagePiece>();
		points.add(getPoint_2_3_4_5_6_First());
		points.add(getPoint_2_3_4_5_6_Second());
		points.add(getPoint_4_5_6_First());
		points.add(getPoint_4_5_6_Second());
		points.add(getPoint_6_First());
		points.add(getPoint_6_Second());
		return points;
	}
	
	/******************************************************************************/
	/*  Metodo:  setPointBottom                                                   */
	/*  Funcion: Asigna los puntos enviados a la parte inferior de la ficha       */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	public List<ImagePiece> setPointBottom(List<ImagePiece> points) {
		List<ImagePiece> newPoints = points;
		for (ImagePiece point : newPoints) {
			point.setY(point.getY() + 4*imagenBase.getIconHeight()/8-10);
		}
		return newPoints;
	}

	/******************************************************************************/
	/*  Metodo:  getPoint_1_3_5                                                   */
	/*  Funcion: Permite crear puntos 1, 3 y 5                                    */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_1_3_5() {		
		return new ImagePiece(	
				imagenPoint.getImage(),
				imagenBase.getIconWidth()/2-imagenPoint.getIconWidth()/2-6,
				imagenBase.getIconHeight()/4-10,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(), 
				null);
	}

	/******************************************************************************/
	/*  Metodo:  getPoint_2_3_4_5_6_First                                         */
	/*  Funcion: Permite crear uno de los puntos 2,3,4,5 y 6                      */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_2_3_4_5_6_First() {
		return new ImagePiece(
				imagenPoint.getImage(),
				imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,
				3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(), 
				null);
	}

	/******************************************************************************/
	/*  Metodo:  getPoint_2_3_4_5_6_Second                                        */
	/*  Funcion: Permite crear otro de los puntos 2,3,4,5 y 6                     */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_2_3_4_5_6_Second() {
		return new ImagePiece(
				imagenPoint.getImage(),
				3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,
				imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(), 
				null);
	}

	/******************************************************************************/
	/*  Metodo:  getPoint_4_5_6_First                                             */
	/*  Funcion: Permite crear uno de los puntos 4,5 y 6                          */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_4_5_6_First() {
		return new ImagePiece(
				imagenPoint.getImage(),
				imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,
				imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(),
				null);
	}

	/******************************************************************************/
	/*  Metodo:  getPoint_4_5_6_Second                                            */
	/*  Funcion: Permite crear otro de los puntos 4,5 y 6                         */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_4_5_6_Second() {
		return new ImagePiece(
				imagenPoint.getImage(),
				3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,
				3*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+6,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(),
				null);
	}


	/******************************************************************************/
	/*  Metodo:  getPoint_6_First                                                 */
	/*  Funcion: Permite crear uno de los puntos 6                                */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_6_First() {
		return new ImagePiece(
				imagenPoint.getImage(),
				imagenBase.getIconWidth()/4-3*imagenPoint.getIconWidth()/4,
				2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(),
				null);
	}

	/******************************************************************************/
	/*  Metodo:  getPoint_6_Second                                                */
	/*  Funcion: Permite crear otro de los puntos 6                               */
	/*																			  */
	/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
	/******************************************************************************/
	private ImagePiece getPoint_6_Second() {
		return new ImagePiece(
				imagenPoint.getImage(),
				3*imagenBase.getIconWidth()/4+2-3*imagenPoint.getIconWidth()/4,
				2*imagenBase.getIconHeight()/8-imagenPoint.getIconHeight()/2+4,
				imagenPoint.getIconWidth(),
				imagenPoint.getIconHeight(),
				null);
	}
}