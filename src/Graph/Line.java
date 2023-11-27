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
    public void save()
    {
        //
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
}
