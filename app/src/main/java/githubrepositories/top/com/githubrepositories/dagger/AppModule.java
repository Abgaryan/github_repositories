package githubrepositories.top.com.githubrepositories.dagger;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import githubrepositories.top.com.githubrepositories.repository.NetworkService;
import githubrepositories.top.com.githubrepositories.view_model.ViewModelFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton @Provides
    NetworkService provideNetworkService() {
        return new Retrofit.Builder()
                .baseUrl(NetworkService.API_GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }
}
