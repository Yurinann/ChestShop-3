package com.Acrobot.ChestShop.Listeners.Item;

import com.Acrobot.ChestShop.Signs.ChestShopSign;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.InventoryHolder;

import static com.Acrobot.Breeze.Utils.ImplementationAdapter.getHolder;

/**
 * @author Acrobot
 */
public class ItemMoveListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public static void onItemMove(InventoryMoveItemEvent event) {
        InventoryHolder destinationHolder = getHolder(event.getDestination(), false);
        InventoryHolder sourceHolder = getHolder(event.getSource(), false);

        if (!(destinationHolder instanceof BlockState) && ChestShopSign.isShopBlock(sourceHolder)) {
            event.setCancelled(true);
        }
    }


}
