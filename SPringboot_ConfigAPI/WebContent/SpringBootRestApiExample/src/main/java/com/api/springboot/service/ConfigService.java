package com.api.springboot.service;


import java.util.List;

import com.api.springboot.model.Document;

public interface ConfigService {
	
	Document getDocumentBasedOnAppcodeAndVersion(double version,String appCode);
	
	List<Document> findByAppcode(String appCode);
	
	void saveDocument(Document document);
	


	
	boolean isDocumentExist(Document document);

}
