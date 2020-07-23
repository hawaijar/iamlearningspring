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

In the next module, we'll start moving into **Application Context** based factory method. *Application Context* based configuration is a superset of plain *Bean factory* method. It adds additonal features on top of the current BeanFactory method.

So, whatever we hvae seen so far, they're well applicable to *Apllication Context* as well. We'll discuss that in detail in the next module.
