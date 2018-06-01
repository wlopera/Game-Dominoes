package com.dominoes.action;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com.dominoes.view.MainFrame;

@SuppressWarnings("serial")
public class DominoesTilesAction extends AbstractAction {
	MainFrame marcoPrincipal;
	
	// Constructor
	public DominoesTilesAction(MainFrame marcoPrincipal, String name, String tooltip, KeyStroke keystroke) {
		super(name);
		if(keystroke != null) {
			putValue(ACCELERATOR_KEY, keystroke);
		}
		this.marcoPrincipal = marcoPrincipal;		
	}
	
	/**
	 * Constructor por defecto
	 */
	public DominoesTilesAction(MainFrame marcoPrincipal) {
		this(marcoPrincipal, "Ficha de Domino", "Creador de fichas de domino", KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK));
	}
	
	// Manejador evento
	public void actionPerformed(ActionEvent e) {
		marcoPrincipal.dominoesTiles();
	}
}
