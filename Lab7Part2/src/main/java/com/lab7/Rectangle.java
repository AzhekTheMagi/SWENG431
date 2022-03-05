package com.lab7;

public class Rectangle
{
    int w, h;

    public Rectangle() {}

    public Rectangle(int w, int h)
    {
        this.w = w;
        this.h = h;
    }

    public int getArea()
    {
        return w * h;
    }

    public int m1(int x, double y)
    {
        return 0;
    }

    public void exceptionTest() throws ClassNotFoundException
    {
        //Do nothing. Verifies skeleton class displays exception
    }
}
