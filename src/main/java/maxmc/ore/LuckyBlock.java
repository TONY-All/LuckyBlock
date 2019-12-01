package maxmc.ore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LuckyBlock extends JavaPlugin {
    public static LuckyBlock Instance;
    public LuckyBlock() {
        Instance = this;
    }

    public static LuckyBlock getInstance() {
        return Instance;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BreakHand(),this);
        Bukkit.getPluginCommand("LBSave").setExecutor(new Excuter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
