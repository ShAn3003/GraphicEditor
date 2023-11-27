package Graph;

import javafx.scene.paint.Color;

public class TextBox extends BaseGraph{
    private Tuple<Double,Double> coord1;
    private Double textSize;
    private Color textColor;
    private String selectedFontStyle;
    private String text;
    public TextBox(double x0, double y0, double x1, double y1)
    {
        setCoord0(x0,y0);
        coord1=new Tuple<Double,Double>(x1,y1);
        SetBound(x0,y0,x1,y1);
        setText("");
    }
    public void SetBound(double x0, double y0, double x1, double y1) {
        super.SetBound((x0+x1)/2,(y0+y1)/2, x1, y1);
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

}
