package be.faros.hiberstraps.domain;

import jakarta.persistence.*;

@Entity
public class Star extends SpaceObject {
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "UUID")
    private Galaxy galaxy;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public enum Type {
        RED_GIANT, YELLOW_GIANT, BLUE_GIANT, WHITE_DWARF, RED_DWARF, BROWN_DWARF
    }
}
