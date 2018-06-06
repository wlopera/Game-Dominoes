package com.dominoes.component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.dominoes.action.TabletAction;
import com.dominoes.action.SalirAction;
import com.dominoes.view.MainFrame;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	private JMenu menu;	
	
	// Constructor
	public Menu(String titulo, MainFrame marcoPrincipal){
		menu = new JMenu(titulo);
		tabletAction(marcoPrincipal);
		salirAction(marcoPrincipal);
	}
	
	/**
	 * tabletAction: Tablero de domino (mesa)
	 */
	private void tabletAction(MainFrame mainFrame){
		menu.add(new JMenuItem(new TabletAction(mainFrame)));
		menu.setMnemonic('D'); // Create shortcut
		add(menu); // Add the file menu				
	}
	
	/**
	 * agregarAbrirAction: Agregar la opcion Salir del Programa Principal
	 */
	private void salirAction(MainFrame mainFrame){
		menu.add(new JMenuItem(new SalirAction(mainFrame)));
		menu.setMnemonic('S'); // Create shortcut
		add(menu); // Add the file menu				
	}
}
