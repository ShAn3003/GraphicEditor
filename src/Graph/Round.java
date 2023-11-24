package Graph;
public class Round extends BaseGraph{
    private float radius;
    public Round(Tuple a,float r)
    {
        this.SetCoord(a);
        this.radius=r;
    }
    public void SetBound()
    {
        left=new Tuple(getcoord().first()-radius,getcoord().second()-radius);
        right=new Tuple(getcoord().first()+radius,getcoord().second()+radius);
    }
}
