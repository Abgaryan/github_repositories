package githubrepositories.top.com.githubrepositories.view.ui.details;

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
import githubrepositories.top.com.githubrepositories.databinding.GithubRepositoryDetailsFragmentBinding;
import githubrepositories.top.com.githubrepositories.model.GithubRepositoryModel;
import githubrepositories.top.com.githubrepositories.view_model.GithubRepositoryDetailsViewModel;

public class GithubRepositoryDetailsFragment extends Fragment implements Injectable {
    private static final String KEY_REPOSITORY_MODEL = "repository_model";
    private GithubRepositoryDetailsFragmentBinding binding;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private GithubRepositoryDetailsViewModel mViewModel;

    public static GithubRepositoryDetailsFragment newInstance() {
        return new GithubRepositoryDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.github_repository_details_fragment, container, false);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this,viewModelFactory).get(GithubRepositoryDetailsViewModel.class);
        mViewModel.setModel(getArguments().getParcelable(KEY_REPOSITORY_MODEL));
        binding.setGithubRepositoryDetailsViewModel(mViewModel);
        binding.setIsLoading(true);

        observeViewModel();
    }

    private void observeViewModel() {
        // Observe project data
        mViewModel.getObservableGithubRepositoryModel().observe(this, githubRepositoryModel -> {
            if (githubRepositoryModel != null) {
                binding.setIsLoading(false);
                mViewModel.setGithubRepositoryModel(githubRepositoryModel);
            }
        });
    }

    /** Creates project fragment for specific repoName*/
    public static GithubRepositoryDetailsFragment forGithubRepositoryModel(GithubRepositoryModel githubRepositoryModel) {
        GithubRepositoryDetailsFragment fragment = GithubRepositoryDetailsFragment.newInstance();
        Bundle args = new Bundle();
        args.putParcelable(KEY_REPOSITORY_MODEL, githubRepositoryModel);
        fragment.setArguments(args);

        return fragment;
    }



}
