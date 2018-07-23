<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>纳税人管理</title>
    <link href="../../static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="../../static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/icon.css">
    <link rel="stylesheet" href="../../static/css/taxpayer.css">
    <style type="text/css">
	.a{
		text-decoration: none;
	}
</style>
  </head>
  <body>
      <div class="container">
      	<table id="dg">
      	</table>
      <div id="tb" style="padding:0 30px;">
        纳税人识别号: <input type="text" name="payerCode" id="payerCode" style="width:166px;height:35px;line-height:35px;"/>
        纳税人名称: <input type="text" name="payerName" id="payerName" style="width:166px;height:35px;line-height:35px;"/>
        <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
        <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
        <a href="javascript:void(0);" id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加纳税人</a>
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
           function openTopWindow(options){
               options = !options ? {} :options;
               options.width = !options.width ? 500 : options.width;
               options.height = !options.height ? 400 : options.height;
               options.title = !options.title ? "" : options.title;
               parent.$("#iframe").prop("src",options.url);
               parent.$("#topWindow").window({
                   title : options.title,
                   width: options.width,
                   height: options.height,
                   modal:true,
                   resizable:true,
                   collapsible:false,
               });
           }
         //刷新
           function doSearch() {
				$('#dg').datagrid("load",{
					"payerCode":$("#payerCode").val(),
					"payerName":$("#payerName").val()
				});
			}
         //详情
         function xiangqing(id) {
        	 openTopWindow({"url":"../../TaxPayerInfoServlet.json?id="+id,
 	   		 	"title":"纳税人信息",	   		 	
 	   		 	 width : 750,
                 height : 550,
 				})
 	           	doSearch()
		}
         
		
     	  //新建任务
           function xinjian(id){ 
           		parent.addTab("调查任务录入","../../AddTaskServlet.json?id="+id)                     		
           }                                   
         //删除
           function del(id) {
        	   $.messager.confirm('操作提示', '确定要删除吗?', function(r){
	  				if (r){
	  					$.post("../../deleteTaxpayerServlet.json",
	  						{"id":id},
	  						function(data){
			           		if(data.success){
			           			alert(data.msg)
			           			doSearch()	
			           		}else{
			           			alert(data.msg)
			           		}
			           	},"json"
			           	),
			           	doSearch()    
	  				}
	   		   });
        	} 
         //修改
           function update(id) {
        	   openTopWindow({"url":"../../UpdateTaxpayerServlet.json?id="+id,
    	   		 "title":"修改纳税人信息",	   		 	
    	   		 width : 750,
                 height : 550, 
        	   })
        	   doSearch()
        	}

         $(function () {
           $('#dg').datagrid({    
        	   title:"纳税人信息",
        	   url:'../../ListTaxpayerServlet.json', 
        	   toolbar:"#tb",
        	   coolapsible:true,
        	   method:"POST",
        	   striped:true,
        	   loadMsg:"拼命加载中...",
        	   pagination:true,
        	   striped:true,
        	   columns:[[    
        	      /*   {field:'id',title:'id',align:'center'}, */   
        	        {field:'payerCode',title:'纳税人识别号',align:'center'},    
        	        {field:'payerName',title:'纳税人名称',align:'center'},    
        	      /*   {field:'bizAddress',title:'生产经营地址',width:100,align:'center'},   */ 
        	        {field:'organName',title:'所属税务机关',align:'center'},
        	        {field:'industryName',title:'行业',align:'center'},   
        	     /*    {field:'bizScope',title:'经营范围',width:100,align:'center'},   */ 
        	      /*   {field:'invoiceType',title:'票种核定',width:100,align:'center'},   */  
        	        {field:'legalPerson',title:'法人代表',align:'center'},   
        	        {field:'legalIdCard',title:'身份号码',align:'center'},   
        	      /*   {field:'legalMobile',title:'手机号码',width:100,align:'center'},   
        	        {field:'legalIdCardImageURL',title:'法人代表身份证扫描图片',width:100,align:'center'},  */  
        	        {field:'finaceName',title:'财务人员',align:'center'},   
        	        {field:'finaceIdCard',title:'财务人员身份号码',align:'center'},   
        	       /*  {field:'finaceMobile',title:'财务人员手机号码',width:100,align:'center'},   
        	        {field:'finaceIdCardImageURL',title:'财务人员身份证扫描图片',width:100,align:'center'},   
        	        {field:'taxerName',title:'办税人员',width:100,align:'center'},   
        	        {field:'taxerIdCard',title:'办税人员身份号码',width:100,align:'center'},   
        	        {field:'taxerMobile',title:'办税人员手机号码',width:100,align:'center'},   
        	        {field:'taxerIdCardImageURL',title:'办税人员身份证扫描图片',width:100,align:'center'},   
        	        {field:'bizAddressPhone',title:'生产经营地电话',width:100,align:'center'},   */ 
        	        {field:'recordDate',title:'录入日期',align:'center'},   
        	      /*   {field:'userId',title:'录入人员',width:100,align:'center'},    */
        	      /*   {field:'removeState',title:'状态',align:'center'},  */  
        	        {field:'cz',title:'操作',align:'center',formatter: 
        	        	function(value,row,index){
        					return "<a href='javascript:void(0)' onclick='xiangqing("+row.id+")'>详情</a>&nbsp;&nbsp;"+
        					"<a href='javascript:void(0)' onclick='del("+row.id+")'>删除</a>&nbsp;&nbsp;"+
        					"<a href='javascript:void(0)' onclick='update("+row.id+")'>修改</a>&nbsp;&nbsp;"+
        					"<a href='javascript:void(0)' onclick='xinjian("+row.id+")'>新建任务</a>";
        				}
        	        } 
        	    ]]    
        	});   
         //查询
     	   $("#searchBtn").click(function(){ 
     	     doSearch()
     	   })
     	   
     	   //添加
         $("#addBtn").click(function() {
        	 openTopWindow({"url":"addTaxPayer.jsp",
	  	   		 	"title":"添加纳税人信息",	   		 	
	  	   		 	 width : 750,
	                  height : 550,
	  				})
	  	           	doSearch()
		})
     	   
          //重置 
          $("#setBtn").click(function(e){
          //文本框的内容清空
          	$("#payerCode").val("");           
          	$("#payerName").val("");           
          })
          
		})
         
    </script>
</html>