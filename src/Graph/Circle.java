package Graph;

import javafx.scene.paint.Color;

public class Circle extends BaseGraph{
    private double radius;
    private Color fillColor;
    private Color borderColor;
    private double lineWidth;
    public Circle(double x, double y, double r, Color fillColor, Color borderColor , Double lineWidth)
    {
        this.setCoord0(x,y);
        this.radius=r;
        this.lineWidth=lineWidth;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        setType(GRAPHTYPE.CIRCLE);
        SetBound(x,y,r);
    }
    public Circle(Circle c)
    {
        this.setCoord0(c.getCoord0().first(),c.getCoord0().second());
        this.radius=c.radius;
        this.lineWidth=c.lineWidth;
        this.fillColor=c.fillColor;
        this.borderColor=c.borderColor;
        setType(GRAPHTYPE.CIRCLE);
        SetBound(c.getCoord0().first(),c.getCoord0().second(),radius);
    }
    public void setRadius(double r)
    {
        radius=r;
    }
    public void SetBound(double x,double y,double r)
    {
        super.SetBound(x-r,y-r,x+r,y+r);
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

    public double getRadius() {
        return radius;
    }

    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Circle\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Radius: ").append(radius).append("\n");
        info.append("FillColor: ").append(fillColor.toString()).append("\n");
        info.append("BorderColor: ").append(borderColor.toString()).append("\n");
        info.append("LineWidth: ").append(lineWidth).append("\n");
        return info.toString();
    }
    @Override
    public void move(Double dx, Double dy) {
        Tuple<Double,Double> coord=this.getCoord0();
        this.setCoord0(coord.first()+dx,coord.second()+dy);
        super.SetBound(this.getLeft().first()+dx,
                this.getLeft().second()+dy,
                this.getRight().first()+dx,
                this.getRight().second()+dy);
    }
}
