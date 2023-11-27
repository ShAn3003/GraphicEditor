package shan.interfaces;

import javafx.scene.canvas.Canvas;

public class MyCanvas extends Canvas {
    public enum MyCanvasMode{
        CIRCLE,
        RECTANGLE,
        TEXTBOX,
        LINE,
        ELLIPSE,
        POINT,
        SELECT
    }
    private MyCanvasMode currentMode;
    public MyCanvas()
    {
        super();
        currentMode=MyCanvasMode.CIRCLE;
    }

    public MyCanvasMode getCurrentMode()
    {
        return currentMode;
    }

    public void setCurrentMode(MyCanvasMode currentMode){
        this.currentMode=currentMode;
    }

}
