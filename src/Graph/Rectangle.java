package Graph;

import javafx.scene.paint.Color;

import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends BaseGraph{
    private Tuple<Double,Double> coord1;
    private Color fillColor;
    private Color borderColor;
    private Double lineWidth;
    public Rectangle(double x0,double y0,double x1,double y1,Color fillColor,Color borderColor ,Double lineWidth)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        this.lineWidth=lineWidth;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        SetBound(x0,y0,x1,y1);
    }

    public void setCoord1(double x,double y) {
        this.coord1 = new Tuple<Double,Double>(x,y);
    }

    @Override
    public void SetBound(double x0, double y0, double x1, double y1) {
        super.SetBound((x0+x1)/2,(y0+y1)/2, x1, y1);
    }

    public void save()
    {
        //
    }
}
