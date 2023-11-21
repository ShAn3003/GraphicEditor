package shan.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.geometry.Pos;
public class Controller {
    @FXML
    private Canvas canvas;

    @FXML
    private ListView<Button> figureList;
    @FXML
    private ColorPicker colorPicker;
    public enum CanvasMode{
        CIRCLE,
        RECTANGLE,
        LINE
    }

    private CanvasMode currentMode=CanvasMode.CIRCLE;

    @FXML
    private void pressADD_TEST() {
        Button selectedButton = figureList.getSelectionModel().getSelectedItem();
        if (selectedButton != null && "circle".equals(selectedButton.getText())) {
            test();
        }
    }
    @FXML
    private  void canvasMouseClicked(MouseEvent event)
    {
        if(currentMode==CanvasMode.CIRCLE)
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
}
