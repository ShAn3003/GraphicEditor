package Graph;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Point extends BaseGraph{
    private List<Tuple<Double,Double>> points;//除定位点以外的点
    private Color fillcolor;
    private double lineWidth;
    public Point(double x,double y,Color fillcolor,double lineWidth)
    {
        setCoord0(x,y);
        points=new ArrayList<>();
        this.fillcolor=fillcolor;
        this.lineWidth=lineWidth;
        setType(GRAPHTYPE.POINT);
    }
    public Point(Point pl)
    {
        setCoord0(pl.getCoord0().first(),pl.getCoord0().second());
        points=new ArrayList<>();
        for(Tuple<Double, Double> p :pl.getPoints())
        {
            points.add(new Tuple<Double,Double>(p.first(),p.second()));
        }
        this.fillcolor=pl.fillcolor;
        this.lineWidth=pl.lineWidth;
        setType(GRAPHTYPE.POINT);
    }
    public List<Tuple<Double,Double>> getPoints()
    {
        return points;
    }
    public void setPoints(List<Tuple<Double,Double>> points)
    {
        this.points=points;
    }
    public void add(double x,double y)
    {
        Tuple<Double,Double> t=new Tuple<Double,Double>(x,y);
        SetBound(x,y);
        points.add(t);
    }

    @Override
    public void SetBound(double x, double y) {
        super.SetBound(min(x,getLeft().first()), min(y,getLeft().second()), max(x,getRight().first()),max(y,getRight().second()));
    }

    public Color getFillcolor() {
        return fillcolor;
    }

    public void setFillcolor(Color fillcolor) {
        this.fillcolor = fillcolor;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }
    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: Point\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Fillcolor: ").append(fillcolor.toString()).append("\n");
        info.append("LineWidth: ").append(lineWidth).append("\n");
        for (Tuple<Double, Double> point : points) {
            info.append("Point: ").append(point.first()).append(", ").append(point.second()).append("\n");
        }
        return info.toString();
    }

    @Override
    public void move(Double dx, Double dy) {
        Tuple<Double,Double> coord=this.getCoord0();
        this.setCoord0(coord.first()+dx,coord.second()+dy);
        for(Tuple<Double,Double> p :points)
        {
            p.set_first(p.first()+dx);
            p.set_second(p.second()+dy);
        }
        super.SetBound(this.getLeft().first()+dx,
                this.getLeft().second()+dy,
                this.getRight().first()+dx,
                this.getRight().second()+dy);
    }
}
