package dev.marcosfarias.pokedex.ui.moves

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.marcosfarias.pokedex.database.dao.MoveDAO
import dev.marcosfarias.pokedex.model.Move
import dev.marcosfarias.pokedex.model.MovesResponse
import dev.marcosfarias.pokedex.repository.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class MovesViewModel(private val moveDAO: MoveDAO, private val movesService: PokemonService): ViewModel() {

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        val call = movesService.getMove()
        call.enqueue(object : Callback<MovesResponse?> {
            override fun onResponse(
                call: Call<MovesResponse?>,
                response: Response<MovesResponse?>
            ) {
                response.body()?.let { data: MovesResponse ->
                    thread {
                        moveDAO.add(data.moves)
                    }
                }
            }

            override fun onFailure(call: Call<MovesResponse?>, t: Throwable) {

            }
        })
    }

    fun getListMove(): LiveData<List<Move>> {
        return moveDAO.all()
    }
}