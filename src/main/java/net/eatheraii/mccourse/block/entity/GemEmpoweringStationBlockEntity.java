package net.eatheraii.mccourse.block.entity;

import net.eatheraii.mccourse.block.custom.GemEmpoweringStationBlock;
import net.eatheraii.mccourse.item.ModItems;
import net.eatheraii.mccourse.screen.GemEmpoweringScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GemEmpoweringStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int FLUID_INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private static final int ENERGY_ITEM_SLOT = 3;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;


    public GemEmpoweringStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEM_EMPOWERING_STATION_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GemEmpoweringStationBlockEntity.this.progress;
                    case 1 -> GemEmpoweringStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: GemEmpoweringStationBlockEntity.this.progress = value;
                    case 1: GemEmpoweringStationBlockEntity.this.maxProgress = value;
                }

            }

            @Override
            public int size() {
                return 2; //two variables to synchronise (progress and max progress)
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Gem Empowering Station");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GemEmpoweringScreenHandler(syncId, playerInventory,this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }


    //saving and loading of data when go into and out of world
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        //use minecraft class
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("gem_empowering_station.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        nbt.putInt("gem_empowering_station.progress", progress);
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(canInsertIntoOutputSlot() && hasRecipe()){
            increaseCraftingProgress(); //bc easier to read
            markDirty(world, pos, state);

            if (hasCraftingFinished()){
                craftItem();
                resetProgress();
            }

        } else {
            resetProgress();
        }

    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(ModItems.PINK_GARNET,
                this.getStack(OUTPUT_SLOT).getCount() + 1));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasCraftingFinished() {
        return this.progress>= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        //if the item in the input slot is raw pink garnet
        return this.getStack(INPUT_SLOT).getItem() == ModItems.RAW_PINK_GARNET;
    }

    private boolean canInsertIntoOutputSlot() {
        //if the output slot is empty
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                //if the output slot has a count that is smaller than the max count. If 63, cool. if 64, not cool.
                this.getStack(OUTPUT_SLOT).getCount() > this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}
