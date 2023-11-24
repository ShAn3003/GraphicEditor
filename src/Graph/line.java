package Graph;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class line extends BaseGraph {
    private Tuple coord2;
    public line(Tuple a, Tuple b) {
        this.SetCoord(a);
        this.coord2=b;
        SetBound();
    }
    public void SetBound()
    {
        this.left =new Tuple(min(getcoord().first(),coord2.first()),max(getcoord().second(),coord2.second()));
        this.right =new Tuple(max(getcoord().first(),coord2.first()),min(getcoord().second(),coord2.second()));
    }
}
