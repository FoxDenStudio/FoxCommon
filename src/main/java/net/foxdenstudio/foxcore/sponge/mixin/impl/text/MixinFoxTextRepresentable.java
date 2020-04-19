package net.foxdenstudio.foxcore.sponge.mixin.impl.text;

import net.foxdenstudio.foxcore.api.text.FoxTextRepresentable;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoxTextRepresentable.class)
public interface MixinFoxTextRepresentable extends TextRepresentable {

    @Shadow(prefix = "shadow$")
    net.foxdenstudio.foxcore.platform.text.Text shadow$toText();

    @Override
    default Text toText() {
        return (Text) shadow$toText();
    }

    @Shadow
    void applyTo(net.foxdenstudio.foxcore.platform.text.Text.Builder builder);

    @Override
    default void applyTo(Text.Builder builder) {
        applyTo((net.foxdenstudio.foxcore.platform.text.Text.Builder) builder);
    }
}
