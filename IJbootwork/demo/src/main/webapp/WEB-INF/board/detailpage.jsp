<%--
  Created by IntelliJ IDEA.
  User: DONGWOOBAE
  Date: 2024-05-28
  Time: 오전 11:40
  To change this template use File | Settings | File Templates.
--%>
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

        pre.adata {
            margin-left: 50px;
            color: gray;
        }
        span.aday {
            font-size: 12px;
            color: gray;
            margin-left: 100px;
        }
        div.trans{
            position: relative;
            margin-left: 20px;
            width: 500px;
        }
    </style>
</head>
<c:set var="stPath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"/>
<body>
<div class="trans">
    <div class="input-group">
        <b>번역할 언어 선택</b>
        <select id="seltrans" style="width: 130px; margin-left: 10px">
            <option value="en">영어</option>
            <option value="zh-CN">중국어</option>
            <option value="ja">일본어</option>
            <option value="fr">프랑스어</option>
        </select>
        <button type="button" id="audioTranslate">듣기</button>
    </div>
    <pre id="trans_lang" style="margin-top:10px;font-size: 25px;white-space: pre-wrap;word-wrap: break-word;"></pre>
</div>

<table width="600">
    <tr>
        <th><h2>${dto.subject}</h2></th>
        <td align="right" style="white-space: nowrap;"><img src="${stPath}/${profile_photo}" style="width: 40px;border-radius: 50%;">
            ${dto.writer}</td>
    </tr>
    <tr>
        <td><fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/></td>
        <td style="text-align: right;white-space: nowrap;"><i class="bi bi-chat-dots"></i>댓글 <span
                class="answerCount"></span> 조회수 ${dto.readcount}</td>
    </tr>
    <tr>
        <td colspan="2">
            <hr>
        </td>
    </tr>
    <tr>
        <td colspan="2" style="display: block; min-height: 250px;">
            <c:if test="${dto.uploadphoto!='no'}">
                <img src="${stPath}/${dto.uploadphoto}" width="200px;" onerror="this.src='../save/noimage1.jpg'">
            </c:if><br>
            <pre>${dto.content}</pre>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <hr>
        </td>
    </tr>
    <tr>
        <td><h5>댓글</h5>
        </td>
    </tr>
    <c:if test="${sessionScope.loginok=='yes'}">
        <tr>
            <td colspan="2" align="right">
                <span>${sessionScope.loginid}</span>
                <input type="number" name="num" value="${dto.num}" hidden="hidden">
                <span id="answerNumber" style="color: gray">0/1000</span>
                <textarea name="content" cols="100%" class="form-control" id="answerText"
                          placeholder="댓글을 남겨보세요"></textarea>
                <button type="button" class="btn btn-outline" id="btnAnswerAdd">등록</button>
                <br>
            </td>
        </tr>
    </c:if>
    <tr>
        <td>
            <div class="answerlist"></div>
        </td>
    </tr>
    <tr>
        <td>
            <c:if test="${sessionScope.loginok=='yes'}">
                <button type="button" class="btn btn-outline-success btn-sm"><i class="bi bi-pencil"></i>글쓰기</button>
                <button type="button" class="btn btn-outline-secondary btn-sm">답글</button>
            </c:if>
            <c:if test="${sessionScope.loginok=='yes' and sessionScope.loginid==dto.myid}">
                <button type="button" class="btn btn-outline-secondary btn-sm"
                        onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정
                </button>
                <button type="button" class="btn btn-outline-secondary btn-sm"
                        id="detailbtnDelete">삭제
                </button>
            </c:if>
        </td>
        <td align="right">
            <button type="button" class="btn btn-outline-secondary btn-sm"
                    onclick="location.href='./list?currentPage=${currentPage}'">목록
            </button>
            <button type="button" class="btn btn-outline-secondary btn-sm"
                    onclick="$('html, body').animate({ scrollTop: 0 }, 'fast');">top
            </button>
        </td>
    </tr>
</table>
<script>
    $("#detailbtnDelete").click(function () {
        let a = confirm("정말 삭제하시겠습니까?");
        if (a) {
            location.href = "./delete?num=${dto.num}&currentPage=${currentPage}";
        }
    });
    $("#answerText").on("input", function () {
        let len = $(this).val().length;
        $("#answerNumber").text(len + "/1000");
    });
    $("#btnAnswerAdd").click(function () {
        let num = ${dto.num};
        let content = $("#answerText").val();
        if (content === '') {
            alert("댓글을 등록해주세요");
            return;
        }
        $.ajax({
            type: "post",
            dataType: "text",
            url: "/board/ansInsert",
            data: {"num": num, "content": content},
            success: function () {
                answer_list();
                //초기화
                $("#answerText").val("");
            }

        });
    });
    $(document).on("click", ".adel", function () {
        let aidx = $(this).attr("aidx");
        let a = confirm("해당 댓글을 삭제할까요?");
        if (a) {
            $.ajax({
                type: "get",
                dataType: "json",
                data: {"aidx": aidx},
                url: "./adelete",
                success: function () {
                    //댓글 삭제 후 목록 다시 출력
                    answer_list();
                }
            });
        }
    });

    function answer_list() {
        let num =${dto.num};
        let length =${list.size()};

        $.ajax({
            type: "get",
            dataType: "json",
            data: {"num": num},
            url: "./alist",
            success: function (data) {
                //댓글 개수 출력
                $("span.answerCount").text(data.list.length);
                //목록 출력
                let s = "";
                let loginok = "${sessionScope.loginok}";
                let loginid = "${sessionScope.loginid}";
                let stpath="${stPath}";


                for (let ele of data.list) {
                    for (let eleP of data.photolist) {
                        if (ele.myid === eleP.myid) {
                            s += `
                        <img src="\${stpath}/\${eleP.photo}" style="width: 40px; border-radius: 50%;" onerror="this.src='../save/noimage1.png'">
                        `;
                            break;
                        }
                    }
                    s += `
                \${ele.writer}(\${ele.myid})
                `;
                    if (loginok === 'yes' && loginid === ele.myid) {
                        s += `
                        <i class="bi bi-trash adel" aidx="\${ele.aidx}"></i>
                         `;
                    }
                    s += `<pre class="adata">\${ele.content}
                                <span class="aday">\${ele.writeday}</span></pre>

                <hr>
                `;
                }
                $(".answerlist").html(s);
            }
        })
    }
    $(function () {
        answer_list();
        //처음 시작시 content 번역
        trans_text();
        $("#seltrans").change(function (){
            trans_text();
        });

    })
    //번역해서 가져오는 함수
    function trans_text(){
        //번역할 문장
        let text=`${dto.content}`;
        //번역할 언어
        let translang=$("#seltrans").val();

        console.log(text);
        console.log(translang);
        $.ajax({
            type:"post",
            dataType:"text",
            url:"./trans",
            data:{"text":text,"translang":translang},
            success:function (data){
                // console.log(data);//json 형식의 문자열
                // console.log(typeof (data));
                let m=JSON.parse(data);
                //번역된 텍스트만 추출
                let s = m.message.result.translatedText;
                console.log(s);
                $("#trans_lang").html(s);


            }
        })
    }
    $("#audioTranslate").click(function (){
        let text=$("#trans_lang").text();
        let translang=$("#seltrans").val();
        let speaker;
        if(translang==="en"){
            speaker="clara";
        }else if(translang==="ja"){
            speaker="dmio";
        }else if(translang==="zh-CN"){
            speaker="meimei";
        }else{
            speaker="";
        }
        $.ajax({
            type: "POST",
            url: "./transVoice",
            data: {
                "text": text,
                "speaker": speaker
            },
            dataType: "text",
            success: function (data) {
                var audio = new Audio(data);
                audio.play();
            }
        });

    });
</script>
</body>
</html>