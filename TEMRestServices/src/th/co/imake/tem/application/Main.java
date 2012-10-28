package th.co.imake.tem.application;

import java.util.List;

import org.restlet.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.util.Paging;

public class Main {

	public static void main(String[] args) throws Exception {
		final ApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] {
						"th/co/imake/tem/application/config/applicationContext-common.xml",
						"th/co/imake/tem/application/config/applicationContext-hibernate.xml",
						"th/co/imake/tem/application/config/applicationContext-resource.xml",
						"th/co/imake/tem/application/config/applicationContext-root-router.xml",
						"th/co/imake/tem/application/config/applicationContext-server.xml" });

		((Component) springContext.getBean("top")).start();
		TemService temService = (TemService)springContext.getBean("temService");
		
		saveTemProvider(temService);
		searchTemProvider(temService);
	}
	
	public static void saveTemProvider(TemService temService) {
		TemProvider temProvider = new TemProvider();
		temProvider.setTpName("AIS");
		temService.insertTemProvider(temProvider);
	}
	
	public static void searchTemProvider(TemService temService) {
		TemProvider temProvider = new TemProvider();
		Paging paging = new Paging();
		List list = temService.searchTemProvider(temProvider, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temProvider = (TemProvider)listObj.get(i);
				System.out.println(temProvider.getTpId()+" : "+temProvider.getTpName());
			}
		}
	}
}
