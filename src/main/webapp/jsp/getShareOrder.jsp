<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Basic DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../js/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/demo/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<script type="text/javascript">
function GetRequest() {
	   var url = location.search; //获取url中"?"符后的字串
	   var theRequest = new Object();
	   if (url.indexOf("?") != -1) {
	      var str = url.substr(1);
	      strs = str.split("&");
	      for(var i = 0; i < strs.length; i ++) {
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
	      }
	   }
	   return theRequest;
	}


$(function(){ 
	var Request = new Object();
	Request = GetRequest();
	var a,b;
	a = Request['startTime'];
	b = Request['endTime'];

        $('#list_data').datagrid({
            title : '分享排行',
            iconCls : 'icon-ok',
            width : 'auto',
            queryParams: {
            	startTime:a,
       			endTime: b
        	}
       	  ,
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
            striped : true,//设置为true将交替显示行背景。
            url:'getShareOrder',//url调用Action方法
            loadMsg : '数据装载中......',
//             singleSelect:true,//为true时只能选择单行
            fitColumns:true,//允许表格自动缩放，以适应父容器
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            remoteSort : false,
//              frozenColumns : [ [ {
//                 field : 'ck',
//                 checkbox : true
//             } ] ]
        });
         

//   	  $('#list_data').datagrid('loadData', data);
});


</script>
</head>
<body >
<!-- 	<div style="margin: 20px 0;"></div> -->


	<table class="easyui-datagrid" id="list_data" 
		style="width: 'auto'; height: '500px'">
		<thead>
			<tr>
				<th data-options="field:'userid',width:'auto'">用户ID</th>
				<th data-options="field:'username',width:'auto'">用户名字</th>
				<th data-options="field:'count',width:'auto'">分享数</th>
			
			</tr>
		</thead>
		
	</table>

</body>
</html>