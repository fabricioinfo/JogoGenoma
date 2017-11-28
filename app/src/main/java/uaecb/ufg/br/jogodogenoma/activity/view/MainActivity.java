package uaecb.ufg.br.jogodogenoma.activity.view;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.support.design.widget.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import uaecb.ufg.br.jogodogenoma.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Button btn_enviar;
    private DrawerLayout sidebar;
    private ActionBarDrawerToggle togglebar;
    private Menu menu;
    private NavigationView nav_sidebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        sidebar = (DrawerLayout) findViewById(R.id.drawer_layout);
        togglebar = new ActionBarDrawerToggle(this,sidebar,R.string.open,R.string.close);
        menu = (Menu) findViewById(R.id.navigation_menu);
       // menu.add("Teste");
        sidebar.addDrawerListener(togglebar);
        togglebar.syncState();
        nav_sidebar = (NavigationView) findViewById(R.id.nav_sidebar);
       nav_sidebar.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(togglebar.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int selected = item.getItemId();

        if(selected == R.id.nav_login){
            Toast.makeText(getBaseContext(),"Funcionou Aorta!!!",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
