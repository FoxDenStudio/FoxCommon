/*
 * This file is part of FoxGuard, licensed under the MIT License (MIT).
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

package net.foxdenstudio.foxcommon.commands.util;

import net.foxdenstudio.foxcommon.state.FCStateRegistry;
import net.foxdenstudio.foxcommon.state.IStateField;
import net.foxdenstudio.foxcommon.util.CallbackHashMap;

import java.util.Map;

public class SourceState {

    private Map<String, IStateField> state = new CallbackHashMap<>((key, map) -> {
        if (key instanceof String) {
            IStateField field = FCStateRegistry.instance().newStateField((String) key);
            if (field != null) {
                map.put((String) key, field);
                return field;
            }
        }
        return null;
    });

    public Map<String, IStateField> getMap() {
        return this.state;
    }

    public IStateField get(String identifier) {
        return this.state.get(identifier);
    }

    public IStateField getFromAlias(String alias) {
        return this.state.get(FCStateRegistry.instance().getID(alias));
    }

    public void flush() {
        state.values().forEach(IStateField::flush);
    }

    public void flush(String field) {
        if (state.containsKey(field)) state.get(field).flush();
    }

    public void flush(String... fields) {
        for (String field : fields) {
            this.flush(field);
        }
    }
}
