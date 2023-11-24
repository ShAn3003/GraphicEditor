package Graph;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends BaseGraph{
    private Tuple coord2;
    private Tuple coord3;
    private Tuple coord4;
    public Rectangle(Tuple a,Tuple b,Tuple c,Tuple d)
    {
        this.SetCoord(a);
        this.coord2 = b;
        this.coord3 = c;
        this.coord4 = d;
    }
    public void SetBound()
    {
        this.left=new Tuple(
                min(min(getcoord().first(),coord2.first()),min(coord3.first(),coord4.first())),
                max(max(getcoord().second(),coord2.second()),max(coord3.second(),coord4.second())));
        this.right=new Tuple(
                max(max(getcoord().first(),coord2.first()),max(coord3.first(),coord4.first())),
                min(min(getcoord().second(),coord2.second()),min(coord3.second(),coord4.second())));
    }
}
