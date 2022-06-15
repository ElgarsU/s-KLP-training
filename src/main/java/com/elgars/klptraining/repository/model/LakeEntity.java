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
@Table
public class LakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer depth;
//    private List<Fish> fishes;

    public LakeEntity() {}

    private LakeEntity(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.depth = b.depth;
//        this.fishes = b.fishes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDepth() {
        return depth;
    }

//    public List<Fish> getFishes() {
//        return fishes;
//    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder copyBuilder() {
        return builder()
                .id(getId())
                .name(getName())
                .depth(getDepth());
//                .fishes(getFishes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LakeEntity)) return false;
        LakeEntity lakeEntity = (LakeEntity) o;
        return id.equals(lakeEntity.id) && name.equals(lakeEntity.name) && depth.equals(lakeEntity.depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, depth);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LakeEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("depth=" + depth)
                .toString();
    }

    public static class Builder {

        private Long id;

        private String name;
        private Integer depth;
//        private List<Fish> fishes;

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
        public Builder depth(final Integer depth) {
            this.depth = depth;
            return this;
        }

//        public Builder fishes(final List<Fish> fishes) {
//            this.fishes = fishes;
//            return this;
//        }

        public LakeEntity build() {
            return new LakeEntity(this);
        }

    }
}
