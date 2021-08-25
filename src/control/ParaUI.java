package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Paciente;
import vistas.UI;

public class ParaUI extends UI {

	private fachada fachada;

	public ParaUI() {
		super();
		this.fachada = new fachada();
		actualizarconsulta();
		
		getjButtonAplicar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int id=Integer.valueOf(getid().getText());
					String nombre=getnombre().getText();
					String apellidos=getapellidos().getText();
					String direccion=getdireccion().getText();
					String nacimiento=getnacimiento().getText();
					String telefono=gettelefono().getText();
					Paciente paciente=new Paciente(id, nombre, apellidos, direccion, nacimiento, telefono);
					if (paciente.getId()>=150) {
						getMensaje().setText("Id fuera de los limites");
						limpiar();
					}else {
						if (fachada.BuscarPaciente(paciente.getId())!=null) {
							limpiar();
							getMensaje().setText("Ese paciente ya existe");
						}else {
							fachada.addPaciente(paciente);
							limpiar();
							getMensaje().setText("Paciente dado de alta");
							getconsultaCombo().addItem(id);
							getcombomodificarid().addItem(id);
							getBajaComboId().addItem(id);
						}
					}
					
					
					

				} catch (Exception e) {
					
					getMensaje().setText("Error al dar de alta");
					
				}
						}
		});
		
		getconsultaCombo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Paciente consulta= fachada.BuscarPaciente(Integer.valueOf(getconsultaCombo().getSelectedItem().toString()));
					
					getidconsulta().setText(String.valueOf(consulta.getId()));
					getnombreconsulta().setText(consulta.getNombre());
					getapellidosconsulta().setText(consulta.getApellidos());
					getdireccionconsulta().setText(consulta.getDireccion());
					getnacimientoconsulta().setText(consulta.getFechanacimiento());
					gettelefonoconsulta().setText(consulta.getTelefono());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
				
		});
		
		getcombomodificarid().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			try {
				Paciente consulta= fachada.BuscarPaciente(Integer.valueOf(getcombomodificarid().getSelectedItem().toString()));
				
				
				getmodificacionnombre().setText(consulta.getNombre());
				getmodificacionapellidos().setText(consulta.getApellidos());
				getmodificaciondireccion().setText(consulta.getDireccion());
				getmodificacionnacimiento().setText(consulta.getFechanacimiento());
				getmodificaciontelefono().setText(consulta.getTelefono());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
				
			}
		});
		
		getmodificacionboton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String id=getcombomodificarid().getSelectedItem().toString();
					String nombre = getmodificacionnombre().getText();
					String apellidos= getmodificacionapellidos().getText();
					String nacimiento= getmodificacionnacimiento().getText();
					String direccion=getmodificaciondireccion().getText();
					String Telefono = getmodificaciontelefono().getText();
					Paciente modificado = new Paciente(Integer.valueOf(id), nombre, apellidos, direccion, nacimiento, Telefono);
					fachada.ModificarPaciente(Integer.valueOf(id));
					fachada.addPaciente(modificado);
					getconsultaCombo().addItem(Integer.valueOf(id));
					getcombomodificarid().addItem(Integer.valueOf(id));
					
					getmodificacionmensaje().setText("Paciente modificado con exito");

				} catch (Exception e) {
					getmodificacionmensaje().setText("Error al modificar");
				}

			}
		});
		
		getBajaComboId().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Paciente consulta= fachada.BuscarPaciente(Integer.valueOf(getBajaComboId().getSelectedItem().toString()));

					getBajaNombre().setText(consulta.getNombre());
					getBajaApellidos().setText(consulta.getApellidos());
					getBajaDireccion().setText(consulta.getDireccion());
					getBajaNacimiento().setText(consulta.getFechanacimiento());
					getBajaTelefono().setText(consulta.getTelefono());
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		getBajaBoton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String id=getBajaComboId().getSelectedItem().toString();
					fachada.ModificarPaciente(Integer.valueOf(id));
					getconsultaCombo().removeItemAt(Integer.valueOf(id)-1);
					getcombomodificarid().removeItemAt(Integer.valueOf(id)-1);
					getBajaMensaje().setText("Paciente dado de baja");
					
				} catch (Exception e) {
					getBajaMensaje().setText("Error al dar de baja");
				}
				
				
			}
		});
	
		
	}
	
	public void actualizarconsulta() {
		int id=0;
		while (id<150) {
			Paciente existe=fachada.BuscarPaciente(id);
			if (existe!=null) {
				getconsultaCombo().addItem(id);
				getcombomodificarid().addItem(id);
				getBajaComboId().addItem(id);
			}
			id++;
		}
	}
	
	
}
