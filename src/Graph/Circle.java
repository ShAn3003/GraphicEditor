package Graph;

import javafx.scene.paint.Color;

public class Circle extends BaseGraph{
    private double radius;
    private Color fillColor;
    private Color borderColor;
    private Double lineWidth;
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
    public void setRadius(double r)
    {
        radius=r;
    }
    public void SetBound(double x,double y,double r)
    {
        super.SetBound(x-r,y-r,x+r,y+r);
    }

    public void save()
    {
        //
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
}
