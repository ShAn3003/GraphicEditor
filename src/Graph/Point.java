package Graph;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Point extends BaseGraph{
    private List<Tuple<Double,Double>> points;//除定位点以外的点
    private Color fillcolor;
    private double lineWidth;
    public Point(double x,double y,Color fillcolor,double lineWidth)
    {
        setCoord0(x,y);
        points=new ArrayList<>();
        this.fillcolor=fillcolor;
        this.lineWidth=lineWidth;
    }
    public List<Tuple<Double,Double>> getPoints()
    {
        return points;
    }
    public void setPoints(List<Tuple<Double,Double>> points)
    {
        this.points=points;
    }
    public void add(double x,double y)
    {
        Tuple<Double,Double> t=new Tuple<Double,Double>(x,y);
        points.add(t);
    }
    public void save()
    {
        //
    }
}
