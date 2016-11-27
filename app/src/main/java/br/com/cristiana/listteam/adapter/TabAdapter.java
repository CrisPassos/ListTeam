package br.com.cristiana.listteam.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.cristiana.listteam.fragments.TeamFragments;

/**
 * Created by Cristiana on 27/11/2016.
 */

public class TabAdapter  extends FragmentStatePagerAdapter {

    public static final int TOTAL_TABS = 1;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    //retorno do gragment que será exibido
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();

        Fragment f = new TeamFragments();
        f.setArguments(bundle);

        return f;
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}
