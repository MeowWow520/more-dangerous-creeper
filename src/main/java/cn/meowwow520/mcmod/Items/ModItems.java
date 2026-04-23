package cn.meowwow520.mcmod.Items;

import cn.meowwow520.mcmod.MoreDangerousCreeper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ModItems {
    // 创建物品变量
    /**
     * MeowWow520 是一个测试物品
     * @implNote 注册于 待定创造物品栏
     */
    public static final Item MeowWow520 = registerItem("meowwow520", Item::new, new Item.Settings());
    public static final Item MeowWow521 = registerItem("meowwow521", Item::new, new Item.Settings());

    /**
     * 注册一个物品
     *
     * @param name     物品的名称
     * @param factory  或许一般默认填 Item::new
     * @param settings 物品的设置
     */
    // TODO: 注释
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MoreDangerousCreeper.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = factory.apply(settings.registryKey(key));
        Registry.register(Registries.ITEM, id, item);
        return item;
    }
    private static void addItemToGroup(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(ModItems.MeowWow520);
        fabricItemGroupEntries.add(ModItems.MeowWow521);
    }

    public static void registerModItems() {
        RegistryKey<ItemGroup> MoreDangerousCreeper_Group = RegistryKey.of(
                RegistryKeys.ITEM_GROUP,
                Identifier.of(MoreDangerousCreeper.MOD_ID,
                "more_dangerous_creeper_group"));
        ItemGroupEvents.modifyEntriesEvent(MoreDangerousCreeper_Group).register(ModItems::addItemToGroup);
        MoreDangerousCreeper.LOGGER.info("Registering Mod Items");
    }
}
