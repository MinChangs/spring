<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<title>사용자 등록</title>

<!-- css, js -->
<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>


$(document).ready(function() {
	var msg = '${msg}';
	if(msg !='')
		alert(msg);
	//주소 찾기 버튼 클릭 이벤트 핸들러
	$("#addrSearchBtn").on("click", function() {
		 new daum.Postcode({
		        oncomplete: function(data) {

		            $("#addr1").val(data.roadAddress);
		            $("#zipcd").val(data.zonecode);
		            
		        }
		    }).open();
		
	});
	
	$('#userRegBtn').on("click", function() {
		//유효성 체크(지금은 생략)
		
		//여기까지 도달하면 검사 완료(submit)
		$('#userId').val('${userInfo.userId}');
		$('#frm').submit();
	});
	
	// 개발용 데이터 초기화 함수 ****** 추후 지울 것
	 //dataInit();
});

function dataInit() {
	$('#userId').val();
	$('#name').val("대덕인");
	$('#alias').val("중앙로");
	$('#addr1').val("대전광역시 중구 중앙로76");
	$('#addr2').val("영민빌딩 2층 204호");
	$('#zipcd').val("34940");
	$('#birth').val("2019-05-31");
	$('#pass').val("userTest1234");
}



</script>
</head>

<body>
	<!-- header -->
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@include file="/WEB-INF/views/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자 등록</h2>
						<form id ="frm" class="form-horizontal" role="form" action="${cp }/user/modify" method="post" enctype="multipart/form-data">
<%-- 							<input type="hidden" name="userId" value="${userInfo.userId}"> --%>

							<div class="form-group">
								<label for="filename" class="col-sm-2 control-label">사용자 사진</label>
								<div class="col-sm-10">
									<input type="file" name="profile" id="profile">
								</div>
							</div>
							
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
								<div class="col-sm-10">
								
									<input type="hidden" class="form-control" id="userId" name="userId" placeholder="사용자 아이디"  >
										<label class="control-label"> ${userInfo.userId}</label> 
								</div>
							</div>
		
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">사용자 이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" name="name" placeholder="사용자 이름" value="${userInfo.name}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="alias" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="alias" name="alias" placeholder="사용자 별명" value="${userInfo.alias}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="addr1" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소" readonly value="${userInfo.addr1}">
								</div>
								<div class="col-sm-2">
									<button id="addrSearchBtn" type="button" class="btn btn-default pull-right">주소 검색</button>
								</div>
							</div>
							
							<div class="form-group">
								<label for="addr2" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소" value="${userInfo.addr2}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="zipcd" name="zipcd" placeholder="우편번호" readonly value="${userInfo.zipcd}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="birth" class="col-sm-2 control-label">생일</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="birth" name="birth" placeholder="생일" value='<fmt:formatDate value="${userInfo.birth}" pattern="yyyy-MM-dd"/>'>
								</div>
							</div>
							
<!-- 							<div class="form-group">
								<label for="pass" class="col-sm-2 control-label">비밀번호</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호">
								</div>
							</div> -->
							

		
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="userRegBtn" type="button" class="btn btn-default">사용자 수정</button>
								</div>
							</div>
						</form>	

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

