package githubrepositories.top.com.githubrepositories.view.ui.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import githubrepositories.top.com.githubrepositories.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, GithubRepositoryListFragment.newInstance())
                    .commitNow();
        }
    }
}
