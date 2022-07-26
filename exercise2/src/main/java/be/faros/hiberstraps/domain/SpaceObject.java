package be.faros.hiberstraps.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SpaceObject extends BaseEntity {
    private String name;
    private Long orbitalPeriod;
    private Double eccentricity;

    @ManyToOne
    @JoinColumn(columnDefinition = "UUID")
    private SpaceObject centralBody;

    @OneToMany(mappedBy = "centralBody")
    private List<SpaceObject> satellites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Long orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public SpaceObject getCentralBody() {
        return centralBody;
    }

    public void setCentralBody(SpaceObject centralBody) {
        this.centralBody = centralBody;
    }

    public List<SpaceObject> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SpaceObject> spaceObjects) {
        this.satellites = spaceObjects;
    }
}
