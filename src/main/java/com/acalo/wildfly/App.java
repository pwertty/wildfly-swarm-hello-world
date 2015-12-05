package com.acalo.wildfly;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

import com.acalo.wildfly.application.Application;
import com.acalo.wildfly.resources.HelloRS;
import com.acalo.wildfly.resources.OtherRS;
import com.acalo.wildfly.services.HelloEJB;

public class App {
	public static void main(String[] args) throws Exception{
		Container container = new Container();

        /*JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "test_wildfly.war");
        deployment.addClass(Application.class);
        deployment.addClass(HelloRS.class);*/
        
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        /*deployment.addResource(HelloRS.class);
        deployment.addResource(OtherRS.class);*/
        
        deployment.addPackage(HelloRS.class.getPackage());
        deployment.addPackage(OtherRS.class.getPackage());
        deployment.addPackage(HelloEJB.class.getPackage());
        
        //deployment.addPackages(true, "com.acalo.wildfly","com.acalo.wildfly.resources");
        
        deployment.addAllDependencies();
        container.start().deploy(deployment);
	}
}
