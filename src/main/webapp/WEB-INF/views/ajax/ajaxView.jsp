<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		console.log("ready")
		$("#requestData").on("click",function(){
			$.ajax({
				url : "/ajax/requestData",
				method : "post",
				success : function(data) {
					console.log(data);
					$("#page").text(data.pageVo.page);
					$("#pageSize").text(data.pageVo.pageSize);
				}
			});
		});
		
		
		$("#user").on("click",function(){
			$.ajax({
				url : "/ajax/user",
				method : "post",
				data : "userId="+$("#userId").val(),
				success : function(data) {
					console.log(data);
					
					/*
					name : <input type="text" id="name" readonly/>
					alias : <input type="text" id="alias" readonly/>
					birth : <input type="text" id="birth" readonly/>
					$("#name").val(data.userVo.name);
					$("#alias").val(data.userVo.alias);
					$("#birth").val(data.userVo.birth);
					*/
					var html ="";
					html +="name : <input type=\"text\" id=\"name\" readonly value=\""+data.userVo.name+"\"/>"; 
					html +="name : <input type=\"text\" id=\"alias\" readonly value=\""+data.userVo.alias+"\"/>"; 
					html +="name : <input type=\"text\" id=\"birth\" readonly value=\""+data.userVo.birth+"\"/>"; 
					
					$("#userJsonInfo").html(html);
				}
				
			});
		})
		
		$("#userHtml").on("click",function(){
			$.ajax({
				url : "/ajax/userHtml",
				method : "post",
				data : $("#frm").serialize(),
				success : function(data) {
					console.log(data);
					$("#userInfo").html(data);
				}
				
			});
		})
	});
</script>
<h2>ajax json 데이터 요청</h2>
<a id ="requestData">데이터 가져오기</a><br>
page : <span id ="page"></span><br>
pageSize : <span id="pageSize"></span>

<h2>ajax json 데이터 요청(user)</h2>
<a id="user"> 데이터 가져오기 </a><br>
userId : <input type="text" id="userId" value="sally"/>
<div id="userJsonInfo"></div>


<h2>ajax html 데이터 요청(user)</h2>
<a id="userHtml"> 데이터 가져오기 </a><br>
<form id="frm">
	userId : <input type="text" id="userIdHtml" name="userId" value="brown"/>
</form>
<div id="userInfo">

</div>