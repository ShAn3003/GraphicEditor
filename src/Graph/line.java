package Graph;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class line extends BaseGraph {
    private Tuple<Double,Double> coord2;
    public line(double x0,double y0,double x1,double y1) {
        setCoord0(x0,y0);
        coord2=new Tuple<Double,Double>(x1,y1);
        SetBound(x0,y0,x1,y1);
    }

    public void save()
    {
        //
    }
}
