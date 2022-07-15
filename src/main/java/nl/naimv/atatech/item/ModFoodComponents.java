package nl.naimv.atatech.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent MERICAN_CHEESE = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 40, 1), 1.0f).build();
    public static final FoodComponent MERICAN_BURGER = new FoodComponent.Builder().hunger(12).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 2), 1.0f).build();
}
