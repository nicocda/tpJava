package presentacion;
import negocio.ControladorDePersonas;
import entidades.Persona;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//Declaracion de la clase
public class Formulario {
Persona p = new Persona();
ControladorDePersonas cp= new ControladorDePersonas();
	private JFrame frame;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario window = new Formulario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDni = new JLabel("dni: ");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("nombre: ");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("email: ");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblApellido = new JLabel("apellido: ");
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JButton btnBuscarDni = new JButton("Buscar");
		btnBuscarDni.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			Persona p = cp.buscarPersona(Integer.parseInt(txtDni.getText()));
				if(null==p)textArea.append("DNI no encontrado, esta disponible\n");
				else textArea.append("DNI: "+p.getDni()+"\n Nombre: "+p.getNombre()+" "+p.getApellido()+"\n Email: "+p.getEmail());
			}
		}); 
		btnBuscarDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDni.setText(null);
				txtNombre.setText(null);
				txtApellido.setText(
						
						null);
				txtEmail.setText(null);
				textArea.append("Borrado con éxito\n");
			}
		});
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*String email= txtEmail.getText();
				String nombre= txtNombre.getText();
				String apellido= txtApellido.getText();
				int dni = Integer.parseInt(txtDni.getText());*/
				p=cp.guardar(Integer.parseInt(txtDni.getText()),txtNombre.getText(),txtApellido.getText(),txtEmail.getText());
				if(p!=null) textArea.append(p.getNombre()+" "+p.getApellido()+" Se Ha Agregado con Éxito\n");
				else textArea.append("Error en agregar Persona\n");
				
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDni, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(btnBuscarDni))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(55)
									.addComponent(lblApellido)
									.addGap(18)
									.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(89))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(114)
					.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(155))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addGap(79))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarDni))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnGuardar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
