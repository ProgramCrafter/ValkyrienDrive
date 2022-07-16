package org.octechnics.valkdrive;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("valkdrive")
public class ValkyrienDrive {
    public ValkyrienDrive() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
