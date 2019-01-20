package githubrepositories.top.com.githubrepositories.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServerResponse {
    @SerializedName("items")
    public List<GithubRepositoryModel> githubRepositoryModelList;

}
