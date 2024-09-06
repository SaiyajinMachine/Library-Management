package io.andrepinho.library.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
public abstract class AbstractModel implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @CreationTimestamp
    private Date creation_time;

    @UpdateTimestamp
    private Date update_time;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Date getCreation_time() {
        return creation_time;
    }

    @Override
    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    @Override
    public Date getUpdate_time() {
        return update_time;
    }

    @Override
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
