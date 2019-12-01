package maxmc.ore.Utils;

import maxmc.ore.LuckyBlock;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class YMLUtil {
    private static Configuration Config;
    private static LuckyBlock Instance = LuckyBlock.getInstance();
    public static void init(){
        Instance.saveDefaultConfig();
        Config = Instance.getConfig();
    }
    public static ConfigurationSection getRewards(){
        return Config.getConfigurationSection("Rewards");
    }
    public static void saveRewarsList(ItemStack[] iss){
        for (ItemStack stack : iss) {
            Config.getConfigurationSection("Rewards").set(stack.getType().name(),stack.getAmount());
            Instance.saveConfig();
        }
    }
}