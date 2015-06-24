package siani.tara.dsl;

import siani.tara.semantic.model.Tara;
import java.util.Locale;
import siani.tara.semantic.model.Tag;
import static siani.tara.semantic.constraints.RuleFactory.*;

public class Monopoly extends Tara {
	public Monopoly() {
		in("").def(context("").allow(multiple("Player", Tag.MAIN, Tag.REQUIRED), single("Board", Tag.MAIN, Tag.SINGLE, Tag.REQUIRED), single("Dices", Tag.MAIN, Tag.SINGLE, Tag.REQUIRED), single("LuckyCards", Tag.MAIN, Tag.SINGLE, Tag.REQUIRED), single("CommunityCards", Tag.MAIN, Tag.SINGLE, Tag.REQUIRED), single("LuckyCards", Tag.MAIN, Tag.SINGLE, Tag.REQUIRED), single("CommunityCards", Tag.MAIN, Tag.SINGLE, Tag.REQUIRED), multiple("HeatMap"), multiple("Simulation"), name()));
		in("Board").def(context("Entity", "Concept").allow(multiple("Init"), multiple("Terrain"), multiple("Community"), multiple("Taxes"), multiple("Station"), multiple("Luck"), multiple("Jail"), multiple("Company"), multiple("FreeParking"), multiple("GoToJail"), parameter("squareAt", "native", false, 0, "SquareAt#public Square squareAt(int position)"), parameter("squareOf", "native", false, 1, "SquareOf#public Square squareOf(Class<? extends Square> aClass)"), parameter("positionOf", "native", false, 2, "Position#public int position(Square square)"), name()).assume(isMain()));
		in("Dices").def(context("Entity", "Concept").allow(parameter("value1", "integer", false, 0, ""), parameter("value2", "integer", false, 1, ""), parameter("roll", "native", false, 2, "Roll#public void roll()"), parameter("doubles", "native", false, 3, "Doubles#public boolean check()"), parameter("v", "native", false, 4, "Value#public int value()"), name()).assume(isMain()));
		in("LuckyCards").def(context("Entity", "Concept").allow(multiple("Card"), parameter("get", "native", false, 0, "Get#public Card get()"), name()).assume(isMain()));
		in("CommunityCards").def(context("Entity", "Concept").allow(multiple("Card"), parameter("get", "native", false, 0, "Get#public Card get()"), name()).assume(isMain()));
		in("Card").def(context("Entity", "Concept").allow(parameter("moveTo", "integer", false, 0, "", "FINAL"), parameter("transport", "native", false, 1, "Movement#public boolean involvesMovement()"), name()));
		in("Init").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Terrain").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Community").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Taxes").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Station").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Luck").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Jail").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Company").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("FreeParking").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("GoToJail").def(context("Entity", "Concept").allow(parameter("count", "integer", false, 0, ""), parameter("increment", "native", false, 1, "Count#public void increment()"), name()));
		in("Player").def(context("Entity", "Concept").allow(parameter("square", new String[]{"Init", "Terrain", "Community", "Taxes", "Station", "Luck", "Jail", "Company", "FreeParking", "GoToJail"}, false, 1, ""), name(), facet("Mover").allow(parameter("turnsToBeInJail", "integer", false, 0, ""), parameter("numberOfRolls", "integer", false, 1, "")), facet("JailScape").allow(parameter("modes:word", new String[]{"Card", "Money"}, true, 0, ""))).require(_parameter("id", "string", false, 0, "")).assume(isMain()));
		in("JailScape").def(context("Behavior", "Concept").allow(multiple("Task"), multiple("Behavior.Knol"), multiple("StateChart"), multiple("EquationSystem"), parameter("modes:word", new String[]{"Card", "Money"}, true, 0, "")).require(_parameter("step", "integer", false, 0, "", "TERMINAL_INSTANCE"), _name()).assume(isFacetInstance()));
		in("Mover").def(context("Behavior", "Concept").allow(multiple("Task"), multiple("Behavior.Knol"), multiple("StateChart"), multiple("EquationSystem")).require(_parameter("step", "integer", false, 0, "", "TERMINAL_INSTANCE"), _name()).assume(isFacetInstance()));
		in("HeatMap.Region").def(context("Concept").allow(name(), parameter("square", "integer", true, 0, "##Tafat"), parameter("entity", new String[]{"Board", "Board.Square", "Dices", "Cards", "Cards.Card", "LuckyCards", "LuckyCards.Card", "CommunityCards", "CommunityCards.Card", "Card", "Square", "Init", "Terrain", "Community", "Taxes", "Station", "Luck", "Jail", "Company", "FreeParking", "GoToJail", "Player"}, false, 1, ""), parameter("calculation", "native", false, 2, "Function#public double calculate()#Tafat")).require(_parameter("square", "integer", true, 0, "##Tafat"), _parameter("entity", new String[]{"Entity"}, false, 1, ""), _parameter("calculation", "native", false, 2, "Function#public double calculate()#Tafat")).assume(isTerminalInstance()));
		in("Task").def(context("Concept").allow(multiple("Task"), multiple("StartJob"), multiple("RecurrentJob"), multiple("EndJob"), single("Task.End"), single("Task.Duration"), single("Task.End"), single("Task.Duration"), parameter("days:word", new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}, true, 0, ""), name(), single("Task.Start")).require(_single("Task.Start")).assume(isFeatureInstance(), isTerminalInstance()));
		in("StateChart.State").def(context("Concept").allow(multiple("StateChart.State.EntryAction"), multiple("StateChart.State.ExitAction"), multiple("StateChart.State.EntryAction"), multiple("StateChart.State.ExitAction"), multiple("StateChart.State"), multiple("StateChart.Transition"), name()).assume(isTerminalInstance()));
		in("HeatMap").def(context("Concept").allow(multiple("HeatMap.Region"), name(), parameter("exportPath", "string", false, 0, "##Tafat")).require(_parameter("exportPath", "string", false, 0, "##Tafat")).assume(isMain(), isTerminalInstance()));
		in("StateChart.State.EntryAction").def(context("Concept").allow(name(), parameter("action", "native", false, 0, "Action#public void execute()#Tafat")).require(_parameter("action", "native", false, 0, "Action#public void execute()#Tafat")).assume(isTerminalInstance()));
		in("StateChart.Transition.Rate").def(context("Concept").allow(name(), parameter("times", "integer", false, 0, "time##Tafat"), parameter("unit:word", new String[]{"Second", "Minute", "Hour", "Day", "Month", "Year"}, false, 1, "")).require(_parameter("times", "integer", false, 0, "time##Tafat"), _parameter("unit:word", new String[]{"Second", "Minute", "Hour", "Day", "Month", "Year"}, false, 1, "")).assume(isTerminalInstance()));
		in("Behavior.Knol").def(context("Concept").allow(name()).assume(isFeatureInstance(), isTerminalInstance()));
		in("Task.Start").def(context("Concept").allow(parameter("deviation", "measure", false, 1, "Time##Tafat"), name(), parameter("time", "date", false, 0, "##Tafat")).require(_parameter("time", "date", false, 0, "##Tafat")).assume(isTerminalInstance()));
		in("StateChart.Transition.After").def(context("Concept").allow(name(), parameter("time", "measure", false, 0, "Time##Tafat")).require(_parameter("time", "measure", false, 0, "Time##Tafat")).assume(isTerminalInstance()));
		in("Task.End").def(context("Concept").allow(parameter("deviation", "measure", false, 1, "Time##Tafat"), name(), parameter("time", "date", false, 0, "##Tafat")).require(_parameter("time", "date", false, 0, "##Tafat")).assume(isTerminalInstance()));
		in("StateChart.State.ExitAction").def(context("Concept").allow(name(), parameter("action", "native", false, 0, "Action#public void execute()#Tafat")).require(_parameter("action", "native", false, 0, "Action#public void execute()#Tafat")).assume(isTerminalInstance()));
		in("StateChart.Transition.Condition").def(context("Concept").allow(name(), parameter("check", "native", false, 0, "Check#public boolean check()#Tafat")).require(_parameter("check", "native", false, 0, "Check#public boolean check()#Tafat")).assume(isTerminalInstance()));
		in("StateChart.Transition.Message").def(context("Concept").allow(name(), parameter("message", "string", false, 0, "##Tafat")).require(_parameter("message", "string", false, 0, "##Tafat")).assume(isTerminalInstance()));
		in("EquationSystem.Stock").def(context("Concept").allow(name(), parameter("function", "native", false, 0, "Function#public double calculate()#Tafat")).require(_parameter("function", "native", false, 0, "Function#public double calculate()#Tafat")).assume(isTerminalInstance()));
		in("EquationSystem.Flow").def(context("Concept").allow(name(), parameter("function", "native", false, 0, "Function#public double calculate()#Tafat")).require(_parameter("function", "native", false, 0, "Function#public double calculate()#Tafat")).assume(isTerminalInstance()));
		in("StateChart").def(context("Concept").allow(multiple("StateChart.State"), multiple("StateChart.Transition"), name()).assume(isFeatureInstance(), isTerminalInstance()));
		in("EquationSystem").def(context("Concept").allow(multiple("EquationSystem.Stock"), multiple("EquationSystem.Flow"), multiple("EquationSystem.Stock"), multiple("EquationSystem.Flow"), parameter("solver:word", new String[]{"Euler"}, false, 0, ""), parameter("step", "double", false, 1, "##Tafat"), name()).assume(isFeatureInstance(), isTerminalInstance()));
		in("StateChart.Transition").def(context("Concept").allow(parameter("action", "native", false, 2, "Action#public void execute()#Tafat"), name(), parameter("from", new String[]{"StateChart.State"}, false, 0, ""), parameter("to", new String[]{"StateChart.State"}, false, 1, "")).require(_parameter("from", new String[]{"StateChart.State"}, false, 0, ""), _parameter("to", new String[]{"StateChart.State"}, false, 1, "")).assume(isTerminalInstance()));
		in("StateChart.Transition.Timeout").def(context("Concept").allow(name(), parameter("timeout", "native", false, 0, "Timeout#public int calculate()#Tafat")).require(_parameter("timeout", "native", false, 0, "Timeout#public int calculate()#Tafat")).assume(isTerminalInstance()));
		in("Simulation").def(context("Concept").allow(name(), parameter("from", "date", false, 0, "##Tafat"), parameter("to", "date", false, 1, "##Tafat")).require(_parameter("from", "date", false, 0, "##Tafat"), _parameter("to", "date", false, 1, "##Tafat")).assume(isTerminalInstance(), isMain()));
		in("Task.Duration").def(context("Concept").allow(parameter("deviation", "measure", false, 1, "Time##Tafat"), name(), parameter("time", "measure", false, 0, "Time##Tafat")).require(_parameter("time", "measure", false, 0, "Time##Tafat")).assume(isTerminalInstance()));
	}

	@Override
	public String languageName() {
		return "Monopoly";
	}

	@Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public boolean isTerminalLanguage() {
        return true;
    }
}
