package dev.marcosfarias.pokedex.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.marcosfarias.pokedex.database.dao.ItemDAO
import dev.marcosfarias.pokedex.model.Item
import dev.marcosfarias.pokedex.model.ItemsResponse
import dev.marcosfarias.pokedex.repository.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class ItemsViewModel(private val itemDAO: ItemDAO, private val itemsService: PokemonService): ViewModel() {

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        val call = itemsService.getItem()
        call.enqueue(object : Callback<ItemsResponse?> {
            override fun onResponse(
                call: Call<ItemsResponse?>,
                response: Response<ItemsResponse?>
            ) {
                response.body()?.let { data: ItemsResponse ->
                    thread {
                        itemDAO.add(data.items)
                    }
                }
            }

            override fun onFailure(call: Call<ItemsResponse?>, t: Throwable) {

            }
        })
    }

    fun getListItem(): LiveData<List<Item>> {
        return itemDAO.all()
    }
}