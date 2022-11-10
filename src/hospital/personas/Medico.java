package hospital.personas;

public class Medico extends EmpleadoPlantilla {

	private String especialidad;
	private int numConsultorio;

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(int numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

}
