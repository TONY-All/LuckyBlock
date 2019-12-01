package maxmc.ore;

import maxmc.ore.Utils.GenerateUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BreakHand implements Listener {
    @EventHandler
    public void onBreak(PlayerInteractEvent e){
        if(e.getClickedBlock().getType().equals(Material.MONSTER_EGG)&&e.getClickedBlock().getState().getData().getData() == 5){
            GenerateUtil.genItem(e.getPlayer(),e.getClickedBlock());
        }
    }
}
