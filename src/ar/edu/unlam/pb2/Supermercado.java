package ar.edu.unlam.pb2;

import java.util.*;

public class Supermercado {
	
	private Set <Producto> productosExistentes = new HashSet<Producto>();
	private List <Producto> stockDeProductos = new ArrayList<Producto>();
	private Map <Integer,Venta> ventas = new HashMap<Integer,Venta>();
	private String nombre;
	private Integer contadorDeVentas=0;

	
	public Supermercado(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Set<Producto> getProductosExistentes() {
		return productosExistentes;
	}
	public void setProductosExistentes(Set<Producto> productosExistentes) {
		this.productosExistentes = productosExistentes;
	}
	public List<Producto> getStockDeProductos() {
		return stockDeProductos;
	}
	public void setStockDeProductos(List<Producto> stockDeProductos) {
		this.stockDeProductos = stockDeProductos;
	}
	public Map<Integer, Venta> getVentas() {
		return ventas;
	}
	public void setVentas(Map<Integer, Venta> ventas) {
		this.ventas = ventas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getContadorDeVentas() {
		return contadorDeVentas;
	}
	public void setContadorDeVentas(Integer contadorDeVentas) {
		this.contadorDeVentas = contadorDeVentas;
	}
	
	public void ingresarProducto(Producto producto) {
		if(this.productosExistentes.contains(producto)) {
			this.stockDeProductos.add(producto);
		}else {
			this.productosExistentes.add(producto);
			this.stockDeProductos.add(producto);
		}
		
	}
	
	public Integer getStock(Integer i) {
		Integer stock = 0;
		for (Producto producto : productosExistentes) {
			if(producto.getId().equals(i)) {
				stock++;
			}
		}
		return stock;
		
	}
	
	public Integer registrarNuevaVenta(Venta v) {
		
		this.contadorDeVentas++;
		this.ventas.put(contadorDeVentas, v);
		return this.contadorDeVentas;
	}
	
	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto) throws ProductoInexistente, ProductoSinStock {
		Producto vendido=this.buscarProducto(codigoDeProducto);
		if(vendido!=null) {
			if(this.getStock(codigoDeProducto)>0) {
				actualizarStock(codigoDeProducto);
				this.ventas.get(numeroDeVenta).agregarProducto(vendido);
//				
			}else {
				throw new ProductoSinStock("Este producto no tiene stock");
			}
		}
	}
	private Producto buscarProducto(Integer codigoDeProducto) throws ProductoInexistente {
		for (Producto producto : productosExistentes) {
			if(producto.getId().equals(codigoDeProducto)) {
				return producto;
			}
		}
		throw new ProductoInexistente("No existe el producto");
	}

	private void actualizarStock(Integer codigoDeProducto) {
		for (Producto producto : productosExistentes) {
			if(producto.getId().equals(codigoDeProducto)) {
				this.productosExistentes.remove(codigoDeProducto);
				return;
			}
		} 
			
		}
	
}
