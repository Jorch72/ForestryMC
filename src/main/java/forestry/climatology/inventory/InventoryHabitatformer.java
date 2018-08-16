package forestry.climatology.inventory;

import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

import forestry.climatology.tiles.TileHabitatformer;
import forestry.core.inventory.InventoryAdapterTile;

public class InventoryHabitatformer extends InventoryAdapterTile<TileHabitatformer> {
	public static final short SLOT_INPUT = 0;

	public InventoryHabitatformer(TileHabitatformer tile) {
		super(tile, 1, "Items");
	}

	@Override
	public boolean canSlotAccept(int slotIndex, ItemStack itemStack) {
		if (slotIndex == SLOT_INPUT) {
			FluidStack fluid = FluidUtil.getFluidContained(itemStack);
			return fluid != null && tile.getTankManager().canFillFluidType(fluid);
		}
		return false;
	}
}
