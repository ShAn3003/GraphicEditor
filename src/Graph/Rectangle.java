package Graph;

import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends BaseGraph{
    private Tuple<Double,Double> coord1;

    public Rectangle(double x0,double y0,double x1,double y1)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        SetBound(x0,y0,x1,y1);
    }

    public void setCoord1(double x,double y) {
        this.coord1 = new Tuple<Double,Double>(x,y);
    }

    public void save()
    {
        //
    }
}
