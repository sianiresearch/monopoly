package siani.tara.dsls;

import siani.tara.semantic.model.Tara;
import java.util.Locale;
import siani.tara.semantic.model.Tag;
import static siani.tara.semantic.constraints.RuleFactory.*;

public class Tafat extends Tara {
	public Tafat() {
		in("").def(context("").allow(multiple("Agent"), multiple("Entity"), multiple("Behavior", Tag.FACET, Tag.ABSTRACT), multiple("Behavior", Tag.FACET), multiple("Action", Tag.FEATURE_INSTANCE), multiple("EquationSystem", Tag.FEATURE_INSTANCE, Tag.TERMINAL), multiple("StateChart", Tag.FEATURE_INSTANCE, Tag.TERMINAL), multiple("Task", Tag.FEATURE_INSTANCE, Tag.TERMINAL), multiple("StartJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("RecurrentJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("EndJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("StartJob", Tag.FEATURE_INSTANCE), multiple("RecurrentJob", Tag.FEATURE_INSTANCE), multiple("EndJob", Tag.FEATURE_INSTANCE), multiple("Job", Tag.FEATURE_INSTANCE), multiple("TableFunction", Tag.FEATURE_INSTANCE), multiple("PointSet", Tag.FEATURE_INSTANCE), multiple("Map", Tag.FEATURE_INSTANCE), multiple("HeatMap", Tag.MAIN, Tag.TERMINAL, Tag.ABSTRACT), multiple("HeatMap", Tag.MAIN, Tag.TERMINAL), single("Simulation", Tag.REQUIRED, Tag.SINGLE, Tag.TERMINAL, Tag.MAIN), name()));
		in("Simulation").def(context("Concept").allow(parameter("from", "date", false, 0, "", "TERMINAL"), parameter("to", "date", false, 1, "", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("Agent").def(context("Concept").allow(name()));
		in("Entity").def(context("Concept").allow(multiple("Entity"), multiple("Entity.Feature", Tag.FEATURE), name()));
		in("Entity.Feature").def(context("Concept").allow(name()).assume(isFeature()));
		in("Behavior").def(context("Concept").allow(multiple("Behavior.Start", Tag.FEATURE_INSTANCE), multiple("Behavior.Knol", Tag.FEATURE_INSTANCE, Tag.TERMINAL, Tag.FINAL), multiple("Action", Tag.FEATURE_INSTANCE, Tag.FINAL), multiple("EquationSystem", Tag.FEATURE_INSTANCE, Tag.TERMINAL, Tag.FINAL), multiple("StateChart", Tag.FEATURE_INSTANCE, Tag.TERMINAL, Tag.FINAL), multiple("Task", Tag.FEATURE_INSTANCE, Tag.TERMINAL, Tag.FINAL), multiple("TableFunction", Tag.FEATURE_INSTANCE, Tag.FINAL), multiple("PointSet", Tag.FEATURE_INSTANCE, Tag.FINAL), multiple("Job", Tag.FEATURE_INSTANCE, Tag.FINAL), multiple("Map", Tag.FEATURE_INSTANCE, Tag.FINAL), parameter("step", "integer", false, 0, "", "TERMINAL"), parameter("init", "native", false, 1, "Action#public void execute()"), name()).assume(isFacet()));
		in("Behavior.Start").def(context("Concept").allow(name()).require(_parameter("start", "native", false, 0, "Action#public void execute()")).assume(isFeatureInstance()));
		in("Behavior.Knol").def(context("Concept").allow(name()).assume(isFeatureInstance(), isTerminalInstance()));
		in("Action").def(context("Concept").allow(parameter("condition", "native", false, 0, "Check#public boolean check()"), name()).require(_parameter("action", "native", false, 1, "Action#public void execute()")).assume(isFeatureInstance()));
		in("EquationSystem").def(context("Concept").allow(multiple("EquationSystem.Stock", Tag.ABSTRACT, Tag.TERMINAL), multiple("EquationSystem.Flow", Tag.ABSTRACT, Tag.TERMINAL), multiple("EquationSystem.Stock", Tag.TERMINAL), multiple("EquationSystem.Flow", Tag.TERMINAL), parameter("solver:word", new String[]{"Euler"}, false, 0, "", "TERMINAL"), parameter("step", "double", false, 1, "", "TERMINAL"), name()).assume(isFeatureInstance(), isTerminalInstance()));
		in("EquationSystem.Stock").def(context("Concept").allow(parameter("function", "native", false, 0, "Function#public double calculate()", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("EquationSystem.Flow").def(context("Concept").allow(parameter("function", "native", false, 0, "Function#public double calculate()", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart").def(context("Concept").allow(multiple("StateChart.State", Tag.TERMINAL), multiple("StateChart.Transition", Tag.TERMINAL), name()).assume(isFeatureInstance(), isTerminalInstance()));
		in("StateChart.State").def(context("Concept").allow(multiple("StateChart.State.EntryAction", Tag.ABSTRACT, Tag.TERMINAL), multiple("StateChart.State.ExitAction", Tag.ABSTRACT, Tag.TERMINAL), multiple("StateChart.State.EntryAction", Tag.TERMINAL), multiple("StateChart.State.ExitAction", Tag.TERMINAL), multiple("StateChart.State", Tag.TERMINAL), multiple("StateChart.Transition", Tag.TERMINAL), name()).assume(isTerminalInstance()));
		in("StateChart.State.EntryAction").def(context("Concept").allow(parameter("action", "native", false, 0, "Action#public void execute()", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart.State.ExitAction").def(context("Concept").allow(parameter("action", "native", false, 0, "Action#public void execute()", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart.Transition").def(context("Concept").allow(parameter("from", new String[]{"StateChart.State"}, false, 0, "", "TERMINAL"), parameter("to", new String[]{"StateChart.State"}, false, 1, "", "TERMINAL"), parameter("action", "native", false, 2, "Action#public void execute()", "TERMINAL"), name()).require(oneOf(_multiple("StateChart.Transition.Condition"), _multiple("StateChart.Transition.Timeout"), _multiple("StateChart.Transition.After"), _multiple("StateChart.Transition.Rate"), _multiple("StateChart.Transition.Message")), _multiple("StateChart.Transition.Condition"), _multiple("StateChart.Transition.Timeout"), _multiple("StateChart.Transition.After"), _multiple("StateChart.Transition.Rate"), _multiple("StateChart.Transition.Message")).assume(isTerminalInstance()));
		in("StateChart.Transition.Condition").def(context("Concept").allow(parameter("check", "native", false, 0, "Check#public boolean check()", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart.Transition.Timeout").def(context("Concept").allow(parameter("timeout", "native", false, 0, "Timeout#public int calculate()", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart.Transition.After").def(context("Concept").allow(parameter("time", "measure", false, 0, "Time", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart.Transition.Rate").def(context("Concept").allow(parameter("times", "integer", false, 0, "time", "TERMINAL"), parameter("unit:word", new String[]{"Second", "Minute", "Hour", "Day", "Month", "Year"}, false, 1, "", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StateChart.Transition.Message").def(context("Concept").allow(parameter("message", "string", false, 0, "", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("Task").def(context("Concept").allow(multiple("Task", Tag.FEATURE_INSTANCE, Tag.TERMINAL), multiple("StartJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("RecurrentJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("EndJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), single("Task.End", Tag.SINGLE, Tag.ABSTRACT, Tag.TERMINAL), single("Task.Duration", Tag.SINGLE, Tag.ABSTRACT, Tag.TERMINAL), single("Task.End", Tag.SINGLE, Tag.TERMINAL), single("Task.Duration", Tag.SINGLE, Tag.TERMINAL), parameter("days:word", new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}, true, 0, "", "TERMINAL"), name()).require(_single("Task.Start")).assume(isFeatureInstance(), isTerminalInstance()));
		in("Task.Start").def(context("Concept").allow(parameter("time", "date", false, 0, "", "TERMINAL"), parameter("deviation", "measure", false, 1, "Time", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("Task.End").def(context("Concept").allow(parameter("time", "date", false, 0, "", "TERMINAL"), parameter("deviation", "measure", false, 1, "Time", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("Task.Duration").def(context("Concept").allow(parameter("time", "measure", false, 0, "Time", "TERMINAL"), parameter("deviation", "measure", false, 1, "Time", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("StartJob").def(context("Concept").allow(name()).require(_parameter("job", new String[]{"Job"}, false, 0, "")).assume(isFeatureInstance()));
		in("RecurrentJob").def(context("Concept").allow(name()).require(_parameter("job", new String[]{"Job"}, false, 0, "")).assume(isFeatureInstance()));
		in("EndJob").def(context("Concept").allow(name()).require(_parameter("job", new String[]{"Job"}, false, 0, "")).assume(isFeatureInstance()));
		in("Job").def(context("Concept").allow(multiple("Job", Tag.FEATURE_INSTANCE), multiple("StartJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("RecurrentJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("EndJob", Tag.FEATURE_INSTANCE, Tag.ABSTRACT), multiple("Job.StartAction", Tag.ABSTRACT), multiple("Job.RecurrentAction", Tag.ABSTRACT), multiple("Job.EndAction", Tag.ABSTRACT), multiple("Job.StartAction"), multiple("Job.RecurrentAction"), multiple("Job.EndAction"), single("Job.Start", Tag.SINGLE), single("Job.Duration", Tag.SINGLE), name()).assume(isFeatureInstance()));
		in("Job.Start").def(context("Concept").allow(parameter("deviation", "measure", false, 1, "Time"), name()).require(_parameter("time", "measure", false, 0, "Time")));
		in("Job.Duration").def(context("Concept").allow(parameter("deviation", "measure", false, 1, "Time"), name()).require(_parameter("time", "measure", false, 0, "Time")));
		in("Job.StartAction").def(context("Concept").allow(name()).require(_parameter("action", "native", false, 0, "Action#public void execute()")));
		in("Job.RecurrentAction").def(context("Concept").allow(name()).require(_parameter("action", "native", false, 0, "Action#public void execute()")));
		in("Job.EndAction").def(context("Concept").allow(name()).require(_parameter("action", "native", false, 0, "Action#public void execute()")));
		in("TableFunction").def(context("Concept").allow(single("TableFunction.NoneInterpolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.LinearInterpolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.PolynomialInterpolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.SplineInterpolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.StepInterpolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.NoneInterpolation", Tag.SINGLE), single("TableFunction.LinearInterpolation", Tag.SINGLE), single("TableFunction.PolynomialInterpolation", Tag.SINGLE), single("TableFunction.SplineInterpolation", Tag.SINGLE), single("TableFunction.StepInterpolation", Tag.SINGLE), single("TableFunction.NoneExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.CustomExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.NearestPointExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.RepeatSeriesExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.LinearExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.PolynomialExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.SplineExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.StepExtrapolation", Tag.SINGLE, Tag.ABSTRACT), single("TableFunction.NoneExtrapolation", Tag.SINGLE), single("TableFunction.CustomExtrapolation", Tag.SINGLE), single("TableFunction.NearestPointExtrapolation", Tag.SINGLE), single("TableFunction.RepeatSeriesExtrapolation", Tag.SINGLE), single("TableFunction.LinearExtrapolation", Tag.SINGLE), single("TableFunction.PolynomialExtrapolation", Tag.SINGLE), single("TableFunction.SplineExtrapolation", Tag.SINGLE), single("TableFunction.StepExtrapolation", Tag.SINGLE), name()).require(_parameter("pointSet", new String[]{"PointSet"}, false, 0, "")).assume(isFeatureInstance()));
		in("TableFunction.NoneInterpolation").def(context("Concept").allow(name()));
		in("TableFunction.LinearInterpolation").def(context("Concept").allow(name()));
		in("TableFunction.PolynomialInterpolation").def(context("Concept").allow(name()));
		in("TableFunction.SplineInterpolation").def(context("Concept").allow(name()));
		in("TableFunction.StepInterpolation").def(context("Concept").allow(name()));
		in("TableFunction.NoneExtrapolation").def(context("Concept").allow(name()));
		in("TableFunction.CustomExtrapolation").def(context("Concept").allow(name()).require(_parameter("function", "native", false, 0, "Function#public double calculate()")));
		in("TableFunction.NearestPointExtrapolation").def(context("Concept").allow(name()));
		in("TableFunction.RepeatSeriesExtrapolation").def(context("Concept").allow(name()));
		in("TableFunction.LinearExtrapolation").def(context("Concept").allow(name()));
		in("TableFunction.PolynomialExtrapolation").def(context("Concept").allow(name()));
		in("TableFunction.SplineExtrapolation").def(context("Concept").allow(name()));
		in("TableFunction.StepExtrapolation").def(context("Concept").allow(name()));
		in("PointSet").def(context("Concept").allow(multiple("PointSet.Point", Tag.FINAL, Tag.ABSTRACT), multiple("PointSet.X", Tag.FINAL, Tag.ABSTRACT), multiple("PointSet.Y", Tag.FINAL, Tag.ABSTRACT), multiple("PointSet.Point", Tag.FINAL), single("PointSet.X", Tag.SINGLE, Tag.FINAL), single("PointSet.Y", Tag.SINGLE, Tag.FINAL), name()).assume(isFeatureInstance()));
		in("PointSet.Point").def(context("Concept").allow(name()).require(_parameter("x", "double", false, 0, "", "FINAL"), _parameter("y", "double", false, 1, "", "FINAL")));
		in("PointSet.X").def(context("Concept").allow(name()).require(_parameter("values", "double", true, 0, "", "FINAL")));
		in("PointSet.Y").def(context("Concept").allow(name()).require(_parameter("values", "double", true, 0, "", "FINAL")));
		in("Map").def(context("Concept").allow(multiple("Map.Entry"), parameter("get", "native", false, 0, "Get#public double get(String key)", "FINAL"), name()).assume(isFeatureInstance()));
		in("Map.Entry").def(context("Concept").allow(name()).require(_parameter("key", "string", false, 0, ""), _parameter("value", "double", false, 1, "")));
		in("HeatMap").def(context("Concept").allow(multiple("HeatMap.Region", Tag.TERMINAL), parameter("exportPath", "string", false, 0, "", "TERMINAL"), name()).assume(isTerminalInstance()));
		in("HeatMap.Region").def(context("Concept").allow(parameter("square", "integer", true, 0, "", "TERMINAL"), parameter("entity", new String[]{"Entity"}, false, 1, "", "TERMINAL"), parameter("calculation", "native", false, 2, "Function#public double calculate()", "TERMINAL"), name()).require(redefine("entity", "Entity")).assume(isTerminalInstance()));
	}

	@Override
	public String languageName() {
		return "Tafat";
	}

	@Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public boolean isTerminalLanguage() {
        return false;
    }
}
