package Graph;
import static java.lang.Math.max;
import static java.lang.Math.min;
public class Ellipse extends BaseGraph {
    private Tuple<Float,Float> coord1;//左端点
    private Tuple<Float,Float> coord2;// 上端点

    public Ellipse(float x0,float y0,float x1,float y1)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Float,Float>(min(2*x0-x1,x1),y0);
        coord2=new Tuple<Float,Float>(x0,min(2*y0-y1,y1));
        SetBound(x0,y0,x1,y1);
    }
    public void SetBound(float x0,float y0,float x1,float y1)
    {
        left=new Tuple<Float,Float>(min(2*x0-x1,x1),min(2*y0-y1,y1));
        right=new Tuple<Float,Float>(max(2*x0-x1,x1),max(2*y0-y1,y1));
    }

}
