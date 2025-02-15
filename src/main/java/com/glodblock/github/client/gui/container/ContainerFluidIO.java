package com.glodblock.github.client.gui.container;

import net.minecraft.entity.player.InventoryPlayer;

import appeng.api.config.Settings;
import appeng.api.config.YesNo;
import appeng.api.util.IConfigManager;
import appeng.tile.inventory.AppEngInternalAEInventory;

import com.glodblock.github.client.gui.container.base.FCContainerFluidConfigurable;
import com.glodblock.github.common.parts.PartFluidExportBus;
import com.glodblock.github.common.parts.base.FCSharedFluidBus;
import com.glodblock.github.util.Ae2Reflect;

public class ContainerFluidIO extends FCContainerFluidConfigurable {

    private final FCSharedFluidBus bus;

    public ContainerFluidIO(InventoryPlayer ip, FCSharedFluidBus te) {
        super(ip, te);
        this.bus = te;
    }

    public FCSharedFluidBus getBus() {
        return this.bus;
    }

    @Override
    public AppEngInternalAEInventory getFakeFluidInv() {
        return (AppEngInternalAEInventory) this.bus.getInventoryByName("config");
    }

    @Override
    protected void loadSettingsFromHost(IConfigManager cm) {
        super.loadSettingsFromHost(cm);
        if (Ae2Reflect.getUpgradeableHost(this) instanceof PartFluidExportBus) {
            this.setCraftingMode((YesNo) cm.getSetting(Settings.CRAFT_ONLY));
        }
    }
}
