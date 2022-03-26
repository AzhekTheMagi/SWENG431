public class Edge
{
    int start;
    int end;

    public Edge(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj)
    {
        Edge e = (Edge) obj;
        return e.start == start && e.end == end;
    }
}
