package cn.panasonic.ppm.business.service;

import java.util.Collection;

import cn.panasonic.ppm.base.service.BaseService;
import cn.panasonic.ppm.domain.business.ResultFile;

public interface FileService extends BaseService<ResultFile>{
	
	public Collection<ResultFile> getFilesByOnlynum(String onlynum);
	public Collection<ResultFile> getFilesByOnlynumAndStageId(String onlynum, Long stageId);
}
