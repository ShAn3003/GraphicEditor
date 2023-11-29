package Graph;

import javafx.scene.paint.Color;

public class TextBox extends BaseGraph{
    private Tuple<Double,Double> coord1;
    private double textSize;
    private Color textColor;
    private String selectedFontStyle;
    private String text;
    public TextBox(double x0, double y0, double x1, double y1)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        SetBound(x0,y0,x1,y1);
        setText("");
        setType(GRAPHTYPE.TEXTBOX);
    }
    
    public TextBox(double x0, double y0, double x1, double y1,String text,Double textSize,Color textColor,String selectedFontStyle)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        SetBound(x0,y0,x1,y1);
        setText(text);
        setType(GRAPHTYPE.TEXTBOX);
        this.textSize=textSize;
        this.textColor=textColor;
        this.selectedFontStyle=selectedFontStyle;
    }

    public TextBox(TextBox t)
    {
        setCoord0(t.getCoord0().first(),t.getCoord0().second());
        coord1=new Tuple<Double,Double>(t.getCoord1().first(),t.getCoord1().second());
        SetBound(t.getCoord0().first(),
                t.getCoord0().second(),
                t.getCoord1().first(),
                t.getCoord1().second());
        setText(t.getText());
        setType(GRAPHTYPE.TEXTBOX);
    }

    public Tuple<Double, Double> getCoord1() {
        return coord1;
    }

    public void SetBound(double x0, double y0, double x1, double y1) {
        super.SetBound(x0,y0, x1, y1);
    }

    public void setSelectedFontStyle(String selectedFontStyle) {
        this.selectedFontStyle = selectedFontStyle;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public void setTextSize(Double textSize) {
        this.textSize = textSize;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getTextSize() {
        return textSize;
    }

    public Color getTextColor() {
        return textColor;
    }

    public String getSelectedFontStyle() {
        return selectedFontStyle;
    }


    public String getText() {
        return text;
    }
    @Override
    public String save() {
        StringBuilder info = new StringBuilder();
        info.append("Type: TextBox\n");
        info.append("Coord0: ").append(getCoord0().first()).append(", ").append(getCoord0().second()).append("\n");
        info.append("Coord1: ").append(getCoord1().first()).append(", ").append(getCoord1().second()).append("\n");
        info.append("Text: ").append(text).append("\n");
        info.append("TextSize: ").append(textSize).append("\n");
        info.append("TextColor: ").append(textColor.toString()).append("\n");
        info.append("SelectedFontStyle: ").append(getSelectedFontStyle()).append("\n");
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
