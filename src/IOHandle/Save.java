package IOHandle;

import java.util.ArrayList;
import java.util.List;
import Graph.BaseGraph;
import java.io.PrintWriter;
import java.io.IOException;

public class Save {
    private List<BaseGraph> graphList;

    public Save() {
        graphList = new ArrayList<>();
    }

    public void addGraph(BaseGraph graph) {
        graphList.add(graph);

    }

    public List<BaseGraph> getGraphList() {
        return graphList;
    }

    public void saveAll(String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (BaseGraph graph : graphList) {
                writer.println(graph.save());
            }
        } catch (IOException e) {
            e.printStackTrace();
            // 可以在这里处理文件保存异常
        }
    }
}
