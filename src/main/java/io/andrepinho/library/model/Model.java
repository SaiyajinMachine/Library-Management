package io.andrepinho.library.model;

import java.util.Date;

public interface Model {
    Integer getId();
    void setId(Integer id);
    Integer getVersion();
    void setVersion(Integer version);
    Date getUpdate_time();
    void setUpdate_time(Date update_time);
    Date getCreation_time();
    void setCreation_time(Date creation_time);
}
