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
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean restricted;

//TODO public no args constructor for entity class??
    public Fish() {
    }

    private Fish (Builder b) {
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
    public static class Builder {

        private Long id;
        private String name;
        private Boolean restricted;

//TODO why builder no args constructor is private? and do we need to explicitly declare one?
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

        public Fish build() {
            return new Fish(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fish)) return false;
        Fish fish = (Fish) o;
        return id.equals(fish.id) && name.equals(fish.name) && restricted.equals(fish.restricted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, restricted);
    }

    @Override
    public String   toString() {
        return new StringJoiner(", ", Fish.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("restricted=" + restricted)
                .toString();
    }
}
