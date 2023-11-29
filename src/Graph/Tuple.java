package Graph;

public class Tuple<T1, T2> {
    private T1 _first;
    private T2 _second;
    public Tuple(T1 item1, T2 item2) {
        this._first = item1;
        this._second = item2;
    }
    public T1 first() {
        return _first;
    }
    public T2 second() {
        return _second;
    }
    public void set_first(T1 _first) {
        this._first = _first;
    }
    public void set_second(T2 _second) {
        this._second = _second;
    }
}
