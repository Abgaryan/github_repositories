package githubrepositories.top.com.githubrepositories.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GithubRepository {
    private NetworkService networkService;

    @Inject
    GithubRepository(NetworkService networkService) {
        this.networkService = networkService;
    }



}
