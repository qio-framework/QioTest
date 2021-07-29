package qio.model;

import qio.annotate.Element;
import qio.annotate.Inject;

@Element
public class Thingamabob {
    String name;

    @Inject
    Doodad doodad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doodad getDoodad() {
        return doodad;
    }

    public void setDoodad(Doodad doodad) {
        this.doodad = doodad;
    }
}
