package com.dominoes.motor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.dominoes.component.MouseControl;
import com.dominoes.domain.ImagePiece;
import com.dominoes.domain.Piece;
import com.dominoes.util.Constantes;
import com.dominoes.util.EnginePieceUtil;

@SuppressWarnings("serial")
public class EnginePiece extends javax.swing.JPanel implements Constantes {

	private JTextArea text;
	private EnginePieceUtil pieceUtil;
	private JDialog modalPanel;
	private Piece piece;

	public EnginePiece(Dimension dimension, JTextArea text) {
		this.setSize(dimension);
		this.text = text;
		getMouseController();
		pieceUtil = new EnginePieceUtil();
		modalPanel = getModalPanel();
		modalPanel.setVisible(true);
		modalPanel.setLocationRelativeTo(null);
	}

	public void setPiece(int top, int bottom) {
		
		piece = new Piece();

		piece.setBasePiece(pieceUtil.getBasePiece());

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

			g.drawImage(piece.getBasePiece().getImage(), 0, 0, piece.getBasePiece().getWidth(),
					piece.getBasePiece().getHeight(), null);

			if (null != piece.getImagesPointTop()) {
				for (ImagePiece point : piece.getImagesPointTop()) {
					g.drawImage(point.getImage(), point.getX(), point.getY(), point.getWidth(), point.getHeight(), null);
				}
			}
			if (null != piece.getImagesPointBotton()) {
				for (ImagePiece point : piece.getImagesPointBotton()) {
					g.drawImage(point.getImage(), point.getX(), point.getY(), point.getWidth(), point.getHeight(), null);
				}
			}
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
			text.setText(pto.toString());
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