package githubrepositories.top.com.githubrepositories.view_model;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import githubrepositories.top.com.githubrepositories.model.GithubRepositoryModel;
import githubrepositories.top.com.githubrepositories.repository.GithubRepository;

public class GithubRepositoryListViewModel extends AndroidViewModel {
    private final LiveData<List<GithubRepositoryModel>>  githubRepositoryListObservable;
    @Inject
    public GithubRepositoryListViewModel(@NonNull GithubRepository githubRepository, @NonNull Application application) {
        super(application);
        githubRepositoryListObservable = githubRepository.getTopGithubRepoList();
    }


    /**
     * Expose the LiveData <GithubRepositoryModels result so the UI can observe it.
     */
    public LiveData<List<GithubRepositoryModel>> getGithubRepositoryListObservable() {
        return githubRepositoryListObservable;
    }

}
