package com.api.springboot;
 
import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.api.springboot.controller.RestApiController;
import com.api.springboot.model.Document;
 
@RunWith(SpringRunner.class)
@WebMvcTest(value = RestApiController.class, secure = false)
public class SpringBootRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8999/SpringBootRestApi/api";
     //
    /* GET */
    @SuppressWarnings("unchecked")
    private static void getDocumentBasedOnAppcodeAndVersion(){
        System.out.println("Testing listAllUsers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
       Document doc = restTemplate.getForObject(REST_SERVICE_URI+"/{appCode}/config/{version}", Document.class);
         
        if(doc!=null){
            
          System.out.println("DOc existed ");
            }
        else{
            System.out.println("No user exist----------");
        }
    }
     
    /* GET */
    private static void getDocumentsBasedOnAPpcode(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Document user = restTemplate.getForObject(REST_SERVICE_URI+"/{appCode}/config", Document.class);
        System.out.println(user);
    }
     
    /* POST */
    private static void createDocument() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Document doc = new Document(0,51,"JAVA1.8");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/dcument/", doc, Document.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
   
 
    public static void main(String args[]){
    	getDocumentBasedOnAppcodeAndVersion();
    	getDocumentsBasedOnAPpcode();
    	createDocument();
        
        
    }
}