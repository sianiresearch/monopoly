package monopoly;

import magritte.primitives.*;

import magritte.wraps.*;


public class Square extends magritte.wraps.Morph {
    public int count() {
        return _get("count").asInteger();
    }

    public void increment() {
        ((monopoly.natives.Count) _get("increment").asNative()).increment();
    }

    public void count(java.lang.Integer value) {
        _edit().set("count", value);
    }

    public void count(magritte.Expression<java.lang.Integer> value) {
        _edit().let("count", value);
    }

    public void increment(magritte.NativeCode value) {
        _edit().let("increment", value);
    }
}
