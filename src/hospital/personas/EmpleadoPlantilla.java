package hospital.personas;

public class EmpleadoPlantilla extends Empleado{

	private double salarioMensual;
	private double porcentajeAdicional;

	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	public double getPorcentajeAdicional() {
		return porcentajeAdicional;
	}

	public void setPorcentajeAdicional(double porcentajeAdicional) {
		this.porcentajeAdicional = porcentajeAdicional;
	}

}
