package tranhung.banglo.tranhung.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import tranhung.banglo.tranhung.view.fragment.TabDe;
import tranhung.banglo.tranhung.view.fragment.TabLo;
import tranhung.banglo.tranhung.view.fragment.TabUser;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoofTabs) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TabUser tabuser = new TabUser();
                return tabuser;
            case 1:
                TabLo tablo = new TabLo();
                return tablo;
            case 2:
                TabDe tabde = new TabDe();
                return tabde;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
