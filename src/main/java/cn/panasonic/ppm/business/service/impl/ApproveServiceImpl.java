package cn.panasonic.ppm.business.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.business.dao.ApproveDao;
import cn.panasonic.ppm.business.service.ApproveService;
import cn.panasonic.ppm.domain.business.Approve;

@Service("approveService")
public class ApproveServiceImpl extends BaseServiceImpl<Approve> implements ApproveService{

	@Resource(name="approveDao")
	private ApproveDao approveDao;
	@Override
	public BaseDao getBaseDao() {
		
		return this.approveDao;
	}
	@Override
	public Collection<Approve> getApprovesByOnlynumAndStage(String onlynum,
			Long stageId) {
		return this.approveDao.getApprovesByOnlynumAndStage(onlynum, stageId);
	}
	@Override
	public Collection<Approve> getApprovesByUserIdAndStatus(Long userId) {
		
		return this.approveDao.getApprovesByUserIdAndStatus(userId);
	}
	@Override
	public Approve getApprovesByOnumAnduIdAndStatus(String onlynum,
			Long userId) {
		
		return this.approveDao.getApprovesByOnumAnduIdAndStatus(onlynum, userId);
	}
	@Override
	public Approve getApprovesByOnumAnduIdAndsId(String onlynum, Long userId,
			Long stageId) {
		
		return this.approveDao.getApprovesByOnumAnduIdAndsId(onlynum, userId, stageId);
	}

}
