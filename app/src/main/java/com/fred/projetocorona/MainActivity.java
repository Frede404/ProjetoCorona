package com.fred.projetocorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Fragment fragmentActual = null;
    private int menuActual = R.menu.menu_main;
    private Menu menu;
    PerfilPessoa perfil = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PerfilAlterado(PerfilPessoa perfil){
        this.perfil = perfil;

        boolean mostraEditarEliminar = (perfil != null);

        menu.findItem(R.id.action_eliminar_perfil).setVisible(mostraEditarEliminar);
        menu.findItem(R.id.action_Perfil_to_Altera_Perfil).setVisible(mostraEditarEliminar);
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

        if(menuActual == R.menu.menu_about){
            if(geraOpcoesMenuAbout(id)) return true;
        }else if(menuActual == R.menu.menu_altera_perfil){
            if(geraOpcoesMenuAlteraPerfil(id)) return true;
        }else if(menuActual == R.menu.menu_estatisticas){
            if(geraOpcoesMenuEstatistica(id)) return true;
        }else if(menuActual == R.menu.menu_historico_registo){
            if(geraOpcoesMenuHistoricoRegisto(id)) return true;
        }else if(menuActual == R.menu.menu_historico_testes){
            if(geraOpcoesMenuHistoricoTestes(id)) return true;
        }else if(menuActual == R.menu.menu_informacao_perfil){
            if(geraOpcoesMenuInformacaoPerfil(id)) return true;
        }else if(menuActual == R.menu.menu_main){
            if(geraOpcoesMenuMain(id)) return true;
        }else if(menuActual == R.menu.menu_novo_perfil){
            if(geraOpcoesMenuNovoPerfil(id)) return true;
        }else if(menuActual == R.menu.menu_novo_teste){
            if(geraOpcoesMenuNovoTeste(id)) return true;
        }else if(menuActual == R.menu.menu_perfil){
            if(geraOpcoesMenuPerfil(id)) return true;
        }else if(menuActual == R.menu.menu_registo){
            if(geraOpcoesMenuRegisto(id)) return true;
        }else if(menuActual == R.menu.menu_teste){
            if(geraOpcoesMenuTeste(id)) return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean geraOpcoesMenuAbout(int id){
        Fragment_About fragmento_destino = (com.fred.projetocorona.Fragment_About) fragmentActual;

        if(id == R.id.action_About_to_Main){
            fragmento_destino.Voltar();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuAlteraPerfil(int id) {
        Fragment_Altera_Perfil fragmento_destino = (com.fred.projetocorona.Fragment_Altera_Perfil) fragmentActual;

        if(id == R.id.action_guarda_alteracao){
            fragmento_destino.Guardar();
            return true;
        }else if(id == R.id.action_Altera_Perfil_to_Perfil){
            fragmento_destino.Cancelar();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuEstatistica(int id) {
        Fragment_Estatistica fragmento_destino = (com.fred.projetocorona.Fragment_Estatistica) fragmentActual;

        if(id == R.id.action_Estatistica_to_Main){
            fragmento_destino.Voltar();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuHistoricoRegisto(int id) {
        Fragment_Historico_Registos fragmento_destino = (com.fred.projetocorona.Fragment_Historico_Registos) fragmentActual;

        if(id == R.id.action_Historico_Registos_to_Informacoes){
            fragmento_destino.Voltar();
            return true;
        }else if(id == R.id.action_Historico_Registos_to_Perfil){
            fragmento_destino.Home();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuHistoricoTestes(int id) {
        Fragment_Historico_Testes fragmento_destino = (com.fred.projetocorona.Fragment_Historico_Testes) fragmentActual;

        if(id == R.id.action_Historico_Testes_to_Teste){
            fragmento_destino.Voltar();
            return true;
        }else if(id == R.id.action_Historico_Testes_to_Perfil){
            fragmento_destino.Home();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuInformacaoPerfil(int id) {
        Fragment_Informacoes fragmento_destino = (com.fred.projetocorona.Fragment_Informacoes) fragmentActual;

        if(id == R.id.action_Informacoes_to_Perfil){
            fragmento_destino.Voltar();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuMain(int id){
        Fragment_Main fragmento_destino = (com.fred.projetocorona.Fragment_Main) fragmentActual;

        if(id == R.id.action_about){
            fragmento_destino.About();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuNovoPerfil(int id) {
        Fragment_Novo_perfil fragmento_destino = (com.fred.projetocorona.Fragment_Novo_perfil) fragmentActual;

        if(id == R.id.action_Novo_perfil_to_Informacoes){
            fragmento_destino.Guardar();
            return true;
        }else if(id == R.id.action_Novo_perfil_to_Perfil){
            fragmento_destino.Cancelar();
            return true;
        }else
        return false;
    }

    private boolean geraOpcoesMenuNovoTeste(int id) {
        Fragment_Novo_Teste fragmento_destino = (com.fred.projetocorona.Fragment_Novo_Teste) fragmentActual;

        if(id == R.id.action_Teste_to_Novo_Teste){
            fragmento_destino.Guardar();
            return true;
        }else if(id == R.id.action_Novo_Teste_to_Teste){
            fragmento_destino.Cancelar();
            return true;
        }else if(id == R.id.action_Novo_Teste_to_Perfil){
            fragmento_destino.Home();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuPerfil(int id) {
        Fragment_Perfil fragmento_destino = (com.fred.projetocorona.Fragment_Perfil) fragmentActual;

        if(id == R.id.action_Perfil_to_Main){
            fragmento_destino.Voltar();
            return true;
        }else if(id == R.id.action_Perfil_to_Novo_perfil){
            fragmento_destino.Adicionar();
            return true;
        }else if(id == R.id.action_Perfil_to_Altera_Perfil){
            fragmento_destino.Editar();
            return true;
        }else if(id == R.id.action_eliminar_perfil){
            fragmento_destino.Eliminar();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuRegisto(int id) {
        Fragment_Registo fragmento_destino = (com.fred.projetocorona.Fragment_Registo) fragmentActual;

        if(id == R.id.action_guarda_registo){
            fragmento_destino.Guardar();
            return true;
        }else if(id == R.id.action_Registo_to_Informacoes) {
            fragmento_destino.Cancelar();
            return true;
        }else if(id == R.id.action_Registo_to_Perfil){
            fragmento_destino.Home();
            return true;
        }
        return false;
    }

    private boolean geraOpcoesMenuTeste(int id) {
        Fragment_Teste fragmento_destino = (com.fred.projetocorona.Fragment_Teste) fragmentActual;

        if(id == R.id.action_Teste_to_Novo_Teste){
            fragmento_destino.Adicionar();
            return true;
        }else if(id == R.id.action_Teste_to_Informacoes){
            fragmento_destino.Voltar();
            return true;
        }else if(id == R.id.action_Teste_to_Perfil){
            fragmento_destino.Home();
            return true;
        }
        return false;
    }
}