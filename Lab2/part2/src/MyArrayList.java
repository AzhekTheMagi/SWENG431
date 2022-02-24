import java.util.ArrayList;

public class MyArrayList <E> extends ArrayList
{
    public MyArrayList()
    {
        // assert postcondition: ArrayList is empty
        super();
        assert this.isEmpty();
    }

    @Override
    public int size()
    {
        // assert postcondition: list is not empty
        // code

        int counter = 0;

        for (Object e: this)
            counter++;

        assert !this.isEmpty();

        return counter;
    }

    // Insert e as a new first element to mal
    public void insertFirst(E e)
    {
        // assert precondition: size >= 0 and e != null
        // code
        // assert postcondition: inserted element is first
        assert this.size() >= 0 && e != null;
        this.add(0, e);
        assert this.get(0) == e;
    }

    // Insert e as a new last element
    public void insertLast(E e)
    {
        // assert precondition: size >= 0 and e != null
        // code
        // assert postcondition: inserted element is last
        assert this.size() >= 0 &&e != null;
        this.add(e);
        assert this.get(this.size() - 1) == e;
    }

    // Delete my first element
    public void deleteFirst()
    {
        // assert precondition: size > 0
        // code
        // assert postcondition: element 2 object points to element 1
        assert this.size() > 0;
        E e = (E) this.get(1);
        this.remove(0);
        assert e == this.get(0);
    }

    // Delete my last element
    public void deleteLast()
    {
        // assert precondition: size > 0
        // code
        // assert postcondition: second to last item is now last
        assert this.size() > 0;
        E e = (E) this.get(this.size() - 2);
        this.remove(this.size() - 1);
        assert e == this.get(this.size() -1);
    }

    public void show()
    {
        for (Object e : this) {
            System.out.println(e);
        }
    }
}
