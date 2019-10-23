package com.lifetech.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.Objects;

public class PersistableElementDTO {

    @Nullable
    private Long id;

    @Nullable
    protected Timestamp optlock;

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getOptlock() {
        return optlock;
    }

    public void setOptlock(Timestamp optlock) {
        this.optlock = optlock;
    }

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        PersistableElementDTO entity = (PersistableElementDTO) that;
        if (id == null || entity.id == null) {
            return false;
        }
        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
