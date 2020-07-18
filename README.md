## First Part - Beanfactory

Beanfactory (a.k.a Spring container) is where objects are created based on specified configuration (by developers).

We provide an XML file where we define the mapping between the bean ids and their classes. That way, Spring knows how to instantiate or inject an object when the main application requires.

In this branch, our main application depends on a bean (read an object) with id = 'triangle'. Beanfactory consults the respective XML file to find the corresponding class, instantiate an object and return to the main application. 

The main purpose of Spring framework is twofold - **Inversion of Control** and **Dependency Injection**.
The former implies that objects are created and managed (lifecycle - init, destroy) by the container on behalf of the main application.
The later indicates that the container creates an objects graph based on objects and their dependent objects used in the main application. People say object (read 'dependencies') are injected to the dependent objects in the course of running program.

When we program to interface, we're doing mainly to reduce the hard-dependency between objects. That's the essence of polymorphism - the ability of injecting various implementations of an interface based on requirements/conditions. If I have a Shape interface and there're multiple implementations of it - Triangle, Circle, Rectangle, the main application programs to Shape interface and depending on user's requirement (or similar circumstances), we inject a Triangle or a Circle etc. 
Injection of the implementations for an interface - the basic tenet of Polymorphism, is done by Spring container. 

## Metdadata configuration
```
<bean id = "triangle" class = "me.hawaijar.Triangle">
</bean>
```

Here, we're instructing Spring to instantiate object of the class 'Triangle' when the application asks for a bean with id = 'triangle' in the following code -

```
Triangle triangle = (Triangle) factory.getBean("triangle");
```

In the above, the application is not creating the object itself. It delegates it to the Spring container (Bean Factory). The **what to be created** is asked by the application, and the **how to be created** is also defined via the **Metadata configuration**. Now, it's up to the Spring container to create the objects (using the metadata) and return to the application. 
