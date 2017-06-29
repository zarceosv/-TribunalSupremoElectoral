package com.tesis.tse.tse_instructivojrv;

import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityManual extends AppCompatActivity {
    ViewPager mViewPager;
    DAO myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        // Crear base de datos
        crearInstanciaDB();
        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);
        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }

    public void crearInstanciaDB(){
        try{
            myDb = new DAO(this);
            myDb.createDataBase();
        }catch (Exception e){

        }
    }

    /**
     * Crea una instancia del view pager con los datos
     * predeterminados
     *
     * @param viewPager Nueva instancia
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        try{
            Cursor res = myDb.consultaSQL("SELECT f.fase_id, f.nombre_tab FROM tse_fase f INNER JOIN tse_actividad a ON f.fase_id = a.fase_id GROUP BY f.fase_id");
            if(res.getCount() == 0){
                return;
            }
            while (res.moveToNext()){
                ActividadGridFragment myGridFragment = ActividadGridFragment.newInstance(Integer.parseInt(res.getString(0)));
                myGridFragment.setContexto(this);
                adapter.addFragment(myGridFragment, res.getString(1));
            }
            res.close();
        }catch (Exception e){
            Log.e("Error",e.toString());
        }
        viewPager.setAdapter(adapter);
    }

    /**
     * Un {@link FragmentPagerAdapter} que gestiona las secciones, fragmentos y
     * títulos de las pestañas
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
