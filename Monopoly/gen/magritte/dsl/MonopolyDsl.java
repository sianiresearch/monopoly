package magritte.dsl;

public class MonopolyDsl extends magritte.schema.Box.Dsl {
    public static final magritte.schema.Box box = new MonopolyDsl();

    protected magritte.schema.Box[] includes() {
        return new magritte.schema.Box[]{
            magritte.ontology.MonopolyMain.box
        };
    }
}