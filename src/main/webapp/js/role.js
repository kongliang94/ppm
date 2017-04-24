 var roletree = {
 	data: {
        treeNode: '',
        zTreePlugin: ''
    },
   	setting: {
        data: {
			simpleData: {
				enable: true,
				idKey: "rid",
				pIdKey: "pId",
			}
        },
        callback: {//回调函数
            onRightClick: function(event, treeId, treeNode){
                roletree.data.treeNode = treeNode;
                roletree.showRMenu(event.clientX, event.clientY);
            }
        }
   },
    /**
     * 显示右键菜单
     */
    showRMenu: function(x, y){
        $("#rMenu ul").show();
        $("#rMenu").css({
            "top": y-45+ "px",
            "left": x + "px",
            "display": "block"
        });
    },
    addRole: function(){
    	 var roleName = window.prompt("请输入角色的名称");
         if (roleName) {
             /**
              * 在增加一个角色之前，先判断该角色的名字是否可用
              */
             $.post("roleAction_showRoleByName.action", {
                 name: roleName
             }, function(data){
            	 roletree.data.zTreePlugin.addNodes();
             });
         }
    },
    updateRole: function(){
		var roleName = window.prompt("请填入修改的名称",roletree.data.treeNode.name);
		if(roletree.data.zTreePlugin.getNodeByParam("name",roleName)){//如果得到的对象存在，则为true
			alert("该名称已经存在了");
		}
    },
    loadRoleTree: function(){
        $.post("roleAction_showRoleTree.action", null, function(json){
            roletree.data.zTreePlugin = $.fn.zTree.init($("#tree"),roletree.setting, json);
        });
    },
    
    init:{
    	initEvent:function(){
   
    		$("#addRole").unbind("click");
    		$("#addRole").bind("click",function(){
    			roletree.addRole();
    		});
    		$("#updateRole").unbind("click");
    		$("#updateRole").bind("click",function(){
    			roletree.updateRole();
    		});
    		$("#deleteRole").unbind("click");
    		$("#deleteRole").bind("click",function(){
    			
    		});
    	}
    }
};
$().ready(function(){
    //roletree.loadRoleTree();
  	$("#rMenu").hover(function(){//进入#rMenu区域的时候做的事情
    }, function(){//出来该区域的时候做的事情
        $("#rMenu").hide();
    });
    //roletree.init.initEvent();
});