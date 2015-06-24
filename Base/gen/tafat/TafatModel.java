package tafat;

public class TafatModel extends magritte.wraps.Model {

    public TafatModel(magritte.wraps.Morph morph) {
        super(morph);
    }

    public TafatModel(magritte.Graph graph) {
		super(graph);
	}

	public tafat.Simulation simulation() {
	    return _get("simulation", tafat.Simulation.class).get(0);
	}

	public magritte.Set<tafat.HeatMap> heatMaps() {
	    return _get("heatMaps", tafat.HeatMap.class);
	}

	public tafat.HeatMap heatMap(int index) {
	    return heatMaps().get(index);
	}
}