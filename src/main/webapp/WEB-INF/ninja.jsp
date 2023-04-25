<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
	
		<div class="row-2 d-flex align-items-center gap-3 mt-3">
			<h1 class="">Your Gold: </h1>
			<div class="border border-dark border-2 rounded d-flex align-items-center justify-content-start " style="width: 125px; height: 50px;">
				<p class="m-0 overflow-hidden text-truncate"> <c:out value="${numGold}"/></p>
			</div>
		</div>
		<p class="mt-3"><em>(Stay above -25 to keep playing)</em></p>
		
		<div class="row-4 col-12 d-flex justify-content-around mt-3 ">
			<div class="border border-dark border-2 p-3 rounded">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<form action="/form" method="post">
					<input type="hidden" name="form" value="farm">
					<button type="submit" class="btn btn-primary">Find Gold!</button>
				</form>
			</div>
			<div class="border border-dark border-2 rounded p-3">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<form action="/form" method="post">
					<input type="hidden" name="form" value="cave">
					<button type="submit" class="btn btn-primary">Find Gold!</button>
				</form>
			</div>
			<div class="border border-dark border-2 rounded p-3">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<form action="/form" method="post">
					<input type="hidden" name="form" value="house">
					<button type="submit" class="btn btn-primary">Find Gold!</button>
				</form>
			</div>
			<div class="border border-dark border-2 rounded p-3">
				<h3>Quest</h3>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/form" method="post">
					<input type="hidden" name="form" value="quest">
					<button type="submit" class="btn btn-primary">Find Gold!</button>
				</form>
			</div>
			<div class="border border-dark border-2 rounded p-3">
				<h3>Spa</h3>
				<p>(takes 5-20 gold)</p>
				<form action="/form" method="post">
					<input type="hidden" name="form" value="spa">
					<button type="submit" class="btn btn-primary">Find Gold!</button>
				</form>
			</div>
		</div>
		
		<div class="row-2 mt-3">
			<h2>Activities: </h2>
			<p><em>(Scroll down to see all activities)</em></p>
		</div>
		<p></p>
		<div class="row-4 col-12 border border-2 mt-3 p-3 rounded d-block " style="height: 200px; overflow-y: auto;">
			<c:forEach var="activity" items="${allActivity}">
<%-- 				<p><c:out value="${activity}"/></p> --%>
				<c:if test="${activity.contains('earned')}">
					<p style="color: green;"><c:out value="${activity}"/></p>
				</c:if>
				<c:if test="${activity.contains('lost')}">
					<p style="color: red;"><c:out value="${activity}"/></p>
				</c:if>
			</c:forEach> 
		</div>
		
		<a href="/reset" class="btn btn-danger mt-3">Reset</a>
		
		
	</div>
</body>
</html>