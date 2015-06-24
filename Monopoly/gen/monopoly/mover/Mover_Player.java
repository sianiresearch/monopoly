package monopoly.mover;

import magritte.primitives.*;

import magritte.wraps.*;


public class Mover_Player extends monopoly.mover.Mover {
    public int turnsToBeInJail() {
        return _get("turnsToBeInJail").asInteger();
    }

    public int numberOfRolls() {
        return _get("numberOfRolls").asInteger();
    }

    public void turnsToBeInJail(java.lang.Integer value) {
        _edit().set("turnsToBeInJail", value);
    }

    public void turnsToBeInJail(magritte.Expression<java.lang.Integer> value) {
        _edit().let("turnsToBeInJail", value);
    }

    public void numberOfRolls(java.lang.Integer value) {
        _edit().set("numberOfRolls", value);
    }

    public void numberOfRolls(magritte.Expression<java.lang.Integer> value) {
        _edit().let("numberOfRolls", value);
    }

    public magritte.Set<Rule> ruleSet() {
        return _definition()._components(Rule.class);
    }

    public Rule rule(int index) {
        return ruleSet().get(index);
    }

    public magritte.Set<PlayerIsJailed> playerIsJailedSet() {
        return _definition()._components(PlayerIsJailed.class);
    }

    public PlayerIsJailed playerIsJailed(int index) {
        return playerIsJailedSet().get(index);
    }

    public magritte.Set<JailAfterThreeDoubles> jailAfterThreeDoublesSet() {
        return _definition()._components(JailAfterThreeDoubles.class);
    }

    public JailAfterThreeDoubles jailAfterThreeDoubles(int index) {
        return jailAfterThreeDoublesSet().get(index);
    }

    public magritte.Set<Advance> advanceSet() {
        return _definition()._components(Advance.class);
    }

    public Advance advance(int index) {
        return advanceSet().get(index);
    }

    public magritte.Set<ToJailWhenInGoToJailSquare> toJailWhenInGoToJailSquareSet() {
        return _definition()._components(ToJailWhenInGoToJailSquare.class);
    }

    public ToJailWhenInGoToJailSquare toJailWhenInGoToJailSquare(int index) {
        return toJailWhenInGoToJailSquareSet().get(index);
    }

    public magritte.Set<CheckCard> checkCardSet() {
        return _definition()._components(CheckCard.class);
    }

    public CheckCard checkCard(int index) {
        return checkCardSet().get(index);
    }

    public magritte.Set<Doubles> doublesSet() {
        return _definition()._components(Doubles.class);
    }

    public Doubles doubles(int index) {
        return doublesSet().get(index);
    }

    public static class Rule extends magritte.wraps.Definition {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }

    public static class PlayerIsJailed extends monopoly.mover.Mover_Player.Rule {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }

    public static class JailAfterThreeDoubles extends monopoly.mover.Mover_Player.Rule {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }

    public static class Advance extends monopoly.mover.Mover_Player.Rule {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }

    public static class ToJailWhenInGoToJailSquare extends monopoly.mover.Mover_Player.Rule {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }

    public static class CheckCard extends monopoly.mover.Mover_Player.Rule {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }

    public static class Doubles extends monopoly.mover.Mover_Player.Rule {
        public boolean check() {
            return ((monopoly.natives.Check) _get("check").asNative()).check();
        }

        public void check(magritte.NativeCode value) {
            _edit().let("check", value);
        }
    }
}
