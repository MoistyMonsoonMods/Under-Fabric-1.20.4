package net.moistymonsoon.monsooncraft.properties;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.state.property.Property;
import net.moistymonsoon.monsooncraft.util.Flower;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class FlowerProperty extends Property<Flower> {
    private final ImmutableSet<Flower> allowedValues;
    private final Map<String, Flower> nameToValue = Maps.newHashMap();

    protected FlowerProperty(String name, Class<Flower> valueClass, Collection<Flower> allowedValues) {
        super(name, valueClass);
        this.allowedValues = ImmutableSet.copyOf(allowedValues);
        for (Flower f : allowedValues) {
            String s = f.name();
            if (this.nameToValue.containsKey(s)) {
                throw new IllegalArgumentException("Multiple values have the same name '" + s + "'");
            }
            this.nameToValue.put(s, f);
        }
    }

    @Override
    public Collection<Flower> getValues() {
        return this.allowedValues;
    }

    @Override
    public String name(Flower value) {
        return getName(value);
    }

    @Override
    public Optional<Flower> parse(String value) {
        return Optional.ofNullable(this.nameToValue.get(value));
    }

    public String getName(Flower value) {
        return value.name();
    }

    public boolean equals(Object p_equals_1_) {
        if (this == p_equals_1_) {
            return true;
        }
        if (p_equals_1_ instanceof FlowerProperty flowerProperty && super.equals(p_equals_1_)) {
            return this.allowedValues.equals(flowerProperty.allowedValues) && this.nameToValue.equals(flowerProperty.nameToValue);
        }
        return false;
    }

    @Override
    public int computeHashCode() {
        int i = super.computeHashCode();
        i = 31 * i + this.allowedValues.hashCode();
        i = 31 * i + this.nameToValue.hashCode();
        return i;
    }

    public static FlowerProperty create(String name, Collection<Flower> values) {
        return new FlowerProperty(name, Flower.class, values);
    }
}