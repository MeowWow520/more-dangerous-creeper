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
    private ModItems() {}
    public static final Item MeowWow520 = registerItem("meowwow520", Item::new, new Item.Settings());
    public static final Item Jerry = registerItem("jerry", Item::new, new Item.Settings());
    /**
     * 注册一个物品
     * @param name 物品的名称
     * @param factory 或许一般默认填 Item::new
     * @param settings 物品的设置
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MoreDangerousCreeper.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        // 关键一步：把 RegistryKey 塞进 Settings
        // NOTE: 这是我在编写 1.21.11 时，由于教程是 1.21 的版本。遇到的 BUG 之一。交由 Grok 之后获得的答案
        settings = settings.registryKey(key);
        Item item = factory.apply(settings);
        Registry.register(Registries.ITEM, id, item);
        return item;
    }
    // 注册所有 ModItems
    public static void registerModItems() {
        MoreDangerousCreeper.LOGGER.info("[" + MoreDangerousCreeper.MOD_ID + "] Registering Items");
        // 为 FOOD_AND_DRINK 标签页创建物品
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(MeowWow520);
            entries.add(Jerry);
        });
    }
}
