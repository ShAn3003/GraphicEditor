package Graph;
import javafx.scene.paint.Color;

import static java.lang.Math.max;
import static java.lang.Math.min;
public class Ellipse extends BaseGraph {
    private Tuple<Double,Double> coord1;//左端点
    private Tuple<Double,Double> coord2;// 上端点

    private Color fillColor;
    private Color borderColor;
    private Double lineWidth;
    public Ellipse(double x0,double y0,double x1,double y1,Color fillColor,Color borderColor,double lineWidth)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(min(2*x0-x1,x1),y0);
        coord2=new Tuple<Double,Double>(x0,min(2*y0-y1,y1));
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        this.lineWidth=lineWidth;
        SetBound(x0,y0,x1,y1);
    }
    public void save()
    {
        //
    }
}
