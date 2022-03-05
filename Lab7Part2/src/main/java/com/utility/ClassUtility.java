package com.utility;

import java.lang.reflect.*;
import java.util.HashMap;

public class ClassUtility
{
    public static void printClassSkeleton(Class c) throws ClassNotFoundException
    {
        System.out.print(Modifier.toString(c.getModifiers()));

        if (c.isInterface())
        {
            System.out.print(" Interface ");
        }
        else
        {
            System.out.print(" class ");
        }

        System.out.println(c.getSimpleName());
        System.out.println("{");
        printFields(c);
        printConstructors(c);
        printMethods(c);
        System.out.println("}");
    }

    private static void printFields(Class c)
    {
        Field[] fieldArray = c.getDeclaredFields();

        for (Field field : fieldArray)
        {
            System.out.print("   ");
            System.out.print(Modifier.toString(field.getModifiers()) + " ");
            System.out.print(field.getType().getName() + " ");
            System.out.println(field.getName() +";");
        }
    }

    private static void printConstructors(Class c)
    {
        Constructor[] consArray = c.getConstructors();

        for (Constructor cons : consArray)
        {
            System.out.print("    ");
            System.out.print(Modifier.toString(cons.getModifiers()) + " ");
            System.out.print(c.getSimpleName());
            ClassUtility.printParameters(cons.getParameterTypes(), c);
            System.out.println(";");
        }
    }

    private static void printMethods(Class c) throws ClassNotFoundException
    {
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods)
        {
            System.out.print("    ");
            System.out.print(Modifier.toString(method.getModifiers()) + " ");
            System.out.print(method.getReturnType().getSimpleName() + " ");
            System.out.print(method.getName());
            ClassUtility.printParameters(method.getParameterTypes(), c);

            Type[] exceptions = method.getExceptionTypes();
            if (exceptions.length > 0)
            {
                System.out.print(" throws ");
                for (int i = 0; i < exceptions.length; i++)
                {
                    Class classTemp = Class.forName(exceptions[i].getTypeName());
                    System.out.print(classTemp.getSimpleName());

                    if (i < exceptions.length - 1)
                    {
                        System.out.print(", ");
                    }
                }
            }

            System.out.println(";");
        }
    }

    private static void printParameters(Type[] t, Class c)
    {
        HashMap<String, Integer> parameter = new HashMap<String, Integer>();
        System.out.print("(");

        for (int i = 0; i < t.length; i++)
        {
            System.out.print(t[i].getTypeName() + " " + t[i].getTypeName());
            if (parameter.containsKey(t[i].getTypeName()))
            {
                int typeCount = parameter.get(t[i].getTypeName());
                typeCount++;
                System.out.print(typeCount);
                parameter.replace(t[i].getTypeName(), typeCount);
            }
            else
            {
                parameter.put(t[i].getTypeName(), 1);
                System.out.print(1);
            }

            if (i < t.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.print(")");
    }
}
