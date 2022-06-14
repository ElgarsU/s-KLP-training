package com.elgars.klptraining.modelDTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;
import java.util.StringJoiner;

@JsonDeserialize(builder = FishDTO.Builder.class)
public class FishDTO {

    private final Long id;
    private final String name;
    private final Boolean restricted;

    public FishDTO(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.restricted = b.restricted;
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

    public static Builder builder() {
        return new Builder();
    }

    public Builder copyBuilder() {
        return builder()
                .id(getId())
                .name(getName())
                .restricted(getRestricted());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishDTO)) return false;
        FishDTO fish = (FishDTO) o;
        return id.equals(fish.id) && name.equals(fish.name) && restricted.equals(fish.restricted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, restricted);
    }

    @Override
    public String   toString() {
        return new StringJoiner(", ", FishDTO.class.getSimpleName() + "[", "]")
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

        public FishDTO build() {
            return new FishDTO(this);
        }
    }
}
