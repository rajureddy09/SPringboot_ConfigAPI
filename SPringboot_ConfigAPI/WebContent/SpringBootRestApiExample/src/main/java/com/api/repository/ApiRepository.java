package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.springboot.model.Document;

@Repository
public interface ApiRepository extends JpaRepository<Document, Long>{

	
	public List<Document> findByAppCode(String id);

    @Query("select s from Document  s where s.appCode=? and version=?")
    public Document findByAPpCOdeANdVersion (String appCode,double version );

}
