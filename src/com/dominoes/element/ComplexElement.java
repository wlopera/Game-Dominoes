package com.dominoes.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

public class ComplexElement {
	private Rectangle rectangle;
	private Line line;
	private List<Circle> circles;
	private Color colorBorder; 
	private Color colorFilling;
	private BasicStroke thickness;
	
	public ComplexElement(Rectangle rectangle, 
		      			  Line line,
		      			  List<Circle> circles, 
		      			  Color colorBorder, 
					      Color colorFilling,
					      BasicStroke thickness){
		
		this.rectangle = rectangle;
		this.line = line;
		this.circles = circles;
		this.colorBorder = colorBorder;
		this.colorFilling = colorFilling;
		this.thickness = thickness;
	}
	
	
	/******************************************************************************/
	/*  Metodo:  draw                                                             */
	/*  Funcion: Dibujar elemento complejo: Un texto y su bound (rectangulo).     */
	/*  OBJETOS: g2D: Contexto gráfico                                            */
	/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
	/******************************************************************************/
	public void draw(Graphics2D g2D) {
		rectangle.draw(g2D, colorBorder, colorFilling, thickness);
		line.draw(g2D, colorBorder, colorFilling, thickness);
		for(Circle circle : circles) {
			circle.draw(g2D, colorBorder, colorFilling, thickness);
		}
	}


	public Rectangle getRectangle() {
		return rectangle;
	}


	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}


	public Line getLine() {
		return line;
	}


	public void setLine(Line line) {
		this.line = line;
	}


	public List<Circle> getCircles() {
		return circles;
	}


	public void setCircles(List<Circle> circles) {
		this.circles = circles;
	}


	@Override
	public String toString() {
		return "ElementoComplejo [rectangle=" + rectangle + ", line=" + line + ", circles=" + circles + "]";
	}

}
