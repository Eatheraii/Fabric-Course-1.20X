package net.eatheraii.mccourse.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class GemEmpoweringStationBlock extends Block {
    //bc block is assymetrical, we need a facing when it is placed.
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public GemEmpoweringStationBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        //if im looking north, i want the block to be facing me (facing south) when I place it)
    }

    //when we have a property, add to the vbuilder.
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //fixing not perfect hitbox
    //return a voxel.
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0,0,0,16,12,16);
    }
}
