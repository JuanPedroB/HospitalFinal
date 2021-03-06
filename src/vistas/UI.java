package vistas;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class UI extends JFrame {

	private JPanel contentPane;
	private AltaPaciente altapaciente;
	private ConsultaPaciente consultapaciente;
	private ModificacionPaciente modificacionpaciente;
	private BajaPaciente bajaPaciente;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UI frame = new UI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		//Los paneles
		Presentacion presentacion=new Presentacion();
		contentPane.add(presentacion,"presentacion");
		AltaMedico altaMedico=new AltaMedico();
		contentPane.add(altaMedico,"altaMedico");
		altapaciente=new AltaPaciente();
		contentPane.add(altapaciente,"altaPaciente");
		bajaPaciente=new BajaPaciente();
		contentPane.add(bajaPaciente,"bajaPaciente");
		ConsultaMedico consultaMedico=new ConsultaMedico();
		contentPane.add(consultaMedico,"consultaMedico");
		consultapaciente=new ConsultaPaciente();
		contentPane.add(consultapaciente,"consultaPaciente");
		modificacionpaciente=new ModificacionPaciente();
		contentPane.add(modificacionpaciente,"modificacionPaciente");
		CierreOperacion cierreOperacion=new CierreOperacion();
		contentPane.add(cierreOperacion,"cierreOperacion");
		CitaEspecialista citaEspecialista=new CitaEspecialista();
		contentPane.add(citaEspecialista,"citaEspecialista");
		Citaoperacion citaoperacion=new Citaoperacion();
		contentPane.add(citaoperacion,"citaoperacion");
		CitaPrimaria citaPrimaria=new CitaPrimaria();
		contentPane.add(citaPrimaria,"citaPrimaria");
		CitasPaciente citasPaciente=new CitasPaciente();
		contentPane.add(citasPaciente,"citasPaciente");
		HistorialPaciente historialPaciente=new HistorialPaciente();
		contentPane.add(historialPaciente,"historialPaciente");
		AtencionCita atenderCita=new AtencionCita();
		contentPane.add(atenderCita,"atenderCita");

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPaciente = new JMenu("Paciente");
		mnPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnPaciente);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("altaPaciente");
			}
		});
		
		mnPaciente.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("bajaPaciente");
			}
		});
		mnPaciente.add(mntmBaja);
		
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("modificacionPaciente");
			}
		});
		mnPaciente.add(mntmModificacion);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("consultaPaciente");
			}
		});
		mnPaciente.add(mntmConsulta);
		
		JMenuItem mntmPedirCitaPrimaria = new JMenuItem("Pedir Cita Primaria");
		mntmPedirCitaPrimaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("citaPrimaria");
			}
		});
		mnPaciente.add(mntmPedirCitaPrimaria);
		
		JMenuItem mntmPedirCitaEspecialista = new JMenuItem("Pedir Cita Especialista");
		mntmPedirCitaEspecialista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("citaEspecialista");
			}
		});
		mnPaciente.add(mntmPedirCitaEspecialista);
		
		JMenuItem mntmPedirOperacion = new JMenuItem("Pedir Operacion");
		mntmPedirOperacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("citaoperacion");
			}
		});
		mnPaciente.add(mntmPedirOperacion);
		
		JMenuItem mntmConsultarCitas = new JMenuItem("Consultar citas");
		mntmConsultarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("citasPaciente");
			}
		});
		mnPaciente.add(mntmConsultarCitas);
		
		JMenuItem mntmVerHistorial = new JMenuItem("Ver Historial");
		mntmVerHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("historialPaciente");
			}
		});
		mnPaciente.add(mntmVerHistorial);
		
		JMenu mnMedico = new JMenu("Medico");
		mnMedico.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnMedico);
		
		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mntmAlta_1.setEnabled(false);
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("altaMedico");
			}
		});
		mnMedico.add(mntmAlta_1);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mntmConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("consultaMedico");
			}
		});
		mnMedico.add(mntmConsulta_1);
		
		JMenuItem mntmAtenderCita = new JMenuItem("Atender cita");
		mntmAtenderCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("atenderCita");
			}
		});
		mnMedico.add(mntmAtenderCita);
		
		JMenu mnOperacion = new JMenu("Operacion");
		mnOperacion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnOperacion);
		
		JMenuItem mntmCerrarOperacion = new JMenuItem("Cerrar Operacion");
		mntmCerrarOperacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("cierreOperacion");
			}
		});
		mnOperacion.add(mntmCerrarOperacion);
	
				
		
	
	}
	private void asociarPanel(String string) {
		((CardLayout)contentPane.getLayout()).show(contentPane,string);
	}
	
	public void limpiar() {
		getid().setText("");
		getnombre().setText("");
		getapellidos().setText("");
		getdireccion().setText("");
		getnacimiento().setText("");
		gettelefono().setText("");
		
	}
	//------------alta paciente
	public JButton getjButtonAplicar() {
		return altapaciente.getbtnAplicar();
	}
	public JTextField getid() {
		return altapaciente.getid();
	}
	public JTextField getnombre() {
		return altapaciente.getnombre();
	}
	public JTextField getapellidos() {
		return altapaciente.getapellidos();
	}
	public JTextField getdireccion() {
		return altapaciente.getdireccion();
	}
	public JTextField getnacimiento() {
		return altapaciente.getnacimiento();
	}
	public JTextField gettelefono() {
		return altapaciente.gettelefono();
	}
	public JLabel getMensaje() {
		return altapaciente.getMensaje();
	}
	
	
	
	//-----------consulta paciente
	
	
	public JComboBox getconsultaCombo() {
		return consultapaciente.getconsultaCombo();
	}
	public JTextField getidconsulta() {
		return consultapaciente.getidconsulta();
	}
	public JTextField getnombreconsulta() {
		return consultapaciente.getnombreconsulta();
	}
	public JTextField getapellidosconsulta() {
		return consultapaciente.getapellidosconsulta();
	}
	public JTextField getdireccionconsulta() {
		return consultapaciente.getdireccionconsulta();
	}
	public JTextField getnacimientoconsulta() {
		return consultapaciente.getnacimientoconsulta();
	}
	public JTextField gettelefonoconsulta() {
		return consultapaciente.gettelefonoconsulta();
	}
	
	
	
	//---------------modificacion paciente
	
	public JComboBox getcombomodificarid() {
		return modificacionpaciente.getcombomodificarid();
	}
	public JTextField getmodificaciondireccion() {
		return modificacionpaciente.getmodificaciondireccion();
	}
	public JTextField getmodificaciontelefono() {
		return modificacionpaciente.getmodificaciontelefono();
	}
	public JTextField getmodificacionnombre() {
		return modificacionpaciente.getmodificacionnombre();
	}
	public JTextField getmodificacionapellidos() {
		return modificacionpaciente.getmodificacionapellidos();
	}
	public JTextField getmodificacionnacimiento() {
		return modificacionpaciente.getmodificacionnacimiento();
	}
	public JButton getmodificacionboton() {
		return modificacionpaciente.getmodificacionboton();
	}
	public JLabel getmodificacionmensaje() {
		return modificacionpaciente.getmodificacionmensaje();
	}
	
	//---------------------baja paciente
	
public JComboBox getBajaComboId() {
	return bajaPaciente.getBajaComboId();
}
public JTextField getBajaNombre() {
	return bajaPaciente.getBajaNombre();
}
public JTextField getBajaApellidos() {
	return bajaPaciente.getBajaApellidos();
}
public JTextField getBajaDireccion() {
	return bajaPaciente.getBajaDireccion();
}
public JTextField getBajaNacimiento() {
	return bajaPaciente.getBajaNacimiento();
}
public JTextField getBajaTelefono() {
	return bajaPaciente.getBajaTelefono();
}
public JLabel getBajaMensaje() {
	return bajaPaciente.getBajaMensaje();
}
public JButton getBajaBoton() {
	return bajaPaciente.getBajaBoton();
}
	
	
	
	
	
	
	

}
