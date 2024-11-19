package InjectingValuesPropertiesFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("InjectingValuesPropertiesFile/applicationContext.xml");
        Car c = (Car) context.getBean("CarBean", Car.class);
        c.saveToDatabase(c);
        Plan p = (Plan) context.getBean("PlanBean", Plan.class);
        p.saveToDatabase(p);
    }
}