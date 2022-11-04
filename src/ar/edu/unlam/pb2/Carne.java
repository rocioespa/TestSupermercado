package ar.edu.unlam.pb2;

public class Carne extends Producto implements Comestible{

	private String f_elaboracion;
	private String f_vencimiento;

	public Carne(Integer id, String nombre, String f_elaboracion,String f_vencimiento,Double precio) {
		super(id, nombre, precio);
		this.f_elaboracion = f_elaboracion;
		this.f_vencimiento = f_vencimiento;
	}

	@Override
	public String getFechaElaboracion() {
		
		return this.f_elaboracion;
	}

	@Override
	public String getFechaVencimiento() {
		
		return this.f_vencimiento;
	}

}
