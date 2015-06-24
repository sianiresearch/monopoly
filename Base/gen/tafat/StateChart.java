package tafat;

import magritte.primitives.*;

import magritte.wraps.*;


public class StateChart extends magritte.wraps.Morph {
    public magritte.Set<Type> stateTypes() {
        return _definition()._aggregables(tafat.StateChart.State.class);
    }

    public Type stateType(int index) {
        return stateTypes().get(index);
    }

    public magritte.Set<Type> transitionTypes() {
        return _definition()._aggregables(tafat.StateChart.Transition.class);
    }

    public Type transitionType(int index) {
        return transitionTypes().get(index);
    }

    public magritte.Set<tafat.StateChart.State> stateSet() {
        return _components(tafat.StateChart.State.class);
    }

    public tafat.StateChart.State state(int index) {
        return stateSet().get(index);
    }

    public magritte.Set<tafat.StateChart.Transition> transitionSet() {
        return _components(tafat.StateChart.Transition.class);
    }

    public tafat.StateChart.Transition transition(int index) {
        return transitionSet().get(index);
    }

    public static class State extends magritte.wraps.Morph {
        public magritte.Set<Type> actionTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.State.Action.class);
        }

        public Type actionType(int index) {
            return actionTypes().get(index);
        }

        public magritte.Set<Type> entryActionTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.State.EntryAction.class);
        }

        public Type entryActionType(int index) {
            return entryActionTypes().get(index);
        }

        public magritte.Set<Type> exitActionTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.State.ExitAction.class);
        }

        public Type exitActionType(int index) {
            return exitActionTypes().get(index);
        }

        public magritte.Set<Type> stateTypes() {
            return _definition()._aggregables(tafat.StateChart.State.class);
        }

        public Type stateType(int index) {
            return stateTypes().get(index);
        }

        public magritte.Set<Type> transitionTypes() {
            return _definition()._aggregables(tafat.StateChart.Transition.class);
        }

        public Type transitionType(int index) {
            return transitionTypes().get(index);
        }

        public magritte.Set<tafat.StateChart.State.Action> actionSet() {
            return _components(tafat.StateChart.State.Action.class);
        }

        public tafat.StateChart.State.Action action(int index) {
            return actionSet().get(index);
        }

        public magritte.Set<tafat.StateChart.State.EntryAction> entryActionSet() {
            return _components(tafat.StateChart.State.EntryAction.class);
        }

        public tafat.StateChart.State.EntryAction entryAction(int index) {
            return entryActionSet().get(index);
        }

        public magritte.Set<tafat.StateChart.State.ExitAction> exitActionSet() {
            return _components(tafat.StateChart.State.ExitAction.class);
        }

        public tafat.StateChart.State.ExitAction exitAction(int index) {
            return exitActionSet().get(index);
        }

        public magritte.Set<tafat.StateChart.State> stateSet() {
            return _components(tafat.StateChart.State.class);
        }

        public tafat.StateChart.State state(int index) {
            return stateSet().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition> transitionSet() {
            return _components(tafat.StateChart.Transition.class);
        }

        public tafat.StateChart.Transition transition(int index) {
            return transitionSet().get(index);
        }

        public static class Action extends magritte.wraps.Morph {
            public void action() {
                ((tafat.natives.Action) _get("action").asNative()).execute();
            }

            public void action(magritte.NativeCode value) {
                _edit().let("action", value);
            }
        }

        public static class EntryAction extends tafat.StateChart.State.Action {
        }

        public static class ExitAction extends tafat.StateChart.State.Action {
        }
    }

    public static class Transition extends magritte.wraps.Morph {
        public tafat.StateChart.State from() {
            return _get("from").as(tafat.StateChart.State.class);
        }

        public magritte.Set<magritte.wraps.Type> fromTypes() {
            return _definition()._getAssignable("entity")
                       .as(magritte.wraps.Type.class);
        }

        public magritte.wraps.Type fromType(int index) {
            return fromTypes().get(index);
        }

        public tafat.StateChart.State to() {
            return _get("to").as(tafat.StateChart.State.class);
        }

        public magritte.Set<magritte.wraps.Type> toTypes() {
            return _definition()._getAssignable("entity")
                       .as(magritte.wraps.Type.class);
        }

        public magritte.wraps.Type toType(int index) {
            return toTypes().get(index);
        }

        public void action() {
            ((tafat.natives.Action) _get("action").asNative()).execute();
        }

        public void from(tafat.StateChart.State value) {
            _edit().set("from", value);
        }

        public void to(tafat.StateChart.State value) {
            _edit().set("to", value);
        }

        public void action(magritte.NativeCode value) {
            _edit().let("action", value);
        }

        public magritte.Set<Type> triggerTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.Transition.Trigger.class);
        }

        public Type triggerType(int index) {
            return triggerTypes().get(index);
        }

        public magritte.Set<Type> conditionTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.Transition.Condition.class);
        }

        public Type conditionType(int index) {
            return conditionTypes().get(index);
        }

        public magritte.Set<Type> timeoutTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.Transition.Timeout.class);
        }

        public Type timeoutType(int index) {
            return timeoutTypes().get(index);
        }

        public magritte.Set<Type> afterTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.Transition.After.class);
        }

        public Type afterType(int index) {
            return afterTypes().get(index);
        }

        public magritte.Set<Type> rateTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.Transition.Rate.class);
        }

        public Type rateType(int index) {
            return rateTypes().get(index);
        }

        public magritte.Set<Type> messageTypes() {
            return _definition()
                       ._aggregables(tafat.StateChart.Transition.Message.class);
        }

        public Type messageType(int index) {
            return messageTypes().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition.Trigger> triggerSet() {
            return _components(tafat.StateChart.Transition.Trigger.class);
        }

        public tafat.StateChart.Transition.Trigger trigger(int index) {
            return triggerSet().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition.Condition> conditionSet() {
            return _components(tafat.StateChart.Transition.Condition.class);
        }

        public tafat.StateChart.Transition.Condition condition(int index) {
            return conditionSet().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition.Timeout> timeoutSet() {
            return _components(tafat.StateChart.Transition.Timeout.class);
        }

        public tafat.StateChart.Transition.Timeout timeout(int index) {
            return timeoutSet().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition.After> afterSet() {
            return _components(tafat.StateChart.Transition.After.class);
        }

        public tafat.StateChart.Transition.After after(int index) {
            return afterSet().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition.Rate> rateSet() {
            return _components(tafat.StateChart.Transition.Rate.class);
        }

        public tafat.StateChart.Transition.Rate rate(int index) {
            return rateSet().get(index);
        }

        public magritte.Set<tafat.StateChart.Transition.Message> messageSet() {
            return _components(tafat.StateChart.Transition.Message.class);
        }

        public tafat.StateChart.Transition.Message message(int index) {
            return messageSet().get(index);
        }

        public static class Trigger extends magritte.wraps.Morph {
        }

        public static class Condition extends tafat.StateChart.Transition.Trigger {
            public boolean check() {
                return ((tafat.natives.Check) _get("check").asNative()).check();
            }

            public void check(magritte.NativeCode value) {
                _edit().let("check", value);
            }
        }

        public static class Timeout extends tafat.StateChart.Transition.Trigger {
            public int timeout() {
                return ((tafat.natives.Timeout) _get("timeout").asNative()).calculate();
            }

            public void timeout(magritte.NativeCode value) {
                _edit().let("timeout", value);
            }
        }

        public static class After extends tafat.StateChart.Transition.Trigger {
            public double time() {
                return _get("time").asDouble();
            }

            public void time(double time) {
                _edit().set("time", time);
            }

            public void time(magritte.Expression<Double> value) {
                _edit().let("time", value);
            }
        }

        public static class Rate extends tafat.StateChart.Transition.Trigger {
            public int times() {
                return _get("times").asInteger();
            }

            public Unit unit() {
                return _definition()._get("unit").asEnumerate(Unit.values());
            }

            public void times(java.lang.Integer value) {
                _edit().set("times", value);
            }

            public void times(magritte.Expression<java.lang.Integer> value) {
                _edit().let("times", value);
            }

            public void Unit(Unit value) {
                _edit().set("unit", magritte.primitives.Enumerate.ordinal(value));
            }

            public enum Unit {Second,
                Minute,
                Hour,
                Day,
                Month,
                Year;
            }
        }

        public static class Message extends tafat.StateChart.Transition.Trigger {
            public String message() {
                return _get("message").asString();
            }

            public void message(java.lang.String value) {
                _edit().set("message", value);
            }

            public void message(magritte.Expression<java.lang.String> value) {
                _edit().let("message", value);
            }
        }
    }
}
