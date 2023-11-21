package shan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shan.controller.Controller;

public class GraphicJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //文件路径+设置控制类的无参构造函数
        FXMLLoader loader = new FXMLLoader(getClass().getResource("controller/view.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("GraphicEditor-ShAn");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
