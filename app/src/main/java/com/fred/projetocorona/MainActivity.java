package com.fred.projetocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Fragment fragmentActual = null;
    private int menuActual = R.menu.menu_main;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setFragmentActual(Fragment fragmentActual){
        this.fragmentActual = fragmentActual;
    }

    public void setMenuActual(int menuActual){
        if(menuActual != this.menuActual){
            this.menuActual = menuActual;
            invalidateOptionsMenu();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menuActual, menu);

        this.menu = menu;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(menuActual == R.menu.menu_main){
            if(geraOpcoesMenuMain(id)) return true;
        }else if(menuActual == R.menu.menu_about){
            if(geraOpcoesMenuAbout(id)) return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean geraOpcoesMenuMain(int id){
        Fragment_Main fragment_main = (com.fred.projetocorona.Fragment_Main) fragmentActual;

        if(id == R.id.action_about){
            fragment_main.About();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuAbout(int id){
        Fragment_About fragment_about = (com.fred.projetocorona.Fragment_About) fragmentActual;

        if(id == R.id.action_About_to_Main){
            fragment_about.Voltar();
            return true;
        }
        return false;
    }
}