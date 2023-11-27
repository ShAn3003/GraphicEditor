package Graph;

import javafx.scene.paint.Color;

public class Round extends BaseGraph{
    private double radius;
    private Color fillColor;
    private Color borderColor;
    private Double lineWidth;
    public Round(double x,double y,double r,Color fillColor,Color borderColor ,Double lineWidth)
    {
        this.setCoord0(x,y);
        this.radius=r;
        this.lineWidth=lineWidth;
        this.fillColor=fillColor;
        this.borderColor=borderColor;
        SetBound(x,y,r);
    }
    public void setRadius(double r)
    {
        radius=r;
    }
    public void SetBound(double x,double y,double r)
    {
        super.SetBound(x,y,x+r,y+r);
    }

    public void save()
    {
        //
    }
}
