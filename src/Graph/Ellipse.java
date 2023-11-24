package Graph;
import static java.lang.Math.max;
import static java.lang.Math.min;
public class Ellipse extends BaseGraph {
    private Tuple coord2;
    private Tuple coord3;

    public Ellipse(Tuple t, Tuple a, Tuple b) {
        this.SetCoord(t);
        this.coord2 = a;
        this.coord3 = b;
        SetBound();
    }
    public void SetBound()
    {
        Tuple coord4 = new Tuple(getcoord().first()*2-coord2.first(),getcoord().second()*2-coord2.second());
        Tuple coord5 = new Tuple(getcoord().first()*2-coord3.first(),getcoord().second()*2-coord3.second());
        this.left=new Tuple(
                min(min(coord2.first(),coord3.first()),min(coord4.first(),coord5.first())),
                max(max(coord2.second(),coord3.second()),max(coord4.second(),coord5.second())));
        this.right=new Tuple(
                max(max(coord2.first(),coord3.first()),max(coord4.first(),coord5.first())),
                min(min(coord2.second(),coord3.second()),min(coord4.second(),coord5.second())));
    }

}
