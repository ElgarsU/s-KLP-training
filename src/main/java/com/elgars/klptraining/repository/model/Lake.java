package com.elgars.klptraining.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table
public class Lake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer depth;
//    private List<Fish> fishes;

    public Lake() {}

    private Lake(Builder b) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lake)) return false;
        Lake lake = (Lake) o;
        return id.equals(lake.id) && name.equals(lake.name) && depth.equals(lake.depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, depth);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lake.class.getSimpleName() + "[", "]")
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

        public Lake build() {
            return new Lake(this);
        }

    }
}
