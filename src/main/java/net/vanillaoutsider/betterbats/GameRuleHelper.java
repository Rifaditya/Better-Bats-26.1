package net.vanillaoutsider.betterbats;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRuleType;
import net.minecraft.world.level.gamerules.GameRuleTypeVisitor;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.serialization.Codec;

public class GameRuleHelper {
    public static GameRule<Boolean> registerBoolean(String name, GameRuleCategory category, boolean defaultValue) {
        return Registry.register(BuiltInRegistries.GAME_RULE, name, new GameRule<>(
                category,
                GameRuleType.BOOL,
                BoolArgumentType.bool(),
                GameRuleTypeVisitor::visitBoolean,
                Codec.BOOL,
                b -> b ? 1 : 0,
                defaultValue,
                FeatureFlagSet.of()));
    }

    public static GameRule<Integer> registerInteger(String name, GameRuleCategory category, int defaultValue) {
        return Registry.register(BuiltInRegistries.GAME_RULE, name, new GameRule<>(
                category,
                GameRuleType.INT,
                IntegerArgumentType.integer(),
                GameRuleTypeVisitor::visitInteger,
                Codec.INT,
                i -> i,
                defaultValue,
                FeatureFlagSet.of()));
    }
}
