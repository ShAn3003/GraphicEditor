package Graph;

import javafx.scene.paint.Color;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends BaseGraph{
    private Tuple<Double,Double> coord1;
    private Color fillColor;
    private Color borderColor;
    private Double lineWidth;
    public Rectangle(double x0,double y0,double x1,double y1,Color fillColor,Color borderColor ,Double lineWidth)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        this.lineWidth=lineWidth;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        setType(GRAPHTYPE.RECTANGLE);
        SetBound(x0,y0,x1,y1);
    }
    public Rectangle(Rectangle rect)
    {
        setCoord0(rect.getCoord0().first(),rect.getCoord0().second());
        coord1=new Tuple<Double,Double>(rect.getCoord1().first(),rect.getCoord1().second());
        this.lineWidth=rect.lineWidth;
        this.fillColor=rect.fillColor;
        this.borderColor=rect.borderColor;
        setType(GRAPHTYPE.RECTANGLE);
        SetBound(rect.getCoord0().first(),
                rect.getCoord0().second(),
                rect.getCoord1().first(),
                rect.getCoord1().second());
    }

    public Tuple<Double, Double> getCoord1() {
        return coord1;
    }

    public void setCoord1(double x, double y) {
        this.coord1 = new Tuple<Double,Double>(x,y);
    }

    @Override
    public void SetBound(double x0, double y0, double x1, double y1) {
        super.SetBound(min(x0,x1),min(y0,y1), max(x0,x1), max(y0,y1));
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
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
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Rectangle\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Coord1: ").append(coord1.first()).append(", ").append(coord1.second()).append("\n");

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
