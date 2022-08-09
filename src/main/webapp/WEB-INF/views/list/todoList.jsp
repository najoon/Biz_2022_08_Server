<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<h3>
		<tr>
			<td>순서</td>
			<td>날짜</td>
			<td>시간</td>
			<td>내용</td>
		</tr>
		<br>


		<c:forEach items="${TODOLIST}" var="TODOLIST">
			<tr>
				<td>${TODOLIST.t_seq}</td>
				<td>${TODOLIST.t_date}</td>
				<td>${TODOLIST.t_time}</td>
				<td>${TODOLIST.t_todo}<a href="${ rootPath}/list/${TODOLIST.t_seq}/update">수정</a></td>
			</tr>
			<br>
		</c:forEach>
		
		
		

		<a href="${ rootPath}/list/input">메모작성</a> <a href="${ rootPath}/">홈으로</a>
	</h3>

</body>
</html>