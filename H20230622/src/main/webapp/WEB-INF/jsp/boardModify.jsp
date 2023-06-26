<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
	<%
	BoardVO vo = (BoardVO)request.getAttribute("board");
	%>
	
	<h3>수정화면(boardModify.jsp)</h3>
	<form name = "myFrm" action="boardModify.do" method = "post">
		<table border = "1" class="table">
			<tr>
				<th>글번호</th><td ><input readonly name= "no" value ="<%=vo.getBrdNo()%>"></td><th>조회수</th><td><%=vo.getClickCnt()%></td>
			</tr>	
			<tr>
				<th>제목</th><td colspan= "3"><input name= "title" value ="<%=vo.getBrdTitle() %>"></td>
			</tr>
			<tr>
				<td colspan ="4"><textarea name ="content" cols = "50" rows ="3" ><%=vo.getBrdContent() %></textarea></td>
			</tr>
			<tr>
				<th>작성자</th><td>${board.brdWriter }</td>
				<th>작성일자<th><td>${board.createDate }</td>
			</tr>
			<tr>
				<td colsapn="4" align="center">
					<input type = "submit" value="저장">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page ="footer.jsp"></jsp:include>