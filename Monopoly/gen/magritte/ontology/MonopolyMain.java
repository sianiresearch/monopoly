package magritte.ontology;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

import static magritte.Tag.*;
import magritte.primitives.Date;
import tafat.*;
import monopoly.*;



public class MonopolyMain extends magritte.schema.Box.Ontology {
	public static final magritte.schema.Box box = new MonopolyMain();

	@Override
	public magritte.schema.Box[] dependencies() {
		return new magritte.schema.Box[]{magritte.dsl.TafatDsl.box};
	}

	@Override
	public void write() {
		def("Board").type("Entity").set(Root).holds("Square").let("*squareAt", new squareAt_ploczet()).let("*squareOf", new squareOf_gurbracdres()).let("*positionOf", new positionOf_ruller());
		def("Dices").type("Entity").set(Root).set("*value1", (0)).set("*value2", (0)).let("*roll", new roll_glilmasdrus()).let("*doubles", new doubles_lillos()).let("*v", new v_relvosrur());
		def("Cards").type("Entity").set(Abstract, Root).holds("Card").let("*get", new get_lizet());
		def("LuckyCards").type("Entity").set(Root).parent("Cards").holds("Card");
		def("CommunityCards").type("Entity").set(Root).parent("Cards").holds("Card");
		def("Card").type("Entity").set("*moveTo", (-1000)).let("*transport", new transport_frenves());
		def("Square").type("Entity").set(Abstract).set("*count", (0)).let("*increment", new increment_silurlan());
		def("Init").type("Entity").parent("Square");
		def("Terrain").type("Entity").parent("Square");
		def("Community").type("Entity").parent("Square");
		def("Taxes").type("Entity").parent("Square");
		def("Station").type("Entity").parent("Square");
		def("Luck").type("Entity").parent("Square");
		def("Jail").type("Entity").parent("Square");
		def("Company").type("Entity").parent("Square");
		def("FreeParking").type("Entity").parent("Square");
		def("GoToJail").type("Entity").parent("Square");
		def("Player").type("Entity").set(Root);
		def("JailScape").type("Behavior").set(Facet, Abstract).set("*modes", multiple("Card", "Money"));
		def("JailScape+Player").type("Behavior").parent("JailScape");
		def("Mover").type("Behavior").set(Facet, Abstract);
		def("Mover+Player").type("Behavior").parent("Mover").has($(21)).has($(22)).has("Mover+Player.Rule").has("Mover+Player.PlayerIsJailed").has("Mover+Player.JailAfterThreeDoubles").has("Mover+Player.Advance").has("Mover+Player.ToJailWhenInGoToJailSquare").has("Mover+Player.CheckCard").has("Mover+Player.Doubles").set("turnsToBeInJail", (0)).set("numberOfRolls", (0));
		def(21).type("Behavior.Start").set(Case).let("start", new start_psiner());
		def(22).type("Action").set(Case).let("action", new action_mecni());
		def("Mover+Player.Rule").type("Behavior.Knol").set(Abstract, Prototype);
		def("Mover+Player.PlayerIsJailed").type("Behavior.Knol").set(Prototype).parent("Mover+Player.Rule").let("check", new check_drussatjet());
		def("Mover+Player.JailAfterThreeDoubles").type("Behavior.Knol").set(Prototype).parent("Mover+Player.Rule").let("check", new check_plolfrumus());
		def("Mover+Player.Advance").type("Behavior.Knol").set(Prototype).parent("Mover+Player.Rule").let("check", new check_psilapsimin());
		def("Mover+Player.ToJailWhenInGoToJailSquare").type("Behavior.Knol").set(Prototype).parent("Mover+Player.Rule").let("check", new check_brutredras());
		def("Mover+Player.CheckCard").type("Behavior.Knol").set(Prototype).parent("Mover+Player.Rule").let("check", new check_nunpse());
		def("Mover+Player.Doubles").type("Behavior.Knol").set(Prototype).parent("Mover+Player.Rule").let("check", new check_natoc());
	}

	private Date asDate(String date){
		try {
			return Date.date(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(date).getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	public static class squareAt_ploczet extends monopoly.Board implements monopoly.natives.SquareAt {
		@Override
		public Square squareAt(int position) {
			return square(position < 0 ? position + 40 : position % 40);
		}
	}

	public static class squareOf_gurbracdres extends monopoly.Board implements monopoly.natives.SquareOf {
		@Override
		public Square squareOf(Class<? extends Square> aClass) {
			return squareSet().asList().stream().filter(s -> s.is(aClass)).findFirst().get();
		}
	}

	public static class positionOf_ruller extends monopoly.Board implements monopoly.natives.Position {
		@Override
		public int position(Square square) {
			return squareSet().asList().indexOf(square);
		}
	}

	public static class roll_glilmasdrus extends monopoly.Dices implements monopoly.natives.Roll {
		@Override
		public void roll() {
			value1(new Random().nextInt(6) + 1);
				value2(new Random().nextInt(6) + 1);
		}
	}

	public static class doubles_lillos extends monopoly.Dices implements monopoly.natives.Doubles {
		@Override
		public boolean check() {
			return value1() == value2();
		}
	}

	public static class v_relvosrur extends monopoly.Dices implements monopoly.natives.Value {
		@Override
		public int value() {
			return value1() + value2();
		}
	}

	public static class get_lizet extends monopoly.Cards implements monopoly.natives.Get {
		@Override
		public Card get() {
			return card(new Random().nextInt(cardSet().size()));
		}
	}

	public static class transport_frenves extends monopoly.Card implements monopoly.natives.Movement {
		@Override
		public boolean involvesMovement() {
			return moveTo() != -1000;
		}
	}

	public static class increment_silurlan extends monopoly.Square implements monopoly.natives.Count {
		@Override
		public void increment() {
			count(count() + 1);
		}
	}

	public static class start_psiner extends monopoly.mover.Mover_Player implements tafat.natives.Action {
		@Override
		public void execute() {
			as(Player.class).square(new MonopolyModel(this).board().squareAt(0));
		}
	}

	public static class action_mecni extends monopoly.mover.Mover_Player implements tafat.natives.Action {
		@Override
		public void execute() {
			numberOfRolls(0);
						turnsToBeInJail(turnsToBeInJail() - 1);
						do {
							new MonopolyModel(this).dices().roll();
							numberOfRolls(numberOfRolls() + 1);
							for (Rule rule : ruleSet())
								if (!rule.check()) return;
						} while (true);
		}
	}

	public static class check_drussatjet extends monopoly.mover.Mover_Player implements monopoly.natives.Check {
		@Override
		public boolean check() {
			if(turnsToBeInJail() > 0)
								if(new MonopolyModel(this).dices().doubles()) turnsToBeInJail(0);
								else return false;
							return true;
		}
	}

	public static class check_plolfrumus extends monopoly.mover.Mover_Player implements monopoly.natives.Check {
		@Override
		public boolean check() {
			if (numberOfRolls() == 3 && new MonopolyModel(this).dices().doubles()) {
								turnsToBeInJail(3);
								as(Player.class).square(new MonopolyModel(this).board().squareOf(Jail.class));
								as(Player.class).square().increment();
								return false;
							}
							return true;
		}
	}

	public static class check_psilapsimin extends monopoly.mover.Mover_Player implements monopoly.natives.Check {
		@Override
		public boolean check() {
			MonopolyModel monopoly = new MonopolyModel(this);
							as(Player.class).square(monopoly.board().squareAt(monopoly.board().positionOf(as(Player.class).square()) + monopoly.dices().v()));
							as(Player.class).square().increment();
							return true;
		}
	}

	public static class check_brutredras extends monopoly.mover.Mover_Player implements monopoly.natives.Check {
		@Override
		public boolean check() {
			if (as(Player.class).square().is(GoToJail.class)) {
								turnsToBeInJail(3);
								as(Player.class).square(new MonopolyModel(this).board().squareOf(Jail.class));
								as(Player.class).square().increment();
								return false;
							}
							return true;
		}
	}

	public static class check_nunpse extends monopoly.mover.Mover_Player implements monopoly.natives.Check {
		@Override
		public boolean check() {
			Card card = null;
							MonopolyModel monopoly = new MonopolyModel(this);
							if (as(Player.class).square().is(Luck.class))
								card = monopoly.luckyCards().get();
							if (as(Player.class).square().is(Community.class))
								card = monopoly.communityCards().get();

							if (card == null || !card.transport()) return true;

							if (monopoly.board().squareAt(card.moveTo()).is(Jail.class)) {
								turnsToBeInJail(3);
								as(Player.class).square(monopoly.board().squareOf(Jail.class));
								as(Player.class).square().increment();
								return false;
							}

							if (card.moveTo() >= 0) {
								as(Player.class).square(monopoly.board().squareAt(card.moveTo()));
								as(Player.class).square().increment();
								return true;
							}

							if (card.moveTo() == -3) {
								as(Player.class).square(monopoly.board().squareAt(monopoly.board().positionOf(as(Player.class).square()) + card.moveTo()));
								as(Player.class).square().increment();
								if (as(Player.class).square().is(GoToJail.class)) {
									turnsToBeInJail(3);
									as(Player.class).square(monopoly.board().squareOf(Jail.class));
									as(Player.class).square().increment();
									return false;
								}
								return true;
							}

							return true;
		}
	}

	public static class check_natoc extends monopoly.mover.Mover_Player implements monopoly.natives.Check {
		@Override
		public boolean check() {
			return new MonopolyModel(this).dices().doubles();
		}
	}
}