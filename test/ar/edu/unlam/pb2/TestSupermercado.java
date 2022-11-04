package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSupermercado {

	@Test
	public void queSePuedaCrearUnSupermecado() {
		Supermercado s = new Supermercado("Nina");
		assertNotNull(s);
	}
	
	
	@Test
	public void queSePuedaCrearUnProducto() {
		Carne c = new Carne(021,"Carne Vacuna","22/06/2021", "31/01/2022",1030.0);
		assertNotNull(c);
	}
	
	@Test
	public void queSePuedaCrearUnStockDeProductos() {
		Supermercado s = new Supermercado("Nina");
		Carne c = new Carne(021,"Carne Vacuna","22/06/2021", "31/01/2022",1030.0);
		Carne c1 = new Carne(021,"Carne Pollo","22/06/2021", "31/01/2022",1030.0);
		Carne c2 = new Carne(021,"Carne Cerdo", "07/07/2021", "15/07/2021",1030.0);
		Heladera h = new Heladera (122,"Heladera Chica",12,20000.0);
		Heladera h2 = new Heladera (122,"Heladera Grande",12,20000.0);
		Remera r = new Remera(323,"Remera corta",750.0,40,"azul");
		Remera r1 = new Remera(323,"Remera Larga",750.0,40,"blanca");
		Remera r2 = new Remera(323,"Remera musculosa",750.0,40,"negra");
		Remera r3 = new Remera(323,"Remera top",750.0,40,"rojo");
		Remera r4 = new Remera(323,"Remera corta",750.0,40,"gris");
		s.ingresarProducto(c);
		s.ingresarProducto(c1);
		s.ingresarProducto(c2);
		s.ingresarProducto(h);
		s.ingresarProducto(h2);
		s.ingresarProducto(r);
		s.ingresarProducto(r1);
		s.ingresarProducto(r2);
		s.ingresarProducto(r3);
		s.ingresarProducto(r4);
		assertEquals(10, s.getStockDeProductos().size());
		assertEquals((Integer)3, s.getStock(021));
		assertEquals((Integer)2, s.getStock(122));
		assertEquals((Integer)5, s.getStock(323));
	}
	
	@Test
	public void queSePuedaGenerarUnaVenta() throws ProductoInexistente, ProductoSinStock {
		Supermercado s = new Supermercado("Nina");
		Carne c = new Carne(021,"Carne Vacuna","22/06/2021", "31/01/2022",1030.0);
		Carne c1 = new Carne(021,"Carne Pollo","22/06/2021", "31/01/2022",1030.0);
		Carne c2 = new Carne(021,"Carne Cerdo", "07/07/2021", "15/07/2021",1030.0);
		Heladera h = new Heladera (122,"Heladera Chica",12,20000.0);
		Heladera h2 = new Heladera (122,"Heladera Grande",12,20000.0);
		Remera r = new Remera(323,"Remera corta",750.0,40,"azul");
		Remera r1 = new Remera(323,"Remera Larga",750.0,40,"blanca");
		Remera r2 = new Remera(323,"Remera musculosa",750.0,40,"negra");
		Remera r3 = new Remera(323,"Remera top",750.0,40,"rojo");
		Remera r4 = new Remera(323,"Remera corta",750.0,40,"gris");
		s.ingresarProducto(c);
		s.ingresarProducto(c1);
		s.ingresarProducto(c2);
		s.ingresarProducto(h);
		s.ingresarProducto(h2);
		s.ingresarProducto(r);
		s.ingresarProducto(r1);
		s.ingresarProducto(r2);
		s.ingresarProducto(r3);
		s.ingresarProducto(r4);
		Venta v = new Venta(434478829, "Rocio España");
		Integer numeroDeVenta = s.registrarNuevaVenta(v);
		
		s.agregarAlCarrito(numeroDeVenta, 323);
		s.agregarAlCarrito(numeroDeVenta, 021); 
		assertEquals((Double)1780.0, v.getImporte());
		
	}
	
	@Test (expected = ProductoInexistente.class)
	public void queNoSePuedaVenderUnProductoInexistente() throws ProductoSinStock, ProductoInexistente {
		Supermercado s = new Supermercado("Nina");
		Carne c = new Carne(021,"Carne Vacuna","22/06/2021", "31/01/2022",1030.0);
		Carne c1 = new Carne(021,"Carne Pollo","22/06/2021", "31/01/2022",1030.0);
		Carne c2 = new Carne(021,"Carne Cerdo", "07/07/2021", "15/07/2021",1030.0);
		Heladera h = new Heladera (122,"Heladera Chica",12,20000.0);
		Heladera h2 = new Heladera (122,"Heladera Grande",12,20000.0);
		Remera r = new Remera(323,"Remera corta",750.0,40,"azul");
		Remera r1 = new Remera(323,"Remera Larga",750.0,40,"blanca");
		Remera r2 = new Remera(323,"Remera musculosa",750.0,40,"negra");
		Remera r3 = new Remera(323,"Remera top",750.0,40,"rojo");
		Remera r4 = new Remera(323,"Remera corta",750.0,40,"gris");
		s.ingresarProducto(c);
		s.ingresarProducto(c1);
		s.ingresarProducto(c2);
		s.ingresarProducto(h);
		s.ingresarProducto(h2);
		s.ingresarProducto(r);
		s.ingresarProducto(r1);
		s.ingresarProducto(r2);
		s.ingresarProducto(r3);
		s.ingresarProducto(r4);
		
		Venta v = new Venta(434478829, "Rocio España");
		Integer numeroDeVenta = s.registrarNuevaVenta(v);
		
		s.agregarAlCarrito(numeroDeVenta, 1);
		s.agregarAlCarrito(numeroDeVenta, 11);
		
	}
	
	@Test (expected = ProductoSinStock.class)
	public void queNoSePuedaVenderUnProductoSinStock() throws ProductoSinStock, ProductoInexistente {
		Supermercado s = new Supermercado("Nina");
		Carne c = new Carne(021,"Carne Vacuna","22/06/2021", "31/01/2022",1030.0);
		Carne c1 = new Carne(021,"Carne Pollo","22/06/2021", "31/01/2022",1030.0);
		Carne c2 = new Carne(021,"Carne Cerdo", "07/07/2021", "15/07/2021",1030.0);
		Heladera h = new Heladera (122,"Heladera Chica",12,20000.0);
		Heladera h2 = new Heladera (122,"Heladera Grande",12,20000.0);
		Remera r = new Remera(323,"Remera corta",750.0,40,"azul");
		Remera r1 = new Remera(323,"Remera Larga",750.0,40,"blanca");
		Remera r2 = new Remera(323,"Remera musculosa",750.0,40,"negra");
		Remera r3 = new Remera(323,"Remera top",750.0,40,"rojo");
		Remera r4 = new Remera(323,"Remera corta",750.0,40,"gris");
		s.ingresarProducto(c);
		s.ingresarProducto(c1);
		s.ingresarProducto(c2);
		s.ingresarProducto(h);
		s.ingresarProducto(h2);
		s.ingresarProducto(r);
		s.ingresarProducto(r1);
		s.ingresarProducto(r2);
		s.ingresarProducto(r3);
		s.ingresarProducto(r4);
		
		Venta v = new Venta(434478829, "Rocio España");
		Integer numeroDeVenta = s.registrarNuevaVenta(v);
		s.agregarAlCarrito(numeroDeVenta, 1);
		s.agregarAlCarrito(numeroDeVenta, 1);
		s.agregarAlCarrito(numeroDeVenta, 1);
	}
}
