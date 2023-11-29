package IOHandle;

import Graph.*;
import javafx.scene.paint.Color;

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
                        case "Circle":
                            {
                                double x, y, radius, lineWidth;
                                Color fillColor;
                                Color borderColor;
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
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    fillColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    borderColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineWidthTokens = line.split(": ");
                                    lineWidth = Double.parseDouble(lineWidthTokens[1]);
                                }
                                loadedGraphs.add(new Circle(x, y, radius, fillColor, borderColor, lineWidth));
                            }
                            break;
                        case "Rectangle":
                            {
                                double x0, y0, x1, y1, lineWidth;
                                Color fillColor, borderColor;
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
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    fillColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    borderColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineWidthTokens = line.split(": ");
                                    lineWidth = Double.parseDouble(lineWidthTokens[1]);
                                }
                                loadedGraphs.add(new Rectangle(x0, y0, x1, y1, fillColor, borderColor, lineWidth));
                            }
                            break;
                        case "Line":
                            {
                                double x0, y0, x1, y1, lineWidth;
                                Color linecolor;
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
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    linecolor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineWidthTokens = line.split(": ");
                                    lineWidth = Double.parseDouble(lineWidthTokens[1]);
                                }
                                loadedGraphs.add(new Line(x0, y0, x1, y1, linecolor, lineWidth));
                            }
                            break;
                        case "Ellipse":
                            {
                                double x0, y0, x1, y1, lineWidth;
                                Color fillColor, borderColor;
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
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    fillColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    borderColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineWidthTokens = line.split(": ");
                                    lineWidth = Double.parseDouble(lineWidthTokens[1]);
                                }
                                loadedGraphs.add(new Ellipse(x0, y0, x1, y1, fillColor, borderColor, lineWidth));
                            }
                            break;
                        case "Point":
                            {
                                double x, y, lineWidth;
                                Color fillcolor;
                                line = reader.readLine();
                                {
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x = Double.parseDouble(coordTokens[0]);
                                    y = Double.parseDouble(coordTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    fillcolor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] lineWidthTokens = line.split(": ");
                                    lineWidth = Double.parseDouble(lineWidthTokens[1]);
                                }
                                Point p=new Point(x, y, fillcolor, lineWidth);
                                while((line = reader.readLine()) != null && line.startsWith("Point: ")){
                                    String[] lineTokens = line.split(": ");
                                    String[] coordTokens = lineTokens[1].split(", ");
                                    x = Double.parseDouble(coordTokens[0]);
                                    y = Double.parseDouble(coordTokens[1]);
                                    p.add(x,y);
                                }
                                loadedGraphs.add(p);
                            }
                            break;
                        case "TextBox":
                            {
                                double x0, y0, x1, y1, lineWidth, textSize;
                                Color textColor;
                                String selectedFontStyle, text;
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
                                line = reader.readLine();
                                {
                                    String[] textTokens = line.split(": ");
                                    text = textTokens[1];
                                }
                                line = reader.readLine();
                                {
                                    String[] textSizeTokens = line.split(": ");
                                    textSize = Double.parseDouble(textSizeTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] colorTokens = line.split(": ");
                                    textColor = Color.valueOf(colorTokens[1]);
                                }
                                line = reader.readLine();
                                {
                                    String[] fontStyleTokens = line.split(": ");
                                    selectedFontStyle = fontStyleTokens[1];
                                }
                                loadedGraphs.add(new TextBox(x0, y0, x1, y1, text, textSize, textColor, selectedFontStyle));
                            }
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
