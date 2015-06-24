package monopoly.jailscape;

import magritte.primitives.*;

import magritte.wraps.*;


public class JailScape extends magritte.wraps.Morph {
    public Modes[] modes() {
        return magritte.primitives.Enumerate.cardinal(_getMultiple("modes")
                                                          .asInteger(),
            Modes.values());
    }

    public int step() {
        return _get("step").asInteger();
    }

    public void Modes(Modes... values) {
        _edit().set("modes", magritte.primitives.Enumerate.ordinal(values));
    }

    public void step(java.lang.Integer value) {
        _edit().set("step", value);
    }

    public void step(magritte.Expression<java.lang.Integer> value) {
        _edit().let("step", value);
    }

    public enum Modes {Card,
        Money;
    }
}
