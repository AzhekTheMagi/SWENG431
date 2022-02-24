public class EquivalenceClass
{
    public int upperBound;          // holds equivalence class upper range
    public int lowerBound;          // holds equivalence class lower range
    public int eqPosition; // holds position of equivalence class in variable row

    public EquivalenceClass(int lowerBound, int upperBound, int position)
    {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        eqPosition      = position;
    }
}
