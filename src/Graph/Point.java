package Graph;

import java.util.ArrayList;
import java.util.List;

public class Point extends BaseGraph{
    private List<Tuple<Double,Double>> points;//除定位点以外的点
    public Point(double x,double y)
    {
        setCoord0(x,y);
        points=new ArrayList<>();
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
