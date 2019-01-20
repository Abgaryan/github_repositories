package githubrepositories.top.com.githubrepositories.view.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import githubrepositories.top.com.githubrepositories.R;
import githubrepositories.top.com.githubrepositories.dagger.Injectable;
import githubrepositories.top.com.githubrepositories.view_model.GithubRepositoryDetailsViewModel;

public class GithubRepositoryDetailsFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private GithubRepositoryDetailsViewModel mViewModel;

    public static GithubRepositoryDetailsFragment newInstance() {
        return new GithubRepositoryDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.github_repository_details_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this,viewModelFactory).get(GithubRepositoryDetailsViewModel.class);
    }

}
