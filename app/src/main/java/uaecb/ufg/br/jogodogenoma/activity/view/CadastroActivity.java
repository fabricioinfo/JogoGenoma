package uaecb.ufg.br.jogodogenoma.activity.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uaecb.ufg.br.jogodogenoma.R;
import uaecb.ufg.br.jogodogenoma.beans.ConfiguracaoFireBase;

public class CadastroActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public String registraUsuario(String email, String senha, String verificaSenha) {
        //variavel para tela de espera e progresso de tarefas
        ProgressDialog pd = new ProgressDialog(this);
        //fazer teste de verificação de campo vazio
        if (TextUtils.isEmpty(email)) {
            return "O campo e-mail está vazio verifique-o";
        } else if (TextUtils.isEmpty(senha)) {
            return "O campo senha está vazio verifique-o";
        }
        //verificar se as senhas são idênticas
        else if (senha.equals(verificaSenha)) {
            return "As senhas são diferentes, verifique-os";
        } else {
            pd.setMessage("Aguarde cadastrando usuários");
            pd.show();
            //criando usuarios por e-mail a senha
            auth = ConfiguracaoFireBase.getFirebaseAuth();
            auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //checar se foi cadastrado corretamente
                    if (task.isSuccessful()) {
                        finish();
                    } else {
                        Toast.makeText(getBaseContext(), "Erro ao cadastrar tente mais tarde", Toast.LENGTH_LONG).show();
                    }
                }
            });
            pd.dismiss();
            return "Usuário Cadastrado com Sucesso";
        }
    }
}
