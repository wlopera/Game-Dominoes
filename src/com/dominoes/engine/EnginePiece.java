package com.dominoes.engine;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	private List<Piece> pieces;
	private Piece pieceTemp;
	private boolean firstPoint;

	private double scale;

	private EnginePieceUtil pieceUtil;

	public EnginePiece(Dimension dimension, Tablet tablet, String imagePointName, double scale) {
		this.setSize(dimension);
		this.tablet = tablet;
		this.scale = scale;

		getMouseController();
		pieceUtil = new EnginePieceUtil(imageBaseName, imagePointName);

		modalPanel = createModalPanel();
		modalPanel.setVisible(true);
		modalPanel.setLocationRelativeTo(null);

		modalPanel.setModal(true);
		pieces = new ArrayList<Piece>();
	}

	/******************************************************************************/
	/* Metodo: setPiece */
	/* Funcion: Generador de los puntos y base de la ficha */
	/*                                                                            */
	/* Fecha: Junio 2018 Realizado por: William Lopera */
	/******************************************************************************/
	public void setPiece(int top, int bottom, boolean vertical, double angle) {

		pieceTemp = new Piece();

		pieceTemp.setVertical(vertical);

		pieceTemp.setValueX(top);
		pieceTemp.setValueY(bottom);
		pieceTemp.setValueXY("" + top + bottom);

		pieceTemp.setAngle(angle-90);

		pieceTemp.setBasePiece(pieceUtil.getBasePiece());

		pieceTemp.setStartPoint(new Point((int) (pieceTemp.getBasePiece().getWidth() * (scale / 2)),
				(int) (pieceTemp.getBasePiece().getHeight() * (scale / 2))));

		switch (top) {
		case 1:
			pieceTemp.setImagesPointTop(pieceUtil.getPointOne());
			break;
		case 2:
			pieceTemp.setImagesPointTop(pieceUtil.getPointTwo());
			break;
		case 3:
			pieceTemp.setImagesPointTop(pieceUtil.getPointThree());
			break;
		case 4:
			pieceTemp.setImagesPointTop(pieceUtil.getPointFour());
			break;
		case 5:
			pieceTemp.setImagesPointTop(pieceUtil.getPointFive());
			break;
		case 6:
			pieceTemp.setImagesPointTop(pieceUtil.getPointSix());
			break;

		default:
			break;
		}

		switch (bottom) {
		case 1:
			pieceTemp.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointOne()));
			break;
		case 2:
			pieceTemp.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointTwo()));
			break;
		case 3:
			pieceTemp.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointThree()));
			break;
		case 4:
			pieceTemp.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointFour()));
			break;
		case 5:
			pieceTemp.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointFive()));
			break;
		case 6:
			pieceTemp.setImagesPointBotton(pieceUtil.setPointBottom(pieceUtil.getPointSix()));
			break;

		default:
			break;
		}

		firstPoint = true;
		repaint();
	}

	/******************************************************************************/
	/* Metodo: paintComponent */
	/* Funcion: Pintar elementos fence y fichas sobre la mesa */
	/*                                                                            */
	/* Fecha: Junio 2018 Realizado por: William Lopera */
	/******************************************************************************/
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.setBackground(new Color(0, 100, 0));

		Graphics2D g2D = (Graphics2D) g;
		AffineTransform old = g2D.getTransform(); // Save the current transform

		if (null != pieces) {
			for (Piece piece : pieces) {
				System.out.println("valor: " + piece.toString());
				paintPiece(g, piece);
			}
		}

		if (null != pieceTemp) {
			paintPiece(g, pieceTemp);
		}

		g2D.setTransform(old);
		g2D.rotate(Math.toRadians(0));

	}

	/******************************************************************************/
	/* Metodo: paintPiece */
	/* Funcion: Pintar la ficha sobre la mesa */
	/*                                                                            */
	/* Fecha: Junio 2018 Realizado por: William Lopera */
	/******************************************************************************/
	private void paintPiece(Graphics g, Piece piece) {
		Graphics2D g2D = (Graphics2D) g;

		AffineTransform at = new AffineTransform();
		at.translate(piece.getStartPoint().x - piece.getBasePiece().getWidth() * (scale / 2),
				piece.getStartPoint().y - piece.getBasePiece().getHeight() * (scale / 2));
		at.scale(scale, scale);

		g2D.setTransform(at);

		// if (!piece.getVertical()) {
		g2D.rotate(Math.toRadians(piece.getAngle()), piece.getBasePiece().getWidth() * (scale / 1),
				piece.getBasePiece().getHeight() * (scale / 1));
		// }

		tablet.setText("Pto start: " + piece.getStartPoint().toString(), false);

		g2D.drawImage(piece.getBasePiece().getImage(), 0, 0, piece.getBasePiece().getWidth(),
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
	}

	/******************************************************************************/
	/* Metodo: getMouseController */
	/* Funcion: Control de eventos del mouse sobre la vista */
	/*                                                                            */
	/* Fecha: Junio 2018 Realizado por: William Lopera */
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
	/* MouseEvent: e: Eventos del mouse */
	/* tipoEvento: Tipo de evento (CLICK-PRESS_MOVED...) */
	/* Fecha: Junio 2018 Realizado por: William Lopera */
	/******************************************************************************/
	public void clickMouse(MouseEvent e, int tipoEvento) {
		Point pto = e.getPoint();
		switch (tipoEvento) {
		case MOUSE_CLICK:
			if (null != pieceTemp) {
				tablet.setText("Click: " + pto.toString(), false);
				pieceTemp.setStartPoint(pto);
				pieces.add(pieceTemp);
				pieceTemp = null;
				firstPoint = false;
				repaint();
			}
			break;
		case MOUSE_RESET:
			tablet.setText("Reset: " + pto.toString(), false);
			pieceTemp = null;
			firstPoint = false;
			repaint();
			break;
		case MOUSE_MOVED:
			if (null != pieceTemp) {
				pieceTemp.setStartPoint(pto);
				repaint();
			}
			break;
		default:
			break;
		}

	}

	/******************************************************************************/
	/* Metodo: createModalPanel */
	/* Funcion: Ventana modal para asignar valores a la ficha a crear */
	/*                                                                            */
	/* Fecha: Junio 2018 Realizado por: William Lopera */
	/******************************************************************************/
	public JDialog createModalPanel() {
		final JDialog panel = new JDialog();

		JLabel lblFirstTop = new JLabel("Valor Superior");
		JLabel lblFirstBottom = new JLabel("Valor Inferior");
		JLabel lblVertical = new JLabel("Posicion Vertical ?");
		JLabel lblAngle = new JLabel("Angulo");

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

		final JCheckBox checkVertical = new JCheckBox("");

		final JComboBox<Integer> cmbAngle = new JComboBox<Integer>();

		cmbAngle.addItem(0);
		cmbAngle.addItem(90);
		cmbAngle.addItem(180);
		cmbAngle.addItem(270);

		JButton btnCancel = new JButton("Cancelar");
		JButton btnOK = new JButton("Ok");

		panel.setLayout(new GridLayout(5, 2));
		panel.add(lblFirstTop);
		panel.add(lblFirstBottom);
		panel.add(cmbTop);
		panel.add(cmbBottom);
		panel.add(lblVertical);
		panel.add(checkVertical);
		panel.add(lblAngle);
		panel.add(cmbAngle);
		panel.add(btnCancel);
		panel.add(btnOK);

		panel.setMinimumSize(new Dimension(300, 200));

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmbTop.setSelectedIndex(0);
				cmbBottom.setSelectedIndex(0);
				modalPanel.setVisible(false);
			}
		});

		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPiece(cmbTop.getSelectedIndex(), cmbBottom.getSelectedIndex(), checkVertical.isSelected(),
						Double.parseDouble(cmbAngle.getSelectedItem().toString()));
				cmbTop.setSelectedIndex(0);
				cmbBottom.setSelectedIndex(0);
				cmbAngle.setSelectedIndex(0);
				checkVertical.setSelected(false);
				modalPanel.setVisible(false);
			}
		});
		return panel;

	}

	public JDialog getModalPanel() {
		return modalPanel;
	}
}