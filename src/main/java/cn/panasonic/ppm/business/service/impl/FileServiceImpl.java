package cn.panasonic.ppm.business.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.business.dao.FileDao;
import cn.panasonic.ppm.business.service.FileService;
import cn.panasonic.ppm.domain.business.ResultFile;

@Service("fileService")
public class FileServiceImpl extends BaseServiceImpl<ResultFile> implements FileService{

	@Resource(name="fileDao")
	private FileDao fileDao;
	@Override
	public BaseDao getBaseDao() {
		
		return this.fileDao;
	}
	@Override
	public Collection<ResultFile> getFilesByOnlynum(String onlynum) {
		
		return this.fileDao.getFilesByOnlynum(onlynum);
	}
	@Override
	public Collection<ResultFile> getFilesByOnlynumAndStageId(String onlynum,
			Long stageId) {
		
		return this.fileDao.getFilesByOnlynumAndStageId(onlynum, stageId);
	}
	
	
	

}
