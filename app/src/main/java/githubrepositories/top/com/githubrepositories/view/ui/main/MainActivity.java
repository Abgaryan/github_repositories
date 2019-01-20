package githubrepositories.top.com.githubrepositories.view.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import githubrepositories.top.com.githubrepositories.R;
import githubrepositories.top.com.githubrepositories.model.GithubRepositoryModel;
import githubrepositories.top.com.githubrepositories.view.ui.details.GithubRepositoryDetailsFragment;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

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

    /** Shows the  detail fragment */
    public void show(GithubRepositoryModel githubRepositoryModel) {
        GithubRepositoryDetailsFragment projectFragment = GithubRepositoryDetailsFragment.forGithubRepositoryModel(githubRepositoryModel);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("detail")
                .replace(R.id.container,
                        projectFragment, null).commit();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
