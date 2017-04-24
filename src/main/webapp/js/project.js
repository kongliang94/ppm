var ProjectUtil={
		
	
		showDiv:function(){
			var stage = $("#stageId").val();
			//alert(stage);
			if(stage==2){
			$("#stage2id").show();
		}
		if(stage==3){
			$("#stage2id").show();
			$("#stage3id").show();
		}
		if(stage==4){
			$("#stage2id").show();
			$("#stage3id").show();
			$("#stage4id").show();
		}
		},
		showSubmit:function(){
			var num=$("#number").val();
			var mark=$("#mark").val();
			
			if(num!="指定人指定"&&mark!=false){
				$("#submit").show();
			}
		}
};




$().ready(function() {
	 
		ProjectUtil.showDiv();
		ProjectUtil.showSubmit();
		});

function stagedata() {
	
	var stageId = $("#stageId").val();
	//alert(stageId);
	if (stageId == 1) {
		alert("这是第一阶段");
	}else{
		alert("系统维护中..");
		
	}
}
function uploadfile() {
	var onlynum = $("#onlynum").val();
	var stageId = $("#stageId").val();
	var pid = $("#pid").val();
	//var id = $("#id").val();
	//if()
	//var pid = parseInt($("#pid").val())+1;
	//alert(id);
	$.layer({
				type : 2,
				border : [ 0 ],
				title : "用户信息",
				closeBtn : [ 0, true ],
				iframe : {
					src : "${pageContext.request.contextPath}/fileAction_uploadUI.action?pid="+pid+"&filePath="+onlynum+"&stage="+stageId
					
				},
				area : [ '510px', '450px' ]
			});

}

function sub() {
	// jquery 表单提交   
	$("#editForm").ajaxSubmit(function(json) {
		// 对于表单提交成功后处理，
		alert(json);
	});

	return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转   
}
function findByName(){
	var findwhere=$("findwhere").val();
	var selectId=$("selectId").val();
	$.post(
    		"${pageContext.request.contextPath}/projectAction_findProjectByName.action",
    		{pname:findwhere,selectId:selectId},
    		function(json){
    			
    			if(json.success){
    				
    			}
    			else{
    				alert(json.msg);
    				window.location.reload();
    			}
    		},'json');
}

function downName(path,name) {
	window.location.href = "${pageContext.request.contextPath}/fileAction_download.action?dir="
			+ path + "&name=" + encodeURIa(encodeURI(name))
}
