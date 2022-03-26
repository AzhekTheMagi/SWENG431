import java.util.ArrayList;

public class NodeParser
{
    int[][] graph;
    ArrayList<Edge> edgeList;
    ArrayList<NodePath> nodePaths;

    public NodeParser(int[][] g)
    {
        this.graph    = g;
        this.edgeList = new ArrayList<>();
        this.nodePaths = new ArrayList<>();
    }

    public void parsePaths()
    {
        int node = 0;

        NodePath nodePath = new NodePath();
        nodePaths.add(nodePath);
        nodePath.add(node);

        parsePaths(nodePath);
    }

    public void parsePaths(NodePath np)
    {
        int lastNode = np.get(np.size() - 1);
        int[] connectedNodes = this.graph[lastNode];

        if (connectedNodes.length == 0) // Base case 1: no more nodes in graph
        {
            return;
        }

        for (int i = 0; i < connectedNodes.length; i++)
        {
            Edge edge = new Edge(lastNode, connectedNodes[i]);

            if (this.edgeList.contains(edge)) // Base case 2: edge has been traversed
            {
                return;
            }
            else
            {
                NodePath nextNodePath;
                edgeList.add(edge);
                nextNodePath = np.copyNodePath();

                if (i == 0)
                {
                    int maxNodePathIndex = nodePaths.size() - 1;
                    nodePaths.set(maxNodePathIndex, nextNodePath);
                }
                else
                {
                    nodePaths.add(nextNodePath);
                }

                nextNodePath.add(connectedNodes[i]);
                parsePaths(nextNodePath); // recursive call for the rest of the nodes in the path
            }
        }
    }

    public void printGraphPaths()
    {
        for (NodePath np : this.nodePaths)
        {
            System.out.println(np.toString());
        }
    }

    public int getCyclomaticComplexity() { return nodePaths.size(); }
}
