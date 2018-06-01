package com.dominoes.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.dominoes.component.Menu;
import com.dominoes.component.PanelImagen;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private Menu menuBar;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame marcoPrincipal = new MainFrame();
		marcoPrincipal.subirInterfax();
	}

	/**
     * subirInterfax: Metodo que permite subir la ventana del sistema
     */
	public void subirInterfax(){
		setTitle("DOMINO - WLOPERA");
		
		// Agregar paneles al frame
		setPreferredSize(new Dimension(1200,600));		
		
		PanelImagen p = new PanelImagen(getSize());
		setContentPane(p);
		
		setLayout(new BorderLayout());
		
		// Agregar Menu
		menuBar = new Menu("Juego", this);
		setJMenuBar(menuBar);
		
		setVisible(true);
	    pack();
	    setLocationRelativeTo(null);	   
	    
	    ImageIcon img = new ImageIcon("image/icono.png");
	    
	    setIconImage(img.getImage());
	    // setResizable(false);
	    
	    setDefaultLookAndFeelDecorated(true);
	    try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			
		} catch (Exception e) {
			System.out.println("Pantalla - Error: "+ e.getMessage());
		}
	    
	    
		// Add a Window closing listener to controlar cerrar vista
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
            	bajarInterfaz();
            }        	
        });
	}
	
	public void dominoesTiles(){
		// Instanciar el objeto MlToExcel
		DominoesTiles dominoesTiles = new DominoesTiles();
				
		dominoesTiles.init();
		// getContentPane().removeAll();
		setContentPane(dominoesTiles);
	    pack();
	}
	
	/**
     * bajarInterfaz:  Metodo que permite cerrar la ventana y el programa
     */
	public void bajarInterfaz()
	{
		this.dispose();
		System.exit(0); 
	}
}
