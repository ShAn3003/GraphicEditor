package Graph;

import javafx.scene.paint.Color;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends BaseGraph {
    private Tuple<Double,Double> coord1;
    private Color lineColor;
    private Double lineWidth;
    public Line(double x0,double y0,double x1,double y1,Color lineColor,Double lineWidth) {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        this.lineColor=lineColor;
        this.lineWidth=lineWidth;
        SetBound(x0,y0,x1,y1);
        setType(GRAPHTYPE.LINE);
    }
    public void SetBound(double x0,double y0,double x1,double y1)
    {
        super.SetBound(x0,y0,x1,y1);
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(Double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Tuple<Double, Double> getCoord1() {
        return coord1;
    }

    public void setCoord1(Tuple<Double, Double> coord1) {
        this.coord1 = coord1;
    }
    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Line\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Coord2: ").append(coord1.first()).append(", ").append(coord1.second()).append("\n");
        return info.toString();
    }

    @Override
    public void move(Double dx, Double dy) {
        Tuple<Double,Double> coord=this.getCoord0();
        this.setCoord0(coord.first()+dx,coord.second()+dy);
        coord1=new Tuple<Double,Double>(coord1.first()+dx,coord1.second()+dy);
        super.SetBound(this.getLeft().first()+dx,
                this.getLeft().second()+dy,
                this.getRight().first()+dx,
                this.getRight().second()+dy);
    }
}
