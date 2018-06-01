package com.dominoes.component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.dominoes.action.DominoesTilesAction;
import com.dominoes.action.SalirAction;
import com.dominoes.view.MainFrame;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	private JMenu menu;	
	
	// Constructor
	public Menu(String titulo, MainFrame marcoPrincipal){
		menu = new JMenu(titulo);
		dominoesTilesAction(marcoPrincipal);
		salirAction(marcoPrincipal);
	}
	
	/**
	 * xmltoExcelAction: Agregar la opcion Abrir XML
	 */
	private void dominoesTilesAction(MainFrame marcoPrincipal){
		menu.add(new JMenuItem(new DominoesTilesAction(marcoPrincipal)));
		menu.setMnemonic('D'); // Create shortcut
		add(menu); // Add the file menu				
	}
	
	/**
	 * agregarAbrirAction: Agregar la opcion Salir del Programa Principal
	 */
	private void salirAction(MainFrame marcoPrincipal){
		menu.add(new JMenuItem(new SalirAction(marcoPrincipal)));
		menu.setMnemonic('S'); // Create shortcut
		add(menu); // Add the file menu				
	}
}
