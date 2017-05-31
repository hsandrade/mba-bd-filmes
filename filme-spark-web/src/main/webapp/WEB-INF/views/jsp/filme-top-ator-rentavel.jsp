<%@ include file="/WEB-INF/views/init.jsp"%>

<form name="frmSpark" id="frmSpark">
	<label for="qtdTop">Quantidade de filmes: </label> <input name="qtdTop"
		id="qtdTop" type="number" value="10" max="20"> <br>
	<button id="btExibirGrafico" type="button"
		class="btn btn-primary">Exibir Gráfico</button>
</form>

<div id="chartSpark"></div>

<script>
	var chartData;
	var chart = null;

	$(document).ready(function() {
		var btGrafico = $("#btExibirGrafico");

		btGrafico.on("click",function(){
			var qtdTop = $("#qtdTop").val();

			$.ajax('/filme-spark-web/rest/filmes/ator/' + qtdTop, {
				beforeSend: function() {
					habilitarElemento(false, btGrafico);
					exibirLoadingBotao(true, btGrafico);
				},
				success : function(result) {
					chartData = result;
					//inicializar o grafico se necessario
					chart = AmCharts.makeChart("chartSpark", {
						"type" : "pie",
						"theme" : "light",
						"dataProvider" : chartData,
						"startDuration" : 0.5,
						"balloonText" : "[[title]]: <b>$[[value]]</b>",	
						"fillColorsField": "color",
						"fillAlphas" : 0.8,
						"lineAlpha" : 0.2,
						"outlineAlpha": 0.4,
						"depth3D": 15,
						"angle": 30,
						"valueField" : "arrecadacaoLocal",
						"autoColor" : true,
						"titleField": "nome"							
					});
				},
				complete: function() {
					habilitarElemento(true, btGrafico);
					exibirLoadingBotao(false, btGrafico);
				}
			});
		});

		btGrafico.trigger('click');
	});

</script>