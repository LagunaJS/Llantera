package mx.itson.llantera.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.itson.llantera.entidades.Linea;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarLinea extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEncargado;
	static Linea iLinea = new Linea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarLinea frame = new AgregarLinea();
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
	public AgregarLinea() {
		setResizable(false);
		setTitle("Nueva Linea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 33, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblEncargado = new JLabel("Encargado:");
		lblEncargado.setBounds(29, 117, 81, 16);
		contentPane.add(lblEncargado);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(39, 61, 360, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEncargado = new JTextField();
		txtEncargado.setBounds(39, 145, 360, 26);
		contentPane.add(txtEncargado);
		txtEncargado.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNombre.getText().equals("") && !txtEncargado.getText().equals("")) {
					iLinea.crearLinea(txtNombre.getText(), txtEncargado.getText());
					JOptionPane.showMessageDialog(null, "Se Guardo Correctamente");
					
				} else {
					JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
				}
				
				MostrarTodo ventana = new MostrarTodo();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnGuardar.setBounds(157, 205, 117, 29);
		contentPane.add(btnGuardar);
	}
}
