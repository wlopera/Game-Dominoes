/******************************************************************************/
/*  Clase:   Circle                                                 		  */
/*  Funcion: Clase control de objetos  Ellipse2D.Double						  */
/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
/******************************************************************************/
package com.dominoes.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import com.dominoes.util.Constantes;

public class Circle extends GraphicElement implements Constantes {
	private Ellipse2D.Double circle;
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius){
		super(ELEMENT_CIRCLE);
		this.center = center;
		this.radius = radius;
	}
	
	/******************************************************************************/
	/*  Metodo:  draw                                                             */
	/*  Funcion: Dibujar un circulo.                                              */
	/*  OBJETOS: g2D: Contexto gráfico                                            */
	/*  Fecha: 	 Junio           Realizado por: William Lopera          		  */
	/******************************************************************************/
	public void draw(Graphics2D g2D, Color colorBorder, Color colorFilling, BasicStroke thickness) {
		// Se llama al método draw de la clase ElementoGrafico
		circle = new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
	    draw(g2D, circle, colorBorder, colorFilling, thickness);
	}

	public Ellipse2D.Double getCircle() {
		return circle;
	}

	public void setCircle(Ellipse2D.Double circle) {
		this.circle = circle;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "circle [circle=" + circle + ", center=" + center + ", radius=" + radius + "]";
	}
}
