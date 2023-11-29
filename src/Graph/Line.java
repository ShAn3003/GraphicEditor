package Graph;

import javafx.scene.paint.Color;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends BaseGraph {
    private Tuple<Double,Double> coord1;
    private Color lineColor;
    private double lineWidth;
    public Line(double x0,double y0,double x1,double y1,Color lineColor,Double lineWidth) {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        this.lineColor=lineColor;
        this.lineWidth=lineWidth;
        SetBound(x0,y0,x1,y1);
        setType(GRAPHTYPE.LINE);
    }
    public Line(Line l) {
        setCoord0(l.getCoord0().first(),l.getCoord0().second());
        coord1=new Tuple<Double,Double>(l.getCoord1().first(),l.getCoord1().second());
        this.lineColor=l.lineColor;
        this.lineWidth=l.lineWidth;
        SetBound(l.getCoord0().first(),
                l.getCoord0().second(),
                l.getCoord1().first(),
                l.getCoord1().second());
        setType(GRAPHTYPE.LINE);
    }
    public void SetBound(double x0,double y0,double x1,double y1)
    {
        super.SetBound(min(x0,x1),min(y0,y1), max(x0,x1), max(y0,y1));
    }

    public Color getLineColor() {
        return lineColor;
    }
    public double getStartX() {
        return getCoord0().first();
    }
    public double getStartY() {
        return getCoord0().second();
    }
    public double getEndX() {
        return coord1.first();
    }
    public double getEndY() {
        return coord1.second();
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
        info.append("Coord1: ").append(coord1.first()).append(", ").append(coord1.second()).append("\n");
        info.append("LineColor: ").append(lineColor.toString()).append("\n");
        info.append("LineWidth: ").append(lineWidth).append("\n");
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
