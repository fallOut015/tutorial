package io.github.fallOut015.tutorial.world.item;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ItemTierTutorial implements IItemTier {
	RAINBOW(4, 4031, 12.0f, 5.0f, 22, () -> {
		return Ingredient.of(ItemsTutorial.RAINBOW_HORN.get());
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private ItemTierTutorial(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}
	
	@Override
	public int getUses() {
		return this.maxUses;
	}
	@Override
	public float getSpeed() {
		return this.efficiency;
	}
	@Override
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}
	@Override
	public int getLevel() {
		return this.harvestLevel;
	}
	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}
}