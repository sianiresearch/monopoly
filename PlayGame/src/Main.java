import magritte.ontology.PlayGameMain;
import tafat.control.TafatEngine;

/**
 * Created by jevora on 17/06/2015.
 */
public class Main {

    public static void main(String[] args) {
        new TafatEngine(PlayGameMain.box).execute();
    }
}
