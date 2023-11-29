package Graph;

import Graph.BaseGraph;

import java.util.List;

public class Tag {
    String tag;
    List<BaseGraph> graphs;
    public Tag(List<BaseGraph> g,String s)
    {
        for(BaseGraph graph:g)
        {
            graph.addTag(s);
        }
        this.graphs=g;
    }
}
