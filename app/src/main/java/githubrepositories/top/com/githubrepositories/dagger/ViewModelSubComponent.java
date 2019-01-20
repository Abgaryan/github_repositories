package githubrepositories.top.com.githubrepositories.dagger;

import dagger.Subcomponent;
import githubrepositories.top.com.githubrepositories.view_model.GithubRepositoryDetailsViewModel;
import githubrepositories.top.com.githubrepositories.view_model.GithubRepositoryListViewModel;

/**
 * A sub component to create ViewModels. It is called by the
 * {@link githubrepositories.top.com.githubrepositories.view_model}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    GithubRepositoryDetailsViewModel githubRepositoryDetailsViewModel();
    GithubRepositoryListViewModel githubRepositoryListViewModel();
}
