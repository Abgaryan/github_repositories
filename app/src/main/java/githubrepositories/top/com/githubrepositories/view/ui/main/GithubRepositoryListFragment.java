package githubrepositories.top.com.githubrepositories.view.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import githubrepositories.top.com.githubrepositories.R;
import githubrepositories.top.com.githubrepositories.view_model.GithubRepositoryListViewModel;

public class GithubRepositoryListFragment extends Fragment {

    private GithubRepositoryListViewModel mViewModel;

    static GithubRepositoryListFragment newInstance() {
        return new GithubRepositoryListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.github_repository_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GithubRepositoryListViewModel.class);
        // TODO: Use the ViewModel
    }

}
