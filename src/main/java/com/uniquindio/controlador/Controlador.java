package com.uniquindio.controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniquindio.interfaceService.ICarritoCompraService;
import com.uniquindio.interfaceService.IClienteService;
import com.uniquindio.interfaceService.IEmpleadoService;
import com.uniquindio.interfaceService.IProductoService;
import com.uniquindio.interfaces.ICarritoCompra;
import com.uniquindio.modelo.CarritoCompra;
import com.uniquindio.modelo.Cliente;
import com.uniquindio.modelo.ClienteRegistrado;
import com.uniquindio.modelo.Direccion;
import com.uniquindio.modelo.Empleado;
import com.uniquindio.modelo.Persona;
import com.uniquindio.modelo.PersonaPassword;
import com.uniquindio.modelo.Producto;
import com.uniquindio.modelo.ProductoDetalle;
import com.uniquindio.modelo.Venta;
import com.uniquindio.modelo.enviarConGMail;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IEmpleadoService service;
	
	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private IProductoService serviceProducto;
	
	@Autowired
	private ICarritoCompraService serviceCarritoCompra;
	
	private CarritoCompra miCarrito = new CarritoCompra();
	
	private List<Producto> listaP = new ArrayList<Producto>(); 
	
	private ClienteRegistrado miCR;
	
	@PostMapping("/login")
	public String logIn( @Validated Persona miE,  Model model) {
		boolean verify = service.verificar(miE.getEmail(), miE.getpassword());
		if(verify == true) {
			return "redirect:/empleado";
		}else {
			boolean verifyCliente = serviceCliente.verificarCliente(miE.getEmail(), miE.getpassword());
			if(verifyCliente == true) {
				Cliente miCliente = serviceCliente.verificarClienteRegistrado(miE.getEmail(), miE.getpassword());
				miCR = new ClienteRegistrado(miCliente.getCedula());
				return "redirect:/cliente";
			}else {
				if(miE.getEmail().equals("admin@mail") && miE.getpassword().equals("admin")) {
					return "redirect:/admin";
				}
			}
			return "redirect:/inicio";
		}
		
	}
	
	@GetMapping("/inicio")
	public String iniciar(Model model) {
		
		return "login";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Empleado> empleado = service.listar();
		model.addAttribute("Empleados", empleado);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("Empleado", new Empleado());
		return "formulario";
	}
	
	@PostMapping("/save")
	public String save(@Validated Empleado e, Model model) {
		
		service.save(e);
		return "redirect:/listar";
	}
	
	@PostMapping("/saveCliente")
	public String save(@Validated Cliente e, Model model) {
		serviceCliente.saveCliente(e);
		return "redirect:/cliente";
	}
	
	@PostMapping("/saveClienteNuevo")
	public String saveNuevo(@Validated Cliente e, Model model) {
		serviceCliente.saveCliente(e);
		return "redirect:/inicio";
	}
	
	@GetMapping("/editar/{cedula}")
	public String editar(@PathVariable Integer cedula,Model model) {
		Optional<Empleado> miE = service.listarId(cedula);
		model.addAttribute("Empleado", miE);
		return "formulario";
	}
	
	@GetMapping("/eliminar/{cedula}")
	public String delete(@PathVariable Integer cedula,Model model) {
		service.delete(cedula);
		return "redirect:/listar";
	}
	
	@GetMapping("/cliente")
	public String visualCliente(Model model) {
		return "vistaCliente";
	}
	
	@GetMapping("/empleado")
	public String visualEmpleado(Model model) {
		return "vistaEmpleado";
	}
	
	@GetMapping("/productos")
	public String listarProductos(Model model) {
		
		List<Producto> producto = serviceProducto.listarProductos();
		model.addAttribute("Productos", producto);
		return "productos";
	}
	
	@GetMapping("/recuperarPassword")
	public String recuperarPw(Model model) {
		return "recuperarPassword";
	}
	
	@PostMapping("/recuperarPw")
	public String recuperarPw(@Validated PersonaPassword e, Model model) {
		Cliente miC = serviceCliente.listarClienteId(e.getCedula());
		enviarConGMail enviar = new enviarConGMail();
		enviar.enviarConGMail(miC.getEmail(), "Su contrasenia es la siguiente", miC.getPassword());
		return "redirect:/inicio";
	}
	
	
	@GetMapping("/productosAgregar/{id_producto}")
	public String agregarProductos(@PathVariable Integer id_producto, Model model) {
		
		Producto miP = serviceProducto.buscarPorId(id_producto);
		Cliente miC = serviceCliente.listarClienteId(miCR.getId());
		Date fecha = new Date();
		listaP.add(miP);
		
		
		if(miCarrito.getMiC() == null) {
			miCarrito.setMiC(miC);
		}else {
			if(!miCarrito.getMiC().getCedula().equals(miC.getCedula())) {
				miCarrito = new CarritoCompra();
				miCarrito.setMiC(miC);
			}
		}
		
		if(miCarrito.getFechaCreacion() == null) {
			miCarrito.setFechaCreacion(fecha);
		}
		
		if(miCarrito.getSubTotal() == null) {
			miCarrito.setSubTotal((float)miP.getValor());
		}else {
			miCarrito.setSubTotal((float)miP.getValor() + miCarrito.getSubTotal()); 
		}
		
		if(miCarrito.getTotal() == null) {
			miCarrito.setTotal((float)miP.getValor());
		}else {
			miCarrito.setTotal((float)miP.getValor() + miCarrito.getTotal()); 
		}
	
		miCarrito.setProductosCarrito(listaP);
		serviceCarritoCompra.saveCarritoCompra(miCarrito);
		return "redirect:/productos";
	}
	
	@GetMapping("/admin")
	public String iniciarAdmin(Model model) {
		
		return "vistaAdmin";
	}
	
	
	
	// Productos
	
	@GetMapping("/opcionesAdminProductos")
	public String opcionesAdminProductos(Model model) {
		
		List<Producto> productos = serviceProducto.listarProductos();
		model.addAttribute("Productos", productos);
		return "opcionesAdminProductos";
	}
	
	
	@GetMapping("/nuevoProducto")
	public String agregarProducto(Model model) {
		model.addAttribute("Producto", new Producto());
		return "formularioProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String saveProducto(@Validated Producto p, Model model) {
		
		serviceProducto.save(p);
		return "redirect:/opcionesAdminProductos";
	}
	
	
	@GetMapping("/productosEliminar/{id_producto}")
	public String deleteProducto(@PathVariable Integer id_producto, Model model) {
		serviceProducto.delete(id_producto);
		return "redirect:/opcionesAdminProductos";
	}
	
	
	@GetMapping("/productosEditar/{id_producto}")
	public String editarProductos(@PathVariable Integer id_producto,Model model) {
		Optional<Producto> miP = serviceProducto.listarId(id_producto);
		model.addAttribute("Producto", miP);
		return "formularioProducto";
	}
	
	@GetMapping("/volverOpcionesAdmin")
	public String volverAdmin(Model model) {
		
		return "vistaAdmin";
	}

	
	// Cliente
	
	@GetMapping("/nuevoCliente")
	public String agregarCliente(Model model) {
		model.addAttribute("Cliente", new Cliente());
		return "formularioCliente";
	}
	
	@PostMapping("/guardarCliente")
	public String saveCliente(@Validated Cliente c, Model model) {
		
		serviceCliente.saveCliente(c);
		return "redirect:/opcionesAdminClientes";
	}
	
	@GetMapping("/opcionesAdminClientes")
	public String opcionesAdminClientes(Model model) {
		
		List<Cliente> clientes = serviceCliente.listarClientes();
		model.addAttribute("Clientes", clientes);
		return "opcionesAdminClientes";
	}
	
	@GetMapping("/clienteEliminar/{cedula}")
	public String deleteCliente(@PathVariable Integer cedula, Model model) {
		serviceCliente.delete(cedula);
		return "redirect:/opcionesAdminClientes";
	}
	
	@GetMapping("/clienteEditar/{cedula}")
	public String editarClientes(@PathVariable Integer cedula,Model model) {
		Optional<Cliente> miC = serviceCliente.listarId(cedula);
		model.addAttribute("Cliente", miC);
		return "formularioCliente";
	}
	
	// carrito compras
	
	@GetMapping("/opcionesAdminCarrito")
	public String opcionesAdminCarrito(Model model) {
		
		List<CarritoCompra> carritos = serviceCarritoCompra.listarCarritos();
		model.addAttribute("CarritoCompras", carritos);
		return "opcionesAdminCarrito";
	}
	
	@GetMapping("/opcionesAdminVenta")
	public String opcionesAdminVenta(Model model) {
		
		List<CarritoCompra> carritos = serviceCarritoCompra.listarCarritos();
		List<Venta> ventas = new ArrayList<>();
		for (CarritoCompra carritoCompra : carritos) {
			Cliente miCliente = carritoCompra.getMiC();
			List<Producto> misProductos = carritoCompra.getProductosCarrito();
			Venta miV = new Venta(carritoCompra.getId_carrito(), miCliente.getCedula(), carritoCompra.getTotal(), carritoCompra.getFechaCreacion());
			ventas.add(miV);
		}
		model.addAttribute("Ventas", ventas);
		return "opcionesAdminVenta";
	}
	
	public int contarProducto(List<Producto> lp, Integer id)
	{
		int contador = 0;
		for (Producto producto : lp) {
			if(producto.getId_producto().equals(id)) {
				contador ++;
			}
		}
		return contador;
	}
	
	
	
	
	public float hallarValorTotal(List<Producto> listaP) {
		
		float suma = 0;
		for (Producto producto : listaP) {
			suma += producto.getValor();
		}
		return suma;
	}
	
	
	
	@GetMapping("/verDetalleVenta/{id_carrito}")
	public String verDetalleVenta(@PathVariable Integer id_carrito,Model model) {
		
		List<CarritoCompra> carros = serviceCarritoCompra.listarCarritos();
		
		CarritoCompra miCarrazo = null;
		for (CarritoCompra carritoCompra : carros) {
			if(carritoCompra.getId_carrito().equals(id_carrito)) {
				miCarrazo = carritoCompra;
			}
		}
		Cliente miCliente = miCarrazo.getMiC();
		List<Producto> productos = miCarrazo.getProductosCarrito();
		List<ProductoDetalle> detalles = new ArrayList<>();
		for (Producto producto : productos) {
			int cont = contarProducto(productos, producto.getId_producto());
			ProductoDetalle miP = new ProductoDetalle(miCliente.getCedula(), producto.getNombre(), producto.getDescripcion(), producto.getValor(),
					8,miCarrazo.getFechaCreacion());
			
			detalles.add(miP);
		}
		model.addAttribute("DetalleVentas", detalles);
		return "verDetalleProductos";
	}
	
	@GetMapping("/volverOpcionesAdminVenta")
	public String volverAdminVenta(Model model) {
		
		return "redirect:/opcionesAdminVenta";
	}
	
	// Cliente
	
	@GetMapping("/opcionesCliente")
	public String opcionesCliente(Model model) {
		
		return "vistaCliente";
	}
	
	@GetMapping("/gestionarDirecciones")
	public String gestionarDirecciones(Model model) {
		Cliente miC = serviceCliente.listarClienteId(miCR.getId());
		if(miC.getDireccion() == null || miC.getDireccion().equals("")) {
			model.addAttribute("Cliente", miC);
			return "crearDirecciones";
			
		}
		
		model.addAttribute("Clientes", miC);
		return "gestionarDirecciones";
	}
	
	@PostMapping("/guardarDireccion")
	public String guardarDireccion(@Validated Cliente miC, Model model) {
		serviceCliente.saveCliente(miC);
		return "redirect:/gestionarDirecciones";
	}
	
	@GetMapping("/direccionEditar")
	public String editarDireccion(Model model) {
		Cliente miC = serviceCliente.listarClienteId(miCR.getId());
		model.addAttribute("Cliente", miC);
		return "crearDirecciones";
	}
	
	
	@GetMapping("/direccionEliminar")
	public String eliminarDireccion (Model model) {
		
		Cliente miC = serviceCliente.listarClienteId(miCR.getId());
		miC.setDireccion("");
		serviceCliente.saveCliente(miC);
		return "vistaCliente";
	}
	
	
	@GetMapping("/cambiarPassword")
	public String editarPassword(Model model) {
		Cliente miC = serviceCliente.listarClienteId(miCR.getId());
		model.addAttribute("Cliente", miC);
		return "formularioPassword";
	}
	
	@PostMapping("/editarPassword")
	public String guardarPassword(@Validated Cliente miC, Model model) {
		serviceCliente.saveCliente(miC);
		return "vistaCliente";
	}
	
	@GetMapping("/listarCarros")
	public String listarCarros(Model model) {
		Cliente miC = serviceCliente.listarClienteId(miCR.getId());
		List<CarritoCompra> misCarros = miC.getMisCarros(); 
		model.addAttribute("CarritoCompras", misCarros);
		return "opcionesCarritosClientes";
	}
	
	@GetMapping("/volverVistaCliente")
	public String volverVistaCliente(Model model) {
		return "vistaCliente";
	}
	
	public List<ProductoDetalle> eliminarRepetidos(List<ProductoDetalle> listaP){
		
		System.out.println(listaP.size());
		List<ProductoDetalle> miLista = new ArrayList<>();
		for (ProductoDetalle productoDetalle : listaP) {
			String name = productoDetalle.getNombre_producto();
			System.out.println(name + "XD");
			int aux = 0;
			int i = 0;
			for (ProductoDetalle productoDetalle2 : listaP) {
				System.out.println(productoDetalle2.getNombre_producto() + "XD2");
				if(name.equals(productoDetalle2.getNombre_producto())) {
					aux ++;
				}
				if(aux == 1) {
					System.out.print(productoDetalle.getNombre_producto() + "Resisas");
					miLista.add(productoDetalle);
				}
				if(aux > 1) {
					listaP.remove(i);
				}
				i ++;
			}
			
			
		}
		return miLista;
	}
	
	@GetMapping("/verDetalleCarritoCliente/{id_carrito}")
	public String verDetalleCarritoCliente(@PathVariable Integer id_carrito,Model model) {
		
		List<CarritoCompra> carros = serviceCarritoCompra.listarCarritos();
		
		CarritoCompra miCarrazo = null;
		for (CarritoCompra carritoCompra : carros) {
			if(carritoCompra.getId_carrito().equals(id_carrito)) {
				miCarrazo = carritoCompra;
			}
		}
		Cliente miCliente = miCarrazo.getMiC();
		List<Producto> productos = miCarrazo.getProductosCarrito();
		List<ProductoDetalle> detalles = new ArrayList<>();
		for (Producto producto : productos) {
			ProductoDetalle miP = new ProductoDetalle(miCliente.getCedula(), producto.getNombre(), producto.getDescripcion(), producto.getValor(),
					1,miCarrazo.getFechaCreacion());
			
			detalles.add(miP);
		}
		model.addAttribute("DetalleVentas", detalles);
		return "verDetalleCarritoCliente";
	}
	
	@GetMapping("/volverOpcionesCarritosClientes")
	public String volverOpcionesCarritosCliente (Model model) {
		return "redirect:/listarCarros";
	}
}
