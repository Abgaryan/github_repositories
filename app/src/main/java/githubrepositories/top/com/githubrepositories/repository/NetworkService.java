package githubrepositories.top.com.githubrepositories.repository;

import java.util.List;
import githubrepositories.top.com.githubrepositories.model.GithubRepository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkService {
    String API_GITHUB_BASE_URL = "https://api.github.com/";

    @GET("search/repositories?q=stars:>0&sort=stars&order=desc")
    Call<List<GithubRepository>> getGithubRepositoryList();

    @GET("/repos/{full_name}")
    Call<GithubRepository> getGithubRepository(@Path("full_name") String fullName);
}