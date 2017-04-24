package cn.panasonic.ppm.business.dao;

import java.util.Collection;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.domain.business.Approve;

public interface ApproveDao extends BaseDao<Approve>{
	/**
	 * 根据项目唯一编号，阶段Id获取审批信息
	 * @param onlynum
	 * @param stageId
	 * @return
	 */
	public Collection<Approve> getApprovesByOnlynumAndStage(final String onlynum,final Long stageId);
	
	/**
	 * 通过用户Id和审批状态获取审批信息
	 * @param userId
	 * @return
	 */
	public Collection<Approve> getApprovesByUserIdAndStatus(final Long userId);
	/**
	 * 通过项目唯一编号、用户Id和审批状态获取审批信息
	 * @param onlynum
	 * @param userId
	 * @return
	 */
	public Approve getApprovesByOnumAnduIdAndStatus(final String onlynum,final Long userId);
	
	/**
	 * 通过项目唯一编号、用户Id和阶段Id获取审批信息
	 * @param onlynum
	 * @param userId
	 * @param stageId
	 * @return
	 */
	public Approve getApprovesByOnumAnduIdAndsId(final String onlynum,final Long userId,final Long stageId);
}
