package monopoly;

import magritte.primitives.*;

import magritte.wraps.*;


public class Player extends magritte.wraps.Morph {
    public String id() {
        return _get("id").asString();
    }

    public monopoly.Square square() {
        return _get("square").as(monopoly.Square.class);
    }

    public magritte.Set<magritte.wraps.Type> squareTypes() {
        return _definition()._getAssignable("entity")
                   .as(magritte.wraps.Type.class);
    }

    public magritte.wraps.Type squareType(int index) {
        return squareTypes().get(index);
    }

    public void id(java.lang.String value) {
        _edit().set("id", value);
    }

    public void id(magritte.Expression<java.lang.String> value) {
        _edit().let("id", value);
    }

    public void square(monopoly.Square value) {
        _edit().set("square", value);
    }
}
