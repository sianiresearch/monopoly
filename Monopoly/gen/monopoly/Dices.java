package monopoly;

import magritte.primitives.*;

import magritte.wraps.*;


public class Dices extends magritte.wraps.Morph {
    public int value1() {
        return _get("value1").asInteger();
    }

    public int value2() {
        return _get("value2").asInteger();
    }

    public void roll() {
        ((monopoly.natives.Roll) _get("roll").asNative()).roll();
    }

    public boolean doubles() {
        return ((monopoly.natives.Doubles) _get("doubles").asNative()).check();
    }

    public int v() {
        return ((monopoly.natives.Value) _get("v").asNative()).value();
    }

    public void value1(java.lang.Integer value) {
        _edit().set("value1", value);
    }

    public void value1(magritte.Expression<java.lang.Integer> value) {
        _edit().let("value1", value);
    }

    public void value2(java.lang.Integer value) {
        _edit().set("value2", value);
    }

    public void value2(magritte.Expression<java.lang.Integer> value) {
        _edit().let("value2", value);
    }

    public void roll(magritte.NativeCode value) {
        _edit().let("roll", value);
    }

    public void doubles(magritte.NativeCode value) {
        _edit().let("doubles", value);
    }

    public void v(magritte.NativeCode value) {
        _edit().let("v", value);
    }
}
