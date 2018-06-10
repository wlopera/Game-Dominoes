/******************************************************************************/
/*  Clase:  Fence                                                             */
/*  Funcion: Imagen guia para ubicacion d elas fichas en la mesa    		  */
/*																			  */
/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
/******************************************************************************/
package com.dominoes.domain;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;

public class Fence implements Serializable{
	private static final long serialVersionUID = 8536337742642802474L;
	
	private Rectangle2D.Double rectangle;   // Fence guia
	private boolean visible;				// Mostrar o no
	private Color color;					// Color del fence
	private int side;						// Ladeo del fence (arriba/abajo/derecha/iquierda)
	
	public Fence() {}
	
	public Fence(Double rectangle, boolean visible, Color color, int side) {
		this.rectangle = rectangle;
		this.visible = visible;
		this.color = color;
		this.side = side;
	}
	
	public Rectangle2D.Double getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle2D.Double rectangle) {
		this.rectangle = rectangle;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Fence [rectangle=" + rectangle + ", visible=" + visible + ", color=" + color + ", side=" + side + "]";
	}
}
	
	