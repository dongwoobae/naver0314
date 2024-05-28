<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Pretendard';
       }
       ul.menu{
       	list-style:none;
       	margin-left:20%;
       }
       ul.menu li{
       float:left;
       width:100px;
       font-size:20px;
       text-align:center;
       border-radius:15px;
       background-color:buttonface;
       margin-left:30px;
       border: 2px groove silver;
       cursor: pointer;
       }
       ul.menu li:hover{
       	background:rgba(0,0,0,0.3);
       	transition:0.5s;
       	color:white;
       }
         div.loginarea{
       	position: fixed;
       	right: 50px;
       	top:100px;
       }
       div.loginarea button{
       	width: 100px;
       }
   </style>
</head>
<script type="text/javascript">
$(function(){
	$("ul.menu>li").mouseover(function(){
		$(this).find("a").css({"color":"white"});
	}).mouseout(function(){
		$(this).find("a").css({"color":"black"});
	}).click(function(){
		let addr=$(this).find("a").attr("href");
		location.href=addr;		
	});
	
	$("#loginfrm").submit(function(e){
		//기본 이벤트 무효화
		e.preventDefault();
		//폼안의 입력값 읽기
		let fdata=$(this).serialize();
		$.ajax({
			type:"get",
			dataType:"json",
			url:`${root}/member/loginGo`,
			data:fdata,
			success:function(data){
				if(data.status=='success'){
					location.reload();
				}else {
					alert("아이디와 비밀번호가 맞지 않습니다");
				}
			}
		})
	});
	
	//로그아웃 이벤트
	$("#btnlogout").click(function(){
		$.ajax({
			type:"get",
			dataType:"text",
			url:`${root}/member/logout`,
			success:function(){
				location.reload();
			}
		})
	});
	
});
</script>
<body>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<ul class="menu">
	<li><a href="${root}/">홈</a></li>
	<li><a href="${root}/member/list">회원목록</a></li>
	<li><a href="${root}/member/form">회원가입</a></li>
	<li><a href="${root}/board/list">게시판</a></li>
	<li><a href="${root}/guest/list">방명록</a></li>
</ul>
<!-- 로그인 모달 다이얼로그 -->
<div class="modal" id="myLoginModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원 로그인</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
	 <form id="loginfrm">	
      <!-- Modal body -->
      <div class="modal-body">
       
        	<table class="table table-bordered">
        		<caption align="top">
        			<label>
        				<input type="checkbox" name="saveid"
        				${sessionScope.saveid==null or sessionScope.saveid=='no'?"":"checked"}>&nbsp;아이디저장
        			</label>
        		</caption>
        		<tr>
        			<th class="table-success" width="80">아이디</th>
        			<td>
        				<input type="text" name="myid" class="form-control"
        				required="required"
        				value="${sessionScope.saveid!=null and sessionScope.saveid=='yes'?
        				sessionScope.loginid:''}">
        			</td>
        		</tr>
        		<tr>
        			<th class="table-success" width="80">비밀번호</th>
        			<td>
        				<input type="password" name="pass" class="form-control"
        				required="required">
        			</td>
        		</tr>
        	</table>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="submit" class="btn btn-sm btn-danger">로그인</button>
      	 
        <button type="button" class="btn btn-sm btn-danger" data-bs-dismiss="modal"
        id="btnclose">닫기</button>
      </div>
	</form>
    </div>
  </div>
</div>

<div class="loginarea">
	<c:if test="${sessionScope.loginok==null}">
		<button type="button" id="btnlogin"
		class="btn btn-success"
		data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
	</c:if>
	
	<c:if test="${sessionScope.loginok!=null}">
		<b style="font-size: 20px;">
		  ${sessionScope.loginid}님</b>
		
		<button type="button" id="btnlogout"
		 style="margin-left: 20px;"
		class="btn btn-success">로그아웃</button> 
	</c:if>
</div>
</body>
</html>
