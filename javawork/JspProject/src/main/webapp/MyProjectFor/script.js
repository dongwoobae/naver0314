const mysidebar = document.querySelector("nav.sidebar");
const toggleBtn = document.querySelector(".toggle-btn");
const mainmenu = document.querySelector(".list-item");
const submenu = document.querySelector(".submenu");

$(".submenu").hide();
toggleBtn.addEventListener("click", function () {
  mysidebar.classList.toggle("active");
  $(".submenu").slideUp();
});

function submitForm() {
        document.querySelector('.formSel').submit();
    }
    
$(document).ready(function () {
  $("nav.sidebar>ul.list>li.list-item>a").click(function (e) {
    e.preventDefault();
    let p = $("nav.sidebar").css("--p");
    if (parseInt(p) === 5) {
      $(this).siblings("ul.submenu").slideToggle();
      $(this).parent().siblings().find("ul.submenu").slideUp();
    }
    
  });
   
   
    
   $("#dashboard").click(function(){
	location.href="Homepage.jsp";
   });
   
   $("#cart").click(function(){
	location.href="cart.jsp";
   });
   
  });

// 장바구니 추가 버튼 클릭 이벤트 핸들러
$("button.btnApply").on("click", function () {
    // 클릭된 제품 정보 가져오기
    var productInfo = {
        company: $(this).parent().siblings("h3").text().trim(),
        name: $(this).parent().siblings("span").text().trim(),
        price: $(this).parent().text().trim(),
        photo: $(this).parent().siblings("img.productImage").attr("src").trim()
        
    };

    // 로컬 스토리지에 제품 정보 저장
    var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
    cartItems.push(productInfo);
    localStorage.setItem("cartItems", JSON.stringify(cartItems));
    alert("상품이 추가되었습니다");
});

$("#btnDelCartAll").on("click",function(){
	let confirmAllDel=confirm("장바구니 전체를 삭제하시겠습니까?");
	if(confirmAllDel){
		localStorage.removeItem("cartItems");
		location.reload();
	}
});

 $("main.container").on("click","button.btnDeleteEach",function(){
    	let confirmEachDel=confirm("해당 제품을 장바구니에서 삭제하시겠습니까?");
    	var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
    	var index = $(this).data("index");
    	if(confirmEachDel){
        // 해당 인덱스의 상품 정보를 로컬 스토리지에서 삭제
        cartItems.splice(index, 1);
        localStorage.setItem("cartItems", JSON.stringify(cartItems));
        // 페이지 다시 로드
        location.reload();
        }
    });
    
 $("#framePopup").click(function(){
	window.open("./myinsertitem/frameinsert.jsp", "frameinsert",
	 "width=400, height=330, left=100, top=50");
 });
 $("#drivetrainPopup").click(function(){
	window.open("./myinsertitem/drivetraininsert.jsp", "drivetraininsert",
	 "width=400, height=330, left=100, top=50");
 });
 $("#wheelPopup").click(function(){
	window.open("./myinsertitem/wheelinsert.jsp", "wheelinsert",
	 "width=400, height=330, left=100, top=50");
 });
