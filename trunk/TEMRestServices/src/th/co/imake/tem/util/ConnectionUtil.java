package th.co.imake.tem.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionUtil {
	public static Session getSession() {
		Session session = null;
		try {
			final ApplicationContext springContext = new ClassPathXmlApplicationContext(
					new String[] { "th/co/imake/tem/application/config/applicationContext-hibernate.xml" });

			SessionFactory sessionFactory = (SessionFactory) springContext
					.getBean("sessionFactory");
			session = sessionFactory.openSession();
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

}
