package net.eatheraii.mccourse.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.eatheraii.mccourse.MCCourseMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemEmpoweringScreen extends HandledScreen<GemEmpoweringScreenHandler> {
    //add our texture
    private static final Identifier TEXTURE =
            new Identifier(MCCourseMod.MOD_ID, "textures/gui/gem_empowering_station_gui.png");

    public GemEmpoweringScreen(GemEmpoweringScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        //can use this to change title of gui and establish x and ys if dont fit.
        super.init();
        //this will br totally off the screen and thats fine
        titleY=1000;
        playerInventoryTitleY = 1000;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        //copied code.
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y); //this method is copied too
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            //add the texture of x and y +85 and +30
            //drawing the arrow and filling it on the gui on the right.
            context.drawTexture(TEXTURE, x + 85, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
