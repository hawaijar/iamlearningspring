package me.hawaijar;

public class Triangle extends Shape {
    public Triangle(Color c) {
       setColor(c);
    }
    public void draw() {
        System.out.println("Triangle drawn!");
    }
}
