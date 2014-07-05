package edu.nju.transportAssistant.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.nju.transportAssistant.service.FlightsService;
import edu.nju.transportAssistant.service.ServiceFacade;
import edu.nju.transportAssistant.service.TrainService;
import edu.nju.transportAssistant.webService.IPWebService;
import edu.nju.transportAssistant.webService.MailValidater;

@ManagedBean
public class Hello {
	final String world = "Hello World!";
	
	public String getworld() {
		ServiceFacade facade = new ServiceFacade();
//		List<Transport> transports = facade.search("南京", "福州", "2014-07-10");
//		for (Transport transport : transports) {
//			System.out.println(transport);
//		}
		
//		System.out.println(facade.validateEmail("Chsadjawdia@qq.com"));
		
//		System.out.println(facade.getIpPlace("219.219.113.223"));
		return world;
	}
}
