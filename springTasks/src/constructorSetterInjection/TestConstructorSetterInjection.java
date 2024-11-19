//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package constructorSetterInjection;
import constructorSetterInjection.circle;
import constructorSetterInjection.square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructorSetterInjection {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.



        ApplicationContext contener = new ClassPathXmlApplicationContext("constructorSetterInjection/applicationContext.xml");
        //Shape circle = context.getBean("circle", Shape.class);
        double radius = 100;
        double height = 20;
        double width = 15;
        circle c = contener.getBean("cicleConstructorInjection", circle.class);
        c.draw2dCircle();
        c.draw3dCircle();
        square s = contener.getBean("squareSetterInjection", square.class);
        s.drawSquare2d();
        s.drawSquare3d();



    }
}