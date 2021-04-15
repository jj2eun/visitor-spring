<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	textarea {
	display: block;
	}
	#visitor{
		background-color: #80808042;
		width: 500px;
		margin: 0px auto;
	}
</style>
<script type="text/javascript">
/* 수정버튼 함수(update) */
function update(_this){
	//debugger;
	// 삭제 버튼 지우기
	$(_this).parent().children("input[value='삭제']").remove();
	// 비밀번호 input태그 추가
	$(_this).before("<input type='password' name='vPwd' placeholder='비밀번호' size='5'>");
	// textarea의 readonly 해제
	$(_this).parent().children().first().prop("readonly", false);
	// 수정버튼 문구 수정완료로 변경
	$(_this).val("수정완료");
	// 수정버튼 onclick함수의 메소드 변경
	$(_this).attr("onclick", "updateConfirm(this);");
}
/* 수정버튼 함수의 실제 기능  */
function updateConfirm(_this){
	var no = $(_this).parent().children("input[name='vNo']").val();
	var content = $(_this).parent().children().first().val();
	var auth = $(_this).parent().children().eq(1).text();
	var regDt = $(_this).parent().children().eq(2).text();
	var pwd = $(_this).parent().children("input[name='vPwd']").val();
	
	var updateData = {
			"vNo": no,
			"vContent": content,
			"vAuth": auth,
			"vRegDt": regDt,
			"vPwd": pwd 
	};
	
	$.ajax({
		url: "${path}/visit/update",
		type: "post",
		data: updateData,
		success: function(result){
			if(result=="수정 완료") {
				alert("수정 완료!");
				$(_this).parent().children().first().val(content);
				$(_this).parent().children().first().prop("readonly", true);
				$(_this).parent().children("input[name='vPwd']").remove();
				$(_this).val("수정");
				$(_this).attr("onclick", "update(this);");
				$(_this).after("<input type='button' onclick='deleteBtn(this);' value='삭제'>");
			} else if(result=="수정 실패"){
				alert("수정 실패!");
				var oriContent = $(_this).parent().children("input[name='oriContent']").val();
				$(_this).parent().children().first().val(content);
				$(_this).parent().children().first().prop("readonly", true);
				$(_this).parent().children("input[name='vPwd']").remove();
				$(_this).val("수정");
				$(_this).attr("onclick", "update(this);");
				$(_this).before("<input type='button' onclick='deleteBtn(this);' value='삭제'>");
			} else if(result == "비밀번호 오류") {
				alert("비밀번호가 틀렸습니다!");
				$(_this).parent().children().first().prop("readonly", false);
				$(_this).parent().children("input[name='vPwd']").val("");
			}
		}
	});
		
}
/* 삭제버튼 */
function deleteBtn(_this){
	// 수정버튼 삭제
	$(_this).parent().children("input[value='수정']").remove();
	// 비밀번호 추가
	$(_this).before("<input type='password' name='vPwd' placeholder='비밀번호' size='5'>");	
	// 삭제완료버튼으로 변화
	$(_this).val("삭제완료");
	// 삭제완료버튼 onclick 메소드 변경
	$(_this).attr("onclick","deleteConfirm(this);");
}
/* 삭제완료 버튼 작동 기능 */
function deleteConfirm(_this){
	var no = $(_this).parent().children("input[name='vNo']").val();
	var pwd = $(_this).parent().children("input[name='vPwd']").val();
	
	var deleteData = {
		"vNo": no,
		"vPwd": pwd
	};
	
	$.ajax({
		url: "${path}/visit/delete",
		type: "post",
		data: deleteData,
		success: function(result){
			if(result == "삭제 완료"){
				alert("삭제 완료!");
				// 해당 폼태그 삭제
				$(_this).parent().remove();
			} else if(result == "삭제 실패"){
				alert("삭제 실패!");
			} else if(result == "비밀번호 오류"){
				alert("비밀번호가 틀렸습니다!");
				$(_this).parent().children("input[name='vPwd']").val("");
			}
		}
	});
}
</script>
</head> 
<body>
	<div id="visitor">
		<h1>환영합니다~ 나의 방명록 입니다.</h1>
		<a href="${path}/member/login">로그인</a>
		<a href="${path}/member/logout">로그아웃</a>
		<%-- ${세션값} 담기 --%>
		${sessionScope.login}님
		<hr>
		<h3>방명록 작성</h3>
			<div class="visitor-box">
				<form action="${path}/visit/v-regist" method="post">
					<textarea name="vContent" rows="10" cols="60"></textarea>
					<input type="text" name="vAuth" placeholder="작성자" size="10">
					<input type="password" name="vPwd" placeholder="글 수정/삭제 비밀번호" size="10">
					<input type="submit" value="등록">
				</form>
			</div>
		<hr>
		<h3>방명록 목록</h3>
		<div id="visitor-list">
			<c:forEach items="${vList}" var="vo">
				<form action="" method="post" class="del-form">
					<textarea rows="10" cols="60" readonly="readonly">${vo.vContent}</textarea>
					작성자: <span>${vo.vAuth}</span>
					작성일자: <span>
							<fmt:formatDate value="${vo.vRegDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</span>
					<input type="button" onclick="update(this);" value="수정">
					<input type="button" onclick="deleteBtn(this);" value="삭제">
					<input type="hidden" name="vNo" value="${vo.vNo}">
					<input type="hidden" name="oriContent" value="${vo.vContent}">
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>