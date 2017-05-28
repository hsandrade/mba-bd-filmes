<%@ include file="/WEB-INF/views/init.jsp"%>

<form name="frmSpark" id="frmSpark">
	<label for="qtdTop">Quantidade de filmes: </label> <input name="qtdTop"
		id="qtdTop" type="number" value="5" max="20"> <br>
	<button id="btExibirGrafico" type="button"
		class="btn btn-primary">Exibir Gráfico</button>
</form>

<div id="chartdiv"></div> 

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
					//inicializar o grafico se necessario
					/* if (chart == null) { */
var chart = AmCharts.makeChart("chartdiv",{
  "type": "serial",
  "categoryField": "titulo",
  "categoryAxis": {
    "gridPosition": "start"
  },
  "graphs": [
    {
      "title": "Filmes Mais Avaliados",
      "valueField": "mediaVotos"
          
    }
  ],
  "valueAxes": [
    {
      "title": "Votos"
    }
  ],
  "legend": {
    "useGraphSettings": true
  },
  "titles": [
    {
      "size": 15,
      "text": "Filmes Mais Avaliado"
    }
  ],
  "dataProvider" : chartData,
  
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