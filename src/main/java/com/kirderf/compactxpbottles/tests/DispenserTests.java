package com.kirderf.compactxpbottles.tests;

import com.kirderf.compactxpbottles.lists.ItemList;
import com.kirderf.compactxpbottles.throwables.CustomThrownExperienceBottle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.phys.AABB;
import net.neoforged.testframework.DynamicTest;
import net.neoforged.testframework.annotation.ForEachTest;
import net.neoforged.testframework.annotation.TestHolder;
import net.neoforged.testframework.gametest.EmptyTemplate;
import net.neoforged.testframework.gametest.GameTest;

import java.util.List;

@ForEachTest(groups = DispenserTests.GROUP)
public class DispenserTests {
    public static final String GROUP = "dispenser";

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x4 can be shot from a dispenser")
    static void bottleX4CanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x4");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x16 can be shot from a dispenser")
    static void bottleX16CanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x16");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x64 can be shot from a dispenser")
    static void bottleX64CanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x64");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x256 can be shot from a dispenser")
    static void bottleX256CanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x256");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x1k can be shot from a dispenser")
    static void bottleX1kCanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x1k");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x4k can be shot from a dispenser")
    static void bottleX4kCanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x4k");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x16k can be shot from a dispenser")
    static void bottleX16kCanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x16k");
    }

    @GameTest
    @EmptyTemplate
    @TestHolder(description = "Tests that experience_bottle_x64k can be shot from a dispenser")
    static void bottleX64kCanBeDispensed(final DynamicTest test) {
        dispenserTest(test, "experience_bottle_x64k");
    }

    private static void dispenserTest(DynamicTest test, String bottleName) {
        test.onGameTest(helper -> helper.startSequence()
            .thenExecute(() -> helper.setBlock(1, 1, 1,
                Blocks.DISPENSER.defaultBlockState().setValue(DispenserBlock.FACING, Direction.UP)))
            .thenExecute(() -> helper.getBlockEntity(1, 1, 1, DispenserBlockEntity.class)
                .setItem(0, new ItemStack(ItemList.BOTTLE_ITEMS.get(bottleName).get())))
            .thenExecute(() -> helper.pulseRedstone(new BlockPos(1, 1, 2), 3))
            .thenIdle(5)
            .thenExecute(() -> {
                List<CustomThrownExperienceBottle> entities = helper.getEntitiesOfClass(
                    CustomThrownExperienceBottle.class, new AABB(-1, 0, -1, 6, 20, 6), e -> true);
                helper.assertTrue(!entities.isEmpty(),
                    "Expected a CustomThrownExperienceBottle to be launched by the dispenser for " + bottleName);
            })
            .thenSucceed());
    }
}
