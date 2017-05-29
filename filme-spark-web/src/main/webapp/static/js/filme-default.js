var tplCssLoadingBt = "<span id='loadingBt' class='glyphicon glyphicon-refresh glyphicon-refresh-animate'></span>";

//inicializar as cores automaticamente do grafico
AmCharts.addInitHandler(function(chart) {
	  for(var i = 0; i < chart.graphs.length; i++) {
	    var graph = chart.graphs[i];
	    if (graph.autoColor !== true)
	      continue;
	    for(var x = 0; x < chart.dataProvider.length; x++) {
	      var color = chart.colors[x]
	      //randomColor refere-se ao plugin externo randomcolor.min.js
	      chart.dataProvider[x]["color"] = randomColor({
	    	   luminosity: 'light',
	    	   hue: 'random'});
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