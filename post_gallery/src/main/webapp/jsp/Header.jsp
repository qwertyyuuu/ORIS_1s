<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>

<nav class="navbar navbar-expand-lg bg-light mt-3 mr-3 ml-3">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Post gallery</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="<c:url value="/home"/>">Main page</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/reg"/>">Sign up</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/auth"/>">Log in</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/posts"/>">Gallery</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/posts/add"/>">Add new</a>
				</li>
			</ul>
		</div>
	</div>
</nav>