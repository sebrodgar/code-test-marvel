package com.srg.pruebamarvel.data.features.characters.sources

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import com.srg.pruebamarvel.data.MarvelApiService
import com.srg.pruebamarvel.utils.MarvelResponseApiModelFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.random.Random

/**
 * Created by sebrodgar on 05/03/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class CharactersRemoteDataSourceImplTest {

    private lateinit var source: CharactersRemoteDataSourceImpl

    @Mock
    private lateinit var apiService: MarvelApiService

    @Before
    fun setUp() {
        source = CharactersRemoteDataSourceImpl(apiService)
    }

    @Test
    fun `it should call service characters and success interactios`() = runBlocking {
        //given:
        val marvelResponse = MarvelResponseApiModelFactory.createOne()
        val limit = 20
        val offset = 0
        apiService.stub { onBlocking { getCharacters(limit, offset) } doReturn marvelResponse }

        //when:
        val result = source.getCharacters(limit, offset)

        //then:
        verify(apiService).getCharacters(limit, offset)
        Assert.assertEquals(marvelResponse.data, result)
    }

    @Test
    fun `it should call service characters and error interactions`() = runBlocking {
        //given:
        val error = Throwable()
        val limit = 20
        val offset = 0
        apiService.stub { onBlocking { getCharacters(limit, offset) } doAnswer { throw error } }

        //when:
        var result: Throwable? = null
        try {
            source.getCharacters(limit, offset)
        } catch (t: Throwable) {
            result = t
        }
        //then:
        verify(apiService).getCharacters(limit, offset)
        Assert.assertEquals(error, result)
    }

    @Test
    fun `it should call service get character and success interactios`() = runBlocking {
        //given:
        val marvelResponse = MarvelResponseApiModelFactory.createOne()
        val characterId = Random.nextLong()
        apiService.stub { onBlocking { getCharacterItem(characterId) } doReturn marvelResponse }

        //when:
        val result = source.getCharacterItem(characterId)

        //then:
        verify(apiService).getCharacterItem(characterId)
        Assert.assertEquals(marvelResponse.data.results[0], result)
    }

    @Test
    fun `it should call service get character and error interactions`() = runBlocking {
        //given:
        val error = Throwable()
        val characterId = Random.nextLong()
        apiService.stub { onBlocking { getCharacterItem(characterId) } doAnswer { throw error } }

        //when:
        var result: Throwable? = null
        try {
            source.getCharacterItem(characterId)
        } catch (t: Throwable) {
            result = t
        }
        //then:
        verify(apiService).getCharacterItem(characterId)
        Assert.assertEquals(error, result)
    }
}