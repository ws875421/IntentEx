package idv.david.intentex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etTeam, etPlayer, etSalary;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        etTeam = findViewById(R.id.etTeam);
        etPlayer = findViewById(R.id.etPlayer);
        etSalary = findViewById(R.id.etSalary);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();

                // 傳送基本資料並對使用者輸入資料做例外處理
                try {
                    String team = etTeam.getText().toString().trim();
                    String player = etPlayer.getText().toString().trim();
                    double salary = Double.parseDouble(etSalary.getText().toString().trim());

                    if (team.isEmpty() || player.isEmpty()) {
                        throw new Exception();
                    }
                    bundle.putString("team", team);
                    bundle.putString("player", player);
                    bundle.putDouble("salary", salary);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, getString(R.string.inputError), Toast.LENGTH_SHORT).show();
                    return;
                }

                // 傳送序列化物件
//                int id = 1;
//                int logo = R.drawable.p23;
//                String name = "洛杉磯道奇";
//                Team team = new Team(id, logo, name);
//                bundle.putSerializable("teamObj", team);
//
//                intent.putExtras(bundle);
//                startActivity(intent);

            }
        });
    }
}
