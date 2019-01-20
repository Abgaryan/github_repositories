package githubrepositories.top.com.githubrepositories.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import githubrepositories.top.com.githubrepositories.view.ui.details.GithubRepositoryDetailsFragment;
import githubrepositories.top.com.githubrepositories.view.ui.main.GithubRepositoryListFragment;

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract GithubRepositoryDetailsFragment contributeGithubRepositoryDetailsFragment();

    @ContributesAndroidInjector
    abstract GithubRepositoryListFragment contributeGithubRepositoryListFragment();
}
