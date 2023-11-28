package shan.controller;

import Graph.*;
import IOHandle.Save;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.geometry.Pos;
import shan.interfaces.MyCanvas;
import shan.interfaces.MyTextArea;
import shan.interfaces.MyVBox;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Controller {
    public Controller() {
        System.out.println("Controller Start!");
    }

    @FXML
    private void initialize() {
        System.out.println("Initialize Called!");
//        各种参数变量初始化
        fillColor = Color.TRANSPARENT;
        borderColor = Color.BLACK;
        lineColor = Color.BLACK;
        lineWidth = 1.0;
        textColor = Color.BLACK;
        textSize = 12.0;
        selectedFontStyle = "华文仿宋";
        textFiled = "";

    }

    @FXML
    private MyCanvas canvas;

    @FXML
    private MyVBox figureBox;

    @FXML
    private MyVBox paraSetInter;

    @FXML
    private MyTextArea remarkArea;

    private String messageBox;

    public MyCanvas.MyCanvasMode getCanvasMode() {
        return canvas.getCurrentMode();
    }

    private List<BaseGraph> graphList;


    private Color fillColor;
    private Color borderColor;

    private Color lineColor;
    private Double lineWidth;
    private Double textSize;
    private Color textColor;
    private String selectedFontStyle;
    private String textFiled;
    private Rectangle selectbox;

    private void setShapeParameters(String shapeType, Color fillColor, Color borderColor, double lineWidth) {
        paraSetInter.getChildren().clear();

        Label fillColorLabel = new Label("Fill-Color");
        ColorPicker fillColorPicker = new ColorPicker(fillColor);
        fillColorPicker.setOnAction(fillColorEvent -> {
            this.fillColor = fillColorPicker.getValue();
            System.out.println("Selected Fill Color for " + shapeType + ": " + this.fillColor.toString());
            // 更新填充颜色--Func
        });

        Label borderColorLabel = new Label("Border-Color");
        ColorPicker borderColorPicker = new ColorPicker(borderColor);
        borderColorPicker.setOnAction(borderColorEvent -> {
            this.borderColor = borderColorPicker.getValue();
            System.out.println("Selected Border Color for " + shapeType + ": " + this.borderColor.toString());
            // 更新边界颜色--Func
        });

        Label lineWidthLabel = new Label("Border-Width");
        ComboBox<Double> lineWidthComboBox = new ComboBox<>();
        ObservableList<Double> lineWidthOptions = FXCollections.observableArrayList(
                1.0, 2.0, 3.0, 4.0, 5.0);  // 添加你想要的线条宽度选项
        lineWidthComboBox.setItems(lineWidthOptions);
        lineWidthComboBox.setValue(lineWidth);
        lineWidthComboBox.setOnAction(lineWidthEvent -> {
            this.lineWidth = lineWidthComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Line Width for " + shapeType + ": " + this.lineWidth);
            // 更新线条宽度--Func
        });

        // 添加其他共有的参数设置组件，如果有的话

        paraSetInter.getChildren().addAll(fillColorLabel, fillColorPicker, borderColorLabel, borderColorPicker, lineWidthLabel, lineWidthComboBox);


    }

    private void setLinePara() {
        paraSetInter.getChildren().clear();

        Label lineColorLabel = new Label("Line-Color");
        ColorPicker lineColorPicker = new ColorPicker(lineColor);
        lineColorPicker.setOnAction(lineColorEvent -> {
            lineColor = lineColorPicker.getValue();
            System.out.println("Selected Line Color: " + lineColor.toString());
            // 更新线条颜色--Func
        });

        Label lineWidthLabel = new Label("Line-Width");
        ComboBox<Double> lineWidthComboBox = new ComboBox<>();
        ObservableList<Double> lineWidthOptions = FXCollections.observableArrayList(
                1.0, 2.0, 3.0, 4.0, 5.0);  // 添加你想要的线条宽度选项
        lineWidthComboBox.setItems(lineWidthOptions);
        lineWidthComboBox.setValue(lineWidth);
        lineWidthComboBox.setOnAction(lineWidthEvent -> {
            lineWidth = lineWidthComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Line Width: " + lineWidth);
            // 更新线条宽度--Func
        });

        // 添加其他直线特有的参数设置组件，如果有的话

        paraSetInter.getChildren().addAll(lineColorLabel, lineColorPicker, lineWidthLabel, lineWidthComboBox);
    }

    private void setCirclePara() {
        setShapeParameters("Circle", Color.WHITE, Color.BLACK, 1.0);
    }

    private void setRectanglePara() {
        setShapeParameters("Rectangle", Color.WHITE, Color.BLACK, 1.0);
    }

    private void setEllipsePara() {
        setShapeParameters("Ellipse", Color.WHITE, Color.BLACK, 1.0);
    }

    private void setTextBoxPara() {
        paraSetInter.getChildren().clear();

        Label textColorLabel = new Label("Text-Color");
        ColorPicker textColorPicker = new ColorPicker(textColor);
        textColorPicker.setOnAction(textColorEvent -> {
            textColor = textColorPicker.getValue();
            System.out.println("Selected Text Color: " + textColor.toString());
            // 更新文本颜色--Func
        });

        Label textSizeLabel = new Label("Text-Size");
        ComboBox<Double> textSizeComboBox = new ComboBox<>();
        ObservableList<Double> textSizeOptions = FXCollections.observableArrayList(
                10.0, 12.0, 14.0, 16.0, 18.0, 20.0, 24.0);  // 添加你想要的文本大小选项
        textSizeComboBox.setItems(textSizeOptions);
        textSizeComboBox.setValue(textSize);
        textSizeComboBox.setOnAction(textSizeEvent -> {
            textSize = textSizeComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Text Size: " + textSize);
            // 更新文本大小--Func
        });

        Label fontStyleLabel = new Label("Font-Style");
        ComboBox<String> fontStyleComboBox = new ComboBox<>();
        fontStyleComboBox.getItems().addAll(Font.getFontNames());
        fontStyleComboBox.setValue(selectedFontStyle);
        fontStyleComboBox.setOnAction(fontStyleEvent -> {
            selectedFontStyle = fontStyleComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Font Style: " + selectedFontStyle);
            // 更新文本字体样式--Func
        });

        Label textFiledLabel = new Label("Text");
        TextArea textArea = new TextArea(textFiled);
        // 添加ChangeListener来监听TextArea的文本变化
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Text in TextArea changed: " + newValue);
            textFiled = newValue;
            // 在这里处理文本变化后的逻辑
        });
        // 添加其他文本框特有的参数设置组件，如果有的话

        paraSetInter.getChildren().addAll(textColorLabel, textColorPicker,
                textSizeLabel, textSizeComboBox, fontStyleLabel, fontStyleComboBox, textFiledLabel, textArea);
    }

    private void setDrawPara() {
        paraSetInter.getChildren().clear();

        Label fillColorLabel = new Label("Fill-Color");
        ColorPicker fillColorPicker = new ColorPicker(fillColor);
        fillColorPicker.setOnAction(fillColorEvent -> {
            this.fillColor = fillColorPicker.getValue();
            System.out.println("Selected Fill Color for " + "Draw" + ": " + this.fillColor.toString());
            // 更新填充颜色--Func
        });
        Label lineWidthLabel = new Label("Line-Width");
        ComboBox<Double> lineWidthComboBox = new ComboBox<>();
        ObservableList<Double> lineWidthOptions = FXCollections.observableArrayList(
                1.0, 2.0, 3.0, 4.0, 5.0);  // 添加你想要的线条宽度选项
        lineWidthComboBox.setItems(lineWidthOptions);
        lineWidthComboBox.setValue(lineWidth);
        lineWidthComboBox.setOnAction(lineWidthEvent -> {
            lineWidth = lineWidthComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Line Width: " + lineWidth);
            // 更新线条宽度--Func
        });
        paraSetInter.getChildren().addAll(fillColorLabel, fillColorPicker, lineWidthLabel, lineWidthComboBox);
    }

    private void resetButtonStyles() {
        // Reset style for all buttons in the VBox
        for (Node node : figureBox.getChildren()) {
            if (node instanceof Button) {
                ((Button) node).setStyle("-fx-font-size: 14px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-color: #2196F3; -fx-border-width: 3px; -fx-border-radius: 5px;");
            }
        }
    }

    @FXML
    private void pressOnFigure(ActionEvent event) {
        fillColor = Color.TRANSPARENT;
        borderColor = Color.BLACK;
        lineColor = Color.BLACK;
        lineWidth = 1.0;
        textColor = Color.BLACK;
        textSize = 12.0;
        selectedFontStyle = "华文仿宋";
        textFiled = "";
        if (event.getSource() instanceof Button clickedButton) {

            resetButtonStyles();

            clickedButton.setStyle("-fx-font-size: 14px; -fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-color: #a80c0c; -fx-border-width: 3px; -fx-border-radius: 5px;");

            System.out.println("Clicked Button: " + clickedButton.getText());
            if ("Circle".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.CIRCLE);
                setCirclePara();
            } else if ("Line".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.LINE);
                setLinePara();

            } else if ("Rectangle".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.RECTANGLE);
                setRectanglePara();
            } else if ("Text".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.TEXTBOX);
                setTextBoxPara();
            } else if ("Ellipse".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.ELLIPSE);
                setEllipsePara();
            } else if ("Draw".equals(clickedButton.getText())) {
                fillColor = Color.BLACK;
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.POINT);
                setDrawPara();
            } else if ("Select".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.SELECT);
//                setEllipsePara();
            }
        }
    }

    private void drawCircle(double centerX, double centerY, double r) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double radius = r;
        // 设置边界颜色
        gc.setStroke(borderColor);
        // 设置边界宽度
        gc.setLineWidth(lineWidth);
        // 设置颜色
        gc.setFill(fillColor);

        // 绘制圆
        gc.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        //绘制边界
        gc.strokeOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

    }

    private void drawPencil(double centerX, double centerY) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double radius = lineWidth;

        // 设置笔触的颜色
        gc.setFill(fillColor);

        // 绘制圆
        gc.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }

    private void drawRectangle(double x0, double y0, double w, double l) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // 设置边界颜色
        gc.setStroke(borderColor);
        // 设置边界宽度
        gc.setLineWidth(lineWidth);
        // 设置填充颜色
        gc.setFill(fillColor);

        //清除之前的矩形，实现实时化
        //gc.clearRect(x0, y0,centerX-x0,centerY-y0);
        //绘制矩形
        gc.fillRect(x0, y0, w, l);
        gc.strokeRect(x0, y0, w, l);
        // 绘制矩形

    }

    private void drawLine(double x0, double y0, double x1, double y1) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // 设置直线颜色
        gc.setStroke(lineColor);
        // 设置边界宽度
        gc.setLineWidth(lineWidth);
        //绘制直线
        gc.strokeLine(x0, y0, x1, y1);
    }

    private void drawEllipse(double centerX, double centerY, double radiusX, double radiusY) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // 设置填充颜色
        gc.setFill(fillColor);
        // 设置边界颜色
        gc.setStroke(borderColor);
        // 设置边界宽度
        gc.setLineWidth(lineWidth);
        // 绘制椭圆
        gc.fillOval(centerX - radiusX, centerY - radiusY, 2 * radiusX, 2 * radiusY);
        gc.strokeOval(centerX - radiusX, centerY - radiusY, 2 * radiusX, 2 * radiusY);
    }

    private void drawText(Double x, Double y) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(textColor);
        Font font = Font.font(selectedFontStyle, textSize);
        gc.setFont(font);
        // 绘制文本框
        gc.fillText(textFiled, x, y);
    }

    private void reDraw(List<BaseGraph> list) {
        Color fillColor0 = fillColor;
        Color borderColor0 = borderColor;
        Color lineColor0 = lineColor;
        Double lineWidth0 = lineWidth;
        Double textSize0 = textSize;
        Color textColor0 = textColor;
        String selectedFontStyle0 = selectedFontStyle;
        String textFiled0 = textFiled;
        for (BaseGraph g : list) {
            if (g.getType() == BaseGraph.GRAPHTYPE.CIRCLE) {
                Circle graph = (Circle) g;
                fillColor = graph.getFillColor();
                borderColor = graph.getBorderColor();
                lineWidth = graph.getLineWidth();
                drawCircle(graph.getCoord0().first(), graph.getCoord0().second(), graph.getRadius());
            } else if (g.getType() == BaseGraph.GRAPHTYPE.ELLIPSE) {
                Ellipse graph = (Ellipse) g;
                fillColor = graph.getFillColor();
                borderColor = graph.getBorderColor();
                lineWidth = graph.getLineWidth();
                drawEllipse(graph.getCoord0().first(),
                        graph.getCoord0().second(),
                        graph.getCoord0().first() - graph.getLeft().first(),
                        graph.getCoord0().second() - graph.getLeft().second());

            } else if (g.getType() == BaseGraph.GRAPHTYPE.LINE) {
                Line graph = (Line) g;
                lineColor = graph.getLineColor();
                lineWidth = graph.getLineWidth();
                drawLine(graph.getCoord0().first(),
                        graph.getCoord0().second(),
                        graph.getCoord1().first(),
                        graph.getCoord1().second());
            } else if (g.getType() == BaseGraph.GRAPHTYPE.POINT) {
                Point graph = (Point) g;
                fillColor = graph.getFillcolor();
                lineWidth = graph.getLineWidth();
                for (Tuple<Double, Double> p : graph.getPoints()) {
                    drawPencil(p.first(), p.second());
                }
            } else if (g.getType() == BaseGraph.GRAPHTYPE.RECTANGLE) {
                Rectangle graph = (Rectangle) g;
                fillColor = graph.getFillColor();
                borderColor = graph.getBorderColor();
                lineWidth = graph.getLineWidth();
                drawRectangle(graph.getLeft().first(),
                        graph.getLeft().second(),
                        graph.getRight().first() - graph.getLeft().first(),
                        graph.getRight().second() - graph.getLeft().second());

            } else if (g.getType() == BaseGraph.GRAPHTYPE.TEXTBOX) {
                TextBox graph = (TextBox) g;
                textSize = graph.getTextSize();
                textColor = graph.getTextColor();
                selectedFontStyle = graph.getSelectedFontStyle();
                textFiled = graph.getText();

                drawText(graph.getCoord0().first(), graph.getCoord0().second());
            }
        }
        fillColor = fillColor0;
        borderColor = borderColor0;
        lineColor = lineColor0;
        lineWidth = lineWidth0;
        textSize = textSize0;
        textColor = textColor0;
        selectedFontStyle = selectedFontStyle0;
        textFiled = textFiled0;
    }

    private void clear(Double x, Double y, Double width, Double height) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(x, y, width, height);
    }

    private List<BaseGraph> SelectGraph(Rectangle selectbox) {
        List<BaseGraph> select = new ArrayList<>();
        for (BaseGraph g : graphList) {
            if (g.getLeft().first() >= selectbox.getLeft().first() &&
                    g.getLeft().second() >= selectbox.getLeft().second() &&
                    g.getRight().first() <= selectbox.getRight().first() &&
                    g.getRight().second() <= selectbox.getRight().second()) {
                //graphList.remove(g);
                select.add(g);
            }
        }
        return select;
    }

    @FXML
    private void canvasMouseClicked(MouseEvent event)
    //当鼠标在 Canvas 上单击时触发。
    {
        if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.CIRCLE) {
            double mouseX = event.getX();
            double mouseY = event.getY();
        }
    }

    private void test() {
    }


    @FXML
    public void canvasMouseDragEnter(MouseDragEvent event)
    //当鼠标拖拽进入 Canvas 区域时触发
    {
    }

    @FXML
    public void canvasMouseDragExit(MouseDragEvent event)
    //当鼠标拖拽退出 Canvas 区域时触发。
    {
    }

    @FXML
    public void canvasMouseDragged(MouseEvent event)
    //当鼠标在 Canvas 上拖拽时触发。
    {
        if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.POINT) {
            double mouseX = event.getX();
            double mouseY = event.getY();
            Point p = (Point) graphList.remove(graphList.size() - 1);
            p.add(mouseX, mouseY);
            p.SetBound(mouseX, mouseY);
            // 执行绘制的动作，传递鼠标位置
            drawPencil(mouseX, mouseY);
            graphList.add(p);
        }
    }

    @FXML
    public void canvasMouseDragOver(MouseDragEvent event)
    // 当鼠标拖拽在 Canvas 上悬停时触发。
    {
    }

    @FXML
    public void canvasMouseDragReleased(MouseDragEvent event)
    //当鼠标拖拽释放时触发。
    {
    }

    @FXML
    public void canvasMouseEntered(MouseEvent event)
    //当鼠标进入 Canvas 区域时触发
    {
    }

    @FXML
    public void canvasMouseExited(MouseEvent event)
    //当鼠标退出 Canvas 区域时触发。
    {
    }

    @FXML
    public void canvasMousePressed(MouseEvent event)
    //当鼠标在 Canvas 上按下时触发。
    {
        double mouseX = event.getX();
        double mouseY = event.getY();
        if (graphList == null) {
            graphList = new ArrayList<>();
        }
        if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.CIRCLE) {
            Circle circle = new Circle(mouseX, mouseY, 0, fillColor, borderColor, lineWidth);
            //生成圆的实例
            graphList.add(circle);//此时半径为零
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.RECTANGLE) {
            Rectangle rect = new Rectangle(mouseX, mouseY, mouseX, mouseY, fillColor, borderColor, lineWidth);
            //
            graphList.add(rect);
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.LINE) {
            Line l = new Line(mouseX, mouseY, mouseX, mouseY, lineColor, lineWidth);
            //
            graphList.add(l);
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.ELLIPSE) {
            Ellipse e = new Ellipse(mouseX, mouseY, 0, 0, fillColor, borderColor, lineWidth);
            //
            graphList.add(e);
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.POINT) {
            Point p = new Point(mouseX, mouseY, lineColor, lineWidth);
            p.SetBound(mouseX, mouseY, mouseX, mouseY);
            //
            graphList.add(p);
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.SELECT) {
            selectbox = new Rectangle(mouseX, mouseY, mouseX, mouseY, Color.TRANSPARENT, Color.RED, lineWidth);
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.TEXTBOX) {
            TextBox t = new TextBox(mouseX, mouseY, mouseX, mouseY);
            //
            graphList.add(t);
        }

    }

    @FXML
    public void canvasMouseMoved(MouseEvent event)
    //当鼠标在 Canvas 上移动时触发
    {

    }

    @FXML
    public void cavasMouseReleased(MouseEvent event)
    //当鼠标在 Canvas 上释放时触发。
    {
        double mouseX = event.getX();
        double mouseY = event.getY();
        if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.CIRCLE) {
            try {
                Circle circle = (Circle) graphList.remove(graphList.size() - 1);
                Tuple<Double, Double> coord = circle.getCoord0();
                double dis = Math.sqrt(Math.pow((mouseX - coord.first()), 2) + Math.pow((mouseY - coord.second()), 2));
                drawCircle(coord.first(), coord.second(), dis);
                circle.setRadius(dis);
                graphList.add(circle);
            } catch (NullPointerException e) {
                System.out.println("图形列表为空");
            }
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.RECTANGLE) {
            try {
                Tuple<Double, Double> coord1 = graphList.remove(graphList.size() - 1).getCoord0();
                Rectangle rect = new Rectangle(coord1.first(), coord1.second(), mouseX, mouseY, fillColor, borderColor, lineWidth);
                coord1 = rect.getLeft();
                Tuple<Double, Double> coord2 = rect.getRight();
                drawRectangle(coord1.first(), coord1.second(), coord2.first() - coord1.first(), coord2.second() - coord1.second());
                graphList.add(rect);
            } catch (NullPointerException e) {
                System.out.println("图形列表为空");
            }
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.LINE) {
            try {
                Tuple<Double, Double> coord1 = graphList.remove(graphList.size() - 1).getCoord0();
                Line l = new Line(coord1.first(), coord1.second(), mouseX, mouseY, lineColor, lineWidth);
                drawLine(coord1.first(), coord1.second(), mouseX, mouseY);
                graphList.add(l);
            } catch (NullPointerException e) {
                System.out.println("图形列表为空");
            }
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.ELLIPSE) {
            try {
                Tuple<Double, Double> coord1 = graphList.remove(graphList.size() - 1).getCoord0();
                double a = abs(coord1.first() - mouseX);
                double b = abs(coord1.second() - mouseY);
                Ellipse e = new Ellipse(coord1.first(), coord1.second(), a, b, fillColor, borderColor, lineWidth);
                drawEllipse(coord1.first(), coord1.second(), a, b);
                graphList.add(e);
            } catch (NullPointerException e) {
                System.out.println("图形列表为空");
            }
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.TEXTBOX) {
            try {
                Tuple<Double, Double> coord1 = graphList.remove(graphList.size() - 1).getCoord0();
                TextBox t = new TextBox(coord1.first(), coord1.second(), mouseX, mouseY);
                t.setText(textFiled);
                t.setTextSize(textSize);
                t.setTextColor(textColor);
                t.setSelectedFontStyle(selectedFontStyle);
                graphList.add(t);
                drawText(coord1.first(), coord1.second());
            } catch (NullPointerException e) {
                System.out.println("图形列表为空");
            }
        } else if (canvas.getCurrentMode() == MyCanvas.MyCanvasMode.SELECT) {
            try {
                selectbox.setCoord1(mouseX, mouseY);
                selectbox.SetBound(selectbox.getCoord0().first(), selectbox.getCoord0().second(), mouseX, mouseY);
                List<BaseGraph> select = SelectGraph(selectbox);
                clear(0.0, 0.0, canvas.getWidth(), canvas.getHeight());
                if (select.isEmpty())
                    System.out.println("未选中任何图形");
                else
                    reDraw(select);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }
        @FXML
        private void handleSave (ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Graph Parameters");

        // 设置文件选择器的默认扩展名和过滤器
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // 显示保存对话框并获取用户选择的文件
        File file = fileChooser.showSaveDialog(new Stage());

        // 如果用户选择了文件，则保存参数
        if (file != null) {
            Save save = new Save();

            // 假设 graphList 是你保存所有图形的列表
            for (BaseGraph graph : graphList) {
                save.addGraph(graph);
            }

            // 调用 saveAll 方法将信息保存到文件
            save.saveAll(file.getAbsolutePath());

            // 可以在这里添加保存成功的提示或其他处理
            System.out.println("Save button clicked!"); // 确保这里有终端输出
        }
    }
    }