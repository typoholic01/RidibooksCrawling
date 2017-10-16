package web.db.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.db.dao.FileDao;
import web.db.vo.File;

@Service
@Transactional
public class FileService {
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	@Autowired
	FileDao dao;
	
	/*************************************************
	 * 					READ
	 * ***********************************************/	

	public List<File> getFileList(int fileSeq) {
		logger.info("진입");
		
		return dao.getFileList(fileSeq);
	}

	public boolean insertFile(File fileDto) {
		logger.info("진입");
		
		return dao.insertFile(fileDto);
		
	} 
}
