package magritte.ontology;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;

import static magritte.Tag.*;
import magritte.primitives.Date;
import monopoly.*;




public class PlayGameMain extends magritte.schema.Box.Scene {
	public static final magritte.schema.Box box = new PlayGameMain();

	@Override
	public magritte.schema.Box[] dependencies() {
		return new magritte.schema.Box[]{magritte.dsl.MonopolyDsl.box};
	}

	@Override
	public void write() {
		def(1).type("Simulation").set(Root).set("from", (asDate("01/01/2015 00:00:00"))).set("to", (asDate("02/01/2015 00:00:00")));
		def(2).type("Dices").set(Root);
		def("board").type("Board").set(Root).has("board.s0").has("board.s1").has("board.s2").has("board.s3").has("board.s4").has("board.s5").has("board.s6").has("board.s7").has("board.s8").has("board.s9").has("board.s10").has("board.s11").has("board.s12").has("board.s13").has("board.s14").has("board.s15").has("board.s16").has("board.s17").has("board.s18").has("board.s19").has("board.s20").has("board.s21").has("board.s22").has("board.s23").has("board.s24").has("board.s25").has("board.s26").has("board.s27").has("board.s28").has("board.s29").has("board.s30").has("board.s31").has("board.s32").has("board.s33").has("board.s34").has("board.s35").has("board.s36").has("board.s37").has("board.s38").has("board.s39");
		def("board.s0").type("Init");
		def("board.s1").type("Terrain");
		def("board.s2").type("Community");
		def("board.s3").type("Terrain");
		def("board.s4").type("Taxes");
		def("board.s5").type("Station");
		def("board.s6").type("Terrain");
		def("board.s7").type("Luck");
		def("board.s8").type("Terrain");
		def("board.s9").type("Terrain");
		def("board.s10").type("Jail");
		def("board.s11").type("Terrain");
		def("board.s12").type("Company");
		def("board.s13").type("Terrain");
		def("board.s14").type("Terrain");
		def("board.s15").type("Station");
		def("board.s16").type("Terrain");
		def("board.s17").type("Community");
		def("board.s18").type("Terrain");
		def("board.s19").type("Terrain");
		def("board.s20").type("FreeParking");
		def("board.s21").type("Terrain");
		def("board.s22").type("Luck");
		def("board.s23").type("Terrain");
		def("board.s24").type("Terrain");
		def("board.s25").type("Station");
		def("board.s26").type("Terrain");
		def("board.s27").type("Terrain");
		def("board.s28").type("Company");
		def("board.s29").type("Terrain");
		def("board.s30").type("GoToJail");
		def("board.s31").type("Terrain");
		def("board.s32").type("Terrain");
		def("board.s33").type("Community");
		def("board.s34").type("Terrain");
		def("board.s35").type("Station");
		def("board.s36").type("Luck");
		def("board.s37").type("Terrain");
		def("board.s38").type("Taxes");
		def("board.s39").type("Terrain");
		def(44).type("LuckyCards").set(Root).has($(45)).has($(46)).has($(47)).has($(48)).has($(49)).has($(50)).has($(51)).has($(52)).has($(53)).has($(54)).has($(55)).has($(56)).has($(57)).has($(58)).has($(59)).has($(60));
		def(45).type("Card");
		def(46).type("Card");
		def(47).type("Card").set("moveTo", (24));
		def(48).type("Card").set("moveTo", (0));
		def(49).type("Card");
		def(50).type("Card").set("moveTo", (39));
		def(51).type("Card");
		def(52).type("Card");
		def(53).type("Card");
		def(54).type("Card").set("moveTo", (11));
		def(55).type("Card").set("moveTo", (15));
		def(56).type("Card");
		def(57).type("Card").set("moveTo", (10));
		def(58).type("Card").set("moveTo", (-3));
		def(59).type("Card");
		def(60).type("Card");
		def(61).type("CommunityCards").set(Root).has($(62)).has($(63)).has($(64)).has($(65)).has($(66)).has($(67)).has($(68)).has($(69)).has($(70)).has($(71)).has($(72)).has($(73)).has($(74)).has($(75)).has($(76)).has($(77));
		def(62).type("Card");
		def(63).type("Card");
		def(64).type("Card");
		def(65).type("Card");
		def(66).type("Card");
		def(67).type("Card");
		def(68).type("Card");
		def(69).type("Card");
		def(70).type("Card").set("moveTo", (0));
		def(71).type("Card").set("moveTo", (1));
		def(72).type("Card");
		def(73).type("Card");
		def(74).type("Card");
		def(75).type("Card");
		def(76).type("Card").set("moveTo", (10));
		def(77).type("Card");
		def("p1").type("Mover+Player").set(Root).set("id", ("p1"));
		def(79).type("Mover+Player").set(Root).set("id", ("p2"));
		def(80).type("Mover+Player").set(Root).set("id", ("p3"));
		def(81).type("Mover+Player").set(Root).set("id", ("p4"));
		def(82).type("HeatMap").set(Root).has("HeatMap.r0").has("HeatMap.r1").has("HeatMap.r2").has("HeatMap.r3").has("HeatMap.r4").has("HeatMap.r5").has("HeatMap.r6").has("HeatMap.r7").has("HeatMap.r8").has("HeatMap.r9").has("HeatMap.r10").has("HeatMap.r11").has("HeatMap.r12").has("HeatMap.r13").has("HeatMap.r14").has("HeatMap.r15").has("HeatMap.r16").has("HeatMap.r17").has("HeatMap.r18").has("HeatMap.r19").has("HeatMap.r20").has("HeatMap.r21").has("HeatMap.r22").has("HeatMap.r23").has("HeatMap.r24").has("HeatMap.r25").has("HeatMap.r26").has("HeatMap.r27").has("HeatMap.r28").has("HeatMap.r29").has("HeatMap.r30").has("HeatMap.r31").has("HeatMap.r32").has("HeatMap.r33").has("HeatMap.r34").has("HeatMap.r35").has("HeatMap.r36").has("HeatMap.r37").has("HeatMap.r38").has("HeatMap.r39").set("exportPath", ("monopoly.png"));
		def("HeatMap.r0").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_jetlas());
		def("HeatMap.r1").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_psazajec());
		def("HeatMap.r2").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_yaskrer());
		def("HeatMap.r3").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_ratjar());
		def("HeatMap.r4").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_micporclec());
		def("HeatMap.r5").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_plaposor());
		def("HeatMap.r6").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_nundol());
		def("HeatMap.r7").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_palkrinbrucpsagan());
		def("HeatMap.r8").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_fralyic());
		def("HeatMap.r9").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_criczedris());
		def("HeatMap.r10").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_glisrat());
		def("HeatMap.r11").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_decnorde());
		def("HeatMap.r12").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_lardrasyel());
		def("HeatMap.r13").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_prarpsu());
		def("HeatMap.r14").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_norpsi());
		def("HeatMap.r15").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_lincruc());
		def("HeatMap.r16").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_yulnun());
		def("HeatMap.r17").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_ditglal());
		def("HeatMap.r18").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_gronjentesmol());
		def("HeatMap.r19").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_valca());
		def("HeatMap.r20").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_prascruc());
		def("HeatMap.r21").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_yunmolbruc());
		def("HeatMap.r22").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_brecflaspsebas());
		def("HeatMap.r23").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_yocbocral());
		def("HeatMap.r24").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_narlal());
		def("HeatMap.r25").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_velirlut());
		def("HeatMap.r26").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_denmilbrin());
		def("HeatMap.r27").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_flucdelnu());
		def("HeatMap.r28").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_plinsi());
		def("HeatMap.r29").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_droslocpus());
		def("HeatMap.r30").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_drasriglucdi());
		def("HeatMap.r31").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_nucdarnis());
		def("HeatMap.r32").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_tunrun());
		def("HeatMap.r33").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_trevolkrispse());
		def("HeatMap.r34").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_psijelmas());
		def("HeatMap.r35").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_nitblasyit());
		def("HeatMap.r36").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_vipsu());
		def("HeatMap.r37").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_psoves());
		def("HeatMap.r38").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_printlarsac());
		def("HeatMap.r39").type("HeatMap.Region").set("square", multiple(0, 0, 0, 0)).set("entity", (ref(""))).let("calculation", new calculation_jiyan());
	}

	private Date asDate(String date){
		try {
			return Date.date(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(date).getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	public static class calculation_jetlas extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_psazajec extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_yaskrer extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_ratjar extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_micporclec extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_plaposor extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_nundol extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_palkrinbrucpsagan extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_fralyic extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_criczedris extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_glisrat extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_decnorde extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_lardrasyel extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_prarpsu extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_norpsi extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_lincruc extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_yulnun extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_ditglal extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_gronjentesmol extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_valca extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_prascruc extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_yunmolbruc extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_brecflaspsebas extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_yocbocral extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_narlal extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_velirlut extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_denmilbrin extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_flucdelnu extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_plinsi extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_droslocpus extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_drasriglucdi extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_nucdarnis extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_tunrun extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_trevolkrispse extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_psijelmas extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_nitblasyit extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_vipsu extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_psoves extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_printlarsac extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}

	public static class calculation_jiyan extends tafat.HeatMap.Region implements tafat.natives.Function {
		@Override
		public double calculate() {
			return entity().as(Square.class).count();
		}
	}
}