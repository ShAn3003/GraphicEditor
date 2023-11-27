package Graph;
public class Round extends BaseGraph{
    private double radius;
    public Round(double x,double y,double r)
    {
        this.setCoord0(x,y);
        this.radius=r;
        SetBound(x,y,r);
    }
    public void setRadius(double r)
    {
        radius=r;
    }
    public void SetBound(double x,double y,double r)
    {
        left=new Tuple<Double,Double>(x-r,y-r);
        right=new Tuple<Double,Double>(x+r,y+r);
    }

    public void save()
    {
        //
    }
}
