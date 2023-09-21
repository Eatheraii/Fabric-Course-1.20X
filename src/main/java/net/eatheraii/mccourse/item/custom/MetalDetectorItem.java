package net.eatheraii.mccourse.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            //make some variables
            BlockPos positionClicked = context.getBlockPos(); //position on block clicked
            PlayerEntity player = context.getPlayer(); //player that clicked
            boolean foundBlock = false;

            for (int i =0; i <= positionClicked.getY() +64; i++){
                //get block state of block to get the block.
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                Block block = blockState.getBlock();

                if (isValuableBlock(blockState)){
                    //have found a valuable block.
                    //output coords and name
                    outPutValuableCoordinates(positionClicked.down(i), player, block);
                    foundBlock=true;

                    //Want to break our of for loop
                    break;
                }
            }

            if (!foundBlock){ //this is a translatable, a key that gets translated in the en us json file
                player.sendMessage(Text.translatable("item.mccourse.metal_detector.no_valuables"));
            }
        }

        //now we want to damage item like when use a sword when hit, the plate should get damaged when right clicked,
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        //makes the player hand show a swinging option, like it went through.
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //add text to tool tip to be displayed.
        //we'll make it so when hover in inventory, press shift for more info and when hold shift will get more info

        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip.shift"));
        }else{
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip"));
        }
    }

    //send message to player of the valuable
    private void outPutValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valuable Found: " + block.getName().getString() + " at "
                + position.getX() + ", " + position.getY() + ", "  + position.getZ() + ", " ));
    }

    //checks if a block is "valuable"
    public boolean isValuableBlock(BlockState blockState){
        return blockState.getBlock() == Blocks.IRON_ORE || blockState.getBlock() == Blocks.GOLD_ORE ||
                blockState.getBlock() == Blocks.DIAMOND_ORE || blockState.getBlock() == Blocks.REDSTONE_ORE;
    }
}
