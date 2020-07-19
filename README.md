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
```java
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
Here, we're helping Spring(container) to initialize the object and also initialize the **name** property  using the setter method. That's why we also created the setter method in the above, otherwise Spring will throw an exception 'cause it can't initialize the property without a setter method. There is another way to initialize object properties - **Constructor method**

So there are only two ways where the container initialzes object properties (including references - inner classes) -
- Setter method
- Constructore method

Spring doesn't know any other beyond these two ways. Try removing setter method() and update **private** modifier with **public** modfier like -

 ```
 public abstract class Shape {
  -   private String name;
  +   public String name;
     public abstract void draw();
```
**Note**: In the above, - indicates the line that's removed. + indicates the line that's added (it's the git diff [file] convention)

Spring will throw an exception there as it doesn't know how to initialzed/access public property thorugh its object. Let's put that way.

What happen if the property of an object is another object?

Let us try out.

Let's add a new Color object as shown below -
```java
public class Color {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

Let's add a color object in our abstract Shape class as shown below -
```java
+ private Color color;
+ public Color getColor() {
        return color;
  }
+ public void setColor(Color color) {
        this.color = color;
  }
```

The way we have to inform the Container to initialze the color object while initializing the Shape object is via a **ref** value. Take a look below -
```xml
+ <bean id="color" class="me.hawaijar.Color">
+   <property name="name" value="purple"></property>
+ </bean>
  <bean id = "shape" class = "me.hawaijar.Triangle">
    <property name="name" value="Triangle"></property>
+   <property name="color" ref="color"></property>
  </bean>
```

So, we're telling the container that to initialize the 'name' property of the shape object, you would used the raw value ("Triangle") but to initialize the 'color' property, you would need to first initialize another object of Color first and inject its reference to it.

So, the container will create the dependency object first (the Color object) and then initialize the value of color property of the Shape object to its reference. In short, Spring is wiring up the dependency tree of the objects. 

This is similiar to what we see in the front-end build process like **Webpack** - We give the entry point (the starting object/module) to the Webpack and Webpack starts digging all its dependencies and build finally a dependecny tree. The only thing that I see different from the Spring container is that Webpack doesn't create/manage the objects - JS module and framework does that. webpack is just creating the dependency graph (of objects), parse all of them and bring out a bundled JS file. That's not what Spring is doing here :-) That's what build process tools like *maven* is perhaps doing. So, yes *maven* would be more similar to *Webpack* in terms of dependency management and finally bringing out the output.



