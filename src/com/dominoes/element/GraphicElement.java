/******************************************************************************/
/*  Clase:   ElementoGrafico                                                  */
/*  Funcion: Clase de control de tipos de elementos a dubujar en la vista     */
/*  Fecha:   Agosto          Realizado por: William Lopera          		  */
/******************************************************************************/
package com.dominoes.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

import com.dominoes.util.Constantes;

public abstract class GraphicElement implements Constantes {
	private int tipoElemento = -1;
	
	// Constructor
	public GraphicElement(int tipoElemento){
		this.tipoElemento = tipoElemento;
	}
	
	/******************************************************************************/
	/*  Metodo:  draw                                                             */
	/*  Funcion: Declaración del método draw que se implementa en cada elemento.  */
	/*  OBJETOS: g2D: Contexto gráfico. 										  */
	/*           view: Vista sobre la que se dibujan los elementos graficos       */
	/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
	/******************************************************************************/
	public abstract void draw(Graphics2D g2D, Color colorBorder, Color colorFilling, BasicStroke thickness);

	public int getTipoElemento() {
		return tipoElemento;
	}

	public void setTipoElemento(int tipoElemento) {
		this.tipoElemento = tipoElemento;
	}


	/******************************************************************************/
	/*  Método:  draw                                                             */
	/*  Función: Dibujar el elemento indicado.                                    */
	/*  OBJETOS: g2D: Contexto gráfico.                                           */
	/*           element: Elemento a ser dibujado.                                */
	/*           view: Vista sobre la que se dibujan los elementos graficos       */
	/*  Fecha: 	 Agosto          Realizado por: William Lopera          		  */
	/******************************************************************************/
	  protected void draw(Graphics2D g2D, Shape element, Color colorBorder, Color colorFilling, BasicStroke thickness) {
	    if(g2D != null) {
	    	Stroke stroke = g2D.getStroke();
	    	Color colorPaint = g2D.getBackground();
	    	if (colorBorder != null)
	    	{
	    		colorPaint = colorBorder;
	    	}
	    	if (thickness != null){
	    		g2D.setStroke(thickness);
	    	}
	    	
	    	g2D.setColor(colorPaint);
		    g2D.draw(element);
	    	if (colorFilling != null)
	    	{
	    		g2D.setColor(colorFilling);
			    g2D.fill(element);
	    	}
	    	g2D.setColor(g2D.getBackground());
	    	g2D.setStroke(stroke);
	    }
	  }
}
