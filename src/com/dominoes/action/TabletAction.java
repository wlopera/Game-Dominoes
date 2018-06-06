package com.dominoes.action;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com.dominoes.view.MainFrame;

@SuppressWarnings("serial")
public class TabletAction extends AbstractAction {
	MainFrame mainFrame;
	
	// Constructor
	public TabletAction(MainFrame mainFrame, String name, String tooltip, KeyStroke keystroke) {
		super(name);
		if(keystroke != null) {
			putValue(ACCELERATOR_KEY, keystroke);
		}
		this.mainFrame = mainFrame;		
	}
	
	/**
	 * Constructor por defecto
	 */
	public TabletAction(MainFrame mainFrame) {
		this(mainFrame, "Ficha de Domino", "Creador de fichas de domino", KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK));
	}
	
	// Manejador evento
	public void actionPerformed(ActionEvent e) {
		mainFrame.tablet();
	}
}
