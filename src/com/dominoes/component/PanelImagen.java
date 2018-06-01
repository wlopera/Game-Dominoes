package com.dominoes.component;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PanelImagen extends javax.swing.JPanel {
	public PanelImagen(Dimension dimension){
		this.setSize(dimension);
	}
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon("image/domino.jpg");
		g.drawImage(imagenFondo.getImage(),280,100,tamanio.width/2, tamanio.height/2, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}