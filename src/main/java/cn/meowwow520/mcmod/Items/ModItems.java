package cn.meowwow520.mcmod.Items;

import cn.meowwow520.mcmod.MoreDangerousCreeper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ModItems {
    private ModItems() {
    }
    // 创建物品变量
    // TODO: 添加一个自定义创造模式物品分页
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
    // TODO: 注释呢？
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MoreDangerousCreeper.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = factory.apply(settings.registryKey(key));
        Registry.register(Registries.ITEM, id, item);
        return item;
    }


    // 注册所有 ModItems
    public static void registerModItems() {
        MoreDangerousCreeper.LOGGER.info("[" + MoreDangerousCreeper.MOD_ID + "] Registering Items");
        // 将物品添加到 标签页 --> 使用 `entries.add(ItemName);`
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(MeowWow520);
            entries.add(MeowWow521);
        });
    }
}
