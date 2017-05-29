<%@ include file="/WEB-INF/views/init.jsp"%>

<form name="frmSpark" id="frmSpark">
	<label for="qtdTop">Diretor: </label> <select id="selDiretor"></select>
	<div id="divLoadDiretor" style="display: inline-block;"></div>
	<br>
	
	<label for="qtdTop">Top atores: </label> <input name="qtdTop"
		id="qtdTop" type="number" value="10" max="20"> <br>	
	
	<br>
	<button id="btExibirGrafico" type="button" class="btn btn-primary">Exibir
		Top Atores por Diretor</button>
</form>

<div id=chartSpark></div> 

<script>
	$(document).ready(
			function() {
				var btGrafico = $("#btExibirGrafico");
				var divLoadDiretor = $("#divLoadDiretor");
				var selDiretor = $("#selDiretor");

				$.ajax('/filme-spark-web/rest/diretores/', {
					beforeSend : function() {
						habilitarElemento(false, selDiretor);
						habilitarElemento(false, btGrafico);
						exibirLoadingBotao(true, divLoadDiretor);
					},
					success : function(result) {
						selDiretor.find("option").remove().end();
						for (var i = 0; i < result.length; i++) {
							selDiretor.append("<option>" + result[i].nome
									+ "</option>")
						}
						btGrafico.trigger('click');
					},
					complete : function() {
						habilitarElemento(true, selDiretor);
						habilitarElemento(true, btGrafico);
						exibirLoadingBotao(false, divLoadDiretor);
					}
				})
				
				selDiretor.on("change", function() {
					btGrafico.trigger('click');
				});
				

				btGrafico.on("click", function() {

					$.ajax('/filme-spark-web/rest/filmes/diretor/'
							+ $("#selDiretor").val() 
							+ "/"
							+ $("#qtdTop").val(), {
						beforeSend : function() {
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
								"graphs" : [ {
									"balloonText" : "[[category]]: <b>$[[value]]</b>",	
									"fillColorsField": "color",
									"fillAlphas" : 0.8,
									"lineAlpha" : 0.2,
									"type" : "column",
									"valueField" : "arrecadacaoLocal",
									"autoColor" : true,
									"labelPosition" : "middle",
									"labelText" : "$[[value]]"
								} ],
								"chartCursor" : {
									"categoryBalloonEnabled" : false,
									"cursorAlpha" : 0,
									"zoomable" : false
								},
								
								"categoryField" : "nome",
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