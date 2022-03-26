import java.util.ArrayList;

public class NodePath extends ArrayList<Integer>
{
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < size(); i++){
            builder.append(get(i));
            if(i <  size()- 1){
                builder.append("->");
            }
        }
        return builder.toString();
    }

    public NodePath copyNodePath()
    {
        NodePath newPath = new NodePath();

        for(int i = 0; i < size(); i++){
            newPath.add(Integer.valueOf(get(i)));
        }
        return newPath;
    }
}
