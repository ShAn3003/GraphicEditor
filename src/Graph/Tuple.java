package Graph;
public class Tuple {//辅助类
    private float _first;
    private float _second;

    public Tuple(float i,float j) {
        this._first = i;
        this._second = j;
    }

    public float first() {
        return this._first;
    }

    public float second() {
        return this._second;
    }
}