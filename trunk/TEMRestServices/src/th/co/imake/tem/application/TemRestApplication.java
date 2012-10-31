package th.co.imake.tem.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.ext.spring.SpringRouter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("application")
public class TemRestApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		// TODO Auto-generated method stub
		final ApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] {
						"th/co/imake/tem/application/config/applicationContext-common.xml",
						"th/co/imake/tem/application/config/applicationContext-hibernate.xml",
						"th/co/imake/tem/application/config/applicationContext-resource.xml",
						"th/co/imake/tem/application/config/applicationContext-root-router.xml" });
	
		SpringRouter router = (SpringRouter) springContext.getBean("root");
		return router;
	}
}
