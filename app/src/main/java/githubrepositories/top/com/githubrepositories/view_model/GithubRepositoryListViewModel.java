package githubrepositories.top.com.githubrepositories.view_model;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import githubrepositories.top.com.githubrepositories.repository.GithubRepository;

public class GithubRepositoryListViewModel extends AndroidViewModel {

    @Inject
    public GithubRepositoryListViewModel(@NonNull GithubRepository githubRepository, @NonNull Application application) {
        super(application);
    }

}
