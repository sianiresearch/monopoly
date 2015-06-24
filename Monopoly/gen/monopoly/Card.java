package monopoly;

import magritte.primitives.*;

import magritte.wraps.*;


public class Card extends magritte.wraps.Morph {
    public int moveTo() {
        return _get("moveTo").asInteger();
    }

    public boolean transport() {
        return ((monopoly.natives.Movement) _get("transport").asNative()).involvesMovement();
    }

    public void transport(magritte.NativeCode value) {
        _edit().let("transport", value);
    }
}
