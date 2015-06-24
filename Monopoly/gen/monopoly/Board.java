package monopoly;

import magritte.primitives.*;

import magritte.wraps.*;


public class Board extends magritte.wraps.Morph {
    public Square squareAt(int position) {
        return ((monopoly.natives.SquareAt) _get("squareAt").asNative()).squareAt(position);
    }

    public Square squareOf(Class<?extends Square> aClass) {
        return ((monopoly.natives.SquareOf) _get("squareOf").asNative()).squareOf(aClass);
    }

    public int positionOf(Square square) {
        return ((monopoly.natives.Position) _get("positionOf").asNative()).position(square);
    }

    public void squareAt(magritte.NativeCode value) {
        _edit().let("squareAt", value);
    }

    public void squareOf(magritte.NativeCode value) {
        _edit().let("squareOf", value);
    }

    public void positionOf(magritte.NativeCode value) {
        _edit().let("positionOf", value);
    }

    public magritte.Set<monopoly.Square> squareSet() {
        return _components(monopoly.Square.class);
    }

    public monopoly.Square square(int index) {
        return squareSet().get(index);
    }
}
