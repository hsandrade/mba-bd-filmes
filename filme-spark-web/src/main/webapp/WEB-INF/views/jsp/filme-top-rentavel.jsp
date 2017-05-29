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

			$.ajax('/filme-spark-web/rest/filmes/rentaveis/' + qtdTop, {
				beforeSend: function() {
					habilitarElemento(false, btGrafico);
					exibirLoadingBotao(true, btGrafico);
				},
				success : function(result) {
					chartData = result;
					//inicializar o grafico se necessario
					/* if (chart == null) { */
						chart = AmCharts.makeChart("chartSpark", {
							"type" : "serial",
							"theme" : "light",
							"dataProvider" : chartData,
							"startDuration" : 1,
							"graphs" : [ {
								"balloonText" : "[[category]]: <b>$[[value]]</b>",
								"fillColorsField": "color",
								"fillAlphas" : 0.8,
								"lineAlpha" : 0.2,
								"type" : "column",
								"valueField" : "arrecadacaoLocal",
								"urlField": "urlImdb",
								"urlTarget": "_blank",								
								"autoColor" : true,
								"labelText" : "$[[value]]",
								"labelPosition" : "middle"
							} ],
							"depth3D": 15,
							"angle": 30,							
							"chartCursor" : {
								"categoryBalloonEnabled" : false,
								"cursorAlpha" : 0,
								"zoomable" : false
							},
							"categoryField" : "titulo",
							"categoryAxis" : {
								"gridPosition" : "start",
								"gridAlpha" : 0,
								"tickPosition" : "start",
								"labelRotation": 45
							}
						});
					/* }
					else {
						//atualizar o grafico de acordo com o json definido na variavel do dataProvider
						chart.dataProvider = chartData;
						chart.validateData();
					} */
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