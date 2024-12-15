package net.satisfy.bakery;

import net.satisfy.bakery.core.registry.*;
import net.satisfy.bakery.core.event.CommonEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bakery {
    public static final String MOD_ID = "bakery";

    public static void init() {
        EntityTypeRegistry.init();
        ObjectRegistry.init();
        RecipeTypeRegistry.init();
        CommonEvents.init();
        TabRegistry.init();
        SoundEventRegistry.init();
    }
}

