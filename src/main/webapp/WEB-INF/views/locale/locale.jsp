<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	$(document).ready(function(){
		//select box option설정
// 		if ('${param.lang}'=='') {
// 			$("#lang").val('ko');
// 		} else {
// 			$("#lang").val('${param.lang}');
// 		}
// 		'${param.lang}'==""?$("#lang").val('ko'):$("#lang").val('${param.lang}');
		$("#lang").val('${lang}');
		
		$("#lang").on("change",function(){
			console.log("select box changed");
			
			$("#frm").submit();
		});
	});
</script>
<form action="/locale/view" method="post" id="frm">
<select id="lang" name="lang">
	<option value="ko" >한국어</option>
	<option value="en">English</option>
	<option value="ja">日本語</option>
</select><br>

GREETING : <spring:message code="GREETING"/><br>
VISITOR : <spring:message code="VISITOR">
		  	<spring:argument value="brown"/>
		  </spring:message>

</form>