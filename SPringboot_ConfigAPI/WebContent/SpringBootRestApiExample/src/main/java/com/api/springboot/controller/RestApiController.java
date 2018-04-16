package com.api.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.springboot.model.Document;
import com.api.springboot.service.ConfigService;
import com.api.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	ConfigService configService; //Service which will do all data retrieval/manipulation work

	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.GET)
	public ResponseEntity<Document> getDocumentBasedOnAppcodeAndVersion(@PathVariable("version") long version,@PathVariable("appCode") String appCode) {
		Document document = configService.getDocumentBasedOnAppcodeAndVersion(version, appCode);
		if (document==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Document>(document, HttpStatus.OK);
	}

	// -------------------Retrieve config of same type------------------------------------------
//http://localhost:8999/SpringBootRestApi/api/123/config
	@RequestMapping(value = "/{appCode}/config", method = RequestMethod.GET)
	public ResponseEntity<List<Document>> getDocumentsBasedOnAPpcode(@PathVariable("appCode") String appCode) {
		logger.info("Fetching User with id {}", appCode);
		List<Document> user = configService.findByAppcode(appCode);
		if (user == null) {
			logger.error("User with id {} not found.", appCode);
			return new ResponseEntity(new CustomErrorType("User with id " + appCode 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Document>>(user, HttpStatus.OK);
	}

	// -------------------Create a document-------------------------------------------
//
	@RequestMapping(value = "/document/", method = RequestMethod.POST)
	public ResponseEntity<?> createDocument(@RequestBody Document document, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", document);

		if (configService.isDocumentExist(document)) {
			logger.error("Unable to create. A document with name {} already exist", document.getAppCode());
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
			document.getAppCode() + " already exist."),HttpStatus.CONFLICT);
		}
		configService.saveDocument(document);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/document/{id}").buildAndExpand(document.getDocId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	
	
}