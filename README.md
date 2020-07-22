## Third Part - Continue... Beanfactory (Constructor injection)

In this module, we wanted to demonstrate the *constructor* way of injecting the dependencies.
So, here's our changes in our class Triangle -

```java
public class Triangle extends Shape {
    public Triangle(Color c) {
       setColor(c);
    }
    public void draw() {
        System.out.println("Triangle drawn!");
    }
}
```

Here we're asking the Spring container to inject (meaning initialize the member variables) using the constructor of the class.

and here's the corresponding changes in the *spring.xml* configuration file.

```xml
<bean id="color" class="me.hawaijar.Color">
    <property name="name" value="Yellow"></property>
</bean>
<bean id = "shape" class = "me.hawaijar.Triangle">
   <property name="name" value="Triangle"></property>
   <constructor-arg ref="color" />
</bean>

```
As you can see above, the 'name' property (or member variable) is initialized using the *Setter method* where as the "color" property is initialized using the *constructor* method.

Pretty similar. That's it!
