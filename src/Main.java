import me.hawaijar.Shape;
import me.hawaijar.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        Shape polygon = (Shape) factory.getBean("shape");
        polygon.draw();
    }
}
