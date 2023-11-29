package IOHandle;

import Graph.BaseGraph;
import Graph.Round;
import Graph.Rectangle;
import Graph.Line;
import Graph.Ellipse;
import Graph.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {
    public static List<BaseGraph> loadFromFile(String filePath) {
        List<BaseGraph> loadedGraphs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("Type: ")){
                    String type = line.split(":")[1].trim();
                    switch (type) {
                        case "Round":
                            {
                                double x, y, radius;
                                line = reader.readLine();                            
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x = Double.parseDouble(coordTokens[0]);
                                    y = Double.parseDouble(coordTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] radiusTokens = line.split(": ");
                                    radius = Double.parseDouble(radiusTokens[1]);
                                }
                                loadedGraphs.add(new Round(x, y, radius));
                            }
                            break;
                        case "Rectangle":
                            {
                                double x0, y0, x1, y1;
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x0 = Double.parseDouble(coordTokens[0]);
                                    y0 = Double.parseDouble(coordTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x1 = Double.parseDouble(coordTokens[0]);
                                    y1 = Double.parseDouble(coordTokens[1]);
                                }
                                loadedGraphs.add(new Rectangle(x0, y0, x1, y1));
                            }
                            break;
                        case "Line":
                            {
                                double x0, y0, x1, y1;
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x0 = Double.parseDouble(coordTokens[0]);
                                    y0 = Double.parseDouble(coordTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x1 = Double.parseDouble(coordTokens[0]);
                                    y1 = Double.parseDouble(coordTokens[1]);
                                }
                                loadedGraphs.add(new Line(x0, y0, x1, y1));
                            }
                            break;
                        case "Ellipse":
                            {
                                double x0, y0, x1, y1;
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x0 = Double.parseDouble(coordTokens[0]);
                                    y0 = Double.parseDouble(coordTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x1 = Double.parseDouble(coordTokens[0]);
                                    y1 = Double.parseDouble(coordTokens[1]);
                                }
                                loadedGraphs.add(new Ellipse(x0, y0, x1, y1));
                            }
                            break;
                        case "Point":
                            //loadedGraphs.add(createPointFromLine(line));
                            break;
                        // 添加其他类型的图形的处理逻辑
                        default:
                            // 忽略未知类型的图形
                            break;
                    }
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            // 在实际应用中，可能希望以某种方式通知用户或记录日志
        }

        return loadedGraphs;
    }

}
