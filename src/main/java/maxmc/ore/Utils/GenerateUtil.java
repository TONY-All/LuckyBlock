package maxmc.ore.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateUtil {
    public static void genItem(Player player, Block block) {
        PlayerInventory inv = player.getInventory();
        int EmptySlot = 0;
        for (int i=0;i<=35;i++){
            ItemStack is = inv.getItem(i);
            if(is.getType().equals(Material.AIR)){
                EmptySlot = EmptySlot+1;
            }
        }
        if(EmptySlot < 3){
            Random r= new Random();
            ConfigurationSection Rewards = YMLUtil.getRewards();
            int Rewardcount = r.nextInt(3) +1;
            player.sendMessage("§b§lMAXMC  §d§l>>  §a你打开了一个幸运方块，得到以下" + Rewardcount + "种物品:");
            String[] Keys = (String[]) Rewards.getKeys(false).toArray();
            List<ItemStack> finalRewards = new ArrayList<>();
            while(Rewardcount>0){
                Rewardcount = Rewardcount-1;
                int i = r.nextInt(90)+1;
                ItemStack rew = new ItemStack(Material.getMaterial(Keys[i]),Rewards.getInt(Keys[i]));
                finalRewards.add(rew);
            }
            for (ItemStack finalReward : finalRewards) {
                player.getInventory().addItem(finalReward);
                String name = I18nUtil.getUnLocalziedName(finalReward);
                player.sendMessage("§6 得到: "+ name + "§a * §e" + Rewards.getInt(finalReward.getType().name()));
            }
            block.setType(Material.AIR);
            player.sendMessage("      §a如果有任何§cBUG反馈§a或§e一些想法和建议");
            player.sendMessage("      §a请联系QQ: 767743748");
            player.sendMessage("      §a如果你的反馈或想法被服务器使用");
            player.sendMessage("      §a服务器会给予相对应的奖励！");
        }else {
            player.sendMessage("§b§lMAXMC  §d§l>>  §r§c你的背包已满，无法打开幸运方块 ");
        }
    }
}
