package com.elgars.klptraining.modelDTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;
import java.util.StringJoiner;

@JsonDeserialize(builder = FishItem.Builder.class)
public class FishItem {

    private final Long id;
    private final String name;
    private final Boolean restricted;
//    private final Lake lake;
    public FishItem(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.restricted = b.restricted;
//        this.lake = b.lake;
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
        if (!(o instanceof FishItem)) return false;
        FishItem fish = (FishItem) o;
        return id.equals(fish.id) && name.equals(fish.name) && restricted.equals(fish.restricted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, restricted);
    }

    @Override
    public String   toString() {
        return new StringJoiner(", ", FishItem.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("restricted=" + restricted)
                .toString();
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {

        private Long id;
        private String name;
        private Boolean restricted;
//        private Lake lake;
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

        public Builder restricted(Boolean restricted) {
            this.restricted = restricted;
            return this;
        }

//        public Builder lake(Lake lake) {
//            this.lake = lake;
//            return this;
//        }

        public FishItem build() {
            return new FishItem(this);
        }
    }
}
