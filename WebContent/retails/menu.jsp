<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!-- ハンバーガーボタン -->
<button type="button" class="drawer-toggle drawer-hamburger">
  <span class="sr-only">toggle navigation</span>
  <span class="drawer-hamburger-icon"></span>
</button>

<nav class="drawer-nav">
  <ul class="drawer-menu">
    <!-- ドロワーメニューの中身 -->
    <li class="drawer-dropdown">
    <a data-toggle="dropdown"><BUTTON class="button" id="analysis"><P>分析</P></BUTTON></a>
      <ul class="drawer-dropdown-menu">
        <li><a href="http://localhost:8080/PosSystem/retails/marketing_analysis.jsp"><BUTTON id="marketing-analisis" class="button2">酒別売上分析</BUTTON></a></li>
        <li><BUTTON id="marketing-analisis-product" class="button2"><P>売上分析</P></BUTTON></li>
        <li><BUTTON id="sales-analisis" class="button2"><P>販売分析</P></BUTTON></li>
      </ul>
  	</li>
  	<li class="drawer-dropdown">
    <a data-toggle="dropdown"><BUTTON class="button"><P>管理</P></BUTTON></a>
      <ul class="drawer-dropdown-menu">
        <li><BUTTON id="ordering-management" class="button2"><P>発注管理</P></BUTTON></li>
        <li><BUTTON id="inventory-management" class="button2"><P>在庫管理</P></BUTTON></li>
        <li><BUTTON id="daily-report-management" class="button2"><P>日報管理</P></BUTTON></li>
        <li><BUTTON id="sales-management" class="button2"><P>売上管理</P></BUTTON></li>
      </ul>
  	</li>
  	<li class="drawer-dropdown">
    <a data-toggle="dropdown"><BUTTON class="button"><P>登録</P></BUTTON></a>
      <ul class="drawer-dropdown-menu">
        <li><BUTTON id="goods-register" class="button2"><P>商品登録</P></BUTTON></li>
        <li><BUTTON id="goods-update" class="button2"><P>商品情報変更</P></BUTTON></li>
        <li><BUTTON id="sales-register" class="button2"><P>売上登録</P></BUTTON></li>
      </ul>
  	</li>
  	<li class="drawer-dropdown">
    <a data-toggle="dropdown"><BUTTON class="button"><P>その他</P></BUTTON></a>
      <ul class="drawer-dropdown-menu">
        <li><BUTTON id="user_info" class="button2"><P>ユーザー情報</P></BUTTON></li>
        <li><BUTTON id="others" class="button2"><P>その他設定</P></BUTTON></li>
      </ul>
  	</li>
  </ul>
</nav>