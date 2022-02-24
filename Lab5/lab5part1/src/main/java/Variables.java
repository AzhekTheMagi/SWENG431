import java.util.ArrayList;

public class Variables
{
    public ArrayList<EquivalenceClass> eqClassList = new ArrayList<>();

    public Variables(String range)
    {
        String[] eqClass = range.split(";");

        // assigns position of equivalence class in variable row
        for (int i = 0; i < eqClass.length; i++)
        {
            String[] boundary = eqClass[i].split(",");
            int lowerBound   = Integer.parseInt(boundary[0].trim());
            int upperBound   = Integer.parseInt(boundary[1].trim());
            eqClassList.add(new EquivalenceClass(lowerBound, upperBound, i + 1));
        }
    }

    // checks if value is in the domain of the variable's equivalence classes
    public int check(int val)
    {
        for (EquivalenceClass eqClass : eqClassList)
        {
            if ((val >= eqClass.lowerBound) && (val <= eqClass.upperBound))
            {
                return eqClass.eqPosition;
            }
        }

        return -1; // Value outside equivalence class range
    }
}
