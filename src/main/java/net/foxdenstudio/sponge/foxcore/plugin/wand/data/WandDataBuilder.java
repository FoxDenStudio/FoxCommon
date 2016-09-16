/*
 * This file is part of FoxCore, licensed under the MIT License (MIT).
 *
 * Copyright (c) gravityfox - https://gravityfox.net/
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.foxdenstudio.sponge.foxcore.plugin.wand.data;

import net.foxdenstudio.sponge.foxcore.plugin.wand.WandType;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;

import java.util.Optional;

public class WandDataBuilder extends AbstractDataBuilder<WandData> implements DataManipulatorBuilder<WandData, ImmutableWandData> {

    private static final int CONTENT_VERSION = 1;

    public WandDataBuilder() {
        super(WandData.class, CONTENT_VERSION);
    }

    @NotNull
    @Override
    public WandData create() {
        return new WandData();
    }

    @NotNull
    @Override
    public Optional<WandData> createFrom(@NotNull DataHolder dataHolder) {
        return create().fill(dataHolder);
    }

    @NotNull
    @Override
    protected Optional<WandData> buildContent(@NotNull DataView container) throws InvalidDataException {
        if (!container.contains(WandKeys.WANDTYPE.getQuery())) return Optional.empty();
        WandData data = create();
        data.setWandType(WandType.valueOf((String) container.get(WandKeys.WANDTYPE.getQuery()).get()));
        return Optional.of(data);
    }


}
