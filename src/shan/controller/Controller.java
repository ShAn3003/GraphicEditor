package shan.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.geometry.Pos;
import shan.interfaces.MyCanvas;
import shan.interfaces.MyTextArea;
import shan.interfaces.MyVBox;

public class Controller {
    @FXML
    private MyCanvas canvas;

    @FXML
    private ListView<Button> figureList;
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private MyVBox paraSetInter;

    @FXML
    private MyTextArea remarkArea;

    @FXML
    private void pressOnCir(){
        Button selectedButton = figureList.getSelectionModel().getSelectedItem();
        if (true){
            test();
        }
    }
    @FXML
    private void pressADD_TEST() {
        Button selectedButton = figureList.getSelectionModel().getSelectedItem();
        if (selectedButton != null && "circle".equals(selectedButton.getText())) {
            test();
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
    public Controller(){
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
