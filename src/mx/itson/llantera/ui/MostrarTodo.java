package mx.itson.llantera.ui;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.itson.llantera.entidades.Cliente;
import mx.itson.llantera.entidades.Contacto;
import mx.itson.llantera.entidades.Linea;
import mx.itson.llantera.entidades.Orden;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarTodo extends JFrame {

	private JPanel contentPane;
	private static JTable tblTodos;
	static Cliente iCliente = new Cliente();
	static Contacto iContacto = new Contacto();
	static Linea iLinea = new Linea();
	static Orden iOrden = new Orden();
	private int vista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarTodo frame = new MostrarTodo();
					frame.setVisible(true);
					rellenarTablaOrden();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Crea el modelo para la tabla de orden
	 */
	static DefaultTableModel modelOrden = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"id","Descripcion","Linea","Cliente"
			}
	);
	
	/**
	 * Rellena la tabla con las ordenes traidas desde la Base de datos
	 */
	public static void  rellenarTablaOrden(){
		List<Orden> ordenes = iOrden.obtenerTodos();		
		int filas = ordenes.size();
		String [][] ordenesString = new String[filas][4];
		int i = 0;
		for(Orden in : ordenes)
		{
			String id = String.valueOf(in.getId());
			String descripcion = in.getDescripcion();
			String linea = in.getLinea().getNombre();
			String cliente = in.getCliente().getNombre();
			
			
			ordenesString[i][0] = id;
			ordenesString[i][1] = descripcion;
			ordenesString[i][2] = linea;
			ordenesString[i][3] = cliente;
			i++;
			

		}
		for (int row = 0; row < ordenesString.length; row++) {
            for (int idx = 0; idx < ordenesString.length; idx++) {
                modelOrden.addRow(ordenesString[idx]);
                
            }break; 
        }
		
		tblTodos.setModel(modelOrden);
		
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
		
		tblTodos.setModel(modelCliente);
		
	}
	
	
	/**
	 * Crea el modelo para la tabla de contactos
	 */
	static DefaultTableModel modelContacto = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"id","Nombre","Telefono","Correo"
			}
	);
	
	/**
	 * Rellena la tabla con los clientes traidas desde la Base de datos
	 */
	public static void  rellenarTablaContactos(){
		
		List<Contacto> contactos = iContacto.obtenerTodos();		
		int filas = contactos.size();
		String [][] contactosString = new String[filas][4];
		int i = 0;
		for(Contacto in : contactos)
		{
			String id = String.valueOf(in.getId());
			String nombre = in.getNombre();
			String telefono = in.getTelefono();
			String correo = in.getCorreo();
			
			
			contactosString[i][0] = id;
			contactosString[i][1] = nombre;
			contactosString[i][2] = telefono;
			contactosString[i][3] = correo;
			i++;
			

		}
		for (int row = 0; row < contactosString.length; row++) {
            for (int idx = 0; idx < contactosString.length; idx++) {
                modelContacto.addRow(contactosString[idx]);
                
            }break; 
        }
		
		tblTodos.setModel(modelContacto);
		
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
		
		tblTodos.setModel(modelLinea);
		
	}

	/**
	 * Create the frame.
	 */
	public MostrarTodo() {
		setTitle("Muestra TodOMatico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblTodos = new JTable();
		tblTodos.setBounds(64, 38, 825, 407);
		contentPane.add(tblTodos);
		
		JButton btnOrdenes = new JButton("Ordenes");
		btnOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblTodos.setModel(modelOrden);
				 for (int i = 0; i < tblTodos.getRowCount(); i++) {
			           modelOrden.removeRow(i);
			           i-=1;
			       }
				rellenarTablaOrden();
				vista = 1;
			}
		});
		btnOrdenes.setBounds(64, 457, 117, 29);
		contentPane.add(btnOrdenes);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblTodos.setModel(modelCliente);
				 for (int i = 0; i < tblTodos.getRowCount(); i++) {
			           modelCliente.removeRow(i);
			           i-=1;
			       }
				rellenarTablaCliente();
				vista = 2;
			}
		});
		btnClientes.setBounds(299, 457, 117, 29);
		contentPane.add(btnClientes);
		
		JButton btnContactos = new JButton("Contactos");
		btnContactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblTodos.setModel(modelContacto);
				 for (int i = 0; i < tblTodos.getRowCount(); i++) {
			           modelContacto.removeRow(i);
			           i-=1;
			       }
				rellenarTablaContactos();
				vista = 3;
			}
		});
		btnContactos.setBounds(529, 457, 117, 29);
		contentPane.add(btnContactos);
		
		JButton btnLineas = new JButton("Lineas");
		btnLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblTodos.setModel(modelLinea);
				 for (int i = 0; i < tblTodos.getRowCount(); i++) {
			           modelLinea.removeRow(i);
			           i-=1;
			       }
				rellenarTablaLineas();
				vista = 4;
			}
		});
		btnLineas.setBounds(749, 457, 117, 29);
		contentPane.add(btnLineas);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (vista) {
				case 1:
					
					AgregarOrden ventanaOrden = new AgregarOrden();
			        ventanaOrden.setVisible(true);
			        dispose();
					break; 
				case 2:
					AgregarCliente ventanaCliente = new AgregarCliente();
			        ventanaCliente.setVisible(true);
			        dispose();
					break;					
				case 3:
					AgregarContacto ventanaContacto = new AgregarContacto();
			        ventanaContacto.setVisible(true);
			        dispose();
					break;
				case 4:
					AgregarLinea ventanaLinea = new AgregarLinea();
			        ventanaLinea.setVisible(true);
			        dispose();
					break;
				default:	
					JOptionPane.showMessageDialog(null, "Selecciona una tabla");
					
				}
			}

		});
		btnNuevo.setBounds(529, 512, 117, 29);
		contentPane.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "No tuve tiempo de hacer esta parte :$");
			}
		});
		btnEditar.setBounds(299, 512, 117, 29);
		contentPane.add(btnEditar);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (vista) {
				case 1:

					break; 
				case 2:

					break;					
				case 3:

					break;
				case 4:
					Linea linea = new Linea();
					linea = iLinea.obtenerPorId(Integer.parseInt(String.valueOf(modelLinea.getValueAt(tblTodos.getSelectedRow(), 0))));
					iLinea.eliminar(linea);
					break;
				default:	
					JOptionPane.showMessageDialog(null, "Selecciona una tabla");
					
				}
			}
		});
		btnX.setBounds(64, 512, 43, 29);
		contentPane.add(btnX);
	}
}
