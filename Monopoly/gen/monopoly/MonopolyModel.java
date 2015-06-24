package monopoly;

public class MonopolyModel extends magritte.wraps.Model {

    public MonopolyModel(magritte.wraps.Morph morph) {
        super(morph);
    }

    public MonopolyModel(magritte.Graph graph) {
		super(graph);
	}

	public monopoly.Board board() {
	    return _get("board", monopoly.Board.class).get(0);
	}

	public monopoly.Dices dices() {
	    return _get("dices", monopoly.Dices.class).get(0);
	}

	public monopoly.LuckyCards luckyCards() {
	    return _get("luckyCards", monopoly.LuckyCards.class).get(0);
	}

	public monopoly.CommunityCards communityCards() {
	    return _get("communityCards", monopoly.CommunityCards.class).get(0);
	}

	public magritte.Set<monopoly.Player> players() {
	    return _get("players", monopoly.Player.class);
	}

	public monopoly.Player player(int index) {
	    return players().get(index);
	}
}