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
$(function(){ 
    $("#search").click(function() {
        $('#list_data').datagrid({
            title : '分享',
            iconCls : 'icon-ok',
            width : 'auto',
            queryParams: {
            	startTime: $('#startTime').datebox('getValue'),
       			endTime: $('#endTime').datebox('getValue')
        	}
       	  ,
            pageSize : 30,//默认选择的分页是每页5行数据
            pageList : [30,40,80 ],//可以选择的分页集合
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
            striped : true,//设置为true将交替显示行背景。
            collapsible : true,//显示可折叠按钮
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个
            url:'getShare',//url调用Action方法
            loadMsg : '数据装载中......',
//             singleSelect:true,//为true时只能选择单行
            fitColumns:true,//允许表格自动缩放，以适应父容器
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            remoteSort : false,
             frozenColumns : [ [ {
                field : 'ck',
                checkbox : true
            } ] ],
            pagination : true,//分页
            rownumbers : true//行数
        });
         
    });
    
//     $("#searchCount").click(function() {
//     	parent.$('#tt').tabs("add", {
//     	    title: '123123123',
//     	    content: '123',
//     	    closable: true
//     	});
//     });    
//     });
    
$("#searchCount").click(function() {
	parent.$('#bbody').layout('remove','east');
	parent.$('#bbody').layout('add',{
	    region: 'east',
	    id:'easst',
	    width: 180,
	    title: '分享人数',
	    href:'getShareCount',
	    queryParams: {
        	startTime: $('#startTime').datebox('getValue'),
   			endTime: $('#endTime').datebox('getValue')
    	},
	    split: true,
	    tools: [{
			iconCls:'icon-reload',
			handler:function(){
				parent.$('#easst').panel('refresh', 'getShareCount');
			}
	    }],
	});});


$("#searchOrder").click(function() {
	var par ;
	par="startTime="+$('#startTime').datebox('getValue')+"&endTime="+$('#endTime').datebox('getValue');
	var content = '<iframe scrolling="auto" frameborder="0"  src="'+"getShareOrder.jsp?"+par+'" style="width:100%;height:100%;"></iframe>';
	parent.$('#bbody').layout('remove','east');
	parent.$('#bbody').layout('add',{
	    region: 'east',
	    id:'easst',
	    content:content,
	    width: '600px',
	    title: '分享人数',
// 	    href:'getShareOrder',
// 	    queryParams: {
//         	startTime: $('#startTime').datebox('getValue'),
//    			endTime: $('#endTime').datebox('getValue')
//     	},
	    split: true,
// 	    tools: [{
// 			iconCls:'icon-reload',
// 			handler:function(){
// 				parent.$('#easst').panel('refresh', 'getShareOrder.jsp');
// 			}
// 	    }],
	});});
	
	
	
});

</script>
</head>
<body >
<!-- 	<div style="margin: 20px 0;"></div> -->
    <div id="toolbar">
     开始时间：<input id="startTime" class="easyui-datebox"></input>  结束时间：<input id="endTime"  class="easyui-datebox" />  
     <button id="search">查询</button>
     
 <button id="searchCount">查询分享人数</button>
  <button id="searchOrder">查询分享排行榜</button>
    </div>

	<table class="easyui-datagrid" id="list_data" 
		style="width: 'auto'; height: 'auto'"; toolbar="#toolbar";">
		<thead>
			<tr>
				<th data-options="field:'userid',width:'auto'">用户ID</th>
				<th data-options="field:'username',width:'auto'">用户名字</th>
				<th data-options="field:'userphone',width:'auto',align:'right'">用户手机</th>
				<th data-options="field:'newuserid',width:'auto',align:'right'">新用户ID</th>
				<th data-options="field:'newusername',width:'auto'">新用户名字</th>
				<th data-options="field:'newuserphone',width:'auto',align:'center'">新用户手机</th>
				<th data-options="field:'time',width:'auto',align:'center'">时间</th>
			</tr>
		</thead>
		
	</table>

</body>
</html>