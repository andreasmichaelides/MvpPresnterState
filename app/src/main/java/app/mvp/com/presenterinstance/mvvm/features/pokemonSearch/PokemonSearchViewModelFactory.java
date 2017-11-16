package app.mvp.com.presenterinstance.mvvm.features.pokemonSearch;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase.ShouldRestoreSearch;
import app.mvp.com.presenterinstance.mvvm.features.pokemonSearch.usecase.SearchPokemon;

/**
 * Created by andreas on 15/11/17.
 */

public class PokemonSearchViewModelFactory implements ViewModelProvider.Factory {

    private final SearchPokemon searchPokemon;
    private final ShouldRestoreSearch shouldRestoreSearch;

    PokemonSearchViewModelFactory(SearchPokemon searchPokemon, ShouldRestoreSearch shouldRestoreSearch) {
        this.searchPokemon = searchPokemon;
        this.shouldRestoreSearch = shouldRestoreSearch;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PokemonSearchViewModel.class)) {
            return (T) new PokemonSearchViewModel(searchPokemon, shouldRestoreSearch);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
