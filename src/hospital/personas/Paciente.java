package hospital.personas;

public class Paciente extends Persona {

	private String numHistoria;
	private String sexo;
	private String grupoSanguineo;
	private String listaMedicamentos[];

	public String getNumHistoria() {
		return numHistoria;
	}

	public void setNumHistoria(String numHistoria) {
		this.numHistoria = numHistoria;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String[] getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(String listaMedicamentos[]) {
		this.listaMedicamentos = listaMedicamentos;
	}

}
