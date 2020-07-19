## Second Part - More Beanfactory

In this module, we wanted to explore the capabilities of Bean factory. We wanted to see what more it's offering to programmers other than instantiating an interface (as we see in the previous module).
To do that, let's change our interface *Shape* to an *Abstract class*. Why? Because we wanted to extend its member to more than methods but also private properties.

So, here's our changes -

```java
    public abstract class Shape {
        public abstract void draw();
    }

```
Here are changes in Triangle and Circle classes -
```java
public class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }
}
```java
    public class Triangle extends Shape {
        public void draw() {
            System.out.println("Triangle drawn!");
        }
    }

we just replaced the word **interface** with **extends**. That's all.
No other changes. Run the program and you'll get the same result.
