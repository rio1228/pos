<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	session.setAttribute("status", null);
%>
<DIV class="logo">
	<H2><a href="http://localhost:8080/PosSystem/retails/index.jsp">Pos</a></H2>
</DIV>

<c:choose>
	<c:when test="${name==null}">
	<FORM ACTION="../CommonLogin" method="post">
	<DIV id="form">
		<P id="userid"><INPUT name="user" type="text" placeholder="メールアドレス"></P>
		<P id="pass"><INPUT name="pass" type="password" placeholder="パスワード"></P>
	</DIV>

		<DIV id="login">
			<INPUT type="submit" value="ログイン">
		</DIV>
	</FORM>
		<DIV id="insert">
			<A href="http://localhost:8080/PosSystem/common/campany_insert.jsp">
			<INPUT type="button" value="新規会員登録"></A>
		</DIV>

	</c:when>

	<c:when test="${name!=null}">
		<DIV id="name">
			<%
				String campanyName = (String)session.getAttribute("name");
				out.print("<P>ようこそ"+campanyName+"様</P>");
			%>
		</DIV>

		<DIV id="settei" title="設定">
			<A href="http://localhost:8080/PosSystem/retails/settei.jsp"><IMG ALT="設定へ移動" SRC="../img/settei.png"></A>
		</DIV>
		<DIV id="logout" title="ログアウト">
			<A href="http://localhost:8080/PosSystem/common/logout.jsp"><IMG ALT="ログアウト" SRC="../img/logout.png"></A>
		</DIV>
		<DIV id="register" title="レジ">
			<A href="http://localhost:8080/PosSystem/retails/register.jsp" id="registerButton"><IMG ALT="レジへ移動" SRC="../img/register.png" ></A>
		</DIV>
	</c:when>
</c:choose>

