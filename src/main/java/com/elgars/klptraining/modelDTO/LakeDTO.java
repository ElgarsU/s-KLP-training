package com.elgars.klptraining.modelDTO;

import com.elgars.klptraining.repository.model.Fish;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@JsonDeserialize(builder = FishDTO.Builder.class)
public class LakeDTO {

    private final Long id;
    private final String name;
    private final Integer depth;
    //private final List<Fish> fishes;

    private LakeDTO(Builder b) {
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LakeDTO)) return false;
        LakeDTO lakeDTO = (LakeDTO) o;
        return id.equals(lakeDTO.id) && name.equals(lakeDTO.name) && Objects.equals(depth, lakeDTO.depth);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, depth);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LakeDTO.class.getSimpleName() + "[", "]")
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
//        public Builder fishes(List<Fish> fishes) {
//            this.fishes = fishes;
//            return this;
//        }
        public LakeDTO build() {
            return new LakeDTO(this);
        }
    }
}
