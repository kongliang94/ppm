package cn.panasonic.ppm.domain.business;

import java.io.Serializable;

public class ResultFile implements Serializable{
	
    private Long id;
    private String onlynum;   //项目唯一编号
   
	
	public String getOnlynum() {
		return onlynum;
	}
	public void setOnlynum(String onlynum) {
		this.onlynum = onlynum;
	}
	private Long stageId;
   
	public Long getStageId() {
		return stageId;
	}
	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}
	private String filePath;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getLogonName() {
		return logonName;
	}
	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}
	private String fileName;
    private String uploadDate;
    private String logonName;


}
