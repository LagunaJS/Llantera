package mx.itson.llantera.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.itson.llantera.entidades.Contacto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarContacto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	static Contacto iContacto = new Contacto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarContacto frame = new AgregarContacto();
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
	public AgregarContacto() {
		setTitle("Nuevo Contacto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 30, 61, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(41, 58, 360, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(31, 96, 61, 16);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(41, 124, 158, 26);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(31, 162, 61, 16);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(41, 190, 360, 26);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNombre.getText().equals("") && !txtTelefono.getText().equals("") && !txtCorreo.getText().equals("")) {
					iContacto.crearContacto(txtNombre.getText(), txtTelefono.getText(), txtCorreo.getText());
					JOptionPane.showMessageDialog(null, "Contacto Guardado");
					MostrarTodo ventana = new MostrarTodo();
					ventana.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Los Campos no deben estar vacios");
				}
				
			}
		});
		btnGuardar.setBounds(153, 243, 117, 29);
		contentPane.add(btnGuardar);
	}

}
