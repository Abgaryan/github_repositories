package githubrepositories.top.com.githubrepositories.dagger;

import githubrepositories.top.com.githubrepositories.view.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
