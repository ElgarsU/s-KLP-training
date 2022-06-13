package com.elgars.klptraining.modelDTO;

import com.elgars.klptraining.repository.model.Fish;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LakeDTO {

    private final Long id;
    private final String name;
    private final Integer depth;
    private final List<Fish> fishes;

    private LakeDTO(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.depth = b.depth;
        this.fishes = b.fishes;
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

    public List<Fish> getFishes() {
        return fishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LakeDTO)) return false;
        LakeDTO lake = (LakeDTO) o;
        return id.equals(lake.id) && name.equals(lake.name) && depth.equals(lake.depth) && Objects.equals(fishes, lake.fishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, depth, fishes);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LakeDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("depth=" + depth)
                .add("fishes=" + fishes)
                .toString();
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private String name;
        private Integer depth;
        private List<Fish> fishes;

        private Builder() {

        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder depth(Integer depth) {
            this.depth = depth;
            return this;
        }

        public Builder fishes(List<Fish> fishes) {
            this.fishes = fishes;
            return this;
        }

        public LakeDTO build() {
            return new LakeDTO(this);
        }
    }
}
