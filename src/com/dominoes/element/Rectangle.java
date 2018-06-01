/******************************************************************************/
/*  Clase:   Rectangule                                                		  */
/*  Funcion: Clase control de objetos  rectangule   						  */
/*  Fecha: 	 Junio           Realizado por: William Lopera          		  */
/******************************************************************************/
package com.dominoes.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.dominoes.util.Constantes;

public class Rectangle extends GraphicElement implements Constantes {
	private Rectangle2D.Double rectangle;
	private double x;
	private double y;
	private double width;
	private double height;
	
	public Rectangle(double x, double y, double width, double height){
		super(ELEMENTO_RECTANGLE);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/******************************************************************************/
	/*  Metodo:  draw                                                             */
	/*  Funcion: Dibujar un rectangulo.                                           */
	/*  OBJETOS: g2D: Contexto gráfico                                            */
	/*  Fecha: 	 Junio           Realizado por: William Lopera          		  */
	/******************************************************************************/
	public void draw(Graphics2D g2D, Color colorBorder, Color colorFilling, BasicStroke thickness) {
		// Se llama al método draw de la clase ElementoGrafico
		rectangle = new Rectangle2D.Double(x, y, width, height);
	    draw(g2D, rectangle, colorBorder, colorFilling, thickness);
	}

	public Rectangle2D.Double getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle2D.Double rectangle) {
		this.rectangle = rectangle;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangule [rectangle=" + rectangle + ", x=" + x + ", y=" + y + ", width=" + width + ", height="
				+ height + "]";
	}

}
