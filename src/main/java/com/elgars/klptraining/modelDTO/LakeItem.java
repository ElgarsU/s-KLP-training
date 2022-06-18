package com.elgars.klptraining.modelDTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;
import java.util.StringJoiner;

@JsonDeserialize(builder = LakeItem.Builder.class)
public class LakeItem {

    private final Long id;
    private final String name;
    private final Integer depth;
    //private final List<Fish> fishes;

    private LakeItem(Builder b) {
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
        if (!(o instanceof LakeItem)) return false;
        LakeItem lakeItem = (LakeItem) o;
        return id.equals(lakeItem.id) && name.equals(lakeItem.name) && Objects.equals(depth, lakeItem.depth);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, depth);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LakeItem.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("depth=" + depth)
                .toString();
    }

    @JsonPOJOBuilder(withPrefix = "")
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
//        public Builder fishes(List<Fish> fishes) {
//            this.fishes = fishes;
//            return this;
//        }
        public LakeItem build() {
            return new LakeItem(this);
        }
    }
}
