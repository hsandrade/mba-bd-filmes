<%@ include file="/WEB-INF/views/init.jsp"%>

<form name="frmSpark" id="frmSpark">
	<label for="qtdTop">Gênero: </label> <select id="selGeneros"></select>
	<div id="divLoadGenero" style="display: inline-block;"></div>

	<br>
	<button id="btExibirTabela" type="button" class="btn btn-primary">Exibir
		Tabela de Filmes</button>
</form>

<h2 class="sub-header">Tabela de Filmes</h2>

<div id="filmesWrapper">
	<table id="tblFilmes" class="table table-striped">
		<thead>
			<tr>
				<th>Título</th>
				<th align='right'>Ano</th>
				<th align='right'>Arrecadação ($)</th>
				<th>Gêneros</th>
				<th align='right'>Média votos</th>
				<th>Link IMDB</th>				
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>

<script>
	$(document).ready(
			function() {
				var btExibir = $("#btExibirTabela");
				var divLoadGenero = $("#divLoadGenero");
				var selGeneros = $("#selGeneros");

				$.ajax('/filme-spark-web/rest/generos/', {
					beforeSend : function() {
						habilitarElemento(false, selGeneros);
						habilitarElemento(false, btExibir);
						exibirLoadingBotao(true, divLoadGenero);
					},
					success : function(result) {
						selGeneros.find("option").remove().end();
						for (var i = 0; i < result.length; i++) {
							selGeneros.append("<option>" + result[i].nome
									+ "</option>")
						}
						btExibir.trigger('click');
					},
					complete : function() {
						habilitarElemento(true, selGeneros);
						habilitarElemento(true, btExibir);
						exibirLoadingBotao(false, divLoadGenero);
					}
				})
				
				selGeneros.on("change", function() {
					btExibir.trigger('click');
				});
				

				btExibir.on("click", function() {

					$.ajax('/filme-spark-web/rest/filmes/genero/'
							+ $("#selGeneros").val(), {
						beforeSend : function() {
							habilitarElemento(false, btExibir);
							exibirLoadingBotao(true, btExibir);
						},
						success : function(result) {
							var tbl = $("#tblFilmes tbody");

							tbl.find('tr').remove();
							
							for(var i=0; i < result.length; i++) {
								var filme = result[i];

								var registro = "<tr><td>" + filme.titulo + "</td><td align='right'>" + filme.ano + "</td>" 
								+ "<td align='right'>" + numeral(filme.arrecadacaoLocal).format('$0,0') + "</td>"
								+ "<td>" + filme.generos + "</td><td align='right'>" + filme.mediaVotos + "</td>"
								+ "<td><a href='" + filme.urlImdb + "' target='_blank'>" + filme.urlImdb + "</a></td></tr>";
								
								tbl.append(registro);
							}
							
							habilitarElemento(true, btExibir);
							exibirLoadingBotao(false, btExibir);
						},
						error : function() {
							habilitarElemento(true, btExibir);
							exibirLoadingBotao(false, btExibir);
						}
					});
				});
			});
</script>