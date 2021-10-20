function eliminar(cedula) {
	console.log(cedula);
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/eliminar/"+cedula,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/listar";
		    	}
		    	});
		  } 
		});
}

function eliminar2() {
	
	swal({
		  title: "Su contrasenia sera enviada a su correo",
		  text: "",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		});
}

function cambiarPassword() {
	
	alert('Producto agregado');
}

function cambiarPasswordNuevo() {
	
	alert('Contrasenia cambiada');
}

function comprarSisas(){
	alert('Producto agregado al carrito');
}

function cambiarPassword1() {
	
	swal({
		  title: "Su contrasenia ha sido cambiada satisfactoriamente",
		  text: "",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		}).then((OK) => {
			if (OK) {
				$.ajax({
				   url:"/vistaCliente",
				   success: function(res) {
					  console.log(res);
				  },			
				});
			  swal("Poof! Registro eliminado!", {
				icon: "success",
			  })
			} 
		  });
}