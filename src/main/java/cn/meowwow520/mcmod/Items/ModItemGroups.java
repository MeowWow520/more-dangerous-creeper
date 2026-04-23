package cn.meowwow520.mcmod.Items;

import cn.meowwow520.mcmod.MoreDangerousCreeper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MORE_DANGEROUS_CREEPER_GROUP = Registry.register(
            Registries.ITEM_GROUP, Identifier.of(MoreDangerousCreeper.MOD_ID, "more_dangerous_creeper_group"),
            ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.more_dangerous_creeper_group"))
                    /* 显示的物品的图标 */
                    .icon(() -> new ItemStack(ModItems.MeowWow520))
                    .entries((displayContext, entries) -> {
                        /* 添加到 ItemGroup 的物品*/
                        entries.add(ModItems.MeowWow520);
                        entries.add(ModItems.MeowWow521);
                    }).build()
    );

    public static void registerModItemGroups() {
        MoreDangerousCreeper.LOGGER.info("Registering Item Groups");
    }
}
