/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function readURL(input){
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e){
            $("#blah")
                    .attr("src", e.target.result)
                    .height((200))
        };
        reader.readAsDataURL(input.files[0]);
    }
}
function addCart(formulario) {
    var valor = formulario.elements[0].value;
    var existencias = formulario.elements[1].value;
    if (existencias > 0) {
        var url = "/carrito/agregar/" + valor;
        $("#resultsBlock").load(url);
    }
}