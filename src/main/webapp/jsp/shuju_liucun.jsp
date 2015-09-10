<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Basic DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../js/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/demo/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
function doSearch(){
	$.ajax({
	    url : "queryLiucun",//指向后台返回datagrid需要json的url
	    data : {
	    	startTime: $('#startTime').datebox('getValue')
	    },
	    type : "get",
	    dataType : "json",
	    success : function(data){
	    		  $('#list_data').datagrid('loadData', data);
	    }
	});
}

</script>

</head>
<body >
    <div id="toolbar">
     开始时间：<input id="startTime" class="easyui-datebox"></input><a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
    </div>

	<table class="easyui-datagrid" id="list_data" 
		style="width: 'auto'; height: '500px'"; toolbar="#toolbar";">
		<thead>
			<tr>
				<th data-options="field:'liucun1',width:'auto'">次日留存</th>
				<th data-options="field:'liucun3',width:'auto'">3日留存</th>
				<th data-options="field:'liucun7',width:'auto'">7日留存</th>
				<th data-options="field:'liucun30',width:'auto'">30日留存</th>
			</tr>
		</thead>
		
	</table>

</body>
</html>