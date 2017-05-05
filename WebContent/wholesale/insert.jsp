<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卸売様用会員登録フォーム</title>
<link rel="stylesheet" type="text/css" href="css/basic.css">
</head>
<body>
	<%
		String insert = request.getRequestURI();
		session.setAttribute("insertURI", insert);
		/* 認証失敗から呼び出されたのかどうか */
		Object namecheck = session.getAttribute("namecheck");
		Object nameok = session.getAttribute("nameok");//チェックサーブレットでつけないとダメ
		/*最初のページではnullが設定されている*/
		if(namecheck != null)
		{
			out.println("<p>その会社名は使われております</p>");
		    out.println("<p>再度会社名を入力して下さい</p>");
			session.setAttribute("namecheck", null);
		}
		else if(nameok != null)
		{
			out.println("<p>その会社名は使用可能です</p>");
		}
	%>
		<H1>会員登録フォーム</H1>
		<H2>以下の内容をご記入ください</H2>
		<FORM ACTION="../InsertDb" method="post">
		<P>会社名</P>
		<INPUT type="text" name="company">
		<P>パスワード</P>
		<INPUT type="password" name="pass" maxlength="8">
		<P>苗字</P>
		<INPUT type="text" name="name1">
		<P>名前</P>
		<INPUT type="text" name="name2">
		<P>苗字(フリガナ)</P>
		<INPUT type="text" name="name3">
		<P>名前(フリガナ)</P>
		<INPUT type="text" name="name4"><BR><BR>
		郵便番号：
		〒<input type="text" name="postcode1" maxlength="3"> - <input type="text" name="postcode2" maxlength="4"><br />

		都道府県：
		<select name="prefecture">
			<option value="0" selected>（未選択）</option>
			<option value="1">北海道</option>
			<option value="2">青森県</option>
			<option value="3">秋田県</option>
			<option value="4">岩手県</option>
			<option value="5">山形県</option>
			<option value="6">宮城県</option>
			<option value="7">福島県</option>
			<option value="8">茨城県</option>
			<option value="9">栃木県</option>
			<option value="10">群馬県</option>
			<option value="11">埼玉県</option>
			<option value="12">神奈川県</option>
			<option value="13">千葉県</option>
			<option value="14">東京都</option>
			<option value="15">山梨県</option>
			<option value="16">長野県</option>
			<option value="17">新潟県</option>
			<option value="18">富山県</option>
			<option value="19">石川県</option>
			<option value="20">福井県</option>
			<option value="21">岐阜県</option>
			<option value="22">静岡県</option>
			<option value="23">愛知県</option>
			<option value="24">三重県</option>
			<option value="25">滋賀県</option>
			<option value="26">京都府</option>
			<option value="27">大阪府</option>
			<option value="28">兵庫県</option>
			<option value="29">奈良県</option>
			<option value="30">和歌山県</option>
			<option value="31">鳥取県</option>
			<option value="32">島根県</option>
			<option value="33">岡山県</option>
			<option value="34">広島県</option>
			<option value="35">山口県</option>
			<option value="36">徳島県</option>
			<option value="37">香川県</option>
			<option value="38">愛媛県</option>
			<option value="39">高知県</option>
			<option value="40">福岡県</option>
			<option value="41">佐賀県</option>
			<option value="42">長崎県</option>
			<option value="43">熊本県</option>
			<option value="44">大分県</option>
			<option value="45">宮崎県</option>
			<option value="46">鹿児島県</option>
			<option value="47">沖縄県</option>
		</select><br />

		市区町村：
		<input type="text" name="citytown"><br />

		番地など：
		<input type="text" name="lastaddress"><br />
		<P>メールアドレス</P>
		<INPUT type="text" name="address">
		<P>携帯電話番号(ハイフンなし)</P>
		<INPUT type="text" name="denwa">

		<INPUT type="submit">
		<INPUT type="reset">
	</FORM>
</body>
</html>