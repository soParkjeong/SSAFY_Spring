<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>SSAFY 자유 게시판</h1>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.created}</td>
				<td>${board.viewCnt}</td>
				<td>
					<a href="${root}/board/detail/${board.id}">상세보기</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<!-- 검색 -->
	<form action="${root}/board/search" method="get">
		<label for="title">제목: </label>
		<input type="text" id="title" name="title" value="${condition.title}">
		<label for="content">내용: </label>
		<input type="text" id="content" name="content" value="${condition.content}">
		<!--  정렬 순서 -->
		<select name="order" id="order">
		    <c:forEach var="order" items="created,viewCnt">
			    <option value="${order}" ${order == condition.order ? 'selected' : ''}>${order == 'created' ? '생성일': '조회수'}</option>
            </c:forEach>
		</select>
		<!--  정렬 방향 -->
		<select name="direction">
			<option value="asc" ${condition.direction == 'asc' ? 'selected' : ''}>오름차순</option>
			<option value="desc" ${condition.direction == 'desc' ? 'selected' : ''}>내림차순</option>
		</select>
		<input type="submit" value="검색">
	</form>
	<hr>
	<a href="${root}/board/create">글 작성</a> <br/>
	<a href="${root}/">메인페이지</a>
</body>
</html>

