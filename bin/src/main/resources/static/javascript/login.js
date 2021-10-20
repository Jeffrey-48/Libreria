const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

$(".loginSpace").hide();
function mostrarLogin() {
	let text = null;
	if ($("#iniciarSesion").text()=== "Iniciar Sesion") {
		$(".loginSpace").show("swing");
		text = "Sesion"
	}else{
		$(".loginSpace").hide("linear");
		text = "Iniciar Sesion";
	}
	$("#iniciarSesion").text(text); 
}