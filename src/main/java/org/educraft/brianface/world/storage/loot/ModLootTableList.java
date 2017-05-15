package org.educraft.brianface.world.storage.loot;

import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Set;
import net.minecraft.util.ResourceLocation;

public class ModLootTableList {

    private static final Set<ResourceLocation> LOOT_TABLES = Sets.<ResourceLocation>newHashSet();
    private static final Set<ResourceLocation> READ_ONLY_LOOT_TABLES = Collections.<ResourceLocation>unmodifiableSet(LOOT_TABLES);

    public static final ResourceLocation ENTITIES_BRIAN = register("entities/brian");

    private static ResourceLocation register(String id)
    {
        return register(new ResourceLocation("brianmod", id));
    }

    public static ResourceLocation register(ResourceLocation id)
    {
        if (LOOT_TABLES.add(id))
        {
            return id;
        }
        else
        {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> getAll()
    {
        return READ_ONLY_LOOT_TABLES;
    }

}
