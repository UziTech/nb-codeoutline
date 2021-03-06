/*
 * Copyright (C) 2015 markiewb
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package de.markiewb.netbeans.plugins.outline.options;

import java.util.prefs.Preferences;
import org.netbeans.api.editor.mimelookup.MimeLookup;
import org.netbeans.api.editor.mimelookup.MimePath;
import org.openide.util.NbPreferences;

/**
 *
 * @author markiewb
 */
public class Options {

    public static final boolean DEFAULT_OUTLINE = true;
    public static final String DEFAULT_POSITION = Position.RIGHT.name();
    public static final String KEY_OUTLINE = "enable.outline";
    public static final String KEY_POSITION = "outline.position";
    public static final String KEY_WIDTH = "outline.width";
    static int WIDTH_DEFAULT = 90;

    public static Position getPosition() {
        String get = NbPreferences.forModule(CodeoutlineOptionsPanel.class).get(KEY_POSITION, DEFAULT_POSITION);
        return Position.valueOf(get.toUpperCase());
    }

    public static int getWidth() {
        return NbPreferences.forModule(CodeoutlineOptionsPanel.class).getInt(KEY_WIDTH, WIDTH_DEFAULT);
    }


    public static boolean isVisible() {
        Preferences prefs = MimeLookup.getLookup(MimePath.EMPTY).lookup(Preferences.class);
        return prefs.getBoolean(Options.KEY_OUTLINE, Options.DEFAULT_OUTLINE);
    }

    public static void setPosition(String toString) {
        NbPreferences.forModule(CodeoutlineOptionsPanel.class).put(KEY_POSITION, Position.valueOf(toString.toUpperCase()).name());
    }

    static void setWidth(Integer value) {
        NbPreferences.forModule(CodeoutlineOptionsPanel.class).putInt(KEY_WIDTH, value);
    }

    public enum Position {

        LEFT, RIGHT
    }

}
