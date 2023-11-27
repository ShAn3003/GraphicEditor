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
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Point\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");

        for (Tuple<Double, Double> point : points) {
            info.append("Point: ").append(point.first()).append(", ").append(point.second()).append("\n");
        }
        return info.toString();
    }
}
