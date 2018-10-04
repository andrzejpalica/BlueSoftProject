package pl.palicaandrzej.models;

import javax.persistence.*;

@Entity
@Table(name = "systems")
public class MySystem extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "name_id")
    private SystemName systemName;

    @Column
    private String description;

    @Column
    private String technologies;

    @Column
    private String owner;

    public MySystem() {
    }

    public SystemName getSystemName() {
        return systemName;
    }

    public void setSystemName(SystemName systemName) {
        this.systemName = systemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
