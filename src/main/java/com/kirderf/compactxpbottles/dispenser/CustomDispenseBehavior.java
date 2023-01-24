package com.kirderf.compactxpbottles.dispenser;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class CustomDispenseBehavior extends AbstractProjectileDispenseBehavior {

    @Override
    protected @NotNull Projectile getProjectile(@NotNull Level p_123360_, Position position, ItemStack stackIn) {
        return new CustomExperienceBottleEntity(p_123360_, position.x(), position.y(), position.z(), (CustomExperienceBottle) stackIn.getItem().asItem());

    }
}

