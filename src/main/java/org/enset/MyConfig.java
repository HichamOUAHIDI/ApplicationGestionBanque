package org.enset;

import org.enset.rmi.BanqueRmiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {
	@Bean
	public SimpleJaxWsServiceExporter getJaxWs(){
		SimpleJaxWsServiceExporter jax=new SimpleJaxWsServiceExporter();
		jax.setBaseAddress("http://localhost:8271/Banque");
		return jax;
	}
	
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext contexte){
		
		RmiServiceExporter rmiService=new RmiServiceExporter();
		rmiService.setService(contexte.getBean("myRmiService"));
		rmiService.setRegistryPort(1099);
		rmiService.setServiceName("BK");
		rmiService.setServiceInterface(BanqueRmiService.class);
		return rmiService;
		
	}
}
