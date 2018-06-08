package com.dominoes.motor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.dominoes.component.MouseControl;
import com.dominoes.domain.ImagePiece;
import com.dominoes.domain.Piece;
import com.dominoes.util.Constantes;
import com.dominoes.util.EnginePieceUtil;
import com.dominoes.view.Tablet;

@SuppressWarnings("serial")
public class EnginePiece extends javax.swing.JPanel implements Constantes {

	private Tablet tablet;
	private JDialog modalPanel;
	private Piece piece;
	private double scale;

	private EnginePieceUtil pieceUtil;
	
	
	public EnginePiece(Dimension dimension, Tablet tablet, String imagePointName, double scale) {
		this.setSize(dimension);
		this.tablet = tablet;
		this.scale = scale;
		
		getMouseController();
		pieceUtil = new EnginePieceUtil(imageBaseName, imagePointName);
		
		modalPanel = getModalPanel();
		modalPanel.setVisible(true);
		modalPanel.setLocationRelativeTo(null);
	}

	public void setPiece(int top, int bottom) {
		
		piece = new Piece();

		piece.setBasePiece(pieceUtil.getBasePiece());
		
		piece.setStartPoint(new Point((int)(piece.getBasePiece().getWidth()*(scale/2)),(int)(piece.getBasePiece().getHeight()*(scale/2))));
		
		
		switch (top) {
		case 1:
			piece.setImagesPointTop(pieceUtil.getPointOne());
			break;
		case 2:
			piece.setImagesPointTop(pieceUtil.getPointTwo());
			break;
		case 3:
			piece.setImagesPointTop(pieceUtil.getPointThree());
			break;
		case 4:
			piece.setImagesPointTop(pieceUtil.getPointFour());
			break;
		case 5:
			piece.setImagesPointTop(pieceUtil.getPointFive());
			break;
		case 6:
			piece.setImagesPointTop(pieceUtil.getPointSix());
			break;

		default:
			break;
		}

		switch (bottom) {
		case 1:
			piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointOne()));
			break;
		case 2:
			piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointTwo()));
			break;
		case 3:
			piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointThree()));
			break;
		case 4:
			piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointFour()));
			break;
		case 5:
			piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointFive()));
			break;
		case 6:
			piece.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointSix()));
			break;

		default:
			break;
		}

		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0, 100, 0));
		
		if (null != piece) {
			
			Graphics2D g2D = (Graphics2D)g;			
			AffineTransform old = g2D.getTransform(); // Save the current transform
			
			AffineTransform at = new AffineTransform();
			at.translate(piece.getStartPoint().x - piece.getBasePiece().getWidth()*(scale/2), piece.getStartPoint().y -piece.getBasePiece().getHeight()*(scale/2));
			at.scale(scale, scale);
			g2D.setTransform(at);
			
			tablet.setText("Pto start: " + piece.getStartPoint().toString(), false);

			g2D.drawImage(piece.getBasePiece().getImage(), 0,0, piece.getBasePiece().getWidth(),
					piece.getBasePiece().getHeight(), null);

			if (null != piece.getImagesPointTop()) {
				for (ImagePiece point : piece.getImagesPointTop()) {
					g2D.drawImage(point.getImage(), point.getX(), point.getY(), point.getWidth(), point.getHeight(), null);
				}
			}
			if (null != piece.getImagesPointBotton()) {
				for (ImagePiece point : piece.getImagesPointBotton()) {
					g2D.drawImage(point.getImage(), point.getX(), point.getY(), point.getWidth(), point.getHeight(), null);
				}
			}
			g2D.setTransform(old);
		}
	}

	/******************************************************************************/
	/* Metodo: crearScrollPanel */
	/* Funcion:Genera el control scroll Panel asociado a control del mouse. */
	/* Para size scroll */
	/* Fecha: Agosto Realizado por: William Lopera */
	/******************************************************************************/
	private void getMouseController() {
		// Asociar el manejo del mouse al scroll
		MouseControl mouse = new MouseControl(this);
		this.addMouseMotionListener(mouse);
		this.addMouseListener(mouse);
	}

	/******************************************************************************/
	/* Metodo: clickMouse */
	/* Funcion: Control de eventos del mouse sobre la vista */
	/* OBJETOS: e: Eventos del mouse */
	/* tipoEvento: Tipo de evento (CLICK-PRESS_MOVED...) */
	/* Fecha: Agosto Realizado por: William Lopera */
	/******************************************************************************/
	public void clickMouse(MouseEvent e, int tipoEvento) {
		Point pto = e.getPoint();
		switch (tipoEvento) {
		case MOUSE_CLICK:
			tablet.setText("Click: " + pto.toString(), false);
			//piece.setStartPoint(new Point(pto.x - piece.getBasePiece().getWidth()/2, pto.y -piece.getBasePiece().getHeight()/2));
			 piece.setStartPoint(pto);
			repaint();
			break;
		case MOUSE_MOVED:
			// System.out.println(pto);
			break;
		default:
			break;
		}
	}

	/******************************************************************************/
	/* Metodo: clickMouse */
	/* Funcion: Control de eventos del mouse sobre la vista */
	/* OBJETOS: e: Eventos del mouse */
	/* tipoEvento: Tipo de evento (CLICK-PRESS_MOVED...) */
	/* Fecha: Agosto Realizado por: William Lopera */
	/******************************************************************************/
	public JDialog getModalPanel() {
		final JDialog panel = new JDialog();

		JLabel lblFirstTop = new JLabel("Valor Superior");
		JLabel lblFirstBottom = new JLabel("Valor Inferior");
		
		final JComboBox<Integer> cmbTop = new JComboBox<Integer>();
		 
		cmbTop.addItem(0);
		cmbTop.addItem(1);
		cmbTop.addItem(2);
		cmbTop.addItem(3);
		cmbTop.addItem(4);
		cmbTop.addItem(5);
		cmbTop.addItem(6);
		
		final JComboBox<Integer> cmbBottom = new JComboBox<Integer>();
		 
		cmbBottom.addItem(0);
		cmbBottom.addItem(1);
		cmbBottom.addItem(2);
		cmbBottom.addItem(3);
		cmbBottom.addItem(4);
		cmbBottom.addItem(5);
		cmbBottom.addItem(6);
				
		JButton btnCancel = new JButton("Cancelar");
		JButton btnOK = new JButton("Ok");
		panel.setLayout(new GridLayout(3, 2));
		panel.add(lblFirstTop);
		panel.add(lblFirstBottom);
		panel.add(cmbTop);
		panel.add(cmbBottom);
		panel.add(btnCancel);
		panel.add(btnOK);

		panel.setMinimumSize(new Dimension(200, 100));

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.dispose();
			}
		});

		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPiece(cmbTop.getSelectedIndex(),cmbBottom.getSelectedIndex());
				//panel.dispose();
			}
		});
		return panel;

	}
}