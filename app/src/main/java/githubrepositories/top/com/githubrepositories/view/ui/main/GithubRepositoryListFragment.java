package githubrepositories.top.com.githubrepositories.view.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import githubrepositories.top.com.githubrepositories.R;
import githubrepositories.top.com.githubrepositories.dagger.Injectable;
import githubrepositories.top.com.githubrepositories.databinding.GithubRepositoryListFragmentBinding;
import githubrepositories.top.com.githubrepositories.view.adapter.GithubRepositoryAdapter;
import githubrepositories.top.com.githubrepositories.view.callback.GithubRepositoryModelClickCallback;
import githubrepositories.top.com.githubrepositories.view_model.GithubRepositoryListViewModel;

public class GithubRepositoryListFragment extends Fragment  implements Injectable {


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private GithubRepositoryListViewModel mViewModel;
    private GithubRepositoryAdapter githubRepositoryAdapter;
    private GithubRepositoryListFragmentBinding binding;

    private final GithubRepositoryModelClickCallback githubRepositoryModelClickCallback = githubRepositoryModel -> {

    };




    static GithubRepositoryListFragment newInstance() {
        return new GithubRepositoryListFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.github_repository_list_fragment, container,false);

        githubRepositoryAdapter= new GithubRepositoryAdapter(githubRepositoryModelClickCallback);
        binding.githubRepoList.setAdapter(githubRepositoryAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(GithubRepositoryListViewModel.class);
        observeViewModel();
    }

    private void observeViewModel() {
        // Update the list when the data changes
        mViewModel.getGithubRepositoryListObservable().observe(this, githubRepositoryModelList -> {
            if (githubRepositoryModelList != null) {
                binding.setIsLoading(false);
                githubRepositoryAdapter.setGithubRepositoryModelList(githubRepositoryModelList);
            }
        });
    }





}
