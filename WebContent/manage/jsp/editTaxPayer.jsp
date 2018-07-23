<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改纳税人</title>
    <link href="static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link href="static/css/edit.css" rel="stylesheet">

  </head>
  <body>
     <div class="container">
        <div class="content">
        <form id="editForm" method="post">
            <div title="纳税人信息" data-options="closable:false" class="basic-info">
                <div class="column"><span class="current">修改纳税人信息</span></div>
                
              		<input name="id" id="id" type="hidden" value="${id }">
                <table class="kv-table">              	
                    <tbody>                 
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content"><input type="text" name="payerCode" readonly value="${map.payerCode }" ></td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content"><input type="text" name="payerName" value="${map.payerName }" placeholder="纳税人名称" ></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><input type="text" name="bizAddress" value="${map.bizAddress }" placeholder="生产经营地址" ></td>
                        <td class="kv-label">生产经营地电话</td>
                        <td class="kv-content"><input type="text" name="bizAddressPhone" value="${map.bizAddressPhone }" placeholder="生产经营地电话" ></td>
                    </tr>
                    <tr>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content">
                            <select name="taxOrganId" id="selectOrgan"> 
                            <option value="${map.taxOrganId }">${map.organName }</option>
                            <option value="-1">请选择所属税务机关</option>
                            <option value="1">中国国税局</option>
                            <option value="2">北京市国税局</option>
                            <option value="3">天津市国税局</option>
                            <option value="4">上海市国税局</option>
                            <option value="5">深圳市国税局</option>
                            <option value="6">武汉市国税局</option>
                            <option value="7">杭州市国税局</option>
                            <option value="8">郑州市国税局</option>
                            </select>
                        </td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content">
                 
                            <select name="industryId" id="selectIndustry"> 
                            <option value="${map.industryId }">${map.industryName }</option>
                            <option value="-1">请选择行业</option>
                            <option value="1">计算机应用相关</option>
                            <option value="2">房地产</option>
                            <option value="3">生物医药</option>
                            <option value="4">金融</option>
                            <option value="5">汽车工业</option>
                            <option value="6">通讯工程</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content"><input type="text" name="bizScope" value="${map.bizScope }" placeholder="生产经营范围"></td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content">
                            <select name="invoiceType">
                                <option value="${map.invoiceType }">${map.invoiceType }</option>
                                <option value="-1">请选择发票种类</option>
                                <option value="增值税普通发票" >增值税普通发票</option>
                                <option value="增值税专用发票" >增值税专用发票</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content"><input type="text" name="legalPerson" value="${map.legalPerson }" placeholder="法人姓名">
                        </td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content"><input type="text" name="legalIdCard" value="${map.legalIdCard }" placeholder="法人代表身份证号码"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content"><input type="text" name="finaceName" value="${map.finaceName }" placeholder="主管财务"></td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content"><input type="text" name="finaceIdCard" value="${map.finaceIdCard }" placeholder="财务身份证号"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">办税人员</td>
                        <td class="kv-content"><label>${map.ta }</label></td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content">${map.rd }</td>
                    </tr>
                    </tbody>                                
                </table>
               
            </div>
            <div class="btn-selection">
                <input type="submit" class="easyui-linkbutton submit-btn" id="editPayer" data-options="selected:true" value="修改">
                <input type="reset" class="easyui-linkbutton reset-btn" id="reset" data-options="selected:true">
            </div>
             </form>
        </div>
    </div>
  </body>
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="static/js/calendar.js"></script>
<script type="text/javascript">
     $("input[name=executeTime]").datebox({
        formatter: easyUIFormater,
        parser: easyUIparser
    });  
  //修改
    $(function() {
    	$("#editPayer").click(function() {
    		$("#editForm").submit(function(e) {
    			e.preventDefault();
    			$.post(
    				"XiugaiTaxpayerServlet.json",
    				$(this).serialize(),
    				function (data) {
    					if (data.success) {
    						parent.$.messager.alert({
    		       				title:"提示",
    		       				msg:data.msg,
    	       				}) 
    	       				parent.$("#topWindow").window("close")
    					} else {
    						$.messager.alert({
    		           			title:"提示",
    		           			msg:data.msg,
    	        			})
    					}
    				},
    				"json"
    			);
    		});
    	})
    })
</script>
</html>