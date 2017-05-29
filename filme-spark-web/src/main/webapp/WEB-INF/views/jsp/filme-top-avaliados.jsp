<%@ include file="/WEB-INF/views/init.jsp"%>

<form name="frmSpark" id="frmSpark">
	<label for="qtdTop">Quantidade de filmes: </label> <input name="qtdTop"
		id="qtdTop" type="number" value="10" max="20"> <br>
	<button id="btExibirGrafico" type="button"
		class="btn btn-primary">Exibir Gráfico</button>
</form>

<div id=chartSpark></div> 

<script>
	var chartData;
	var chart = null;

	$(document).ready(function() {
		var btGrafico = $("#btExibirGrafico");

		btGrafico.on("click",function(){
			var qtdTop = $("#qtdTop").val();

			$.ajax('/filme-spark-web/rest/filmes/avaliados/' + qtdTop, {
				beforeSend: function() {
					habilitarElemento(false, btGrafico);
					exibirLoadingBotao(true, btGrafico);
				},
				success : function(result) {
					chartData = result;
					chart = AmCharts.makeChart("chartSpark",{
						"type" : "serial",
						"theme" : "light",
						"dataProvider" : chartData,
						"startDuration" : 0.5,
					    "valueAxes": [{
					        "id": "mediaAxis",
					        "axisAlpha": 0,
					        "gridAlpha": 0,
					        "position": "right",
					        "title": "Média Avaliação"
					    }, {
					        "id": "qtdAxis",
					        "axisAlpha": 0,
					        "gridAlpha": 0,
					        "position": "left",
					        "title": "Quantidade de Votos"
					    }],						
						"graphs" : [ {
							"balloonText" : "[[category]]: <b>[[value]]</b>",
							"fillColorsField": "color",
							"fillAlphas" : 0.8,
							"lineAlpha" : 0.2,
							"type" : "column",
							"valueField" : "qtdVotos",
							"urlField": "urlImdb",
							"urlTarget": "_blank",
							"valueAxis": "qtdAxis",
							"autoColor" : true,
							"labelText" : "[[value]]",
							"labelPosition" : "middle"
						},
						{
					        "balloonText": "Média:[[value]]",
					        "bullet": "round",
					        "bulletBorderAlpha": 1,
					        "useLineColorForBulletBorder": true,
					        "bulletColor": "#FFFFFF",
					        "bulletSizeField": "townSize",
					        "dashLengthField": "dashLength",
					        "labelPosition": "right",
					        "labelText": "[[value]]",
					        "title": "Quantidade votos",
					        "fillAlphas": 0,
					        "valueField": "mediaVotos",
							"urlField": "urlImdb",
							"urlTarget": "_blank",					        
					        "valueAxis": "mediaAxis"
					    }],
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
				},
				complete: function() {
					habilitarElemento(true, btGrafico);
					exibirLoadingBotao(false, btGrafico);
				}
			});
		});
	});

</script>