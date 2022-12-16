<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>All Posts</title>
</head>
<body>
	<jsp:include page="/jsp/Header.jsp" />
	<div class="mt-3 ml-3">
		<c:forEach var="postModel" items="${postModels}">
			<div class="card w-75 mx-auto mt-3" style="max-height: 18rem">
				<div class="card-body">
					<h5 class="card-title">${postModel.getTitle()}</h5>
					<p class="card-text">Click the button to read this postModel</p>
					<a href="/postModels/${postModel.getId()}" class="btn btn-primary">Read</a>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
