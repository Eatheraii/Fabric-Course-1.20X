package net.eatheraii.mccourse;

import net.eatheraii.mccourse.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;

public class MCCourseModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModels();

    }
}
