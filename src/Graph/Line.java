package Graph;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends BaseGraph {
    private Tuple<Double,Double> coord2;
    public Line(double x0,double y0,double x1,double y1) {
        setCoord0(x0,y0);
        coord2=new Tuple<Double,Double>(x1,y1);
        SetBound(x0,y0,x1,y1);
    }
    public void SetBound(double x0,double y0,double x1,double y1)
    {
        left=new Tuple<Double,Double>(min(x0,x1),min(y0,y1));
        right=new Tuple<Double,Double>(max(x0,x1),max(y0,y1));
    }
    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Line\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Coord2: ").append(coord2.first()).append(", ").append(coord2.second()).append("\n");

        return info.toString();
    }
}
