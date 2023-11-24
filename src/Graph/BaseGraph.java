package Graph;
public class BaseGraph {
    private Tuple coord1;//定位点，
    public Tuple left;//边界框左上角，
    public Tuple right;//边界框右下角，
    public BaseGraph(Tuple a) {
        SetCoord(a);
    }
    public BaseGraph() {
        coord1 = new Tuple(0, 0);
    }
    public Tuple getcoord()
    {
        return this.coord1;
    }
    public void SetCoord(Tuple a)
    {
        this.coord1=a;
    }
    public void SetBound()
    {

    }
}
