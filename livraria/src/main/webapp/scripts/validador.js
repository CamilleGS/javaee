/**
 * validação de formulario
 */

function validar(){
	let nome = frmLivro.nome.value
	let autor = frmLivro.autor.value
	let valor = frmLivro.valor.value	
	
	if(nome === ""){
		alert("preencha o campo nome")
		frmLivro.nome.focus()
		return false
	}else if(autor === ""){
			alert("preencha o campo autor")
			frmLivro.autor.focus()
			return false
	}else if(valor === ""){
				alert("preencha o campo valor")
				frmLivro.valor.focus()
				return false
	}else {
		document.forms["frmLivro"].submit()
	}
}