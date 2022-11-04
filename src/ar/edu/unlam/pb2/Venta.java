package ar.edu.unlam.pb2;

import java.util.*;

public class Venta {
	
	private Integer dniDelComprador;
	private String nombreDelComprador;
	private Set <Producto> productosVendidos;
	
	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		super();
		this.dniDelComprador = dniDelComprador;
		this.nombreDelComprador = nombreDelComprador;
		this.productosVendidos = new HashSet<>();
	}

	public Integer getDniDelComprador() {
		return dniDelComprador;
	}

	public void setDniDelComprador(Integer dniDelComprador) {
		this.dniDelComprador = dniDelComprador;
	}

	public String getNombreDelComprador() {
		return nombreDelComprador;
	}

	public void setNombreDelComprador(String nombreDelComprador) {
		this.nombreDelComprador = nombreDelComprador;
	}

	public Set<Producto> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(Set<Producto> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}

	public void agregarProducto(Producto vendido) {
		this.productosVendidos.add(vendido);
	}
	
	public Double getImporte() {
		double importe=0.0;
		for (Producto producto : productosVendidos) {
			importe += producto.getPrecio();
		}
		return importe;
	}
}
