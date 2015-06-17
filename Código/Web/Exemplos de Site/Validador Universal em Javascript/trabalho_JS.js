// JavaScript Document
/*
* @Validador Universal
* @copyleft (cc) 2008 UNIFACS - Desenvolvimento Web Sites - Turma 04. Alguns direitos reservados
* @licence http://www.gnu.org/licence/lgpl.html LGPL Licence
* @author Lucas Figueiredo - lukas.figueiredo@hotmail.com
* @author Gustavo Ramalho - gustavo@xisweb.com.br
* @author Elton Augusto - elton18augusto@hotmail.com
* @author Anderson Andrade - andrades23@gmail.com


CARACTERISTICAS DO VALIDADOR

* bloqeia digito de caracteres pré-definidos, nos campos numericos como CEP ipedi o digito de letras e em campos especifico de texto
como nome bloueia o digito de números
* valida cep de acordo com o estado
* valida CPF
* valida Data
* valida senha com restrição minima de 3 caracteres
* auto completar nos campos: CEP,CPF,RG,Data
* valida campo radio, checkbox no sbmit do formulário


// JavaScript Document
*/


//função que é chamda no onfocus e retorna mensagem na div correspondente ao campo
function informa(Ncampo)
{
var campo=document.getElementById('resposta'+Ncampo);
	//se campo Ncampo = cep retira o hífen
	if(Ncampo == 'nome')
	{
		campo.innerHTML="informe um nome com mínimo 3 caracteres";
	}
	if(Ncampo == 'senha')
	{
		campo.innerHTML="informe senha de 3 a 6 caracteres";
	}
	
	if(Ncampo == 'uf')
	{
		document.getElementById('respostacep').innerHTML="";
	}
	
	if(Ncampo == 'cep')
	{
		if(document.getElementById('uf').value=="selecione")
		{
			campo.innerHTML="selecione o estado antes de informar o CEP";
			return false;
		}else
		campo.innerHTML="somente números, 8 digitos";
	}
	 //se Ncampo = CPF retira os pontos e hífen
	if(Ncampo == 'cpf')
	{
		campo.innerHTML="somente números, 11 digitos";
	}	
	
	//se Ncampo = reg retira híifen
	if(Ncampo == 'rg')
	{
		campo.innerHTML="somente numeros, 10 digitos";
	}
	//se Ncampo = data retira as barras '/'
	if(Ncampo == 'data')
	{
		campo.innerHTML="formato dd/mm/aaaa";
	}
	if(Ncampo == 'email')
		campo.innerHTML="informe o e-mail";
	
}



//função que restringe caracteres digitados. Números ou letras
function valida_digitos(Ncampo)
{
		 //caracteres permitidos
		 if(Ncampo=="nome")
		 er=/[0-9]/;
		 if(Ncampo=="cep" || Ncampo=="cpf" || Ncampo=="rg")
		 er=/[a-z]/;		 
		 digito=document.getElementById(Ncampo).value;
		 var tempor;
		 
		  for (var i=0;i<digito.length; i++) {
			tempor = digito.substring(i,i+1); 
			//se digitos não igual aos caracteres informado na variavel digitos, então é deletado
			  if (er.test(digito)) {
			  document.getElementById(Ncampo).value=digito.substring(0,digito.length-1);
			 
			 return false;
			  break;
    		}
   		}
 }






//função que retorna o erro na div correspondente ao campo, uando a vlaidação falha
function erro(Ncampo)
{
	//if(Ncampo=="nome")
	//resposta="nome deve ter no minimo 3 caracteres";
	if(Ncampo=="cpf")
	resposta="número de CPF inválido";
	
	/*document.getElementById('resposta'+Ncampo).innerHTML="nome deve ter no minimo 3 caracteres";
	document.getElementById(Ncampo).style.background="red";
	document.getElementById(Ncampo).focus();
	return false;
	}*/
	document.getElementById(Ncampo).style.background="red";
	document.getElementById('resposta'+Ncampo).innerHTML="informe " + Ncampo;
	document.getElementById(Ncampo).focus();
	return false;
}
//fnção que formata o campo se a validação estiver ok
function ok(Ncampo)
{
	document.getElementById(Ncampo).style.background="#98EE84";
	document.getElementById('resposta'+Ncampo).innerHTML="";
	return true;
}





//função que é chamda no submit, valida os campos em geral, veificandos se estão vazios e os botões de radio e checkbox
function valida_enviar(campo){
	
	d=document.getElementById('uf').value;
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('nome','senha','cep','cpf','rg','data','email');
	for(i=0;i<campos.length;i++)
	{	
		/*if(campos[i]=='nome')
		{
			if(document.getElementById(campos[i]).value.length < 3)
			{
				document.getElementById('resposta'+campos[i]).innerHTML="informe o "+campos[i];
				conta++;
			}	
		}*/	
		if(campos[i]=='email')
		{
			var er=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
			if(!er.test(document.getElementById(campos[i]).value))
			{
				//alert("informe o e-mail correto")
				document.getElementById('resposta'+campos[i]).innerHTML="informe o e-mail correto";
//				document.getElementById(campos[i]).style.background="red";
				conta++;
			}
		}
			/*if(!er.test(b))
				{	
					return erro(Ncampo);			
				}		
				//se Ncamp
			
			if(document.getElementById(campos[i]).value.length < 3)
			{
				document.getElementById('resposta'+campos[i]).innerHTML="informe o "+campos[i];
				conta++;
			}	
		}*/
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="informe "+campos[i];
			conta++;
		}
			
	}			
	
	
	
	//se  botão radio não selecionado, não passa e retorna alert
	if (campo.sexo[0].checked!=true && campo.sexo[1].checked!=true)
	{ 
			document.getElementById('respostasexo').innerHTML="selecione o sexo";
			conta++;
	}
	
	//se campo select opção=selecione, não passa e retorna alert
	if(d == "selecione")
	{
			document.getElementById('respostauf').innerHTML="selecione o Estado";
			conta++;
	}
	//se campo checkbox não selecionado, não passa e retorna alert
	if (campo.assinar.checked!=true)
	{ 
			document.getElementById('respostaassinar').innerHTML="confirme a informação, clicando na caixa ao lado";
			conta++;
	}
			if(conta==0)
			return true;
			else
			return false;
	//return true;
}	
	


//função que limpa a div correspondente a checkbox, radio e select quando não vazios
function limpaID(ID)
{
document.getElementById('resposta'+ID).innerHTML="";
}



//função que valida o cep de acorodo com o estado selecionado, é feito um loop e de acorodo com o indice do estado é verificado
//a expressão regular correspondente ao cep no indice
function valida_cep(Ncampo)
{
	var er;
	var cep = document.getElementById(Ncampo).value;
	var uf=new Array('AM','SP','RJ','MS','MG','MT','AC','AL','AP','CE','DF','ES','GO','MA','PA','PE','PI','PR','RN','RO','RR','RS','SC','SE','TO','BA');
	var ers=new Array(/^[6][9][0-8][0-9]{2}-[0-9]{3}$/,/^([1][0-9]{3}|[01][0-9]{4})-[0-9]{3}$/,/^[2][0-8][0-9]{3}-[0-9]{3}$/,
	/^[2][0-8][0-9]{3}-[0-9]{3}$/,/^[2][0-8][0-9]{3}-[0-9]{3}$/,/^[7][8][8][0-9]{2}-[0-9]{3}$/,/^[6][9]{2}[0-9]{2}-[0-9]{3}$/,
	/^[5][7][0-9]{3}-[0-9]{3}$/,/^[6][89][9][0-9]{2}-[0-9]{3}$/,/^[6][0-3][0-9]{3}-[0-9]{3}$/,/^[7][0-3][0-6][0-9]{2}-[0-9]{3}$/,
	/^[2][9][0-9]{3}-[0-9]{3}$/,/^[7][3-6][7-9][0-9]{2}-[0-9]{3}$/,/^[6][5][0-9]{3}-[0-9]{3}$/,/^[6][6-8][0-8][0-9]{2}-[0-9]{3}$/,
	/^[5][0-6][0-9]{2}-[0-9]{3}$/,/^[6][4][0-9]{3}-[0-9]{3}$/,/^[8][0-7][0-9]{3}-[0-9]{3}$/,/^[5][9][0-9]{3}-[0-9]{3}$/,
	/^[7][8][9][0-9]{2}-[0-9]{3}$/,/^[6][9][3][0-9]{2}-[0-9]{3}$/,/^[9][0-9]{4}-[0-9]{3}$/,/^[8][89][0-9]{3}-[0-9]{3}$/,
	/^[4][9][0-9]{3}-[0-9]{3}$/,/^[7][7][0-9]{3}-[0-9]{3}$/,/^[4][0-8][0-9]{3}-[0-9]{3}$/);
	
		
		//document.getElementById('resposta'+Ncampo).innerHTML="";
			
	/*if(document.getElementById('uf').value=="selecione")
	{
		document.getElementById('resposta'+Ncampo).innerHTML="selecione o estado";
		return false;
	}*/
	if(document.getElementById('uf').value=="selecione" && document.getElementById('cep').value!="")
	{
		document.getElementById(Ncampo).style.background="red";
		document.getElementById(Ncampo).innerHTML ="selecione o estado antes de informar o CEP";
		return false;
	}
	
	for(i=0;i<uf.length;i++)
	{	
			if(uf[i]==document.getElementById('uf').value)
			{	
				if(cep!="")
				{	
					er=ers[i];
					if(!er.test(cep))
					{	
						return erro(Ncampo);						
					}		
					else
					{	
						return ok(Ncampo);					
					}
				}
				

		 }	document.getElementById(Ncampo).style.background="#FFFFFF";
			document.getElementById('resposta'+Ncampo).innerHTML="";
	}	
}


//valida os campos
function valida_campos(Ncampo)

{   
		//de acorodo com o campo a var er recebe uma expressão regular que vai vlaidar o campo exceto  CPF,CEP e Data que valida atrave da função
		//validar_CPF()		
			if(Ncampo=="senha")
				var er =/^\w{3,6}$/;
			if(Ncampo=="rg")
				var er =/^[0-9]{8}-[0-9]{2}$/;		
			if(Ncampo=="nome")
				var er=/[a-zA-Z]{3,}/;
			if(Ncampo=="email")
				  var er=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
				
			 b=document.getElementById(Ncampo).value;
			if(b != "")
			{ 
				if(!er.test(b))
				{	
					return erro(Ncampo);			
				}		
				//se Ncampo passar na ER, então é feita a formatação do campo CEP = xxxxx-xxx
				else
				{	
					return ok(Ncampo);					
				}
			}
			document.getElementById(Ncampo).style.background="#FFFFFF";
	 		document.getElementById('resposta'+Ncampo).innerHTML="";
			
}   





//function que valida, data pelo formato xx/xx/xxxx e verifica se a data existe
function validar_Data(Ncampo){

var er = /^(([0-2]\d|[3][0-1])\/([0]\d|[1][0-2])\/[1-2][0-9]\d{2})$/;
b=document.getElementById(Ncampo).value;
document.getElementById(Ncampo).style.background="#FFFFFF";
document.getElementById('resposta'+Ncampo).innerHTML="";
if(b!=""){
if(er.test(b)){

var dia = b.substring(0,2);
var mes = b.substring(3,5);
var ano = b.substring(6,10);
	
	if(ano < 1940)
	{
		alert("O ano especificado não é valido");
		document.getElementById(Ncampo).style.background="red";
		//document.getElementById('resposta'+Ncampo).innerHTML="O ano especificado não é válido";
		document.getElementById(Ncampo).focus();
		return false;
	}
	
		if((mes==04 || mes==06 || mes==09 || mes==11) && (dia > 30)){
			document.getElementById(Ncampo).style.background="red";
			alert("O mês especificado contém no máximo 30 dias");
			//document.getElementById('resposta'+Ncampo).innerHTML="O mês especificado contém no máximo 30 dias";
			document.getElementById(Ncampo).focus();
			return false;
		} else
		{
		if(ano%4!=0 && mes==02 && dia>28){
			document.getElementById(Ncampo).style.background="red";
			alert("Data incorreta!! O mês especificado contém no máximo 28 dias.");
			//document.getElementById('resposta'+Ncampo).innerHTML="Data incorreta!! O mês especificado contém no máximo 28 dias.";
			document.getElementById(Ncampo).focus();
			return false;
		} else{
		if(ano%4==0 && mes==02 && dia>29){
			document.getElementById(Ncampo).style.background="red";
			alert("Data incorreta!! O mês especificado contém no máximo 29 dias");
			//document.getElementById('resposta'+Ncampo).innerHTML="Data incorreta!! O mês especificado contém no máximo 29 dias";
			document.getElementById(Ncampo).focus();
			return false;
		} else{ 
		//alert ("Data correta!");
		return ok(Ncampo);
		}}}} else {
			document.getElementById(Ncampo).style.background="red";
			//alert("Formato inválido de data");
			document.getElementById('resposta'+Ncampo).innerHTML="Formato inválido de data";
			document.getElementById(Ncampo).focus();
			return false;
		}
		}
		document.getElementById(Ncampo).style.background="#FFFFFF";
		document.getElementById('resposta'+Ncampo).innerHTML="";
}




//função que valida o cpf
function validar_CPF(Ncampo)   
{   	
		erro = new String;   
  		cpf=document.getElementById(Ncampo);
        if (cpf.value.length == 14)   
   		 {     
				cpf.value = cpf.value.replace('.', '');   
				cpf.value = cpf.value.replace('.', '');   
				cpf.value = cpf.value.replace('-', ''); 
	  
				var nonNumbers = /\D/;   
				
				if (nonNumbers.test(cpf.value))   
				{   
						erro = "A verificacao de CPF suporta apenas números!";   
				}   
				else   
				{   
						if (cpf.value == "00000000000" ||   
								cpf.value == "11111111111" ||   
								cpf.value == "22222222222" ||   
								cpf.value == "33333333333" ||   
								cpf.value == "44444444444" ||   
								cpf.value == "55555555555" ||   
								cpf.value == "66666666666" ||   
								cpf.value == "77777777777" ||   
								cpf.value == "88888888888" ||   
								cpf.value == "99999999999") {   
								   
								erro = "Número de CPF inválido 1!"   
								//document.getElementById(Ncampo).value = cpf.value;
						}   
						
						
						var a = [];   
						var b = new Number;   
						var c = 11;   
	  
						for (i=0; i<11; i++){   
								a[i] = cpf.value.charAt(i);   
								if (i < 9) b += (a[i] * --c);   
						}   
		   
						if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }   
						b = 0;   
						c = 11;   
		   
						for (y=0; y<10; y++) b += (a[y] * c--);   
		   
						if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }   
		   
						if ((cpf.value.charAt(9) != a[9]) || (cpf.value.charAt(10) != a[10])) {   
							erro = "Número de CPF inválido.";  
							//document.getElementById(Ncampo).value = cpf.value; 
						}   
				}   
		}   
		else   
		{   
			if(cpf.value.length == 0)  
			{
				document.getElementById('resposta'+Ncampo).innerHTML="";
				document.getElementById(Ncampo).style.background="#FFFFFF" 
				return false;   
			}
			else   
				erro = "Número de CPF inválido.";   
		}   
		if (erro.length > 0) {   
				alert(erro);   

				if (cpf.value.length == 11)   
				{     
					str = cpf.value;
					str2 = cpf.value.substring(0,3);
					str3 = cpf.value.substring(3,6);
					str4 = cpf.value.substring(6,9);
					str5 = cpf.value.substring(9,12);
					result=str.replace(str,str2+'.');
					result2=str.replace(str,str3+'.');
					result3=str.replace(str,str4+'-');
					document.getElementById(Ncampo).value = result + result2 + result3 + str5;
					document.getElementById(Ncampo).style.background="red";
					document.getElementById(Ncampo).focus(); 
					return false;   
				}				
			
				document.getElementById(Ncampo).value = cpf.value;
				document.getElementById(Ncampo).style.background="red";
				document.getElementById(Ncampo).focus(); 
				return false;   
		}     
		document.getElementById(Ncampo).style.background="#98EE84";
		document.getElementById('resposta'+Ncampo).innerHTML="";
		str = cpf.value;
		str2 = cpf.value.substring(0,3);
		str3 = cpf.value.substring(3,6);
		str4 = cpf.value.substring(6,9);
		str5 = cpf.value.substring(9,12);
		result=str.replace(str,str2+'.');
		result2=str.replace(str,str3+'.');
		result3=str.replace(str,str4+'-');
		document.getElementById(Ncampo).value = result + result2 + result3 + str5;
		return true;       
}   




//função que formata os campos - auto completa os campos cep,cpf,rg e data
function formata(Ncampo)
{
	var campo=document.getElementById(Ncampo).value;
	var str;
	var str2;
	var str3;

	if(Ncampo=='cep')
	{	
		if(campo.length==5)
		{	
			var str = campo.substring(0,5);
			document.getElementById(Ncampo).value = str+"-";
		}
	}
	if(Ncampo=='rg')
	{	
		if(document.getElementById(Ncampo).value.length==8)
		{	
			var str = document.getElementById(Ncampo).value.substring(0,8);
			document.getElementById(Ncampo).value = str+"-";
		}
	}
	
	if(Ncampo=='data')
	{	
		if(document.getElementById(Ncampo).value.length==2)
		{	
			var str = document.getElementById(Ncampo).value.substring(0,2);
			pt1=document.getElementById(Ncampo).value = str+"/";
		}
		if(document.getElementById(Ncampo).value.length==5)
		{	
			var str2 = document.getElementById(Ncampo).value.substring(3,5);
			pt2=document.getElementById(Ncampo).value = pt1+str2+"/";
		}
	}
	
	if(Ncampo=="cpf")
	{
		if(document.getElementById(Ncampo).value.length==3)
			{
				
				valor=document.getElementById(Ncampo).value;
				str = document.getElementById(Ncampo).value.substring(0,3);
				result=valor.replace(valor,str+'.');
				document.getElementById(Ncampo).value = result;
			}
		if(document.getElementById(Ncampo).value.length==7)
			{
				valor1=document.getElementById(Ncampo).value;
				str2 = document.getElementById(Ncampo).value.substring(4,8);
				result2=valor1.replace(valor1,str2+'.');
				document.getElementById(Ncampo).value = result + result2;
			}
		if(document.getElementById(Ncampo).value.length==11)
			{
				valor2=document.getElementById(Ncampo).value;
				str3 = document.getElementById(Ncampo).value.substring(8,11);

				result3=document.getElementById(Ncampo).value = result + result2 + str3 + "-";
			}
		if(document.getElementById(Ncampo).value.length==15)
			{
				valor3=document.getElementById(Ncampo).value;
				str3 = document.getElementById(Ncampo).value.substring(12,15);
				result4=valor3.replace(valor3,str3);
				document.getElementById(Ncampo).value = result + result2 + result3 + result4;
			}
					
	}
	
}