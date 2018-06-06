/******************************************************************************/
/*  Clase:  ImagePiece                                                        */
/*  Funcion: Imagen componente de una ficha de domino base/punto    		  */
/*																			  */
/*  Fecha: 	 Junio 2018          Realizado por: William Lopera          	  */
/******************************************************************************/
package com.dominoes.domain;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.Serializable;

public class ImagePiece implements Serializable{
	
	private static final long serialVersionUID = 7420515400110414509L;
	
	private Image image;   				// Imagen domino (base/punto)
	private int x;						// Posicion x
	private int y;						// POsicion y
    private int width;					// Ancho
    private int height;					// Alto
    private ImageObserver observer;		// Observer para actualizar la imagen
    
    public ImagePiece() {}
    
	public ImagePiece(Image image, int x, int y, int width, int height, ImageObserver observer) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.observer = observer;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ImageObserver getObserver() {
		return observer;
	}

	public void setObserver(ImageObserver observer) {
		this.observer = observer;
	}

	@Override
	public String toString() {
		return "ImagenPoint [image=" + image + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height
				+ ", observer=" + observer + "]";
	}
}
