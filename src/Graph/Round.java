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

    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Round\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Radius: ").append(radius).append("\n");

        return info.toString();
    }
}
