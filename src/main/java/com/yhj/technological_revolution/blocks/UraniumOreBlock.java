package com.yhj.technological_revolution.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import java.util.List;
import java.util.Collections;

public class UraniumOreBlock extends DropExperienceBlock {
    public UraniumOreBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        // 返回铀矿石的掉落物
        return Collections.singletonList(new ItemStack(Items.RAW_IRON));
    }
}
