package com.dominoes.component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.dominoes.motor.EnginePiece;
import com.dominoes.util.Constantes;

public class MouseControl extends MouseAdapter implements Constantes
{
	private EnginePiece piece;
	
	public MouseControl(EnginePiece piece){
		this.piece = piece;
	}
	
	public void mouseMoved(MouseEvent e) {
		piece.clickMouse(e, MOUSE_MOVED);
    }
	 
	public void mousePressed(MouseEvent e) {
		piece.clickMouse(e, MOUSE_CLICK);
    }
}
