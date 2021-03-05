package com.srg.pruebamarvel.data.features.characters

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import com.srg.pruebamarvel.data.features.characters.mappers.toDomain
import com.srg.pruebamarvel.data.features.characters.sources.CharactersDataSource
import com.srg.pruebamarvel.utils.CharacterApiModelFactory
import com.srg.pruebamarvel.utils.CharactersPageApiModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharactersRepositoryImplTest {

    private lateinit var repository: CharactersRepositoryImpl

    @Mock
    private lateinit var dataSource: CharactersDataSource

    @Before
    fun setUp() {
        repository = CharactersRepositoryImpl(dataSource)
    }

    @Test
    fun `it should call service characters and success interactios`() = runBlocking {
        //given:
        val characterPage = CharactersPageApiModelFactory.createOne()
        val limit = 20
        val offset = 0
        dataSource.stub { onBlocking { getCharacters(limit, offset) } doReturn characterPage }

        //when:
        val result = repository.getCharacters(limit, offset)

        //then:
        verify(dataSource).getCharacters(limit, offset)
        Assert.assertEquals(characterPage.toDomain(), result)
    }

    @Test
    fun `it should call service characters and error interactions`() = runBlocking {
        //given:
        val error = Throwable()
        val limit = 20
        val offset = 0
        dataSource.stub { onBlocking { getCharacters(limit, offset) } doAnswer { throw error } }

        //when:
        var result: Throwable? = null
        try {
            repository.getCharacters(limit, offset)
        } catch (t: Throwable) {
            result = t
        }
        //then:
        verify(dataSource).getCharacters(limit, offset)
        Assert.assertEquals(error, result)
    }

    @Test
    fun `it should call service get character and success interactios`() = runBlocking {
        //given:
        val character = CharacterApiModelFactory.createOne()
        val characterId = Random.nextLong()
        dataSource.stub { onBlocking { getCharacterItem(characterId) } doReturn character }

        //when:
        val result = repository.getCharacterItem(characterId)

        //then:
        verify(dataSource).getCharacterItem(characterId)
        Assert.assertEquals(character.toDomain(), result)
    }

    @Test
    fun `it should call service get character and error interactions`() = runBlocking {
        //given:
        val error = Throwable()
        val characterId = Random.nextLong()
        dataSource.stub { onBlocking { getCharacterItem(characterId) } doAnswer { throw error } }

        //when:
        var result: Throwable? = null
        try {
            repository.getCharacterItem(characterId)
        } catch (t: Throwable) {
            result = t
        }
        //then:
        verify(dataSource).getCharacterItem(characterId)
        Assert.assertEquals(error, result)
    }
}