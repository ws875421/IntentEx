package idv.david.intentex;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvTeam, tvPlayer, tvSalary, tvId, tvName;
    private ImageView ivLogo;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViews();
        showResult();
    }

    private void findViews() {
        tvTeam = findViewById(R.id.tvTeam);
        tvPlayer = findViewById(R.id.tvPlayer);
        tvSalary = findViewById(R.id.tvSalary);
        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        ivLogo = findViewById(R.id.ivLogo);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.this.finish();
            }
        });
    }

    private void showResult() {
        Bundle bundle = getIntent().getExtras();
        String team = bundle.getString("team");
        String player = bundle.getString("player");
        double salary = bundle.getDouble("salary");
        Team teamObj = (Team) bundle.getSerializable("teamObj");

        tvTeam.setText("輸入球隊名稱： " + team);
        tvPlayer.setText("輸入球員名稱： " + player);
        tvSalary.setText("輸入球員薪水： " + salary);

        tvId.setText("物件ID： " + teamObj.getId());
        tvName.setText("物件name：" + teamObj.getName());
        ivLogo.setImageResource(teamObj.getLogo());
    }
}
