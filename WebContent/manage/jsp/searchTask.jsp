<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务查询</title>
<link href="../../static/css/base.css" rel="stylesheet">
<link rel="stylesheet" href="../../static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/icon.css">
<style type="text/css">
.a {
	text-decoration: none;
}
</style>
</head>
  <script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
<!--   <script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script> -->
  <script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
<!--   <script type="text/javascript" src="../../static/js/notice.js"></script> -->
  <script type="text/javascript">
   /**
    *打开在父窗口中打开window
    */
    function openTopWindow(options){
    	options = !options ? {} :options;
        options.width = !options.width ? 500 : options.width;
        options.height = !options.height ? 400 : options.height;
        options.url = !options.url ? "404.html" : options.url;
        options.title = !options.title ? "" : options.title;
        parent.$("#topWindow").window({
           title : options.title,
           width: options.width,
           height: options.height,
           content : "<iframe scrolling='no' frameborder='0' border='0' height='100%' width='100%' src='"+options.url+"'></iframe>",
           modal:true,
           resizable:false,
           collapsible:false
        });
    }
    /**
    *   添加处理函数
  	**/
  //刷新
    function doSearch() {
			$('#dg').datagrid("load",{
				"payerCode":$("#payerCode").val(),
				"payerName":$("#payerName").val()
			});
		} 
  	
  //查询操作函数定义
    /* function doSearch(){  
		$("#dg").datagrid("reload","../../ListTaxsourceServlet.json?"+$("#conForm").serialize())
	} */
    
     //查询任务详细信息
     function xiangqing(id){    	           
	    openTopWindow({"url":"../../TaskInfoServlet.json?id="+id,
	   	"title":"任务信息",	   		 	
	   	 width : 750,
         height : 600,
		})
	    doSearch()	           	             
     }
     //删除
      function del(id){	
    	  $.messager.confirm('操作提示', '确定要删除吗?', function(r){
				if (r){
				     $.post( 
				    	"../../DeleteTaskServlet.json",
				    	{"id":id},
				    	function(data){
					       if(data.success){
			           			alert(data.msg),
			           			doSearch()	
			           		}else{
			           			alert(data.msg)
			           		}
				    },
				    "json"
				    ),
				    doSearch()	   
				}
  		   });
      }
     //修改
     function update(id){
     	openTopWindow({ 
     		  url:"../../UpdateTaskServlet.json?id="+id,
	   		  title:"修改任务信息",	   		 	
	   		  width : 850,
              height : 700,
		})
		doSearch() 
     }
  </script> 
<body>
	<div class="container">
		<table id="dg">
		</table>
		<div id="tb" style="padding: 0 30px;">
			<form id="conForm">
				<div class="conditions">
					<span class="con-span">纳税人识别号: </span>
						<input type="text" name="payerCode" id="payerCode" style="width: 166px; height: 35px; line-height: 35px;"> 
					<span class="con-span">纳税人名称: </span>
						<input type="text" name="payerName" id="payerName" style="width: 166px; height: 35px; line-height: 35px;"> 
					<span class="con-span">税务机关: </span> 
						<select name="subOrganId" style="width: 166px; height: 35px; line-height: 35px;">
						<option value="-1">请选择税务机关</option>
						<option value="1">中国国税局</option>
	                    <option value="2">北京市国税局</option>
	                    <option value="3">天津市国税局</option>
	                    <option value="4">上海市国税局</option>
	                    <option value="5">深圳市国税局</option>
	                    <option value="6">武汉市国税局</option>
	                    <option value="7">杭州市国税局</option>
	                    <option value="8">郑州市国税局</option>
						</select> 
					<span class="con-span">行业: </span> 
						<select name="industryId" style="width: 166px; height: 35px; line-height: 35px;">
						<option value="-1">请选择行业</option>
						<option value="1">计算机应用相关</option>
                        <option value="2">房地产</option>
                        <option value="3">生物医药</option>
                        <option value="4">金融</option>
                        <option value="5">汽车工业</option>
                        <option value="6">通讯工程</option>
						</select>
				</div>
				<div class="conditions">
					<span class="con-span">任务开始时间(执行): </span>
						<input class="easyui-datebox" type="text" name="startDate" style="width: 166px; height: 35px; line-height: 35px;"> 
					<span class="con-span">任务结束时间(执行): </span>
						<input class="easyui-datebox" type="text" name="endDate" style="width: 166px; height: 35px; line-height: 35px;"> 
					<a href="javascript:void(0);" class="easyui-linkbutton"	iconCls="icon-search" id="searchTask" data-options="selected:true">查询</a>
					<a href="javascript:void(0);" class="easyui-linkbutton"	id="resetTask" iconCls="icon-reload">重置</a> 
					<a href="javascript:void(0);" class="easyui-linkbutton more" iconCls="icon-more">更多</a>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	/**
	 *打开在父窗口中打开window
	 */
	function openTopWindow(options) {
		options = !options ? {} : options;
		options.width = !options.width ? 500 : options.width;
		options.height = !options.height ? 400 : options.height;
		options.title = !options.title ? "" : options.title;
		parent.$("#iframe").attr("src", options.url);
		parent.$("#topWindow").window({
			title : options.title,
			width : options.width,
			height : options.height,
			modal : true,
			resizable : true,
			collapsible : false,
		});
	}
		
	
$(function() {
	$('#dg').datagrid({
	   title:"纳税人信息",
 	   url:'../../ListTaxsourceServlet.json', 
 	   toolbar:"#tb",
 	   coolapsible:true,
 	   method:"POST",
 	   striped:true,
 	   loadMsg:"拼命加载中...",
 	   pagination:true,
 	   striped:true,
 	   columns:[[
 		 {field:'taskName',title:'任务名称',align:'center'},
 		 {field:'payerCode',title:'纳税人识别号',align:'center'},
 		 {field:'payerName',title:'纳税人名称',align:'center'},
 		 {field:'industryName',title:'行业',align:'center'},
 		 {field:'bizScope',title:'经营范围',align:'center'},
 		 {field:'executeTime',title:'执行时间',align:'center'},
 		 {field:'recordTaskDate',title:'录入日期',align:'center'},
 		 {field:'timeOut',title:'录入超时(天)',align:'center'},
 		 {field:'cz',title:'操作',align:'center',formatter: 
	        	function(value,row,index){
				return "<a href='javascript:void(0)' onclick='xiangqing("+row.id+")'>详情</a>&nbsp;&nbsp;"+
				"<a href='javascript:void(0)' onclick='del("+row.id+")'>删除</a>&nbsp;&nbsp;"+
				"<a href='javascript:void(0)' onclick='update("+row.id+")'>修改</a>"
		}}
 	  ]]
	});
	//查询事件
	  $("#searchTask").click(function(){ 
	   doSearch()
	  })
       //重置操作
     $("#resetTask").click(function(){
     	$("#conForm").form("reset")
     })
});

</script>
</html>