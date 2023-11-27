package Graph;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Ellipse extends BaseGraph {
    private Tuple<Double,Double> coord1;//左端点
    private Tuple<Double,Double> coord2;// 上端点

    public Ellipse(double x0,double y0,double x1,double y1)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(min(2*x0-x1,x1),y0);
        coord2=new Tuple<Double,Double>(x0,min(2*y0-y1,y1));
        SetBound(x0,y0,x1,y1);
    }
    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Ellipse\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Coord1: ").append(coord1.first()).append(", ").append(coord1.second()).append("\n");
        info.append("Coord2: ").append(coord2.first()).append(", ").append(coord2.second()).append("\n");
        return info.toString();
    }
}
