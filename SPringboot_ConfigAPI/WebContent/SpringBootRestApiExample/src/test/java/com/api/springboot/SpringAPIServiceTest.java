package com.api.springboot;


import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.api.repository.ApiRepository;
import com.api.springboot.model.Document;
import com.api.springboot.service.ConfigServiceImpl;

public class SpringAPIServiceTest {

	
	ConfigServiceImpl service=null;
	@Before
    public void setUp() {
		 service=Mockito.mock(ConfigServiceImpl.class);
		ApiRepository repository = Mockito.mock(ApiRepository.class);
        
    }
	@Test
	public void getDocumentBasedOnAppcodeAndVersionTest(){
		
		service.getDocumentBasedOnAppcodeAndVersion(12.4, "acd");
		
	}
	@Test
	public void saveDocumentTest(){
		
		service.saveDocument(new Document(1,1.2,"JAVA9"));
		
	}
	
	@Test
	public void findByAppcodeTest(){
		
		service.findByAppcode("java8");
		
	}
	
	
}
