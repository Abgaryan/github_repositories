package githubrepositories.top.com.githubrepositories.view_model;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import githubrepositories.top.com.githubrepositories.model.GithubRepositoryModel;
import githubrepositories.top.com.githubrepositories.repository.GithubRepository;

public class GithubRepositoryDetailsViewModel extends AndroidViewModel {
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private static final MutableLiveData ABSENT = new MutableLiveData();
    private final LiveData<GithubRepositoryModel> githubRepositoryModelObservable;
    private final MutableLiveData<GithubRepositoryModel> githubRepositoryModel ;

    public ObservableField<GithubRepositoryModel> githubRepositoryModelObservableField = new ObservableField<>();

    @Inject
    public GithubRepositoryDetailsViewModel(@NonNull GithubRepository githubRepository, @NonNull Application application) {
        super(application);
        this.githubRepositoryModel=new MutableLiveData<>();

        githubRepositoryModelObservable = Transformations.switchMap(githubRepositoryModel, input -> {
            if (input == null) {
                return ABSENT;
            }

            return githubRepository.getTopGithubRepoDetails( githubRepositoryModel.getValue().owner.login, githubRepositoryModel.getValue().name);
        });
    }



    public LiveData<GithubRepositoryModel> getObservableGithubRepositoryModel() {
        return githubRepositoryModelObservable;
    }

    public void setGithubRepositoryModel(GithubRepositoryModel githubRepositoryModel) {
        this.githubRepositoryModelObservableField.set(githubRepositoryModel);
    }

    public void setModel(GithubRepositoryModel githubRepositoryModel) {
        this.githubRepositoryModel.setValue(githubRepositoryModel);
    }

}
