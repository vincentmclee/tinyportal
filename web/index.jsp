<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
  "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>桃園縣政府e化資訊平台登入頁</title>
	<link href="${contextPath}/style.css" rel="stylesheet" type="text/css">
  </head>
  <body>
	<table width="30%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
		<td colspan="2" align="left" valign="top" class="top_bg">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			  <td align="right" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="750" height="1"></td>
			</tr>
			<tr>
			  <td align="right" valign="top" class="top_font"><a href="http://www.tycg.gov.tw/" target="_blank">桃園縣府入口網</a>│線上課程</td>
			</tr>
		  </table>
		</td>
	  </tr>
	  <tr>
		<td colspan="2" align="left" valign="top">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			  <td align="left" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
					<td align="left" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="502" height="2"></td>
				  </tr>
				  <tr>
					<td align="left" valign="top" class="logo_banner"><img src="${contextPath}/images/logo.jpg" alt="桃園縣政府e化資訊平台" width="279" height="114"></td>
				  </tr>
				  <tr>
					<td align="left" valign="top">
					  <table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						  <td align="left" valign="top"><span class="main_fontb">(1)新版員工入口網系統上線囉！</span><br>
							<span class="main_font">員工入口網使用者手冊請<a href="#">下載</a>，相關問題請來電：04-22065001</span><br>
							<br>
							<span class="main_fontb">(2)使用e公務訊息精靈接收訊息零時差！</span><br>
							<span class="main_font">e公務訊息精靈安裝檔請下載，安裝說明文件請<a href="#">下載</a>。</span></td>
						</tr>
					  </table>
					</td>
				  </tr>
				</table>
			  </td>
			  <td align="left" valign="top" class="right_downbg">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				  <tr>
					<td align="left" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="248" height="2"></td>
				  </tr>
				  <tr>
					<td align="left" valign="top">
					  <table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						  <td width="100%" align="left" valign="top"><img src="${contextPath}/images/img01.jpg" alt="登入員工入口網" width="248" height="114"></td>
						</tr>
						<tr>
						  <td align="left" valign="top">
							<form id="login_form" name="login_form" method="post" action="${contextPath}/app/portal/login">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							  <tr>
								<td width="8%" rowspan="11" align="left" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="22" height="5"></td>
								<td width="92%" align="left" valign="top">
								  <table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tiny:flash var="login_message" key="message" />
	                                <c:if test="${login_message != null}">
									<tr>
									  <td colspan="2" align="center">
										<span class="error">${login_message}</span>
									  </td>
									</tr>
									</c:if>
									<tr>
									  <td width="43%" align="left" valign="top" class="login_font">‧使用者帳號：</td>
									  <td width="57%" align="left" valign="middle">
										<input id="j_username" name="j_username" type="text" class="login_line" size="15" value="${j_username}">
									  </td>
									</tr>
									<tr>
									  <td align="left" valign="top" class="login_font">‧使用者密碼：</td>
									  <td align="left" valign="middle">
										<input id="j_password" name="j_password" type="password" class="login_line" size="15">
									  </td>
									</tr>
								  </table>
								</td>
							  </tr>
							  <tr>
								<td align="left" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="22" height="10"></td>
							  </tr>
							  <tr>
								<td align="left" valign="top">
								  <input id="remeber_me" name="remeber_me" type="checkbox">
								  <span class="login_font">記住我的帳號密碼</span><span class="login_blue">【<a href="#">說明</a>】</span>
								</td>
							  </tr>
							  <tr>
								<td align="left" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="22" height="10"></td>
							  </tr>
							  <tr>
								<td align="center" valign="top"><input class="btn" name="submit2" type="submit" value="登入" /></td>
							  </tr>
							  <tr>
								<td align="right" valign="top" class="login_font"><a href="#">無法登入</a>│<a href="#">登入說明</a></td>
							  </tr>
							  <tr>
								<td><hr style="border: #999999 dashed 1px;"></td>
							  </tr>
							  <tr>
								<td align="left" valign="top"><img src="${contextPath}/images/d.gif" alt="" width="22" height="10"></td>
							  </tr>
							  <tr>
								<td align="center" valign="top" bgcolor="#e8e8e8">
								  <table width="95%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									  <td align="left" valign="top" class="login_font">還沒有申請e化資訊平台帳號？註冊帳號免費又方便。</td>
									</tr>
									<tr>
									  <td align="left" valign="top">&nbsp;</td>
									</tr>
									<tr>
									  <td align="right" valign="top" class="login_fontb">【<a href="#">立即註冊</a>】</td>
									</tr>
								  </table>
								</td>
							  </tr>
							  <tr>
								<td align="left" valign="top">&nbsp;</td>
							  </tr>
							</table>
							</form>
						  </td>
						</tr>
					  </table>
					</td>
				  </tr>
				</table>
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
	  <tr>
		<td colspan="2" align="left" valign="top">&nbsp;</td>
	  </tr>
	  <tr>
		<td colspan="2" align="left" valign="top" class="downbg">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			  <td align="left" valign="top" class="p_font"><a href="#">隱私權保護 </a>│ <a href="#">安全政策</a></td>
			</tr>
		  </table>
		</td>
	  </tr>
	  <tr>
		<td colspan="2" align="left" valign="top" class="p_font">‧地址：( 33001 )桃園市縣府路一號／TEL：886-3-3322101<br>
		  ‧版權所有 © 桃園縣政府 Copyright 2009 Taoyuan County Government. All rights reserved.<br>
		  ‧建議解析度 1024*768  建議使用IE6.0以上或Firefox   尊重智慧財產權請勿任意轉載作商業用途</td>
	  </tr>
	</table>
  </body>
</html>
