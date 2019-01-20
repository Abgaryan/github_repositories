package githubrepositories.top.com.githubrepositories.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import githubrepositories.top.com.githubrepositories.R;
import githubrepositories.top.com.githubrepositories.databinding.GithubRepositoryListItemBinding;
import githubrepositories.top.com.githubrepositories.model.GithubRepositoryModel;
import githubrepositories.top.com.githubrepositories.view.callback.GithubRepositoryModelClickCallback;

public class GithubRepositoryAdapter extends RecyclerView.Adapter<GithubRepositoryAdapter.GithubRepositoryViewHolder> {

    private List<? extends GithubRepositoryModel> mGithubRepositoryModelList;

    @Nullable
    private final GithubRepositoryModelClickCallback githubRepositoryModelClickCallback;

    public GithubRepositoryAdapter(@Nullable GithubRepositoryModelClickCallback githubRepositoryModelClickCallback) {
        this.githubRepositoryModelClickCallback = githubRepositoryModelClickCallback;
    }

    public void setGithubRepositoryModelList(final List<? extends GithubRepositoryModel> githubRepositoryModelList) {
        if (this.mGithubRepositoryModelList == null) {
            this.mGithubRepositoryModelList = githubRepositoryModelList;
            notifyItemRangeInserted(0, githubRepositoryModelList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return GithubRepositoryAdapter.this.mGithubRepositoryModelList.size();
                }

                @Override
                public int getNewListSize() {
                    return githubRepositoryModelList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return GithubRepositoryAdapter.this.mGithubRepositoryModelList.get(oldItemPosition).id ==
                            githubRepositoryModelList.get(newItemPosition).id;
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    GithubRepositoryModel githubRepositoryModel = githubRepositoryModelList.get(newItemPosition);
                    GithubRepositoryModel old = githubRepositoryModelList.get(oldItemPosition);
                    return githubRepositoryModel.id == old.id
                            && Objects.equals(githubRepositoryModel.git_url, old.git_url);
                }
            });
            this.mGithubRepositoryModelList = githubRepositoryModelList;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public GithubRepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GithubRepositoryListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.github_repository_list_item,
                        parent, false);

        binding.setCallback(githubRepositoryModelClickCallback);

        return new GithubRepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubRepositoryViewHolder holder, int position) {
        holder.binding.setGithubRepositoryModel(mGithubRepositoryModelList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mGithubRepositoryModelList == null ? 0 : mGithubRepositoryModelList.size();
    }

    static class GithubRepositoryViewHolder extends RecyclerView.ViewHolder {

        final GithubRepositoryListItemBinding binding;

        GithubRepositoryViewHolder(GithubRepositoryListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
