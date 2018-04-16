package com.api.springboot;

import org.aspectj.lang.annotation.Before;

public class ConfigAPIRepositoryTest {
	@Before
    public void setUp() {
        clientRepositoryMock = Mockito.mock(ClientRepository.class);
        createClientService = new CreateClientService(clientRepositoryMock);
    }
	
	
}
