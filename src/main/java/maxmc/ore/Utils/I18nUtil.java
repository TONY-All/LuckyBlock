package maxmc.ore.Utils;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class I18nUtil {
    public static String getUnLocalziedName(ItemStack is){
        net.minecraft.server.v1_12_R1.ItemStack NMSis = CraftItemStack.asNMSCopy(is);
        return NMSis.a()+".name";
    }
}
