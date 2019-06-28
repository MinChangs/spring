<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
.userTr:hover {
	cursor: pointer;
}
</style>
<!-- css, js -->
<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
<script>
	$(document).ready(function() {
		$(".userTr").on("click", function() {
			console.log("userTr click")
			//userId를 획득하는 방법

			//사용자 아이디를 %$serId 값으로 설정해주고

			var userId = $(this).find(".userId").text();

			$('#userId').val(userId);
			//#frm을 이용하여 submit();
			$("#frm").submit();

		});

		$("#exceldown").on("click", function() {
			filename = $('#filename').val();
			if (filename == "") {
				$('#filename').val('userList');
			}
			$("#excelfrm").submit();
			$('#filename').val('');
		});

	});
</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자(tiles)</h2>
		<!-- 사용자 상세조회 : userId가 필요 -->
		<form id="frm" action="${cp}/user/user" method="get">
			<input type="hidden" id="userId" name="userId">
		</form>

		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>

				<c:forEach items="${userList}" var="userpage" varStatus="status">
					<tr class="userTr" data-userId="${userpage.userId}">
						<td class="userId">${userpage.userId}</td>
						<td>${userpage.name}</td>
						<td>${userpage.alias}</td>
						<td></td>
					</tr>
				</c:forEach>
			</table>
		</div>



		<a href="${cp}/user/form" class="btn btn-default pull-right">사용자
			등록</a><br>



		<!--  사용자수 : 105건
						 	  페이지네이션 : 11건 -->
		<div class="text-center">
			<ul class="pagination">

				<c:choose>
					<c:when test="${pageVo.page==1}">
						<li class="prev disabled"><span>«</span></li>
					</c:when>
					<c:otherwise>
						<li class="prev"><a
							href="${cp}/user/pagingList?page=${pageVo.page-1}&pageSize=${pageVo.pageSize}">«</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach begin="1" end="${paginationSize}" var="i">
					<c:choose>
						<c:when test="${pageVo.page == i}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${cp}/user/pagingList?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>

				<c:choose>
					<c:when test="${pageVo.page == paginationSize}">
						<li class="next disabled"><span>»</span></li>
					</c:when>
					<c:otherwise>
						<li class="next"><a
							href="${cp}/user/pagingList?page=${pageVo.page+1}&pageSize=${pageVo.pageSize}">»</a></li>
					</c:otherwise>
				</c:choose>

			</ul>

		</div>

		<form action="${cp}/user/userListExcel" method="get" id="excelfrm">
			<input type="text" id="filename" name="filename" size="45"
				placeholder="저장할 파일명을 입력하세요(미입력시:userList.xlsx)"> <input
				id="exceldown" type="button" class="btn btn-default" value="다운로드">
		</form>
	</div>
</div>


