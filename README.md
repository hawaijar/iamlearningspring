## Second Part - More Beanfactory

In this module, we wanted to explore the capabilities of Bean factory. We wanted to see what more it's offering to programmers other than instantiating an interface (as we see in the previous module).
To do that, let's change our interface *Shape* to an *Abstract class*. Why? Because we wanted to extend its member to more than methods but also private properties.

So, here's our changes -

```java
public abstract class Shape {
    public abstract void draw();
}

```

```java
public class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }
}
```
```java
public class Triangle extends Shape {
    public void draw() {
        System.out.println("Triangle drawn!");
    }
}
```
We just replaced the word **interface** with **extends**. That's all!
No other changes. Run the program and you'll get the same result.

Now let's add a property *name* in the Shape interface as shown below -
``java
private String name;
```
And its getter() and setter() as well -
```java
public String getName() {
    return name;
}
```
```java
public void setName(String name) {
    this.name = name;
}
```

We wanted the property to be initialized to a concrete value at the time of its instantiation by the Container.
The way we would be doing is by defining a **property** tag in the configuration file. Take a look below -

```xml
<bean id = "shape" class = "me.hawaijar.Triangle">
    <property name="name" value="Triangle"></property>
</bean>
```
