<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div title="纳税人信息" class="basic-info">
                <div class="column"><span class="current">纳税人信息</span></div>
                <form id="editForm">
                <table class="kv-table">              	
                    <tbody>                 
                    <tr>
                        <td class="kv-label">纳税人识别号</td>
                        <td class="kv-content"><label>${map.payerCode }</label></td>
                        <td class="kv-label">纳税人名称</td>
                        <td class="kv-content"><label>${map.payerName }</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营地址</td>
                        <td class="kv-content"><label>${map.bizAddress }</label></td>
                        <td class="kv-label">生产经营地电话</td>
                        <td class="kv-content"><label>${map.bizAddressPhone }</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content"><label>${map.organName }</label></td>
                        <td class="kv-label">行业</td>
                        <td class="kv-content"><label>${map.industryName }</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">生产经营范围</td>
                        <td class="kv-content"><label>${map.bizScope }</label></td>
                        <td class="kv-label">票种核定</td>
                        <td class="kv-content"><label>${map.invoiceType }</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">法人代表人</td>
                        <td class="kv-content"><label>${map.legalPerson }</label></td>
                        <td class="kv-label">法人身份证号</td>
                        <td class="kv-content"><label>${map.legalIdCard }</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">主管财务</td>
                        <td class="kv-content"><label>${map.finaceName }</label></td>
                        <td class="kv-label">财务身份证号</td>
                        <td class="kv-content"><label>${map.finaceIdCard }</label></td>
                    </tr>
                    
                      <tr>
                        <td class="kv-label">法人身份证照片</td>
                        <td class="kv-content">${map.legalIdCardImageURL }<img id="chooseLegalIdCardPreview" alt=""  width="200" height="150"/></td>
                        <td class="kv-label">财务身份证照片</td>
                        <td class="kv-content">${map.finaceIdCardImageURL }<img id="chooseFinaceIdCardPreview" alt=""  width="200" height="150"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">录入人员</td>
                        <td class="kv-content"><label>${map.ta }</label></td>
                        <td class="kv-label">录入日期</td>
                        <td class="kv-content"><label>${map.rd }</label></td>
                    </tr>
                    </tbody>                                
                </table>
                </form>
            </div>         
        </div>
    </div>
  </body>
</html>