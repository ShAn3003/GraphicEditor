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
        this.tag=s;
    }
    public void add(List<BaseGraph> graphs)
    {
        for(BaseGraph graph:graphs)
        {
            this.graphs.add(graph);
        }
    }
    public String getTag() {
        return tag;
    }

    public List<BaseGraph> getGraphs() {
        return graphs;
    }
}
