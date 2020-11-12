$(function(){
	var modal = $('#modalCadastroRapidoEstilo');
	var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
	var form = modal.find("form");
	form.on('submit', function(event) {event.preventDefault()});	//prevenir que o usuário consiga submeter o estilo quando estiver vazio
	var url = form.attr('action');
	var inputNomeEstilo = $('#nomeEstilo');
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');

	modal.on('show.bs.modal', onModalShow);	//faz com que tenha o foco na caixa de texto
	modal.on('hide.bs.modal', onModalClose);	// faz com que ao fechar o modal o que estiver na caixa de texto seja deletado
	botaoSalvar.on('click', onBotaoSalvarClick);



	function onModalShow(){
		inputNomeEstilo.focus();
	}

	function onModalClose(){	//para deletarmos, trocamos o que está escrito pela string vazia abaixo
		inputNomeEstilo.val('');
		containerMensagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}

	function onBotaoSalvarClick(){
		var nomeEstilo = inputNomeEstilo.val().trim();
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({'nome': nomeEstilo}),
			error: onErroSalvandoEstilo,
			success: onEstiloSalvo
		});
	}

	function onErroSalvandoEstilo(obj){
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden');
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}

	function onEstiloSalvo(estilo){
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value='+ estilo.codigo + '>' + estilo.nome + '</option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
	}


});