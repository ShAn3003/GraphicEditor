package Graph;
public class Round extends BaseGraph{
    private float radius;
    public Round(float x,float y,float r)
    {
        this.setCoord0(x,y);
        this.radius=r;
        SetBound(x,y,r);
    }
    public void SetBound(float x,float y,float r)
    {
        left=new Tuple<Float,Float>(x-r,y-r);
        right=new Tuple<Float,Float>(x+r,y+r);
    }
}
