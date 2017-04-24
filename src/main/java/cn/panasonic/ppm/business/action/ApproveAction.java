package cn.panasonic.ppm.business.action;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.UserService;
import cn.panasonic.ppm.business.service.ApproveService;
import cn.panasonic.ppm.business.service.ProjectService;
import cn.panasonic.ppm.domain.basedata.User;
import cn.panasonic.ppm.domain.business.Approve;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.domain.business.ResultFile;

@Controller("approveAction")
@Scope("prototype")
public class ApproveAction extends BaseAction<Approve>{
		
}
