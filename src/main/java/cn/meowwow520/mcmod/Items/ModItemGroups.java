package cn.meowwow520.mcmod.Items;

import cn.meowwow520.mcmod.MoreDangerousCreeper;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP,
                Identifier.of(MoreDangerousCreeper.MOD_ID, id));
    }


}
