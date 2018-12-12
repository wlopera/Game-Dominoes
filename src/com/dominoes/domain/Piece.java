/******************************************************************************/
/*  Clase:   Piece                                                            */
/*  Funcion: Ficha de domino 									    		  */
/*																			  */
/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
/******************************************************************************/
package com.dominoes.domain;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

public class Piece implements Serializable{
	
	private static final long serialVersionUID = -5473767365827837015L;
	
	private ImagePiece basePiece;				// Imagen base de la ficha de domino
	private List<ImagePiece> imagesPointTop;	// Imagenes puntos parte arriba de la ficha de domino 
	private List<ImagePiece> imagesPointBotton;	// Imagenes puntos parte abajo de la ficha de domino
	private Point startPoint;					// Posicion inicial de la ficha sobre la mesa - ficha del jugador
	private Point endPoint;						// POsicion final de la ficha sobre la mesa - ficha jugada
	private Boolean vertical;					// Posicion vertical/horizontal sobre la mesa
	private String valueXY;						// Valor de la ficha (ej: 66:doble seis)
	private int valueX;							// Valor de un lado de la ficha (ej: 6)
	private int valueY;							// Valor del otro lado de la ficha (ej: 6)
	private double angle;                       // Angulo de inclinacion d ela ficha
	
	public ImagePiece getBasePiece() {
		return basePiece;
	}

	public void setBasePiece(ImagePiece basePiece) {
		this.basePiece = basePiece;
	}

	public List<ImagePiece> getImagesPointTop() {
		return imagesPointTop;
	}

	public void setImagesPointTop(List<ImagePiece> imagesPointTop) {
		this.imagesPointTop = imagesPointTop;
	}

	public List<ImagePiece> getImagesPointBotton() {
		return imagesPointBotton;
	}

	public void setImagesPointBotton(List<ImagePiece> imagesPointBotton) {
		this.imagesPointBotton = imagesPointBotton;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Boolean getVertical() {
		return vertical;
	}

	public void setVertical(Boolean vertical) {
		this.vertical = vertical;
	}

	public String getValueXY() {
		return valueXY;
	}

	public void setValueXY(String valueXY) {
		this.valueXY = valueXY;
	}

	public int getValueX() {
		return valueX;
	}

	public void setValueX(int valueX) {
		this.valueX = valueX;
	}

	public int getValueY() {
		return valueY;
	}

	public void setValueY(int valueY) {
		this.valueY = valueY;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "Piece [basePiece=" + basePiece + ", imagesPointTop=" + imagesPointTop + ", imagesPointBotton="
				+ imagesPointBotton + ", startPoint=" + startPoint + ", endPoint=" + endPoint + ", vertical=" + vertical
				+ ", valueXY=" + valueXY + ", valueX=" + valueX + ", valueY=" + valueY + ", angle=" + angle + "]";
	}

}