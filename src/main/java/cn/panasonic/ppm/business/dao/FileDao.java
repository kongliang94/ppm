package cn.panasonic.ppm.business.dao;

import java.util.Collection;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.domain.business.ResultFile;

public interface FileDao extends BaseDao<ResultFile>{
	
	/**
	 * 根据项目唯一号获取成果物信息
	 * @param onlynum
	 * @return
	 */
	public Collection<ResultFile> getFilesByOnlynum(final String onlynum);
	
	/**
	 * 获取该项目确定阶段的成果物
	 * @param onlynum
	 * @param stageId
	 * @return
	 */
	public Collection<ResultFile> getFilesByOnlynumAndStageId(final String onlynum,final Long stageId);
}
