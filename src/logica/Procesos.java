package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hospital.CitaMedica;
import hospital.personas.EmpleadoEventual;
import hospital.personas.EmpleadoPlantilla;
import hospital.personas.Medico;
import hospital.personas.Paciente;

public class Procesos {
	String dni, nombre, apellido, fechaNacimiento, direccion, ciudad, codEmpleado, numHorasExt, fechaIngreso, area,
			cargo;

	ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
	ArrayList<EmpleadoPlantilla> listaEmpleadoPlantilla = new ArrayList<EmpleadoPlantilla>();
	ArrayList<EmpleadoEventual> listaEmpleadoEventual = new ArrayList<EmpleadoEventual>();
	ArrayList<CitaMedica> listaCitaMedica = new ArrayList<CitaMedica>();
	ArrayList<Medico> listaMedico = new ArrayList<Medico>();

	int cantCitas = 0;
	int numCitas = 0;

	public Procesos() {
		numCitas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de citas medicas por dia"));
		presentarMenu();
	}

	private void presentarMenu() {
		int opc;
		String cad = "SISTEMA HOSPITALARIO \nRegistro\n\n";
		cad += "1. Registrar Usuarios\n";
		cad += "2. Registrar Cita Medica\n";
		cad += "3. Imprimir Datos\n";
		cad += "4. Salir\n\n";
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(cad + "Ingrese una opcion"));

			switch (opc) {
			case 1:
				cargarMenuRegistro();
				break;
			case 2:

				System.out.println(cantCitas + "<" + numCitas);
				if (cantCitas < numCitas) {
					if (validaRegistrosPrevios()) {
						registrarCitaMedica();
					} else {
						JOptionPane.showMessageDialog(null,
								"No se puede registrar la cita, verifique que los empleados por planilla,\n"
										+ "medicos y pacientes se encuentren previamente\nregistrados en el sistema",
								"Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"No se puede registrar la cita, Ha superado el numero de citas por dia", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
				break;
			case 3:
				if (validaRegistrosEmpleados()) {
					imprimirDatos();
				}
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Chao");
				break;
			default:
				break;
			}
		} while (opc != 4);
		JOptionPane.showMessageDialog(null, "salio");
	}

	private void imprimirDatos() {
		String menuMsj = "Menu Reportes\n\n";
		menuMsj += "1. Imprimir Empleados de Planilla\n";
		menuMsj += "2. Imprimir Empleados Eventuales\n";
		menuMsj += "3. Imprimir Medicos\n";
		menuMsj += "4. Imprimir Pacientes\n";
		menuMsj += "5. Imprimir Citas\n";
		menuMsj += "6. Salir\n\n";
		int cod = Integer.parseInt(JOptionPane.showInputDialog(menuMsj + "Seleccione una opcion"));

		switch (cod) {
		case 1:
			if (listaEmpleadoPlantilla.isEmpty()==false) {
				System.out
						.println("***************************Empleados Planilla**************************************");
				for (int i = 0; i < listaEmpleadoPlantilla.size(); i++) {

					System.out.println("Numero DNI: " + listaEmpleadoPlantilla.get(i).getDni());

					System.out.println("Nombre: " + listaEmpleadoPlantilla.get(i).getNombre() + " "
							+ listaEmpleadoPlantilla.get(i).getApellido());

					System.out.println("Codigo Empleado: " + listaEmpleadoPlantilla.get(i).getCodEmpleado());

					System.out.println("Cargo: " + listaEmpleadoPlantilla.get(i).getCargo());

					System.out.println("Salario mensual: " + listaEmpleadoPlantilla.get(i).getSalarioMensual());

					System.out.println();
				}

				System.out.println(
						"*************************************************************************************");

			} else {
				JOptionPane.showMessageDialog(null, "No existe informacion registrada", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		case 2:
			if (listaEmpleadoEventual.isEmpty()==false) {

				System.out.println(
						"******************************Empleados Eventuales**************************************");
				for (int i = 0; i < listaEmpleadoEventual.size(); i++) {

					System.out.println("Numero DNI: " + listaEmpleadoEventual.get(i).getDni());

					System.out.println("Nombre: " + listaEmpleadoEventual.get(i).getNombre() + ""
							+listaEmpleadoEventual.get(i).getApellido());

					System.out.println("Codigo Empleado:" +listaEmpleadoEventual.get(i).getCodEmpleado());

					System.out.println("Cargo:" + listaEmpleadoEventual.get(i).getCargo());

					System.out.println("Honorarios por hora:" + listaEmpleadoEventual.get(i).getHonorariosHora());

					System.out.println(
							"Fecha termino de contrato: " + listaEmpleadoEventual.get(i).getFechaTerminoContrato());

					System.out.println();
				}

				System.out.println(
						"*************************************************************************************");

			} else {
				JOptionPane.showMessageDialog(null, "No existe informacion registrada", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		case 3:
			if (listaMedico.isEmpty()==false) {

				System.out.println(
						"**********************************Medicos*********************************************");

				for (int i = 0; i < listaMedico.size(); i++) {
					System.out.println("Numero DNI: " + listaMedico.get(i).getDni());

					System.out.println(
							"Nombre: " + listaMedico.get(i).getNombre() + " " + listaMedico.get(i).getApellido());
					System.out.println("Codigo Empleado: " + listaMedico.get(i).getCodEmpleado());

					System.out.println("Cargo: " +listaMedico.get(i).getCargo());

					System.out.println("Especialidad: " + listaMedico.get(i).getEspecialidad());

					System.out.println("Numero de consultorio: " +listaMedico.get(i).getNumConsultorio());

					System.out.println();
				}

				System.out.println(
						"*************************************************************************************");

			} else {
				JOptionPane.showMessageDialog(null, "No existe informacion registrada", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		case 4:
			if (listaPaciente.isEmpty()==false) {

				System.out.println(
						"**********************************Pacientes*********************************************");

				for (int i = 0; i < listaPaciente.size(); i++) {
					System.out.println("Numero DNI: " + listaPaciente.get(i).getDni());

					System.out.println(
							"Nombre: " + listaPaciente.get(i).getNombre() + " " + listaPaciente.get(i).getApellido());
					System.out.println("Numero Historia Clinica: " +listaPaciente.get(i).getNumHistoria());

					System.out.println("Sexo: " + listaPaciente.get(i).getSexo());

					System.out.println("Grupo Sanguineo: " + listaPaciente.get(i).getGrupoSanguineo());

					System.out.println("Lista Medicamentos");
					for (int j = 0; j < listaPaciente.get(i).getListaMedicamentos().length; j++) {
						System.out.print(listaPaciente.get(i).getListaMedicamentos()[j] + " / ");

					}
					System.out.println();
				}

				System.out.println(
						"*************************************************************************************");

			} else {
				JOptionPane.showMessageDialog(null, "No existe informacion registrada", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		case 5:
			if (listaCitaMedica.isEmpty()==false) {

				System.out.println(
						"**********************************Citas*********************************************");

				for (int i = 0; i < listaCitaMedica.size(); i++) {
					System.out.println("Servicio: " + listaCitaMedica.get(i).getServicio());

					System.out.println("Paciente: " + listaCitaMedica.get(i).getPaciente().getNombre() + ""
							+ listaCitaMedica.get(i).getPaciente().getApellido());

					System.out.println("Medico: " + listaCitaMedica.get(i).getMedico().getNombre() + ""
							+ listaCitaMedica.get(i).getMedico().getApellido());

					System.out.println("Fecha: " + listaCitaMedica.get(i).getFecha());

					System.out.println("Hora: " + listaCitaMedica.get(i).getHora());

					System.out.println();
				}

				System.out.println(
						"*************************************************************************************");

			} else {
				JOptionPane.showMessageDialog(null, "No existe informacion registrada", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		default:
			break;
		}
	}

	private boolean validaRegistrosEmpleados() {
		boolean retorno = false;
		if (listaEmpleadoPlantilla.isEmpty()==false ||listaEmpleadoEventual.isEmpty()==false) {

			if (validarEmpleado()) {
				retorno = true;
			} else {
				JOptionPane.showMessageDialog(null, "No existen empleados con ese documento", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		} else {
			JOptionPane.showMessageDialog(null, "No existen empleados Registrados", "Error", JOptionPane.ERROR_MESSAGE);

		}
		return retorno;
	}

	private boolean validarEmpleadoPlanilla() {
		String documentoEmpleado = JOptionPane.showInputDialog("Ingrese el documento del empleado por planilla");
		boolean retorna = false;
		for (int i = 0; i < listaEmpleadoPlantilla.size(); i++) {
			if

			(documentoEmpleado.equals(listaEmpleadoPlantilla.get(i).getDni())) {

				retorna = true;
			}
		}
		return retorna;
	}

	private boolean validarEmpleado() {

		String documentoEmpleado = JOptionPane.showInputDialog("Ingrese el documento del empleado");

		boolean retorna = false;
		if (listaEmpleadoPlantilla.isEmpty()==false) {
			for (int i = 0; i < listaEmpleadoPlantilla.size(); i++)

			{

				if

				(documentoEmpleado.equals(listaEmpleadoPlantilla.get(i).getDni())) {

					retorna = true;
				}
			}
		}
		if (retorna == false) {
			if (listaEmpleadoEventual.isEmpty()==false) {
				for (int i = 0; i < listaEmpleadoEventual.size(); i++) {
					if

					(documentoEmpleado.equals(listaEmpleadoEventual.get(i).getDni())) {

						retorna = true;
					}
				}
			}
		}
		return retorna;
	}

	private boolean validaRegistrosPrevios() {
		boolean retorno = false;
		if (listaPaciente.isEmpty()==false && listaMedico.isEmpty()==false && listaEmpleadoPlantilla.isEmpty()==false) {
			retorno = true;
		}
		return retorno;
	}

	private void registrarCitaMedica() {
		if (validarEmpleadoPlanilla()) {
			CitaMedica miCita = new CitaMedica();
			miCita.setServicio(JOptionPane.showInputDialog("Ingrese el Servicio"));

			miCita.setPaciente(asignarPaciente());
			miCita.setMedico(asignaMedico());

			miCita.setFecha(JOptionPane.showInputDialog("Ingrese la fecha"));
			miCita.setHora(JOptionPane.showInputDialog("Ingrese la Hora"));

			JOptionPane.showMessageDialog(null, "La cita se ha registrado exitosamente!!!");

			listaCitaMedica.add(miCita);
			cantCitas++;

		} else {
			JOptionPane.showMessageDialog(null, "El documento no corresponde a un empleado por planilla", "Advertencia",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	private Medico asignaMedico() {
		boolean repiteCiclo = false;
		Medico miMedico = null;
		do {
			String

			documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del Medico");

			for (int i = 0; i < listaMedico.size(); i++) {
				if

				(documentoPaciente.equals(listaMedico.get(i).getDni())) {
					miMedico = listaMedico.get(i);
				}
			}
			if (miMedico != null) {
				repiteCiclo = false;
			} else {
				repiteCiclo = true;
				JOptionPane.showMessageDialog(null,
						"El documento no corresponde a un Medico\n" + "Por favor ingrese un documento valido",
						"Advertencia", JOptionPane.WARNING_MESSAGE);

			}
		} while (repiteCiclo == true);
		return miMedico;
	}

	private Paciente asignarPaciente() {
		boolean repiteCiclo = false;
		Paciente miPaciente = null;
		do {
			String

			documentoPaciente = JOptionPane.showInputDialog("Ingrese el documento del paciente");

			for (int i = 0; i < listaPaciente.size(); i++) {
				if (documentoPaciente.equals(listaPaciente.get(i).getDni())) {
					miPaciente = listaPaciente.get(i);
				}
			}
			if (miPaciente != null) {
				repiteCiclo = false;
			} else {
				repiteCiclo = true;
				JOptionPane.showMessageDialog(null,
						"El documento no corresponde a un Paciente\n" + "Por favor ingrese un documento valido",
						"Advertencia", JOptionPane.WARNING_MESSAGE);

			}

		} while (repiteCiclo == true);
		return miPaciente;
	}

	private void cargarMenuRegistro() {
		String cad = "REGISTRO DE USUARIOS\nregistro\n\n";
		cad += "1. Registrar Empleado\n";
		cad += "2. Registrar Paciente\n";
		cad += "3. Regresar\n\n";
		int

		opc = Integer.parseInt(JOptionPane.showInputDialog(cad + "Ingrese una opcion"));

		switch (opc) {
		case 1:
			String tipoEmpleado = "Tipo Empleado\n\n";
			tipoEmpleado += "1.Empleado Planilla\n";
			tipoEmpleado += "2.Empleado Eventual\n";
			tipoEmpleado += "3.Medico\n\n";
			int

			tipo = Integer.parseInt(JOptionPane.showInputDialog(tipoEmpleado + "Seleccione el tipo de empleado"));

			registrarEmpleado(tipo);
			break;
		case 2:
			registrarPaciente();
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	private void registrarPaciente() {
		if (listaPaciente.isEmpty() == true) {
			int

			cantPaciente = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Pacientes a registrar"));

			for (int i = 0; i < cantPaciente; i++) {
				JOptionPane.showMessageDialog(null, "Registro de datos paciente " + (i + 1));

				Paciente miPaciente = new Paciente();

				miPaciente.setDni(JOptionPane.showInputDialog("Ingrese el DNI del Paciente " + (i + 1)));
				miPaciente.setNombre(JOptionPane.showInputDialog("Ingrese el Nombre del Paciente " + (i + 1)));
				miPaciente.setApellido(JOptionPane.showInputDialog("Ingrese el Apellido del Paciente " + (i + 1)));

				miPaciente.setFechaNacimiento(
						JOptionPane.showInputDialog("Ingrese la fecha de Nacimiento del Paciente " + (i + 1)));
				miPaciente.setDireccion(JOptionPane.showInputDialog("Ingrese la Direccion del Paciente " + (i + 1)));
				miPaciente.setCiudad(JOptionPane.showInputDialog("Ingrese Ciudad del Paciente " + (i + 1)));

//datos paciente

				miPaciente.setNumHistoria(JOptionPane
						.showInputDialog("Ingrese el Numero de la Historia Clinica del Paciente " + (i + 1)));
				miPaciente.setSexo(JOptionPane.showInputDialog("Ingrese el Sexo del Paciente " + (i + 1)));
				miPaciente.setGrupoSanguineo(
						JOptionPane.showInputDialog("Ingrese el Grupo Sanguineo del Paciente " + (i + 1)));

				int

				cantMedic = Integer.parseInt(JOptionPane.showInputDialog(
						"Cuantos medicamentos a los que es alergico el paciente " + (i + 1) + " desea Registrar?"));

				
				String arregloMedicamentos[] = new String[cantMedic];
				for (int j = 0; j < arregloMedicamentos.length;

						j++) {
					arregloMedicamentos[j] = JOptionPane.showInputDialog("Ingrese el medicamento " + (j + 1));
				}

				miPaciente.setListaMedicamentos(arregloMedicamentos);
				listaPaciente.add(miPaciente);
			}
			JOptionPane.showMessageDialog(null, "El registro de Pacientes se ha realizado con exito");

		} else {
			JOptionPane.showMessageDialog(null, "Ya se han registrado los Pacientes", "ERROR",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	private void registrarEmpleado(int tipo) {
		switch (tipo) {
		case 1:
			if (listaEmpleadoPlantilla.isEmpty() == true) {
				int cantEmpleadoPlanilla = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese la cantidad de empleados por planilla a registrar"));

				for (int i = 0; i < cantEmpleadoPlanilla; i++) {
					JOptionPane.showMessageDialog(null, "Registro de datos Empleado Planilla " + (i + 1));

					asignarValoresGeneralesEmpleado("Empleado por Planilla " + (i + 1));

					EmpleadoPlantilla miEmpleadoPlanilla = new EmpleadoPlantilla();

//datos persona
					miEmpleadoPlanilla.setDni(dni);
					miEmpleadoPlanilla.setNombre(nombre);
					miEmpleadoPlanilla.setApellido(apellido);

					miEmpleadoPlanilla.setFechaNacimiento(fechaNacimiento);

					miEmpleadoPlanilla.setDireccion(direccion);
					miEmpleadoPlanilla.setCiudad(ciudad);
//datos empleado
					miEmpleadoPlanilla.setCodEmpleado(codEmpleado);
					miEmpleadoPlanilla.setNumHorasExtras(numHorasExt);
					miEmpleadoPlanilla.setFechaIngreso(fechaIngreso);

					miEmpleadoPlanilla.setArea(area);
					miEmpleadoPlanilla.setCargo(cargo);
//datos empleado planilla

					miEmpleadoPlanilla.setSalarioMensual(Double.parseDouble(JOptionPane
							.showInputDialog("Ingrese el salario mensual del empleado por Planilla " + (i + 1))));
					miEmpleadoPlanilla.setPorcentajeAdicional(Double.parseDouble(JOptionPane
							.showInputDialog("Ingrese el salario mensual del empleado por planilla" + (i + 1))));
					listaEmpleadoPlantilla.add(miEmpleadoPlanilla);

				}
				JOptionPane.showMessageDialog(null, "El registro de Empleados por Planilla se ha realizado con exito");

			} else {
				JOptionPane.showMessageDialog(null, "Ya se han registrado los empleados por Planilla", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		case 2:
			if (listaEmpleadoEventual.isEmpty() == true) {
				int

				cantEmpleadoEventual = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese la cantidad de empleados eventuales a registrar"));

				for (int i = 0; i < cantEmpleadoEventual; i++) {
					JOptionPane.showMessageDialog(null, "Registro de datos Empleado Eventual " + (i + 1));

					asignarValoresGeneralesEmpleado("Empleado Eventual " + (i + 1));

					EmpleadoEventual miEmpleadoEventual = new

					EmpleadoEventual();

//datos persona
					miEmpleadoEventual.setDni(dni);
					miEmpleadoEventual.setNombre(nombre);

					miEmpleadoEventual.setApellido(apellido);

					miEmpleadoEventual.setFechaNacimiento(fechaNacimiento);

					miEmpleadoEventual.setDireccion(direccion);
					miEmpleadoEventual.setCiudad(ciudad);
//datos empleado
					miEmpleadoEventual.setCodEmpleado(codEmpleado);
					miEmpleadoEventual.setNumHorasExtras(numHorasExt);
					miEmpleadoEventual.setFechaIngreso(fechaIngreso);

					miEmpleadoEventual.setArea(area);
					miEmpleadoEventual.setCargo(cargo);
//datos empleado eventual

					miEmpleadoEventual.setHonorariosHora(Double.parseDouble(JOptionPane
							.showInputDialog("Ingrese los honorarios hora del Empleado Eventual " + (i + 1))));
					miEmpleadoEventual.setFechaTerminoContrato(JOptionPane.showInputDialog(
							"Ingrese la fecha de terminacion de contrato del Empleado Eventual" + (i + 1)));
					listaEmpleadoEventual.add(miEmpleadoEventual);

				}
				JOptionPane.showMessageDialog(null, "El registro de Empleados Eventuales se ha realizado con exito");

			} else {
				JOptionPane.showMessageDialog(null, "Ya se han registrado los empleados Eventuales", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			}
			break;

		case 3:
			if (listaMedico.isEmpty() == true) {
				int

				cantMedicos = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Medicos a registrar"));

				for (int i = 0; i < cantMedicos; i++) {
					JOptionPane.showMessageDialog(null, "Registro de datos Medico " + (i + 1));

					asignarValoresGeneralesEmpleado("Medico " + (i + 1));

					Medico miMedico = new Medico();
//datos persona
					miMedico.setDni(dni);
					miMedico.setNombre(nombre);
					miMedico.setApellido(apellido);
					miMedico.setFechaNacimiento(fechaNacimiento);
					miMedico.setDireccion(direccion);
					miMedico.setCiudad(ciudad);
//datos empleado
					miMedico.setCodEmpleado(codEmpleado);
					miMedico.setNumHorasExtras(numHorasExt);
					miMedico.setFechaIngreso(fechaIngreso);
					miMedico.setArea(area);
					miMedico.setCargo(cargo);
//datos medico

					miMedico.setEspecialidad(
							JOptionPane.showInputDialog("Ingrese la especialidad del Medico " + (i + 1)));
					miMedico.setNumConsultorio(Integer.parseInt(
							JOptionPane.showInputDialog("Ingrese el numero de consultorio del Medico " + (i + 1))));
					listaMedico.add(miMedico);
				}
				JOptionPane.showMessageDialog(null, "El registro de Medicos se ha realizado con exito");

			} else {
				JOptionPane.showMessageDialog(null, "Ya se han registrado los Medicos", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			}
			break;
		default:
			break;
		}
	}

	private void asignarValoresGeneralesEmpleado(String tipo) {

		dni = JOptionPane.showInputDialog("Ingrese el DNI del " + tipo);
		nombre = JOptionPane.showInputDialog("Ingrese el nombre del " + tipo);

		apellido = JOptionPane.showInputDialog("Ingrese el apellido del " + tipo);

		fechaNacimiento = JOptionPane.showInputDialog("Ingrese la fecha Nacimiento del " + tipo);

		direccion = JOptionPane.showInputDialog("Ingrese la direccion del " + tipo);

		ciudad = JOptionPane.showInputDialog("Ingrese la ciudad del " + tipo);

		codEmpleado = JOptionPane.showInputDialog("Ingrese el codEmpleado del " + tipo);

		numHorasExt = JOptionPane.showInputDialog("Ingrese el num de Horas Extras del " + tipo);

		fechaIngreso = JOptionPane.showInputDialog("Ingrese la fecha Ingreso del " + tipo);

		area = JOptionPane.showInputDialog("Ingrese el area del " + tipo);
		cargo = JOptionPane.showInputDialog("Ingrese el cargo del" + tipo);
	}
}
