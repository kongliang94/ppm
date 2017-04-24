$().ready(function(){
	
	$("body").data("data",{
		a:'aaaaa',
		b:'bbbbb'
	});
	
	
	var json = $("body").data("data");
	//alert(json.a);
	
	
	$("button#yes").unbind("click");
	$("button#yes").bind("click",function(){
		alert(1);
		$("td#status").html("已审批")
		
		//alert($("td#name").text());
	});
	
	$("button#no").unbind("click");
	$("button#no").bind("click",function(){
            if ($("textarea#text").val().trim()==null||$("textarea#text").val().trim()=="") {
             	alert("请输入驳回原因");                	
            }else{
            	window.location.href="cin.html";
            }                    
	});
});
