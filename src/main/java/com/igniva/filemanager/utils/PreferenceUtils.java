package com.igniva.filemanager.utils;

import android.content.SharedPreferences;
import android.graphics.Color;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

/**
 * Modified by Vinita on 10-10-2016.
 */
public class PreferenceUtils {


    // Colors Patch 1
    private static String RED="#F44336";
    private static String PURPLE="#9c27b0";
    private static String VIOLET="#673ab7";
    private static String DARK_PINK="#e91e63";
    private static String ROYAL_BLUE="#03A9F4";
    private static String DARK_BLUE="#2196F3";
    private static String LIGHT_BLUE="#03A9F4";
    private static String CYAN="#00BCD4";
    private static String TEAL="#009688";
    private static String GREEN="#4CAF50";
    private static String LIGHT_GREEN="#8bc34a";
    private static String AMBER="#FFC107";
    private static String ORANGE="#FF9800";
    private static String DARK_ORANGE="#FF5722";
    private static String BROWN="#795548";
    private static String BLACK="#212121";
    private static String GREY="#607d8b";
    private static String SUPER_SU="#004d40";
    // Colors Patch 1 END

    // Colors Patch 2
    private static String RED2="e84e40";
    private static String PURPLE2="ab47bc";
    private static String VIOLET2="7e57c2";
    private static String DARK_PINK2="ec407a";
    private static String ROYAL_BLUE2="29b6f6";
    private static String DARK_BLUE2="738ffe";
    private static String LIGHT_BLUE2="29b6f6";
    private static String CYAN2="26c6da";
    private static String TEAL2="26a69a";
    private static String GREEN2="2baf2b";
    private static String LIGHT_GREEN2="9ccc65";
    private static String AMBER2="ffca28";
    private static String ORANGE2="ffa726";
    private static String DARK_ORANGE2="ff7043";
    private static String BROWN2="8d6e63";
    private static String BLACK2="bdbdbd";
    private static String GREY2="78909c";
    private static String SUPER_SU2="0E5D50";

    // Colors Patch 2 END


    static int primary=-1,accent=-1,folder=-1,theme=-1, primaryTwo=-1;

    public static final String KEY_PRIMARY_TWO = "skin_two";
    public static final String KEY_PRIMARY = "skin";
    public static final String KEY_ACCENT = "accent_skin";
    public static final String KEY_ICON_SKIN = "icon_skin";
    public static final String KEY_CURRENT_TAB = "current_tab";

    public static final int DEFAULT_PRIMARY = 4;
    public static final int DEFAULT_ACCENT = 1;
    public static final int DEFAULT_ICON = -1;
    public static final int DEFAULT_CURRENT_TAB = 1;

    public static int getStatusColor(String skin) {
        int c=darker(Color.parseColor(skin),0.6f);
        return c;
    }

    public static int getStatusColor(int skin) {
        int c=darker(skin,0.6f);
        return c;
    }

    public static int darker (int color, float factor) {
        int a = Color.alpha(color);
        int r = Color.red( color );
        int g = Color.green( color );
        int b = Color.blue( color );

        return Color.argb( a,
                Math.max( (int)(r * factor), 0 ),
                Math.max( (int)(g * factor), 0 ),
                Math.max( (int)(b * factor), 0 ) );
    }
    public static String random(SharedPreferences Sp) {


        Random random = new Random();
        int[] pos =combinations[ random.nextInt(combinations.length - 1)];
        int primary=pos[0],accent=pos[1],icon=pos[2];
        Sp.edit().putInt(KEY_PRIMARY, primary).commit();
        Sp.edit().putInt(KEY_PRIMARY_TWO, primary).commit();
        Sp.edit().putInt(KEY_ACCENT, accent).commit();
        Sp.edit().putInt(KEY_ICON_SKIN, icon).commit();
        return colors[primary];
    }
    public static int getAccent(SharedPreferences Sp){
        if(accent==-1)
        accent=Sp.getInt(KEY_ACCENT, DEFAULT_ACCENT);
        return accent;
    }

    public static int getPrimaryColor(SharedPreferences Sp){
        if(primary==-1)
        primary=Sp.getInt(KEY_PRIMARY, DEFAULT_PRIMARY);
        return primary;
    }

    /**
     * Get primary color of second tab from preferences
     * @return the color position in color array; from the preferences
     */
    public static int getPrimaryTwoColor(SharedPreferences Sp) {
        return primaryTwo==-1 ? Sp.getInt(KEY_PRIMARY_TWO, DEFAULT_PRIMARY) : null;
    }

    public static int getFolderColor(SharedPreferences Sp){
        if(folder==DEFAULT_ICON) {
            int icon = Sp.getInt(KEY_ICON_SKIN, DEFAULT_ICON);
            folder = icon == DEFAULT_ICON ? Sp.getInt(KEY_ACCENT, DEFAULT_ACCENT) : icon;
        }
        return folder;
    }
    public static String getPrimaryColorString(SharedPreferences Sp) {
        return (colors[getPrimaryColor(Sp)]);
    }

    /**
     * Get primary color of second tab from preferences
     * @return the color string in hex from the {@link #colors} array
     * based on color position from preferences
     */
    public static String getPrimaryTwoColorString(SharedPreferences Sp) {
        return (colors[getPrimaryTwoColor(Sp)]);
    }

    public static String getFolderColorString(SharedPreferences Sp) {
        return (colors[getFolderColor(Sp)]);
    }
    public static String getAccentString(SharedPreferences Sp) {
        return (colors[getAccent(Sp)]);
    }
    public static int getTheme(SharedPreferences Sp){
        if(theme==-1){
            int th = Integer.parseInt(Sp.getString("theme", "0"));
            theme = th == 2 ? PreferenceUtils.hourOfDay() : th;
        }
        return theme;
    }
    public static void reset(){
        primary=accent=folder=theme=primaryTwo=-1;
    }
    public static int getPosition(String Sp){
        int i=-1;
        for(String s:colors){
            i++;
            if(s.equals(Sp))return i;
        }
        return -1;
    }
    public final static int[][] combinations=new int[][]{
            //primary,accent,folder
            {14,11,12},
            {4,1,4},
            {8,12,8},
            {17,11,12},
            {3,1,3},
            {16,14,16},
            {1,12,1},
            {16,0,16},
            {0,12,0},
            {6,1,6},
            {7,1,7}
    };


    public static float[] calculatevalues(String color) {
        int c = Color.parseColor(color);
        float r = (float) Color.red(c) / 255;
        float g = (float) Color.green(c) / 255;
        float b = (float) Color.blue(c) / 255;
        return new float[]{r, g, b};
    }

    public static float[] calculatefilter(float[] values) {
        float[] src = {

                values[0], 0, 0, 0, 0,
                0, values[1], 0, 0, 0,
                0, 0, values[2], 0, 0,
                0, 0, 0, 1, 0
        };
        return src;
    }
    public static String getSelectionColor(String skin) {

        String[] colors = new String[]{
                RED, "#74"+RED2,
                DARK_PINK, "#74"+DARK_PINK2,
                PURPLE, "#74"+PURPLE2,
                VIOLET, "#74"+VIOLET2,
                ROYAL_BLUE, "#74"+ROYAL_BLUE2,
                DARK_BLUE, "#74"+DARK_BLUE2,
                LIGHT_BLUE, "#74"+LIGHT_BLUE2,
                CYAN, "#74"+CYAN2,
                TEAL, "#74"+TEAL2,
                GREEN, "#74"+GREEN2,
                LIGHT_GREEN, "#74"+LIGHT_GREEN2,
                AMBER, "#74"+AMBER2,
                ORANGE, "#74"+ORANGE2,
                DARK_ORANGE, "#74"+DARK_ORANGE2,
                BROWN, "#74"+BROWN2,
                BLACK, "#79"+BLACK2,
                GREY, "#74"+GREY2,
                SUPER_SU, "#74"+SUPER_SU2
        };
        return colors[Arrays.asList(colors).indexOf(skin) + 1];
    }
        public final static String[] colors = new String[]{
                RED,
                DARK_PINK,
                PURPLE,
                VIOLET,
                ROYAL_BLUE,
                DARK_BLUE,
                LIGHT_BLUE,
                CYAN,
                TEAL,
                GREEN,
                LIGHT_GREEN,
                AMBER,
                ORANGE,
                DARK_ORANGE,
                BROWN,
                BLACK,
                GREY,
                SUPER_SU
        };
        public static final String LICENCE_TERMS = "<html><body>" +
            "<h3>Notices for files:</h3>" +
            "<ul><li>nineoldandroids-2.4.0.jar</ul></li>" +	//nineoldandroids
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* Copyright 2012 Jake Wharton<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Licensed under the Apache License, Version 2.0 (the \"License\");<br>" +
            "&nbsp;* you may not use this file except in compliance with the License.<br>" +
            "&nbsp;* You may obtain a copy of the License at<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.apache.org/licenses/LICENSE-2.0<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Unless required by applicable law or agreed to in writing, software<br>" +
            "&nbsp;* distributed under the License is distributed on an \"AS IS\" BASIS,<br>" +
            "&nbsp;* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>" +
            "&nbsp;* See the License for the specific language governing permissions and<br>" +
            "&nbsp;* limitations under the License.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for files:</h3> " +
            "<ul><li>RootTools.jar</ul></li>" +	//RootTools
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* This file is part of the RootTools Project: http://code.google.com/p/roottools/<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Copyright (c) 2012 Stephen Erickson, Chris Ravenscroft, Dominik Schuermann, Adam Shanks<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* This code is dual-licensed under the terms of the Apache License Version 2.0 and<br>" +
            "&nbsp;* the terms of the General Public License (GPL) Version 2.<br>" +
            "&nbsp;* You may use this code according to either of these licenses as is most appropriate<br>" +
            "&nbsp;* for your project on a case-by-case basis.<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* The terms of each license can be found in the root directory of this project's repository as well as at:<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.apache.org/licenses/LICENSE-2.0<br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.gnu.org/licenses/gpl-2.0.txt<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Unless required by applicable law or agreed to in writing, software<br>" +
            "&nbsp;* distributed under these Licenses is distributed on an \"AS IS\" BASIS,<br>" +
            "&nbsp;* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>" +
            "&nbsp;* See each License for the specific language governing permissions and<br>" +
            "&nbsp;* limitations under that License.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3> " +
            "<ul><li>CircularImageView</ul></li>" +	//CircularImageView
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* The MIT License (MIT)<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Copyright (c) 2014 Pkmmte Xeleon<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Permission is hereby granted, free of charge, to any person obtaining a copy<br>" +
            "&nbsp;* of this software and associated documentation files (the \"Software\"), to deal<br>" +
            "&nbsp;* in the Software without restriction, including without limitation the rights<br>" +
            "&nbsp;* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell<br>" +
            "&nbsp;* copies of the Software, and to permit persons to whom the Software is<br>" +
            "&nbsp;* furnished to do so, subject to the following conditions:" +
            "&nbsp;*<br>" +
            "&nbsp;* The above copyright notice and this permission notice shall be included in<br>" +
            "&nbsp;* all copies or substantial portions of the Software.<br>" +
            "&nbsp;* THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR<br>" +
            "&nbsp;* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,<br>" +
            "&nbsp;* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE<br>" +
            "&nbsp;* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER<br>" +
            "&nbsp;* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,<br>" +
            "&nbsp;* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN<br>" +
            "&nbsp;* THE SOFTWARE.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3> " +
            "<ul><li>FloatingActionButton</ul></li>" +	//FloatingActionBar
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* The MIT License (MIT)<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Copyright (c) 2014 Oleksandr Melnykov<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Permission is hereby granted, free of charge, to any person obtaining a copy<br>" +
            "&nbsp;* of this software and associated documentation files (the \"Software\"), to deal<br>" +
            "&nbsp;* in the Software without restriction, including without limitation the rights<br>" +
            "&nbsp;* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell<br>" +
            "&nbsp;* copies of the Software, and to permit persons to whom the Software is<br>" +
            "&nbsp;* furnished to do so, subject to the following conditions:" +
            "&nbsp;*<br>" +
            "&nbsp;* The above copyright notice and this permission notice shall be included in<br>" +
            "&nbsp;* all copies or substantial portions of the Software.<br>" +
            "&nbsp;* THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR<br>" +
            "&nbsp;* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,<br>" +
            "&nbsp;* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE<br>" +
            "&nbsp;* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER<br>" +
            "&nbsp;* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,<br>" +
            "&nbsp;* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN<br>" +
            "&nbsp;* THE SOFTWARE.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3>" +
            "<ul><li>Android System Bar Tint</ul></li>" +	// SystemBar tint
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* Copyright 2013 readyState Software Limited<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Licensed under the Apache License, Version 2.0 (the \"License\");<br>" +
            "&nbsp;* you may not use this file except in compliance with the License.<br>" +
            "&nbsp;* You may obtain a copy of the License at<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.apache.org/licenses/LICENSE-2.0<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Unless required by applicable law or agreed to in writing, software<br>" +
            "&nbsp;* distributed under the License is distributed on an \"AS IS\" BASIS,<br>" +
            "&nbsp;* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>" +
            "&nbsp;* See the License for the specific language governing permissions and<br>" +
            "&nbsp;* limitations under the License.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3> " +
            "<ul><li>Material Dialogs</ul></li>" +	//Material Dialogs
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* The MIT License (MIT)<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Copyright (c) 2014 Aidan Michael Follestad<br>" +
            "&nbsp;*<br>" +
            "&nbsp;* Permission is hereby granted, free of charge, to any person obtaining a copy<br>" +
            "&nbsp;* of this software and associated documentation files (the \"Software\"), to deal<br>" +
            "&nbsp;* in the Software without restriction, including without limitation the rights<br>" +
            "&nbsp;* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell<br>" +
            "&nbsp;* copies of the Software, and to permit persons to whom the Software is<br>" +
            "&nbsp;* furnished to do so, subject to the following conditions:" +
            "&nbsp;*<br>" +
            "&nbsp;* The above copyright notice and this permission notice shall be included in<br>" +
            "&nbsp;* all copies or substantial portions of the Software.<br>" +
            "&nbsp;* THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR<br>" +
            "&nbsp;* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,<br>" +
            "&nbsp;* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE<br>" +
            "&nbsp;* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER<br>" +
            "&nbsp;* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,<br>" +
            "&nbsp;* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN<br>" +
            "&nbsp;* THE SOFTWARE.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3>" +
            "<ul><li>UnRAR</ul></li>" +	// junRar
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* UnRAR - free utility for RAR archives<br>" +
            "&nbsp;* License for use and distribution of<br>" +
            "&nbsp;* FREE portable version<br>" +
            "&nbsp;*/ " +
            "<br><br>" +
            "https://raw.githubusercontent.com/junrar/junrar/master/license.txt" +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3>" +
            "<ul><li>commons-compress</ul></li>" +	// commons-compress
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* Copyright [yyyy] [name of copyright owner]<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Licensed under the Apache License, Version 2.0 (the \"License\");<br>" +
            "&nbsp;* you may not use this file except in compliance with the License.<br>" +
            "&nbsp;* You may obtain a copy of the License at<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.apache.org/licenses/LICENSE-2.0<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Unless required by applicable law or agreed to in writing, software<br>" +
            "&nbsp;* distributed under the License is distributed on an \"AS IS\" BASIS,<br>" +
            "&nbsp;* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>" +
            "&nbsp;* See the License for the specific language governing permissions and<br>" +
            "&nbsp;* limitations under the License.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3>" +
            "<ul><li>sticky-headers-recyclerview</ul></li>" +	// stickyHeadersRecyclerView
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* Copyright 2014 Jacob Tabak - Timehop<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Licensed under the Apache License, Version 2.0 (the \"License\");<br>" +
            "&nbsp;* you may not use this file except in compliance with the License.<br>" +
            "&nbsp;* You may obtain a copy of the License at<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.apache.org/licenses/LICENSE-2.0<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Unless required by applicable law or agreed to in writing, software<br>" +
            "&nbsp;* distributed under the License is distributed on an \"AS IS\" BASIS,<br>" +
            "&nbsp;* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>" +
            "&nbsp;* See the License for the specific language governing permissions and<br>" +
            "&nbsp;* limitations under the License.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "<h3>Notices for libraries:</h3>" +
            "<ul><li>Universal Image Loader</ul></li>" +	// universalImageLoader
            "<p style = 'background-color:#eeeeee;padding-left:1em'><code>" +
            "<br>/*<br>" +
            "&nbsp;* Copyright 2011-2015 Sergey Tarasevich<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Licensed under the Apache License, Version 2.0 (the \"License\");<br>" +
            "&nbsp;* you may not use this file except in compliance with the License.<br>" +
            "&nbsp;* You may obtain a copy of the License at<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* &nbsp;&nbsp;&nbsp;http://www.apache.org/licenses/LICENSE-2.0<br>" +
            "&nbsp;* <br>" +
            "&nbsp;* Unless required by applicable law or agreed to in writing, software<br>" +
            "&nbsp;* distributed under the License is distributed on an \"AS IS\" BASIS,<br>" +
            "&nbsp;* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>" +
            "&nbsp;* See the License for the specific language governing permissions and<br>" +
            "&nbsp;* limitations under the License.<br>" +
            "&nbsp;*/ " +
            "<br><br></code></p>" +
            "</body></html>";

    public static int hourOfDay() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour <= 6 || hour >= 18) {
            return 1;
        } else
            return 0;
    }
}
