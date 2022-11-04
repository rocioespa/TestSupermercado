package ar.edu.unlam.pb2;

public class Remera extends Producto implements Indumentaria{

	private Integer talle;
	private String color;
 

	public Remera(Integer id, String nombre, Double precio, Integer talle, String color) {
		super(id, nombre, precio);
		this.talle = talle;
		this.color = color;
	}

	@Override
	public Integer getTalle() {
		return this.talle;
		
	}

	@Override
	public String getcolor() {
		return this.color;
		
	}

}
