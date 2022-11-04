package ar.edu.unlam.pb2;

public class Heladera extends Producto implements Electrodomestico{

	private Integer mesesGarantia; 
	public Heladera(Integer id, String nombre, Integer mesesGarantia,Double precio) {
		super(id, nombre, precio);
		this.mesesGarantia = mesesGarantia;
	}

	@Override
	public Integer getMesesGarantia() {
		// TODO Auto-generated method stub
		return this.mesesGarantia;
	}

}
