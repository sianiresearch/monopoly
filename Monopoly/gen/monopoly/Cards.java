package monopoly;

import magritte.primitives.*;

import magritte.wraps.*;


public class Cards extends magritte.wraps.Morph {
    public Card get() {
        return ((monopoly.natives.Get) _get("get").asNative()).get();
    }

    public void get(magritte.NativeCode value) {
        _edit().let("get", value);
    }

    public magritte.Set<Type> cardTypes() {
        return _definition()._aggregables(monopoly.Card.class);
    }

    public Type cardType(int index) {
        return cardTypes().get(index);
    }

    public magritte.Set<monopoly.Card> cardSet() {
        return _components(monopoly.Card.class);
    }

    public monopoly.Card card(int index) {
        return cardSet().get(index);
    }
}
