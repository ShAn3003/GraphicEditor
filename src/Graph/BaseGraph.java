package Graph;


import javafx.scene.paint.Color;

import static java.lang.Math.max;
import static java.lang.Math.min;

public abstract class BaseGraph {
    public GRAPHTYPE getType() {
        return type;
    }

    public void setType(GRAPHTYPE type) {
        this.type = type;
    }

    public enum GRAPHTYPE {
        CIRCLE,
        RECTANGLE,
        TEXTBOX,
        LINE,
        ELLIPSE,
        POINT
    }

    private Tuple<Double, Double> coord0;
    //定位点，
    //边界框左上角，
    private Tuple<Double, Double> left;
    //边界框右下角，
    private Tuple<Double, Double> right;
    private GRAPHTYPE type;

    public BaseGraph(double a, double b) {

    }

    public BaseGraph() {

    }

    // Getter和Setter方法
    void setCoord0(double a, double b) {
        coord0 = new Tuple<Double, Double>(a, b);
    }

    public Tuple<Double, Double> getCoord0() {
        return this.coord0;
    }

    public void SetBound(double x0, double y0, double x1, double y1) {
        left = new Tuple<Double, Double>(x0, y0);
        right = new Tuple<Double, Double>(x1, y1);
    }

    public Tuple<Double, Double> getLeft() {
        return left;
    }

    public Tuple<Double, Double> getRight() {
        return right;
    }

    public void SetBound(double x, double y)//draw
    {

    }

    public String save() {
        return "";
    }
}


