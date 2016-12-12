/*
 * Copyright (C) 2014 Arpit Khurana <arpitkh96@gmail.com>, Vishal Nehra <vishalmeham2@gmail.com>
 *
 * This file is part of Amaze File Manager.
 *
 * Amaze File Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.igniva.filemanager.fragments.preference_fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.igniva.filemanager.BuildConfig;
import com.igniva.filemanager.R;
import com.igniva.filemanager.activities.AboutActivity;
import com.igniva.filemanager.activities.BaseActivity;
import com.igniva.filemanager.ui.views.CheckBx;
import com.igniva.filemanager.utils.Futils;
import com.igniva.filemanager.utils.PreferenceUtils;
import com.stericson.RootTools.RootTools;

public class Preffrag extends PreferenceFragment{

    private static final CharSequence PREFERENCE_KEY_ABOUT = "about";

    int theme;
    SharedPreferences sharedPref;
    String url="https://play.google.com/store/apps/details?id=com.amaze.filemanager";
    String appPackageName = "com.amaze.filemanager";
    //CheckBx gplus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceUtils.reset();
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        final int th1 = Integer.parseInt(sharedPref.getString("theme", "0"));
        theme = th1==2 ? PreferenceUtils.hourOfDay() : th1;

        findPreference("columns").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                final String[] sort = getResources().getStringArray(R.array.columns);
                MaterialDialog.Builder a = new MaterialDialog.Builder(getActivity());
                if(theme==1)a.theme(Theme.DARK);
                a.title(R.string.gridcolumnno);
                int current = Integer.parseInt(sharedPref.getString("columns", "-1"));
                current=current==-1?0:current;
                if(current!=0)current=current-1;
                a.items(sort).itemsCallbackSingleChoice(current, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        sharedPref.edit().putString("columns", "" + (which!=0?sort[which]:""+-1)).commit();
                        dialog.dismiss();
                        return true;
                    }
                });
                a.build().show();
                return true;
            }
        });

//        findPreference("theme").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            @Override
//            public boolean onPreferenceClick(Preference preference) {
//                String[] sort = getResources().getStringArray(R.array.theme);
//                int current = Integer.parseInt(sharedPref.getString("theme", "0"));
//                MaterialDialog.Builder a = new MaterialDialog.Builder(getActivity());
//                if(theme==1)a.theme(Theme.DARK);
//                a.items(sort).itemsCallbackSingleChoice(current, new MaterialDialog.ListCallbackSingleChoice() {
//                    @Override
//                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                        sharedPref.edit().putString("theme", "" + which).commit();
//                        dialog.dismiss();
//                        restartPC(getActivity());
//                        return true;
//                    }
//                });
//                a.title(R.string.theme);
//                a.build().show();
//                return true;
//            }
//        });
//        findPreference("colors").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            @Override
//            public boolean onPreferenceClick(Preference preference) {
//                ((com.igniva.filemanager.activities.Preferences) getActivity()).selectItem(1);
//                return true;
//            }
//        });



        final CheckBx rootmode = (CheckBx) findPreference("rootmode");
        rootmode.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                boolean b = sharedPref.getBoolean("rootmode", false);
                if (b) {
                    if (RootTools.isAccessGiven()) {
                        rootmode.setChecked(true);
                    
                    } else {  rootmode.setChecked(false);
				
                        Toast.makeText(getActivity(), getResources().getString(R.string.rootfailure), Toast.LENGTH_LONG).show();
                    }
                } else {
                    rootmode.setChecked(false);
                    
                }


                return false;
            }
        });

        // Feedback
        Preference preference3 = (Preference) findPreference("feedback");
        preference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
               // Toast.makeText(getActivity(),"more free apps clicked",Toast.LENGTH_SHORT).show();
//                final String appPackageName = "com.amaze.filemanager"; // getPackageName() from Context or Activity object
               // Toast.makeText(getActivity(),""+appPackageName,Toast.LENGTH_SHORT).show();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:"+"Team+Amaze")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    Toast.makeText(getActivity(),"Exception",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                        "mailto","vishalmeham2@gmail.com", null));
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback : Amaze File Manager");
//                startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.more_freeapps)));
                return false;
            }
        });

        // About
        Preference aboutPreference = findPreference(PREFERENCE_KEY_ABOUT);
        aboutPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
              //  Toast.makeText(getActivity(),"Rate us clicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                //startActivity(new Intent(getActivity(), AboutActivity.class));
                return false;
            }
        });

        // G+
//        gplus = (CheckBx) findPreference("plus_pic");
//        gplus.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//            @Override
//            public boolean onPreferenceClick(Preference preference) {
//                if(gplus.isChecked()){
//                    boolean b=checkGplusPermission();
//                    if(!b)requestGplusPermission();
//                }
//                return false;
//            }
//        });
//        if (BuildConfig.IS_VERSION_FDROID)
//            gplus.setEnabled(false);

        // Colored navigation bar
    }

    public static void restartPC(final Activity activity) {
        if (activity == null)
            return;
        final int enter_anim = android.R.anim.fade_in;
        final int exit_anim = android.R.anim.fade_out;
        activity.overridePendingTransition(enter_anim, exit_anim);
        activity.finish();
        activity.overridePendingTransition(enter_anim, exit_anim);
        activity.startActivity(activity.getIntent());
    }

    public void invalidateGplus(){
        boolean a=checkGplusPermission();
       // if(!a)gplus.setChecked(false);
    }
    public boolean checkGplusPermission() {
        // Verify that all required contact permissions have been granted.
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.GET_ACCOUNTS)
                != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }
    private void requestGplusPermission() {
        final String[] PERMISSIONS = {Manifest.permission.GET_ACCOUNTS,
                Manifest.permission.INTERNET};
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.GET_ACCOUNTS) || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.INTERNET)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example, if the request has been denied previously.

            String fab_skin = (BaseActivity.accentSkin);
            final MaterialDialog materialDialog=new Futils().showBasicDialog(getActivity(),fab_skin,theme, new String[]{getResources().getString(R.string.grantgplus), getResources().getString(R.string.grantper), getResources().getString(R.string.grant), getResources().getString(R.string.cancel),null});
            materialDialog.getActionButton(DialogAction.POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat
                            .requestPermissions(getActivity(),PERMISSIONS, 66);
                    materialDialog.dismiss();
                }
            });
            materialDialog.getActionButton(DialogAction.NEGATIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
            materialDialog.setCancelable(false);
            materialDialog.show();

        } else {
            // Contact permissions have not been granted yet. Request them directly.
            ActivityCompat
                    .requestPermissions(getActivity(), PERMISSIONS, 66);
        }
    }}