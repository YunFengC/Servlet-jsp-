<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
	function add() {
			var pname = $("#pname").val();
			var market_price = $("#market_price").val();
			var pimage = $("#pimage").val();
			var cid = $("#cid").val();
			var pdesc = $("#pdesc").val();
			var is_hot = $("#is_hot").val();
			var shop_price = $("#shop_price").val();
		$.post("${pageContext.request.contextPath}/adminServlet",{"method":"addProduct","pname":pname,"market_price":market_price,"pimage":pimage,"cid":cid,"pdesc":pdesc,"is_hot":is_hot,"shop_price":shop_price},function(data){
			if(data!=null){
				window.location.href = "${pageContext.request.contextPath}/admin/product/list.jsp";
				alert("添加成功！！！")
			}else{
				alert("添加失败！！！")
			}
		})
	}
	</script>
	
	
	</HEAD>
	
	<body>
		<!--  -->
			<input type="hidden" name="pid" value="<s:property value="model.pid"/>">
			<input type="hidden" name="image" value="<s:property value="model.image"/>">
			
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加商品</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="pname" value="${requestScope.pb.pname}" id="pname" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<select name="is_hot" id="is_hot">
							<option value="1" >是</option>
							<option value="0" >否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="market_price" value="${pb.market_price }" id="market_price" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="shop_price" value="${pb.shop_price }" id="shop_price" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" value="" id="pimage" value="${pb.pimage }"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的二级分类ID：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="categorySecond.csid" id="cid">
								<option value="请选择" >请选择
							<c:forEach items="${li }" var="cid">
								<option value="${cid.cid }" >${cid.cid }
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="pdesc" rows="5" cols="30" id="pdesc" >${pb.pdesc }</textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok" onclick="add()">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
	</body>
</HTML>