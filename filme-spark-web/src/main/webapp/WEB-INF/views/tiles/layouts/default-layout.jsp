<%@ include file="/WEB-INF/views/init.jsp"%>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="static/css/filme.css">

<script src="static/js/plugin/jquery-3.2.1.min.js"></script>
<script src="static/js/plugin/bootstrap.min.js"></script>
<script src="static/js/plugin/amcharts/amcharts.js"></script>
<script src="static/js/plugin/amcharts/serial.js"></script>
<script src="static/js/plugin/amcharts/dataloader.min.js"></script>
<script src="static/js/plugin/amcharts/light.js"></script>
<script src="static/js/plugin/randomcolor.min.js"></script>
<script src="static/js/filme-default.js"></script>
</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="page-header">
					<h1><tiles:getAsString name="title" /></h1>
				</div>
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</html>