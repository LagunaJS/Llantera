package mx.itson.llantera.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.itson.llantera.entidades.Cliente;
import mx.itson.llantera.entidades.Contacto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtNombreContacto;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	static Contacto iContacto = new Contacto();
	static Cliente iCliente = new Cliente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCliente frame = new AgregarCliente();
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
	public AgregarCliente() {
		setTitle("Nuevo Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 32, 61, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(32, 60, 378, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(22, 98, 80, 16);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(32, 126, 378, 26);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 164, 388, 12);
		contentPane.add(separator);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(187, 174, 61, 16);
		contentPane.add(lblContacto);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(22, 205, 61, 16);
		contentPane.add(lblNombre_1);
		
		txtNombreContacto = new JTextField();
		txtNombreContacto.setBounds(32, 233, 378, 26);
		contentPane.add(txtNombreContacto);
		txtNombreContacto.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(22, 271, 61, 16);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(32, 299, 378, 26);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(22, 337, 61, 16);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(32, 361, 378, 26);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNombre.getText().equals("") && !txtDireccion.getText().equals("") && !txtNombreContacto.getText().equals("") && !txtTelefono.getText().equals("") && !txtCorreo.getText().equals("")) {
					int id = iContacto.crearContacto(txtNombreContacto.getText(), txtTelefono.getText(), txtCorreo.getText());
					Contacto contacto = new Contacto();
					contacto = iContacto.obtenerPorId(id);
					iCliente.crearCliente(txtNombre.getText(), txtDireccion.getText(), contacto);
					JOptionPane.showMessageDialog(null, "Cliente Guardado");
					MostrarTodo ventana = new MostrarTodo();
					ventana.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
				}
			}
		});
		btnGuardar.setBounds(166, 413, 117, 29);
		contentPane.add(btnGuardar);
	}
}
