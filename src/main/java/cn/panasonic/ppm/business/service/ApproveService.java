package cn.panasonic.ppm.business.service;

import java.util.Collection;

import cn.panasonic.ppm.base.service.BaseService;
import cn.panasonic.ppm.domain.business.Approve;

public interface ApproveService extends BaseService<Approve>{

	public Collection<Approve> getApprovesByOnlynumAndStage(String onlynum,Long stageId);
		
	public Collection<Approve> getApprovesByUserIdAndStatus(Long userId);
	
	public Approve getApprovesByOnumAnduIdAndStatus(String onlynum,Long userId);

	public Approve getApprovesByOnumAnduIdAndsId(String onlynum,Long userId,Long stageId);
}
