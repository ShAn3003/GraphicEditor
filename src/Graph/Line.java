package Graph;

import javafx.scene.paint.Color;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends BaseGraph {
    private Tuple<Double,Double> coord2;
    private Color lineColor;
    private Double lineWidth;
    public Line(double x0,double y0,double x1,double y1,Color lineColor,Double lineWidth) {
        setCoord0(x0,y0);
        coord2=new Tuple<Double,Double>(x1,y1);
        this.lineColor=lineColor;
        this.lineWidth=lineWidth;
        SetBound(x0,y0,x1,y1);
    }
    public void SetBound(double x0,double y0,double x1,double y1)
    {
        super.SetBound((x0+x1)/2,(y0+y1)/2, x1, y1);
    }
    public void save()
    {
        //
    }
}
