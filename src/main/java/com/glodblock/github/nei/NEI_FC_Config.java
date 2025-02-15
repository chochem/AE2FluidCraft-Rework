package com.glodblock.github.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.glodblock.github.FluidCraft;
import com.glodblock.github.client.gui.*;
import com.glodblock.github.nei.recipes.FluidRecipe;

public class NEI_FC_Config implements IConfigureNEI {

    @Override
    public void loadConfig() {
        API.registerNEIGuiHandler(new NEIGuiHandler());
        API.addSearchProvider(new NEIItemFilter());
        for (String identifier : FluidRecipe.getSupportRecipes()) {
            API.registerGuiOverlayHandler(
                    GuiFluidCraftingWireless.class,
                    FluidCraftingTransferHandler.INSTANCE,
                    identifier);
            API.registerGuiOverlayHandler(
                    GuiFluidPatternWireless.class,
                    FluidPatternTerminalRecipeTransferHandler.INSTANCE,
                    identifier);
            API.registerGuiOverlayHandler(
                    GuiFluidPatternExWireless.class,
                    FluidPatternTerminalRecipeTransferHandler.INSTANCE,
                    identifier);
            API.registerGuiOverlayHandler(
                    GuiFluidPatternTerminal.class,
                    FluidPatternTerminalRecipeTransferHandler.INSTANCE,
                    identifier);
            API.registerGuiOverlayHandler(
                    GuiFluidPatternTerminalEx.class,
                    FluidPatternTerminalRecipeTransferHandler.INSTANCE,
                    identifier);
        }
    }

    @Override
    public String getName() {
        return FluidCraft.MODNAME;
    }

    @Override
    public String getVersion() {
        return FluidCraft.VERSION;
    }
}
