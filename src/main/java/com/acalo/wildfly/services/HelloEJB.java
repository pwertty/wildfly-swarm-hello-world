package com.acalo.wildfly.services;

import javax.ejb.Stateless;

@Stateless
public class HelloEJB {
	public String sayHello(){
		return "hola desde el EJB";
	}
}
