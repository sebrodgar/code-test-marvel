package com.srg.pruebamarvel.data.features.characters

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import com.srg.pruebamarvel.data.features.characters.mappers.toDomain
import com.srg.pruebamarvel.domain.features.characters.CharactersRepository
import com.srg.pruebamarvel.domain.features.characters.GetCharacterUseCase
import com.srg.pruebamarvel.utils.CharacterApiModelFactory
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
class GetCharactersUseCaselTest {

    private lateinit var useCase: GetCharacterUseCase

    @Mock
    private lateinit var repository: CharactersRepository

    @Before
    fun setUp() {
        useCase = GetCharacterUseCase(repository)
    }

    @Test
    fun `it should call service get character use case and success interactios`() = runBlocking {
        //given:
        val character = CharacterApiModelFactory.createOne().toDomain()
        val characterId = Random.nextLong()
        repository.stub { onBlocking { getCharacterItem(characterId) } doReturn character }

        //when:
        val result = repository.getCharacterItem(characterId)

        //then:
        verify(repository).getCharacterItem(characterId)
        Assert.assertEquals(character, result)
    }

    @Test
    fun `it should call service get character use case and error interactions`() = runBlocking {
        //given:
        val error = Throwable()
        val characterId = Random.nextLong()
        repository.stub { onBlocking { getCharacterItem(characterId) } doAnswer { throw error } }

        //when:
        var result: Throwable? = null
        try {
            repository.getCharacterItem(characterId)
        } catch (t: Throwable) {
            result = t
        }
        //then:
        verify(repository).getCharacterItem(characterId)
        Assert.assertEquals(error, result)
    }
}