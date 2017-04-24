var GylUtils = {
	/**
	 * 基础数据模块
	 */
	basedata:{
		/**
		 * 分页的逻辑
		 */
		dispage:{
			/**
			 * 当点击首页、上一页、下一页、尾页的时候，要跳转到的action
			 */
			linkNextPage:function(){
				/**
				 * this为当前的按钮
				 */
				var currentPage = $(this).attr("param");
				var url = $("body").data("url");
				window.location.href = url+"?currentPage="+currentPage;
			}
		},
		/**
		 * 初始化事件
		 */
		initEvent:function(){
			/**
			 * 给首页添加click事件
			 */
			$("input[flag='firstPage']").unbind("click");
			$("input[flag='firstPage']").bind("click",function(){
				
					/**
					 * this就代表首页的按钮
					 */
					GylUtils.basedata.dispage.linkNextPage.call(this);
			});
			
			/**
			 * 给上一页添加click事件
			 */
			$("input[flag='prePage']").unbind("click");
			$("input[flag='prePage']").bind("click",function(){
				if($(this).attr("param")=="0"){
					alert("已经是第一页了");
				}else{
					/**
					 * this就代表首页的按钮
					 */
					GylUtils.basedata.dispage.linkNextPage.call(this);
				}
			});
			
			/**
			 * 给下一页添加click事件
			 */
			$("input[flag='nextPage']").unbind("click");
			$("input[flag='nextPage']").bind("click",function(){
				/**
				 * linkNextPage函数中的this代表"下一页"的按钮的对象
				 */
				var totalPages = $(this).attr("last");//总的页数
				if($(this).attr("param")>totalPages){//已经没有下一页了
					alert("已经是最后一页了");
				}else{
					GylUtils.basedata.dispage.linkNextPage.call(this);
				}
			});
			
			/**
			 * 给尾页添加click事件
			 */
			$("input[flag='lastPage']").unbind("click");
			$("input[flag='lastPage']").bind("click",function(){
				GylUtils.basedata.dispage.linkNextPage.call(this);
			});
		}
	},
	/**
	 * 权限模块
	 */
	privilege:{
		
	},
	/**
	 * 业务模块
	 */
	business:{
		
	}
};
