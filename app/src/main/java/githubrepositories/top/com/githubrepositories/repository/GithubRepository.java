package githubrepositories.top.com.githubrepositories.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import githubrepositories.top.com.githubrepositories.model.GithubRepositoryModel;
import githubrepositories.top.com.githubrepositories.model.ServerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class GithubRepository {
    private NetworkService networkService;

    @Inject
    GithubRepository(NetworkService networkService) {
        this.networkService = networkService;
    }


    public LiveData<List<GithubRepositoryModel>> getTopGithubRepoList() {
        final MutableLiveData<List<GithubRepositoryModel>> data = new MutableLiveData<>();

        networkService.getGithubRepositoryList().enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(@NonNull Call<ServerResponse> call, @NonNull Response<ServerResponse> response) {
                if(response.body() != null){
                data.setValue(response.body().githubRepositoryModelList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ServerResponse> call, @NonNull Throwable t) {
                data.setValue(null);
            }

        });

        return data;
    }


    public LiveData<GithubRepositoryModel> getTopGithubRepoDetails(String user,String repoName) {
        final MutableLiveData<GithubRepositoryModel> data = new MutableLiveData<>();

        networkService.getGithubRepository(user,repoName).enqueue(new Callback<GithubRepositoryModel>() {
            @Override
            public void onResponse(@NonNull Call<GithubRepositoryModel> call, @NonNull Response<GithubRepositoryModel> response) {
                if(response.body() != null){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GithubRepositoryModel> call, @NonNull Throwable t) {
                data.setValue(null);
            }

        });

        return data;
    }
}
