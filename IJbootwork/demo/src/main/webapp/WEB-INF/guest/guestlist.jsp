<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Pretendard';
        }
    </style>
</head>
<body>
<c:if test="${sessionScope.loginok!=null}">
    <div class="guestFormArea" style="width: 500px; padding: 5px; margin: 5px;">
        <h4>방명록</h4><span id="answerNumber" style="color: gray">0/1000</span>
        <textarea style="width: 100%; height: 80px;" id="gcontent" class="form-control"></textarea>
        <div style="display: flex; margin-top:10px;">
        <span style="margin-right: 85px;">
            <input type="file" id="photoupload" multiple class="form-control"></span>
        <span>
        <button type="button" id="btnAddGuest" class="btn btn-outline">등록</button>
            </span></div>
        <hr>
    </div>
</c:if>
<div class="guestListArea"></div>
<script>
    //방명록 불러오는 함수
    function guest_list(){
        let s="";

    }
    //방명록 등록 버튼
    $("#btnAddGuest").click(function (){
        let gcontent=$("#gcontent").val();
        if(gcontent===""){
            alert("글 작성 후 등록");
            return;
        }
        let formdata=new FormData();
        //여러장의 사진들을 formdata에 등록
        for(let i=0;i<$("#photoupload")[0].files.length;i++){
            formdata.append("upload",$("#photoupload")[0].files[i]);//선택한 모든 사진들
        }
        //내용도 formdata에 등록
        formdata.append("gcontent",gcontent);
       $.ajax({
          type:"post",
          dataType:"text",
          url:"./addGuest",
           data:formdata,
           processData: false,
           contentType: false,
           success:function (){
                guest_list();
                //초기화
               $("#gcontent").val("");
               $("#photoupload").val("");
           }
       });
    });
    $("#gcontent").on("input", function () {
        let len = $(this).val().length;
        $("#answerNumber").text(len + "/1000");
    });
</script>
</body>
</html>
