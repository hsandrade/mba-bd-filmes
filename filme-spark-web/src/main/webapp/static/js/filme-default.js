var tplCssLoadingBt = "<span id='loadingBt' class='glyphicon glyphicon-refresh glyphicon-refresh-animate'></span>";

//inicializar as cores automaticamente do grafico
AmCharts.addInitHandler(function(chart) {
	  for(var i = 0; i < chart.graphs.length; i++) {
	    var graph = chart.graphs[i];
	    if (graph.autoColor !== true)
	      continue;
	    var colorKey = "autoColor-"+i;
	    graph.lineColorField = colorKey;
	    graph.fillColorsField = colorKey;
	    for(var x = 0; x < chart.dataProvider.length; x++) {
	      var color = chart.colors[x]
	      chart.dataProvider[x][colorKey] = color;
	    }
	  }
	  
	}, ["serial"]);


//botao deve ser um objeto JQuery de acordo com  o elemento a receber o loading.
function exibirLoadingBotao(exibir, botao) {
	if (exibir) {
		botao.prepend(tplCssLoadingBt);
	}
	else {
		botao.find('#loadingBt').remove();
	}
}

function habilitarElemento(habilitar, ele) {
	if (habilitar) {
		ele.removeAttr("disabled");
	}
	else {
		ele.attr("disabled","disabled");
	}
	
}