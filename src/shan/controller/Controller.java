package shan.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class Controller {
    @FXML
    private MyCanvas canvas;

    @FXML
    private MyVBox figureBox;

    @FXML
    private MyVBox paraSetInter;

    @FXML
    private MyTextArea remarkArea;

    public MyCanvas.MyCanvasMode getCanvasMode()
    {
        return canvas.getCurrentMode();
    }
    private Color fillColor;

    private Color borderColor;

    private Color lineColor;
    private Double lineWidth;

    private Double textSize;
    private Color textColor;
    private String selectedFontStyle;
    private void setCirclePara(){
        paraSetInter.getChildren().clear();
        Label fillColorLabel = new Label("Fill-Color");
        ColorPicker fillColorPicker = new ColorPicker();
        fillColorPicker.setOnAction(fillColorEvent -> {
            fillColor = fillColorPicker.getValue();
            System.out.println("Selected Fill Color: " + fillColor.toString());
            // 更新填充颜色--Func
        });

        Label borderColorLabel = new Label("Border-Color");
        ColorPicker borderColorPicker = new ColorPicker();
        borderColorPicker.setOnAction(borderColorEvent -> {
            borderColor = borderColorPicker.getValue();
            System.out.println("Selected Border Color: " + borderColor.toString());
            // 更新边界颜色--Func
        });
        paraSetInter.getChildren().addAll(fillColorLabel, fillColorPicker, borderColorLabel, borderColorPicker);
    }
    private void setEllipsePara() {
        paraSetInter.getChildren().clear();

        Label fillColorLabel = new Label("Fill-Color");
        ColorPicker fillColorPicker = new ColorPicker();
        fillColorPicker.setOnAction(fillColorEvent -> {
            fillColor = fillColorPicker.getValue();
            System.out.println("Selected Fill Color for Ellipse: " + fillColor.toString());
            // 更新椭圆填充颜色--Func
        });

        Label borderColorLabel = new Label("Border-Color");
        ColorPicker borderColorPicker = new ColorPicker();
        borderColorPicker.setOnAction(borderColorEvent -> {
            borderColor = borderColorPicker.getValue();
            System.out.println("Selected Border Color for Ellipse: " + borderColor.toString());
            // 更新椭圆边界颜色--Func
        });

        paraSetInter.getChildren().addAll(fillColorLabel, fillColorPicker, borderColorLabel, borderColorPicker);
    }

    private void setRectanglePara() {
        paraSetInter.getChildren().clear();

        Label fillColorLabel = new Label("Fill-Color");
        ColorPicker fillColorPicker = new ColorPicker();
        fillColorPicker.setOnAction(fillColorEvent -> {
            fillColor = fillColorPicker.getValue();
            System.out.println("Selected Fill Color: " + fillColor.toString());
            // 更新填充颜色--Func
        });

        Label borderColorLabel = new Label("Border-Color");
        ColorPicker borderColorPicker = new ColorPicker();
        borderColorPicker.setOnAction(borderColorEvent -> {
            borderColor = borderColorPicker.getValue();
            System.out.println("Selected Border Color: " + borderColor.toString());
            // 更新边界颜色--Func
        });

        // 添加其他矩形特有的参数设置组件，如果有的话

        paraSetInter.getChildren().addAll(fillColorLabel, fillColorPicker, borderColorLabel, borderColorPicker);
    }


    private void setLinePara() {
        paraSetInter.getChildren().clear();

        Label lineColorLabel = new Label("Line-Color");
        ColorPicker lineColorPicker = new ColorPicker();
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
        lineWidthComboBox.setOnAction(lineWidthEvent -> {
            lineWidth = lineWidthComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Line Width: " + lineWidth);
            // 更新线条宽度--Func
        });

        // 添加其他直线特有的参数设置组件，如果有的话

        paraSetInter.getChildren().addAll(lineColorLabel, lineColorPicker, lineWidthLabel, lineWidthComboBox);
    }



    private void setTextBoxPara() {
        paraSetInter.getChildren().clear();

        Label textColorLabel = new Label("Text-Color");
        ColorPicker textColorPicker = new ColorPicker();
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
        textSizeComboBox.setOnAction(textSizeEvent -> {
            textSize = textSizeComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Text Size: " + textSize);
            // 更新文本大小--Func
        });

        Label fontStyleLabel = new Label("Font-Style");
        ComboBox<String> fontStyleComboBox = new ComboBox<>();
        fontStyleComboBox.getItems().addAll(Font.getFontNames());
        fontStyleComboBox.setOnAction(fontStyleEvent -> {
            selectedFontStyle = fontStyleComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Font Style: " + selectedFontStyle);
            // 更新文本字体样式--Func
        });

        // 添加其他文本框特有的参数设置组件，如果有的话

        paraSetInter.getChildren().addAll(textColorLabel, textColorPicker, textSizeLabel, textSizeComboBox, fontStyleLabel, fontStyleComboBox);
    }


    @FXML
    private void pressOnFigure(ActionEvent event) {
        if (event.getSource() instanceof Button clickedButton) {
            // Now you have the reference to the clicked button
            System.out.println("Clicked Button: " + clickedButton.getText());
            if ("Circle".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.CIRCLE);
                setCirclePara();
            } else if ("Line".equals(clickedButton.getText())) {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.LINE);
                setLinePara();

            }else if("Rectangle".equals(clickedButton.getText()))
            {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.RECTANGLE);
                setRectanglePara();
            }else if("Text".equals(clickedButton.getText()))
            {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.TEXTBOX);
                setTextBoxPara();
            }else if("Ellipse".equals(clickedButton.getText()))
            {
                canvas.setCurrentMode(MyCanvas.MyCanvasMode.ELLIPSE);
                setEllipsePara();
            }
        }
    }

    @FXML
    private  void canvasMouseClicked(MouseEvent event)
    //当鼠标在 Canvas 上单击时触发。
    {
        if(canvas.getCurrentMode()== MyCanvas.MyCanvasMode.CIRCLE)
        {
            double mouseX = event.getX();
            double mouseY = event.getY();
            // 执行绘制圆的动作，传递鼠标位置
            drawCircle(mouseX, mouseY);
        }
    }

    private void drawCircle(double centerX, double centerY) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double radius = 100;

        // 清空画布
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        // 设置圆的颜色
        gc.setFill(javafx.scene.paint.Color.BLUE);

        // 绘制圆
        gc.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }

    private void test(){
    }



    @FXML
    public void canvasMouseDragEnter(MouseDragEvent mouseDragEvent)
    //当鼠标拖拽进入 Canvas 区域时触发
    {
    }
    @FXML
    public void canvasMouseDragExit(MouseDragEvent mouseDragEvent)
    //当鼠标拖拽退出 Canvas 区域时触发。
    {
    }

    @FXML
    public void canvasMouseDragged(MouseEvent event)
    //当鼠标在 Canvas 上拖拽时触发。
    {
    }
    @FXML
    public void canvasMouseDragOver(MouseDragEvent mouseDragEvent)
    // 当鼠标拖拽在 Canvas 上悬停时触发。
    {
    }

    @FXML
    public void canvasMouseDragReleased(MouseDragEvent mouseDragEvent)
//    当鼠标拖拽释放时触发。
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
    }
}
