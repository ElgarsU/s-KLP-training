package com.elgars.klptraining.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "fish")
public class FishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean restricted;
//    private Lake lake;

    public FishEntity() {
    }

    private FishEntity(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.restricted = b.restricted;
//        this.lake = lake;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getRestricted() {
        return restricted;
    }

//    public Lake getLake() {
//        return lake;
//    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder copyBuilder() {
        return builder()
                .id(getId())
                .name(getName())
                .restricted(getRestricted());
//                .lake(getLake());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishEntity)) return false;
        FishEntity fish = (FishEntity) o;
        return id.equals(fish.id) && name.equals(fish.name) && restricted.equals(fish.restricted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, restricted);
    }

    @Override
    public String   toString() {
        return new StringJoiner(", ", FishEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("restricted=" + restricted)
                .toString();
    }

    public static class Builder {

        private Long id;
        private String name;
        private Boolean restricted;
//        private Lake lake;

        private Builder() {
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder restricted(final Boolean restricted) {
            this.restricted = restricted;
            return this;
        }

//        public Builder lake(final Lake lake) {
//            this.lake = lake;
//            return this;
//        }

        public FishEntity build() {
            return new FishEntity(this);
        }

    }
}
