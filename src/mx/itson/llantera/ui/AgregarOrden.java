package mx.itson.llantera.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.itson.llantera.entidades.Cliente;
import mx.itson.llantera.entidades.Linea;
import mx.itson.llantera.entidades.Orden;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarOrden extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private static JTable tblLinea;
	private static JTable tblCliente;
	static Linea iLinea = new Linea();
	static Cliente iCliente = new Cliente();
	static Orden iOrden = new Orden();
	private boolean t = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarOrden frame = new AgregarOrden();
					frame.setVisible(true);
					rellenarTablaLineas();
					rellenarTablaCliente();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el modelo para la tabla de lineas
	 */
	static DefaultTableModel modelLinea = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"id","Nombre","Encargado"
			}
	);
	
	/**
	 * Rellena la tabla con los clientes traidas desde la Base de datos
	 */
	public static void  rellenarTablaLineas(){
		
		List<Linea> lineas = iLinea.obtenerTodos();		
		int filas = lineas.size();
		String [][] lineasString = new String[filas][3];
		int i = 0;
		for(Linea in : lineas)
		{
			String id = String.valueOf(in.getId());
			String nombre = in.getNombre();
			String encargado = in.getEncargado();
			
			
			lineasString[i][0] = id;
			lineasString[i][1] = nombre;
			lineasString[i][2] = encargado;
			i++;
			

		}
		for (int row = 0; row < lineasString.length; row++) {
            for (int idx = 0; idx < lineasString.length; idx++) {
                modelLinea.addRow(lineasString[idx]);
                
            }break; 
        }
		
		tblLinea.setModel(modelLinea);
		
	}
	
	/**
	 * Crea el modelo para la tabla de clientes
	 */
	static DefaultTableModel modelCliente = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"id","Nombre","Contacto","Direccion"
			}
	);
	
	/**
	 * Rellena la tabla con los clientes traidas desde la Base de datos
	 */
	public static void  rellenarTablaCliente(){
		List<Cliente> clientes = iCliente.obtenerTodos();		
		int filas = clientes.size();
		String [][] clientesString = new String[filas][4];
		int i = 0;
		for(Cliente in : clientes)
		{
			String id = String.valueOf(in.getId());
			String nombre = in.getNombre();
			String contacto = in.getContacto().getNombre();
			String direccion = in.getDireccion();
			
			
			clientesString[i][0] = id;
			clientesString[i][1] = nombre;
			clientesString[i][2] = contacto;
			clientesString[i][3] = direccion;
			i++;
			

		}
		for (int row = 0; row < clientesString.length; row++) {
            for (int idx = 0; idx < clientesString.length; idx++) {
                modelCliente.addRow(clientesString[idx]);
                
            }break; 
        }
		
		tblCliente.setModel(modelCliente);
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public AgregarOrden() {
		setTitle("Nueva Orden");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripion = new JLabel("Descripion:");
		lblDescripion.setBounds(31, 29, 105, 16);
		contentPane.add(lblDescripion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!t) {
					rellenarTablaLineas();
					rellenarTablaCliente();
					t = true;
				}

			}
		});
		txtDescripcion.setBounds(41, 57, 616, 39);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblLinea = new JLabel("Linea:");
		lblLinea.setBounds(105, 108, 61, 16);
		contentPane.add(lblLinea);
		
		tblLinea = new JTable();
		tblLinea.setBounds(31, 136, 223, 220);
		contentPane.add(tblLinea);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(514, 108, 61, 16);
		contentPane.add(lblCliente);
		
		tblCliente = new JTable();
		tblCliente.setBounds(445, 136, 223, 220);
		contentPane.add(tblCliente);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idLinea = Integer.parseInt(String.valueOf(modelLinea.getValueAt(tblLinea.getSelectedRow(), 0)));
				int idCliente = Integer.parseInt(String.valueOf(modelCliente.getValueAt(tblCliente.getSelectedRow(), 0)));
				Linea linea = new Linea();
				Cliente cliente = new Cliente();
				
				linea = iLinea.obtenerPorId(idLinea);
				cliente = iCliente.obtenerPorId(idCliente);
				
				if (linea != null && cliente != null && !txtDescripcion.getText().equals("")) {
					iOrden.crearOrden(txtDescripcion.getText(), linea, cliente);
					
					JOptionPane.showMessageDialog(null, "Orden Guardada");
					
					MostrarTodo ventana = new MostrarTodo();
					ventana.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Asegurate de llenar la descripcion, elegir Linea y Cliente");
				}
			}
		});
		btnGuardar.setBounds(285, 407, 117, 29);
		contentPane.add(btnGuardar);
	}
}
