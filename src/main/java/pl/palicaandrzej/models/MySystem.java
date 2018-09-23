package pl.palicaandrzej.models;

import javax.persistence.*;

@Entity
@Table(name = "systems")
public class MySystem extends BaseModel {

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "system_name")
    private SystemName systemName;

    @Column
    private String description;

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
}
