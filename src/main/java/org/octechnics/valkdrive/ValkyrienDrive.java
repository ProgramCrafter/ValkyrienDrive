package org.octechnics.valkdrive;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// use org.octechnics.valkdrive.BlocksItemsRegistryHelper;

@Mod(ValkyrienDrive.MOD_ID)
public class ValkyrienDrive {
    public static Logger logger = LogManager.getLogger();
    
    public static final BlocksItemsRegistryHelper registry_blocks = new BlocksItemsRegistryHelper();
    
    public static final String MOD_ID = "valkdrive";
    
    public ValkyrienDrive() {
        logger.info("valkdrive - registering mod");
        MinecraftForge.EVENT_BUS.register(this);
        
        registry_blocks.initialize();
    }
}
