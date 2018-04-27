<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
a:hover {
	background-color: gainsboro;
}
a:active {
	background-color: gainsboro;
}
a:visited {
	color: green;
}

</style>

<div id="navigation">
			<ul>
				<li><a href="${pageContext.request.contextPath}/main">노나연</a></li>
				<li><a href="${pageContext.request.contextPath}/guest/list">방명록</a></li>
				<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
			</ul>
		</div> <!-- /navigation -->