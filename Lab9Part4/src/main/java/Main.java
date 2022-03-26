/**
 * @author Anthony Vallin, aav5195
 * class: SWENG431
 * date: 20220323
 * assignment: Lab9 Part4
 * description: accepts a graph as input and shows cyclomatic complexity and independent paths, using
 * depth first traversal technique.
 */
public class Main
{
    public static void main(String[] args)
    {
        int[][] graph = {{1}, {2}, {3,4,5}, {4,6}, {6}, {4,6}, {7}, {1,8}, {}}; // DFT graph from fig 9.6 in M9.3 lecture
        NodeParser nodeParser = new NodeParser(graph);
        nodeParser.parsePaths();
        nodeParser.printGraphPaths();
        System.out.println("Cyclomatic Complexity = " + nodeParser.getCyclomaticComplexity());
    }
}
