<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/view/color.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/board/boardList.jsp</title>
<link rel="stylesheet" href="/struts/board/common/css/css.css" type="text/css">
<script type="text/javascript">
	function focusIt() {
		document.inform.id.focus();
	}
	function checkIt() {
		inputForm = eval("document.inform");
		if (!inputForm.id.value) {
			alert("���̵� �Է��ϼ���..");
			inputForm.id.focus();
			return false;
		}
		if (!inputForm.passwd.value) {
			alert("��й�ȣ�� �Է��ϼ���..");
			inputForm.passwd.focus();
			return false;
		}
	}
</script>
</head>
<body onload="focusIt();" bgcolor='${bodyback_c }'>
<c:if test='${sessionScope.memId == null }'>
	<form action="inform" method="post" action="loginPro.action" onsubmit="return checkIt();">
		<table>
			<thead></thead>
		</table>
	</form>
	
</c:if>
	<table>
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>�۾���</th>
				<th>��¥</th>
			</tr>
		</thead>
	</table>
</body>
</html>