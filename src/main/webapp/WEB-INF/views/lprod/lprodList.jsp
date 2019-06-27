<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>LPROD 리스트</title>

<!-- css, js -->
<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
</head>

<body>
<!-- header -->
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

<!-- left -->
<%@include file="/WEB-INF/views/common/left.jsp" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>상품 번호</th>
									<th>상품 아이디</th>
									<th>상품 이름</th>
								</tr>
								
								<c:forEach items="${lprodList}" var="list">
									<tr>
										<td>${list.lprod_id}</td>
										<td>${list.lprod_gu}</td>
										<td>${list.lprod_nm}</td>
									</tr>
								
								</c:forEach>
				
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>
						
						<!--  사용자수 : 105건
						 	  페이지네이션 : 11건 -->
						<div class="text-center">
							<ul class="pagination">
							
							
							
							
							<c:choose>
								<c:when test="${LpageVo.page == 1 }">
									<li class="prev disabled"><span>«</span></li>
								</c:when>
								<c:otherwise>
									<li class="prev"><a href="${cp}/lprod/pagingList?page=${LpageVo.page-1}&pageSize=${LpageVo.pageSize}">«</a></li>
								</c:otherwise>
							</c:choose>
							
							<c:forEach begin="1" end="${LpaginationSize}" var="i">
								<c:choose>
									<c:when test="${LpageVo.page == i}">
										<li class="active"><span>${i}</span></li>
									</c:when>
									<c:otherwise>
									<li><a href="${cp}/lprod/pagingList?page=${i}&pageSize=${LpageVo.pageSize}">${i}</a></li>
										
									</c:otherwise>
								</c:choose>
							
							</c:forEach>
							
							<c:choose>
								<c:when test="${LpageVo.pageSize == LpaginationSize}">
									<li class="next disabled"><span>»</span></li>
								</c:when>
								<c:otherwise>
									<li class="next"><a href="${cp}/lprod/pagingList?page=${LpageVo.page+1}&pageSize=${LpageVo.pageSize}">»</a></li>
								</c:otherwise>
							</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
