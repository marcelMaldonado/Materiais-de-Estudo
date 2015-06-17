function valida(){
	var saida=true;
	if((document.form.nome.value=="")||(document.form.nome.value.length < 5)){
		alert("Digite seu nome completo!");
		document.form.nome.focus();
		saida=false;
	}
	if((document.form.email.value=="")||(document.form.email.value.length < 8)){
		alert("Digite um e-mail válido!");
		document.form.email.focus();
		saida=false;
	}
	if((document.form.ddd.value=="")||(isNaN(document.form.ddd.value)==true)){
		alert("Digite um ddd válido para seu telefone!");
		document.form.ddd.focus();
		saida=false;
	}
	if((document.form.telefone.value=="")||(isNaN(document.form.telefone.value)==true)){
		alert("Digite um número de telefone válido!");
		document.form.telefone.focus();
		saida=false;
	}
	if(document.form.msg.value==""){
		alert("Digite uma mensagem!");
		document.form.msg.focus();
		saida=false;
	}
	return saida;
}

