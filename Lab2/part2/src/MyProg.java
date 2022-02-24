/**
 *
 * @author Anthony Vallin, aav5195
 * Class: SWENG431
 * Date: 20220120
 * Assignment: Lab 2, part 2
 * Description: Assertion demo
 */

public class MyProg
{
    public static void main(String[] args)
    {
        MyArrayList<Student> mal = new MyArrayList<>();
        mal.insertFirst(new Student(1, "John"));
        mal.insertFirst(new Student(2, "Mary"));
        mal.insertLast(new Student(3, "Mike"));
        mal.show();
        mal.deleteLast();
        mal.show();
        mal.deleteFirst();
        mal.show();
    }
}
