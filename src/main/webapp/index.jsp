<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.User"%>
<%
	User user = (User) session.getAttribute("admin");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Basic DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="js/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/demo/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function addTab(title, url) {
		if ($('#tt').tabs('exists', title)) {
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="jsp/'
					+ url + '" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add', {
				title : title,
				content : content,
				closable : true
			});

		}
	}
</script>

<style>
.footer {
	width: 100%;
	text-align: center;
	line-height: 35px;
}

.top-bg {
	background-color: #d8e4fe;
	height: 80px;
}
</style>

</head>

<body id="bbody" class="easyui-layout">
	<div region="north" border="true" split="true"
		style="overflow: hidden; height: 10px;">
		<div class="top-bg"></div>
	</div>



	<div region="west" split="true" title="导航菜单" style="width: 200px;">
		<div title="一点玩管理" iconcls="icon-save"
			style="overflow: auto; padding: 10px;">
			<ul id="yidianwan" class="easyui-tree">
				<li><span>一点玩</span>

					<ul>
						<li><span><a target="mainFrame"
								href="javascript:void(0)" onclick="addTab('分享','getShare2.jsp')">分享</a></span>
						</li>
						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('积分兑换','getScoreBuy.jsp')">积分兑换</a></span></li>
						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('进入和完成','getGameEnterAndFinish.jsp')">进入和完成</a></span>
						</li>
						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('签到','getCheckIn.jsp')">签到</a></span></li>

					</ul></li>

			</ul>


			<ul id="xintiao" class="easyui-tree">
				<li><span>心跳斗地主</span>

					<ul>

						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('充值','jieru_getPay.jsp')">充值</a></span></li>

						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('充值合计','jieru_getPayManage.jsp')">充值合计</a></span></li>

					</ul></li>

			</ul>

	<ul id="qmgz" class="easyui-tree">
				<li><span>全民国战</span>

					<ul>

						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('充值','jieru_getPay.jsp')">充值</a></span></li>

						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('充值合计','jieru_getPayManage.jsp')">充值合计</a></span></li>

					</ul></li>

			</ul>
			
			
			<ul id="jieru" class="easyui-tree">
				<li><span>接入网游查询</span>

					<ul>

						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('充值','jieru_admin_getPay.jsp')">充值</a></span></li>

						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('充值合计','jieru_admin_getPayManage.jsp')">充值合计</a></span></li>

					</ul></li>
			</ul>

			<ul id="shuju" class="easyui-tree">
				<li><span>数据</span>

					<ul>
						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('用户查询','shuju_queryYDUser.jsp')">用户查询</a></span></li>
						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('每日注册数','shuju_regnum.jsp')">每日注册数</a></span></li>
						<li><span><a target="mainFrame"
								href="javascript:void(0)"
								onclick="addTab('留存','shuju_liucun.jsp')">留存</a></span></li>

					</ul></li>

			</ul>
		</div>
	</div>
	<div id="mainPanle" region="center" style="overflow: hidden;"
		class="easyui-layout">

		<div id="tt" class="easyui-tabs"
			style="width: 'auto'; height: 'auto';">
			<div title="Home">
				<input id="hi" type="hidden" value="<%=user.getGroup()%>" />
			</div>
		</div>


	</div>
	<script type="text/javascript">
		function hideSome() {
			var type = $("#hi").val();
			if (type == '' || type == 0) {
				window.location = "login.jsp";
			}
			
			$(".easyui-tree").hide();

			if (type == 7) {
				$("#xintiao").show();
			}

			if (type == 8) {
				$("#shuju").show();
			}
			if (type == 6) {
				$("#qmgz").show();
			}
			if(type==1){
				$("#yidianwan").show();
				$("#shuju").show();
				$("#jieru").show();
				
			}
			
		}
		$(document).ready(function() {
			hideSome();
		});
	</script>
</body>

</html>