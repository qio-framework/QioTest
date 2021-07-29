package qio.model;

import qio.annotate.Element;
import qio.annotate.Inject;

@Element
public class Thingabob {
    String name;

    @Inject
    Doodad doodad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doodad getDoodadUno() {
        return doodad;
    }

    public void setDoodadUno(Doodad doodad) {
        this.doodad = doodad;
    }
}
