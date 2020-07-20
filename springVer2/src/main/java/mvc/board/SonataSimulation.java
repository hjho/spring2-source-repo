package mvc.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// java-Oracle, java-Mybatis, java-Spring[스프링에서 트랜잭션을 일괄처리할 수 있도록 설정하기]
public class SonataSimulation {

	public static void main(String[] args) {
		Sonata herCar = null;
		Sonata himCar = null;
		Sonata yourCar = new Sonata("빨강",100);
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("mvc\\board\\Sonata.xml");
		herCar = (Sonata)context.getBean("herCar");
		System.out.println(herCar);
		himCar = (Sonata)context.getBean("himCar");
		System.out.println(himCar);
		System.out.println(yourCar);
	}
}
