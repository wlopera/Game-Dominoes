/******************************************************************************/
/*  Clase:   Line                                                			  */
/*  Funcion: Clase control de objetos  Line2D.Double						  */
/*  Fecha: 	 Junio           Realizado por: William Lopera          		  */
/******************************************************************************/
package com.dominoes.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import com.dominoes.util.Constantes;

public class Line extends GraphicElement implements Constantes {
	private Line2D.Double linea;
	private Point ptoInicial;
	private Point ptoFinal;

	public Line(Point ptoInicial, Point ptoFinal) {
		super(ELEMENT_LINE);
		this.ptoInicial = ptoInicial;
		this.ptoFinal = ptoFinal;
	}

	/******************************************************************************/
	/* Metodo: draw */
	/* Funcion: Dibujar la línea. */
	/* OBJETOS: g2D: Contexto gráfico */
	/* Fecha: Junio Realizado por: William Lopera */
	/******************************************************************************/
	public void draw(Graphics2D g2D, Color colorBorder, Color colorFilling, BasicStroke thickness) {
		// Se llama al método draw de la clase ElementoGrafico
		linea = new Line2D.Double(ptoInicial, ptoFinal);
		draw(g2D, linea, colorBorder, colorFilling, thickness);
	}

	public Point getPtoInicial() {
		return ptoInicial;
	}

	public void setPtoInicial(Point ptoInicial) {
		this.ptoInicial = ptoInicial;
	}

	public Point getPtoFinal() {
		return ptoFinal;
	}

	public void setPtoFinal(Point ptoFinal) {
		this.ptoFinal = ptoFinal;

	}

	@Override
	public String toString() {
		return " - Linea [linea=" + linea + ", ptoInicial=" + ptoInicial + ", ptoFinal=" + ptoFinal + "]";
	}

}
