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

        div.guestListArea {

            width: 500px;
        }

        div.guestDetail {
            display: flex;
            justify-content: space-between;
        }

        div.guestPhoto img {
            margin-left: 10px;
        }
    </style>
</head>
<c:set var="stPath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/guestphoto"/>
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
<!-- 사진 클릭시 Modal -->
<div class="modal" id="myPhotoLargeModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title phototitle">제목</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <img src="" class="largephoto">
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    function large_photo(writer, photoname) {
        $(".phototitle").text("[" + writer + "] 님이 올린 사진입니다");
        $(".largephoto").attr("src", `${stPath}/\${photoname}`);
    }

    //방명록 불러오는 함수
    function guest_list() {
        $.ajax({
            type: "post",
            url: "./datas",
            dataType: "json",
            success: function (data) {
                let s = `<b>총 \${data.length}개의 글이 있습니다</b><br><hr>`;
                $.each(data, function (idx, ele) {
                    s += `
                    <div class="guestDetail">
            <pre>
<b>\${ele.writer} (\${ele.myid})</b>
<span style="font-size: 10px; color: gray;">${ele.writeday}</span>
        \${ele.gcontent}
                </pre>
            <div class="guestPhoto">
                    `;
                    if (ele.photos !== null) {
                        var photoGuest = ele.photos.split(',');
                        var stPath = "${stPath}";
                        photoGuest.forEach(function (photo) {
                            s += `<img src='${stPath}/\${photo}' width='70'
                             data-bs-toggle="modal" data-bs-target="#myPhotoLargeModal"
							 onclick="large_photo('\${ele.writer}','\${photo}')">`;
                        });
                    }
                    s += `</div></div><hr>`;
                });

                $("div.guestListArea").html(s);
            }
        })
    }

    //방명록 등록 버튼
    $("#btnAddGuest").click(function () {
        let gcontent = $("#gcontent").val();
        if (gcontent === "") {
            alert("글 작성 후 등록");
            return;
        }
        let formdata = new FormData();
        let answerNumber = $("#answerNumber").val().length;
        //여러장의 사진들을 formdata에 등록
        for (let i = 0; i < $("#photoupload")[0].files.length; i++) {
            formdata.append("upload", $("#photoupload")[0].files[i]);//선택한 모든 사진들
        }
        //내용도 formdata에 등록
        formdata.append("gcontent", gcontent);
        $.ajax({
            type: "post",
            dataType: "text",
            url: "./addGuest",
            data: formdata,
            processData: false,
            contentType: false,
            success: function () {
                guest_list();
                //초기화
                $("#gcontent").val("");
                $("#photoupload").val("");
                $("#answerNumber").html(`\${answerNumber}/1000`);
            }
        });
    });
    $("#gcontent").on("input", function () {
        let len = $(this).val().length;
        $("#answerNumber").text(len + "/1000");
    });
    $(function () {
        guest_list();
    })
</script>
</body>
</html>
