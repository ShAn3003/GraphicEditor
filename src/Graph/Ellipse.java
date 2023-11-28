package Graph;
import javafx.scene.paint.Color;
import static java.lang.Math.min;

public class Ellipse extends BaseGraph {
    private Tuple<Double,Double> coord1;//左端点
    private Tuple<Double,Double> coord2;// 上端点

    private Color fillColor;
    private Color borderColor;
    private Double lineWidth;
    public Ellipse(double x0,double y0,double x1,double y1,Color fillColor,Color borderColor,double lineWidth)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(min(2*x0-x1,x1),y0);
        coord2=new Tuple<Double,Double>(x0,min(2*y0-y1,y1));
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        this.lineWidth=lineWidth;
        SetBound(x0,y0,x1,y1);
        setType(GRAPHTYPE.ELLIPSE);
    }
    public Ellipse(Ellipse e)
    {
        setCoord0(e.getCoord0().first(),e.getCoord0().second());
        coord1=new Tuple<Double,Double>(e.getCoord1().first(),e.getCoord1().second());
        coord2=new Tuple<Double,Double>(e.getCoord2().first(),e.getCoord2().second());
        this.fillColor=e.fillColor;
        this.borderColor=e.borderColor;
        this.lineWidth=e.lineWidth;
        SetBound(e.getCoord0().first(),
                e.getCoord0().second(),
                e.getCoord0().first()-e.getLeft().first(),
                e.getCoord0().second()-e.getLeft().second());
        setType(GRAPHTYPE.ELLIPSE);
    }
    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Tuple<Double, Double> getCoord1() {
        return coord1;
    }

    public Tuple<Double, Double> getCoord2() {
        return coord2;
    }

    public void setCoord1(Double x,Double y) {
        this.coord1 = new Tuple<Double,Double>(x,y);
    }
    public void setCoord2(Double x,Double y) {
        this.coord2 = new Tuple<Double,Double>(x,y);
    }


    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(Double lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public void SetBound(double x0, double y0, double a, double b) {
        super.SetBound(x0-a, y0-b, x0+a, y0+b);
    }
    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Ellipse\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Coord1: ").append(coord1.first()).append(", ").append(coord1.second()).append("\n");
        info.append("Coord2: ").append(coord2.first()).append(", ").append(coord2.second()).append("\n");
        return info.toString();
    }

    @Override
    public void move(Double dx, Double dy) {
        Tuple<Double,Double> coord=this.getCoord0();
        this.setCoord0(coord.first()+dx,coord.second()+dy);
        coord1=new Tuple<Double,Double>(coord1.first()+dx,coord1.second()+dy);
        coord2=new Tuple<Double,Double>(coord2.first()+dx,coord2.second()+dy);
        super.SetBound(this.getLeft().first()+dx,
                this.getLeft().second()+dy,
                this.getRight().first()+dx,
                this.getRight().second()+dy);
    }
}
