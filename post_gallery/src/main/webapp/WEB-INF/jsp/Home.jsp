<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<jsp:include page="/jsp/Header.jsp" />
	<div class="ml-3 mt-3">
		<h1>Hello</h1>
		<img src="<c:url value="/img/image.jpg"/>" alt="img" />
	</div>
</body>
</html>
