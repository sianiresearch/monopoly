package tafat;

import magritte.primitives.*;

import magritte.wraps.*;


public class HeatMap extends tafat.View {
    public String exportPath() {
        return _get("exportPath").asString();
    }

    public void exportPath(java.lang.String value) {
        _edit().set("exportPath", value);
    }

    public void exportPath(magritte.Expression<java.lang.String> value) {
        _edit().let("exportPath", value);
    }

    public magritte.Set<Type> regionTypes() {
        return _definition()._aggregables(tafat.HeatMap.Region.class);
    }

    public Type regionType(int index) {
        return regionTypes().get(index);
    }

    public magritte.Set<tafat.HeatMap.Region> regionSet() {
        return _components(tafat.HeatMap.Region.class);
    }

    public tafat.HeatMap.Region region(int index) {
        return regionSet().get(index);
    }

    public static class Region extends magritte.wraps.Morph {
        public int square() {
            return _get("square").asInteger();
        }

        public tafat.Entity entity() {
            return _get("entity").as(tafat.Entity.class);
        }

        public magritte.Set<magritte.wraps.Type> entityTypes() {
            return _definition()._getAssignable("entity")
                       .as(magritte.wraps.Type.class);
        }

        public magritte.wraps.Type entityType(int index) {
            return entityTypes().get(index);
        }

        public double calculation() {
            return ((tafat.natives.Function) _get("calculation").asNative()).calculate();
        }

        public void square(int... square) {
            _edit().set("square", square);
        }

        public void square(magritte.Expression<Integer> value) {
            _edit().let("square", value);
        }

        public void square(magritte.wraps.Operation operation, int... square) {
            _edit(operation).set("square", square);
        }

        public void entity(tafat.Entity value) {
            _edit().set("entity", value);
        }

        public void calculation(magritte.NativeCode value) {
            _edit().let("calculation", value);
        }
    }
}
