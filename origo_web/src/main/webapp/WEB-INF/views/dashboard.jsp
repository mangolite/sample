<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1" name="viewport">
<title>Hello WebSocket</title>

<link type="text/css" rel="stylesheet" media="screen"
	href="/app/resources/css/compiled/skin/black/bootstrap/theme.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="/app/resources/css/compiled/skin/black/theme.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="/app/resources/css/compiled/skin/black/module/fx.css" />
<script src="/app/resources/jquery/jquery.js"></script>
<script src="/app/resources/utils/utils.js"></script>
<script src="/app/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/app/resources/js/module/fx/tradeTab.js"></script>

</head>
<body role="document">
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">dfferentia</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 col-sm-2 col-xs-3 col-md-2 col-sm-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">FX Pricing</a></li>
					<li class="list-group-item-info"><a href="#"><span
							class="glyphicon glyphicon-play"></span> Vanilla</a></li>
				</ul>
			</div>
			<div
				class="col-lg-10 col-sm-10 col-xs-12  col-sm-offset-2 col-md-10 col-md-offset-2 main fx">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs fxTab" role="tablist">
					<li class="active"><a href="#trade" role="tab"
						data-toggle="tab">Trade</a></li>
					<li><a href="#volatility" role="tab" data-toggle="tab">Volatility</a></li>
					<li><a href="#curve" role="tab" data-toggle="tab">Curve</a></li>
					<li><a href="#riskAnalysis" role="tab" data-toggle="tab">Risk
							Analysis</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane active" id="trade">
						<div class="row">
							<ul class="nav nav-pills hidden-md hidden-lg tradeTab"
								role="tablist">
								<li><a href="#form">Form</a></li>
								<li><a href="#result">Result</a></li>
							</ul>
							<hr class="hidden-lg">
							<div class="tab-content">
								<div
									class="tab-pane active visible-md-block  visible-lg-block visible-sm-block"
									id="form">
									<div class="col-md-12 col-sm-12 col-xs-12 col-lg-7">
										<div class="row">
											<form class="form-horizontal tradeForm">
												<div class=" col-sm-6 container-fluid">
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													
												</div>
												<div class=" col-sm-6 container-fluid">
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
													<div class="input-group">
														<div class="input-group-btn">
															<button type="button" class="btn btn-default">Trade
																Date</button>
														</div>
														<input type="text" class="form-control">
														<div class="input-group-btn">
															<button type="button"
																class="btn btn-default glyphicon glyphicon-calendar"></button>
														</div>
													</div>
												</div>
											</form>
											<div class="clearfix"></div>
											<hr />
											<div class=" container">
												<!-- Standard button -->
												<button type="button" class="btn btn-default">Calculate</button>
												<!-- Standard button -->
												<button type="button" class="btn btn-default">Solver</button>
												<!-- Standard button -->
												<button type="button" class="btn btn-default">Refresh</button>
												<!-- Standard button -->
												<button type="button" class="btn btn-default">Clear</button>
											</div>
										</div>
									</div>
								</div>
								<div
									class="tab-pane visible-md-block  visible-lg-block visible-sm-block"
									id="result">
									<div class="col-md-12  col-lg-5 col-sm-12 col-xs-12">
										<div class="table-responsive">
											<table class="table table-striped">
												<thead>
													<tr>
														<th>#</th>
														<th>Header</th>
														<th>Header</th>
														<th>Header</th>
														<th>Header</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>1,001</td>
														<td>Lorem</td>
														<td>ipsum</td>
														<td>dolor</td>
														<td>sit</td>
													</tr>
													<tr>
														<td>1,002</td>
														<td>amet</td>
														<td>consectetur</td>
														<td>adipiscing</td>
														<td>elit</td>
													</tr>
													<tr>
														<td>1,003</td>
														<td>Integer</td>
														<td>nec</td>
														<td>odio</td>
														<td>Praesent</td>
													</tr>
													<tr>
														<td>1,003</td>
														<td>libero</td>
														<td>Sed</td>
														<td>cursus</td>
														<td>ante</td>
													</tr>
													<tr>
														<td>1,004</td>
														<td>dapibus</td>
														<td>diam</td>
														<td>Sed</td>
														<td>nisi</td>
													</tr>
													<tr>
														<td>1,005</td>
														<td>Nulla</td>
														<td>quis</td>
														<td>sem</td>
														<td>at</td>
													</tr>
													<tr>
														<td>1,006</td>
														<td>nibh</td>
														<td>elementum</td>
														<td>imperdiet</td>
														<td>Duis</td>
													</tr>
													<tr>
														<td>1,007</td>
														<td>sagittis</td>
														<td>ipsum</td>
														<td>Praesent</td>
														<td>mauris</td>
													</tr>
													<tr>
														<td>1,008</td>
														<td>Fusce</td>
														<td>nec</td>
														<td>tellus</td>
														<td>sed</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>




					</div>
					<div class="tab-pane" id="volatility">...</div>
					<div class="tab-pane" id="curve">...</div>
					<div class="tab-pane" id="riskAnalysis">...</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>