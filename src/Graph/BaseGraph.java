package Graph;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BaseGraph {
    private Tuple<Double,Double> coord0;
    //定位点，
    //边界框左上角，
    public Tuple<Double,Double> left;
    //边界框右下角，
    public Tuple<Double,Double> right;

    public BaseGraph(double a,double b) {

    }
    public BaseGraph() {

    }
    // Getter和Setter方法
    public void setCoord0(double a,double b)
    {
        coord0=new Tuple<Double,Double>(a,b);
    }
    public Tuple<Double,Double> getCoord0()
    {
        return this.coord0;
    }
    public void SetBound(double x0,double y0,double x1,double y1)
    {
        left=new Tuple<Double,Double>(min(2*x0-x1,x1),min(2*y0-y1,y1));
        right=new Tuple<Double,Double>(max(2*x0-x1,x1),max(2*y0-y1,y1));
    }

    public Tuple<Double, Double> getLeft() {
        return left;
    }

    public Tuple<Double, Double> getRight() {
        return right;
    }

    public String save()
    {
        return "";
    }
}
