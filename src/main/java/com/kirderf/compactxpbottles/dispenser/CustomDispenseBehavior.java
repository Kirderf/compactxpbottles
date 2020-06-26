package com.kirderf.compactxpbottles.dispenser;

import com.kirderf.compactxpbottles.entity.CustomExperienceBottleEntity;
import com.kirderf.compactxpbottles.items.CustomExperienceBottle;
import com.kirderf.compactxpbottles.lists.ItemList;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class CustomDispenseBehavior extends ProjectileDispenseBehavior {

    public static void init() {
        DispenserBlock.registerDispenseBehavior(ItemList.x4experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x16experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x64experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x256experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x512experiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x1kexperiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x2kexperiencebottle, new CustomDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ItemList.x4kexperiencebottle, new CustomDispenseBehavior());
    }
    @Override
    protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
        return new CustomExperienceBottleEntity(worldIn, position.getX(), position.getY(), position.getZ(), (CustomExperienceBottle) stackIn.getItem().asItem());

    }

}

