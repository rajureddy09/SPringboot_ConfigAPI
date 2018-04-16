package com.api.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.repository.ApiRepository;
import com.api.springboot.model.Document;



@Service("configService")
public class ConfigServiceImpl implements ConfigService{
	
	@Autowired
	ApiRepository repository;
	
	private static List<Document> documents;
	
	static{
		
	}

	public Document getDocumentBasedOnAppcodeAndVersion(double version,String appCode) {
		return repository.findByAPpCOdeANdVersion(appCode, version);
	}
	
	public List<Document> findByAppcode(String appCode) {
		
		return repository.findByAppCode(appCode);
	}
	
	public boolean  isDocumentExist(Document doc) {
		 Document obj=repository.findByAPpCOdeANdVersion(doc.getAppCode(), doc.getVersionNo());
		if(obj==null)
		 return false;
		else 
			return true;
	 
		
	}
	
	public void saveDocument(Document doc) {
		
		repository.save(doc);
	}

	

	
}
