<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レジ</title>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
  src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/register.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/jquery.keypad.css">
<link type="text/css" rel="stylesheet"
  href="http://code.jquery.com/ui/1.10.3/themes/cupertino/jquery-ui.min.css" />
  <link href="https://fonts.googleapis.com/earlyaccess/roundedmplus1c.css" rel="stylesheet" />
</head>
<body>
	<DIV ID="wrapper">
		<DIV id="main">
			<DIV id="back"><P><a href="http://localhost:8080/PosSystem/retails/index.jsp"><INPUT type="button"value="←戻る"></a></P></DIV>
			<DIV id="register-contents">
				<DIV id="part1">
					<DIV id="register">
						<DIV id="reji_body">
							<TABLE id="register_body">
							</TABLE>
						</DIV>
						<DIV id="product_quantity">
								<P>数量：0点</P>
						</DIV>
					</DIV>

					<DIV id="sub-contents">
						<DIV id="barcode">
							バーコードリーダー：<INPUT type="text" id="reader">
							<BUTTON id="insert">検索</BUTTON>
						</DIV>
						<DIV id="product-group">
							<BUTTON class="button" class="red" class="product-button" value="4562101973462"><P>ドメーヌ ルバイヤート</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="4562101973493"><P>プティ ルバイヤート</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="4562101972731"><P>「塩尻収穫」</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="4972212010879"><P>楽園ワイン1800</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="4904339454847"><P>ガルナッチャ NEW</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="4004068110158"><P>マドンナ Ｒ </P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="8008530072209"><P>ランブル ロッソ</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="3438931009415"><P>デユツク ブリユツト</P></BUTTON>
							<BUTTON class="button" class="red" class="product-button" value="4901777187955"><P>フレシネ ネグロ</P></BUTTON>

						</DIV>
					</DIV>

				</DIV>
				<DIV id="part2">
					<DIV id="part2-1">
						<TABLE id="casher" BORDER="1">
							<TR>
								<TD id="totalHead">小計</TD>
								<TD class="price" id="totalprice" class="p-word"><P>\0</P></TD>
							</TR>
							<TR>
								<TD id="taxHead">外税</TD>
								<TD class="price" id="tax" class="p-word"><P>\0</P></TD>
							</TR>
							<TR>
								<TD id="sumHead">合計</TD>
								<TD class="price" id="summary" class="p-word"><P>\0</P></TD>
							</TR>
							<TR>
								<TD id="depoHead">現金</TD>
								<TD class="price" id="depo" ><INPUT id="keypad" type="text"></TD>
							</TR>
							<TR>
								<TD id="changeHead">おつり</TD>
								<TD class="price" id="change" class="p-word"><P>\0</P></TD>
							</TR>
						</TABLE>

						<DIV id="attribute">
							<TABLE id="attrTable" BORDER="1">
								<TR>
									<TD id="user_name">ユーザーID</TD>
									<TD id="user_span"><P>なし</P></TD>
								</TR>
								<TR>
									<TD id="name">名前</TD>
									<TD id="name_span"><P>ゲスト様</P></TD>
								</TR>
								<TR>
									<TD id="sex">性別</TD>
									<TD id="sex_span"><P>男<INPUT name="sex" type="radio" VALUE="1" CHECKED="checked">
							 			女<INPUT name="sex" type="radio" VALUE="2"></P></TD>
								</TR>
								<TR>
									<TD id="age_layer">年代層</TD>
									<TD id="age_span"><SELECT id="age_select">
										<OPTION value="0" SELECTED>（未選択）</option>
										<OPTION value="1" >20代前半</option>
										<OPTION value="2" >20代後半</option>
										<OPTION value="3" >30代前半</option>
										<OPTION value="4" >30代後半</option>
										<OPTION value="5" >40代前半</option>
										<OPTION value="6" >40代後半</option>
										<OPTION value="7" >50代</option>
										<OPTION value="8" >60代以降</option>
										</SELECT></TD>
								</TR>
							</TABLE>
						</DIV>
					</DIV>
					<DIV id="accounting">
					<BUTTON id="delete">削除</BUTTON>
					<BUTTON id="discount">割引</BUTTON>
					<BUTTON class="other">その１</BUTTON>
					<BUTTON class="other">その２</BUTTON>
					<BUTTON class="other">その３</BUTTON>
					<BUTTON class="other">その４</BUTTON>
					<BUTTON class="other">その５</BUTTON>
					<BUTTON class="other">その６</BUTTON>
					<BUTTON class="other">その７</BUTTON>
					<BUTTON class="other">その８</BUTTON>
					<BUTTON class="other">その９</BUTTON>
					<BUTTON class="other">その10</BUTTON>
					<BUTTON class="other">その11</BUTTON>
					<BUTTON class="other">その12</BUTTON>
					<BUTTON class="other">その13</BUTTON>
					<BUTTON class="other1">その14</BUTTON>
					<BUTTON class="other1">その15</BUTTON>
					<BUTTON class="other1">その16</BUTTON>
					<BUTTON class="other1">その17</BUTTON>
					<BUTTON id="deposit">現計</BUTTON>
					<BUTTON class="other2">その18</BUTTON>
					<BUTTON class="other2">その19</BUTTON>
					<BUTTON class="other2">その20</BUTTON>
					<BUTTON class="other2">その21</BUTTON>

					</DIV>
				</DIV>
			</DIV>
		</DIV>
	</DIV>
<SCRIPT TYPE="text/javascript" SRC="http://localhost:8080/PosSystem/js/vendor/jquery.json.min.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC="http://localhost:8080/PosSystem/js/vendor/keypad/jquery.plugin.min.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC="http://localhost:8080/PosSystem/js/vendor/keypad/jquery.keypad.min.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC="http://localhost:8080/PosSystem/js/common/keypad.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC="http://localhost:8080/PosSystem/js/common/register.js"></SCRIPT>


</body>
</html>