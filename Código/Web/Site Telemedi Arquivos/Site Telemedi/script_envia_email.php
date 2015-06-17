<?PHP

$nome	 	= $_POST['nome'];
$email		= $_POST['email'];
$ddd		= $_POST['ddd'];
$telefone	= $_POST['telefone'];
$msg	 	= $_POST['msg'];

		 
$mensagem_site = "

Envio Formulario de contato do site:

	Nome: $nome
	E-mail: $email
	DDD: $ddd
	Telefone: $telefone
	
	Mensagem do usuario: $msg
	
";

$headers = "MIME-Version: 1.0\r\n";
$headers .= "Content-type: text/plain; charset=iso-8859-1\r\n";
$headers .= "From: contato@telemedi.com.br\r\n"; //de
$headers .= "Return-Path: contato@telemedi.com.br\r\n"; //repete de

// aqui eu configuro para qual e-mail devo enviar o Formulário:
//Exemplo: mail("adriano.nenem@hotmail.com", "Formulario do Site", $mensagem_site, $headers);

mail("contato@telemedi.com.br", "Formulario do Site", $mensagem_site, $headers);


echo
"<script language='javascript'>
 alert('Obrigado por entrar em contato. Em breve entraremos em contato.');
 location = 'contato.html';
</script> 
";
				 
?>
