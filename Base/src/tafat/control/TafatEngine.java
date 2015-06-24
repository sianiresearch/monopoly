package tafat.control;

import magritte.Graph;
import magritte.Set;
import magritte.schema.Box;
import magritte.schema.MemoryGraph;
import tafat.Behavior;
import tafat.Simulation;
import tafat.TafatModel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static magritte.helpers.Selection.instancesOf;
import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;


public class TafatEngine {

    private final Set<Behavior> behaviors;
    private Graph graph = new MemoryGraph();
    private TafatModel tafat = new TafatModel(graph);
    private ScheduledExecutorService executor;

    public TafatEngine(Box box) {
        initServer();
        box.load(graph);
        behaviors = tafat._find(Behavior.class);
        behaviors.forEach(behavior -> behavior.startSet().forEach(start -> start.start()));
    }

    public void execute() {
//        long steps = steps();
//        for (int step = 0; step < steps; step++) run();
//        System.out.println(readHeatMap());
    }

    private void initServer() {
        port(8080);
        staticFileLocation("/public");
        get("/query/:name", (req, res) -> readHeatMap());
        get("/control/play", (req, res) -> play());
        get("/control/pause", (req, res) -> pause());
    }

    private String play() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate((Runnable) this::step, 0, 100, TimeUnit.MILLISECONDS);
        return "OK";
    }

    private String pause() {
        executor.shutdownNow();
        return "OK";
    }

    private void step() {
        run();
    }

    private void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        behaviors.forEach(this::run);
    }

    private void run(Behavior behavior) {
        behavior.actionSet().filter(action -> action.condition()).forEach(action -> action.action());
    }

    private String readHeatMap() {
        StringBuilder result = new StringBuilder();
//        tafat.heatMap(0).regionSet().forEach(r -> result.append(", ").append(r.calculation()));
        graph.find(instancesOf("Square")).forEach(r -> result.append(", ").append(r.get("count").toString()));
        return "heatmap = [" + result.substring(2) + "]";
    }

    private long steps() {
        Simulation simulation = tafat.simulation();
        return (simulation.to().timestamp() - simulation.from().timestamp()) / 1000;
    }
}
