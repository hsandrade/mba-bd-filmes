<%@ include file="/WEB-INF/jsp/init.jsp"%>

<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HelloWorld page</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</head>
<body>
	Greeting : ${boasVindas}
	<div class="page-header">
		<h1>Buttons</h1>
	</div>
	<p>
		<button type="button" class="btn btn-lg btn-default">Default</button>
		<button type="button" class="btn btn-lg btn-primary">Primary</button>
		<button type="button" class="btn btn-lg btn-success">Success</button>
		<button type="button" class="btn btn-lg btn-info">Info</button>
		<button type="button" class="btn btn-lg btn-warning">Warning</button>
		<button type="button" class="btn btn-lg btn-danger">Danger</button>
		<button type="button" class="btn btn-lg btn-link">Link</button>
	</p>
	<p>
		<button type="button" class="btn btn-default">Default</button>
		<button type="button" class="btn btn-primary">Primary</button>
		<button type="button" class="btn btn-success">Success</button>
		<button type="button" class="btn btn-info">Info</button>
		<button type="button" class="btn btn-warning">Warning</button>
		<button type="button" class="btn btn-danger">Danger</button>
		<button type="button" class="btn btn-link">Link</button>
	</p>
	<p>
		<button type="button" class="btn btn-sm btn-default">Default</button>
		<button type="button" class="btn btn-sm btn-primary">Primary</button>
		<button type="button" class="btn btn-sm btn-success">Success</button>
		<button type="button" class="btn btn-sm btn-info">Info</button>
		<button type="button" class="btn btn-sm btn-warning">Warning</button>
		<button type="button" class="btn btn-sm btn-danger">Danger</button>
		<button type="button" class="btn btn-sm btn-link">Link</button>
	</p>
	<p>
		<button type="button" class="btn btn-xs btn-default">Default</button>
		<button type="button" class="btn btn-xs btn-primary">Primary</button>
		<button type="button" class="btn btn-xs btn-success">Success</button>
		<button type="button" class="btn btn-xs btn-info">Info</button>
		<button type="button" class="btn btn-xs btn-warning">Warning</button>
		<button type="button" class="btn btn-xs btn-danger">Danger</button>
		<button type="button" class="btn btn-xs btn-link">Link</button>
	</p>

</body>
</html>