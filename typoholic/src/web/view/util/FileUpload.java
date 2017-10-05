package web.view.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	
	
	private String storedFileName;
	private String orgFileName;
	
	@SuppressWarnings("unused")
	private FileUpload() {
	}

	public FileUpload(MultipartFile uploadFile, String path) {
        OutputStream out = null;
        byte[] bytes;
				
		//file save
        if (!uploadFile.getOriginalFilename().equals("")) {
			logger.info("upload file start");
        	//이름 짓기
			orgFileName = uploadFile.getOriginalFilename();
			storedFileName = System.currentTimeMillis() + "_" + orgFileName;
            
			try {
				bytes = uploadFile.getBytes();
	            //파일 저장
	            File file = new File(path + storedFileName);        
	            out = new FileOutputStream(file);
	            out.write(bytes);
	            
			} catch (IOException e) {
				logger.error("upload: {}",e.getMessage());
			} finally {
	            try {
					out.close();
				} catch (IOException e) {
					logger.error("close: {}",e.getMessage());
				}
				logger.info("upload file end");
			}
            
            
		} else {
			logger.info("upload file null");
			//bbs 저장
			storedFileName = "-1";
			orgFileName = "-1";
		}
		
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
}