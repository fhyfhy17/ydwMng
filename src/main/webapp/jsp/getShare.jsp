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
	    url : "getShare",//指向后台返回datagrid需要json的url
	    data : {
	    	startTime: $('#startTime').datebox('getValue'),
			endTime: $('#endTime').datebox('getValue')
	    },
	    type : "get",
	    dataType : "json",
	    success : function(data){
	    		  $('#list_data').datagrid('loadData', data);
	    }
	});
}
$(function(){$('#pp').pagination({
    total:2000,
    pageSize:10,
    onSelectPage: function(pageNumber, pageSize){
        $('#content').panel('refresh', 'getShareCount?page='+pageNumber+'&size='+pageSize);
    }
});
});





</script>

</head>
<body >
<!-- 	<div style="margin: 20px 0;"></div> -->
    <div id="toolbar">
     开始时间：<input id="startTime" class="easyui-datebox"></input>  结束时间：<input id="endTime"  class="easyui-datebox"></input> <a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
    </div>
<!--     <div region="south" border="true" split="true" style="overflow: hidden; height: 60px;"> -->
<!--      		 <div class="footer">   -->
<!--      			<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div> -->
<!-- 			</div> -->
<!--     </div> -->
	<table class="easyui-datagrid" id="list_data" 
		style="width: 'auto'; height: '500px'"; toolbar="#toolbar";">
		<thead>
			<tr>
				<th data-options="field:'userid',width:'auto'">用户ID</th>
				<th data-options="field:'username',width:'auto'">用户名字</th>
				<th data-options="field:'userphone',width:'auto',align:'right'">用户手机</th>
				<th data-options="field:'newuserid',width:'auto',align:'right'">新用户ID</th>
				<th data-options="field:'newusername',width:'auto'">新用户名字</th>
				<th data-options="field:'newuserphone',width:'auto',align:'center'">新用户手机</th>
				<th data-options="field:'time',width:'auto',align:'center'">时间</th>
				<th data-options="field:'count',width:'auto',align:'center'">总分享数</th>
			</tr>
		</thead>
		
	</table>
		<div id="pp" style="background:#efefef;border:1px solid #ccc;height:40px"></div>
</body>
</html>