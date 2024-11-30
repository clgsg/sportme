
let btnRegistrarme = document.getElementById("btnRegistrarme");
btnRegistrarme.addEventListener("click", evento=>{
    registrarse();
});

let registrarse = async() => {

    let infoFormulario = {};

    infoFormulario.apodo=document.getElementById("apodo").value;
    infoFormulario.nombre=document.getElementById("nombre").value;
    infoFormulario.apellido1=document.getElementById("apellido1").value;
    infoFormulario.apellido2=document.getElementById("apellido2").value;
    infoFormulario.correo=document.getElementById("correo").value;
    infoFormulario.pwd=document.getElementById("pwd").value;

    let request = await fetch("http://localhost:8080/usr/new", 
    {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
        body: JSON.stringify(infoFormulario)
    });

}