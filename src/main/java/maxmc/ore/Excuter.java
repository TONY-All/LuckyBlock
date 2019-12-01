package maxmc.ore;

import maxmc.ore.Utils.YMLUtil;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Excuter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p =(Player)sender;
            Block b = p.getTargetBlock(null,10);
            if(b instanceof Chest){
                Chest c = (Chest)b;
                Inventory inv = c.getBlockInventory();
                YMLUtil.saveRewarsList(inv.getContents());
            }
        }
        return true;
    }
}
