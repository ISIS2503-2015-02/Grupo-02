package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagLayout;

import javax.swing.JTabbedPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import Mundo.PrincipalMundo;
import Mundo.Vcub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField longitudT;
	private JTextField latitudT;
	private JButton btnDevolver;
	private JButton btnActualizar;
	private JButton btnAlquilar;
	private JButton btnActualizarLista;
	private JList list_2;
	private JList list_1;
	private JList list;
	private JTextField textField;
	private JButton btnIniciar;
	
	private PrincipalMundo pm;
	private JTextField idDondeDevolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{213, 211, 198, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDisponibles = new JLabel("Disponibles");
		GridBagConstraints gbc_lblDisponibles = new GridBagConstraints();
		gbc_lblDisponibles.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibles.gridx = 0;
		gbc_lblDisponibles.gridy = 0;
		panel.add(lblDisponibles, gbc_lblDisponibles);
		
		JLabel lblOcupados = new JLabel("Ocupados");
		GridBagConstraints gbc_lblOcupados = new GridBagConstraints();
		gbc_lblOcupados.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcupados.gridx = 1;
		gbc_lblOcupados.gridy = 0;
		panel.add(lblOcupados, gbc_lblOcupados);
		
		JLabel lblNoDisponibles = new JLabel("No Disponibles");
		GridBagConstraints gbc_lblNoDisponibles = new GridBagConstraints();
		gbc_lblNoDisponibles.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoDisponibles.gridx = 2;
		gbc_lblNoDisponibles.gridy = 0;
		panel.add(lblNoDisponibles, gbc_lblNoDisponibles);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		panel.add(scrollPane_2, gbc_scrollPane_2);
		
		list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		list_2 = new JList();
		scrollPane_1.setViewportView(list_2);
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					int esta = Integer.parseInt(idDondeDevolver.getText());
					Vcub ocu = (Vcub) list_1.getSelectedValue();
					pm.devolverVcub(ocu.getId(), esta);
					pm.actualizarListas();
					list.setListData(pm.getVcubesDisponibles().toArray());
					list_1.setListData(pm.getVcubesOcupados().toArray());
					list_2.setListData(pm.getVcubesNoDisponibles().toArray());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Revise el numero de la estacion");
				}
			}
		});
		GridBagConstraints gbc_btnDevolver = new GridBagConstraints();
		gbc_btnDevolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevolver.gridx = 0;
		gbc_btnDevolver.gridy = 2;
		panel.add(btnDevolver, gbc_btnDevolver);
		
		idDondeDevolver = new JTextField();
		GridBagConstraints gbc_idDondeDevolver = new GridBagConstraints();
		gbc_idDondeDevolver.insets = new Insets(0, 0, 5, 5);
		gbc_idDondeDevolver.fill = GridBagConstraints.HORIZONTAL;
		gbc_idDondeDevolver.gridx = 1;
		gbc_idDondeDevolver.gridy = 2;
		panel.add(idDondeDevolver, gbc_idDondeDevolver);
		idDondeDevolver.setColumns(10);
		
		latitudT = new JTextField();
		GridBagConstraints gbc_latitudT = new GridBagConstraints();
		gbc_latitudT.insets = new Insets(0, 0, 5, 0);
		gbc_latitudT.fill = GridBagConstraints.HORIZONTAL;
		gbc_latitudT.gridx = 2;
		gbc_latitudT.gridy = 2;
		panel.add(latitudT, gbc_latitudT);
		latitudT.setColumns(10);
		
		btnAlquilar = new JButton("Alquilar");
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.alquilarVcub();
				pm.actualizarListas();
				list.setListData(pm.getVcubesDisponibles().toArray());
				list_1.setListData(pm.getVcubesOcupados().toArray());
				list_2.setListData(pm.getVcubesNoDisponibles().toArray());
			}
		});
		GridBagConstraints gbc_btnAlquilar = new GridBagConstraints();
		gbc_btnAlquilar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlquilar.gridx = 0;
		gbc_btnAlquilar.gridy = 3;
		panel.add(btnAlquilar, gbc_btnAlquilar);
		
		btnActualizar = new JButton("Actualizar Pos");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vcub sele = (Vcub) list_1.getSelectedValue();
					double lat = Double.parseDouble(latitudT.getText());
					double log = Double.parseDouble(longitudT.getText());
					pm.actualizarPosicionVcub(sele.getId(), lat, log);
					pm.actualizarListas();
					list.setListData(pm.getVcubesDisponibles().toArray());
					list_1.setListData(pm.getVcubesOcupados().toArray());
					list_2.setListData(pm.getVcubesNoDisponibles().toArray());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Revise longitud y latitud");
				}
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		longitudT = new JTextField();
		GridBagConstraints gbc_longitudT = new GridBagConstraints();
		gbc_longitudT.insets = new Insets(0, 0, 5, 0);
		gbc_longitudT.fill = GridBagConstraints.HORIZONTAL;
		gbc_longitudT.gridx = 2;
		gbc_longitudT.gridy = 3;
		panel.add(longitudT, gbc_longitudT);
		longitudT.setColumns(10);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String[] txt = textField.getText().split("//");
					pm = new PrincipalMundo(Integer.parseInt(txt[0]),Integer.parseInt(txt[1]));
					list.setListData(pm.getVcubesDisponibles().toArray());
					list_1.setListData(pm.getVcubesOcupados().toArray());
					list_2.setListData(pm.getVcubesNoDisponibles().toArray());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Revise parametros estacion");
				}
			}
		});
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.insets = new Insets(0, 0, 0, 5);
		gbc_btnIniciar.gridx = 0;
		gbc_btnIniciar.gridy = 4;
		panel.add(btnIniciar, gbc_btnIniciar);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnActualizarLista = new JButton("Actualizar Lista");
		btnActualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.actualizarListas();
				list.setListData(pm.getVcubesDisponibles().toArray());
				list_1.setListData(pm.getVcubesOcupados().toArray());
				list_2.setListData(pm.getVcubesNoDisponibles().toArray());
			}
		});
		GridBagConstraints gbc_btnActualizarLista = new GridBagConstraints();
		gbc_btnActualizarLista.gridx = 2;
		gbc_btnActualizarLista.gridy = 4;
		panel.add(btnActualizarLista, gbc_btnActualizarLista);
		
	}

}
