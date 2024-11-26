/**
 * 
 */

function confirmar(id) {

	let resposta = confirm("confirmar exclusão")
	if (resposta) {
		window.location.href = "delete?id=" + id
	}


}