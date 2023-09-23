package net.eatheraii.mccourse.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PinkGarnetLampBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public PinkGarnetLampBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(CLICKED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            world.setBlockState(pos, state.cycle(CLICKED)); //will alternate basically
        }

        return ActionResult.SUCCESS;
    }
}
