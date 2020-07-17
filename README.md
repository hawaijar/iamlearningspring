## First Part - Beanfactory

Beanfactory (a.k.a Spring container) is where objects are created based on specified configuration (by developers).

We provide an XML file where we define the mapping between the bean ids and their classes. That way, Spring knows how to instantiate or inject an object when the main application requires.

In this branch, our main application depends on a bean (read an object) with id = 'triangle'. Beanfactory consults the respective XML file to find the corresponding class, instantiate an object and return to the main application. 