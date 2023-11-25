package Graph;
public class BaseGraph {
    private Tuple<Float,Float> coord0;
    //定位点，
    //边界框左上角，
    public Tuple<Float,Float> left;
    //边界框右下角，
    public Tuple<Float,Float> right;

    public BaseGraph(float a,float b) {

    }
    public BaseGraph() {

    }
    // Getter和Setter方法
    void setCoord0(float a,float b)
    {
        coord0=new Tuple<Float,Float>(a,b);
    }
    Tuple<Float,Float> getCoord0()
    {
        return this.coord0;
    }
}
