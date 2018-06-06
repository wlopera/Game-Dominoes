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
		super.paintComponent(g);
		ImageIcon imagenBase = new ImageIcon("image/domino.jpg");
		g.drawImage(imagenBase.getImage(),450,100,imagenBase.getIconWidth(),imagenBase.getIconHeight(), null);
		
		setOpaque(false);
	
	}
}