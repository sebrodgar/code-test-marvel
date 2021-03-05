package com.srg.pruebamarvel.presentation.features.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import com.srg.pruebamarvel.data.features.characters.mappers.toDomain
import com.srg.pruebamarvel.domain.features.characters.CharactersRepository
import com.srg.pruebamarvel.domain.features.characters.GetCharacterListUseCase
import com.srg.pruebamarvel.utils.CharactersPageApiModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by sebrodgar on 05/03/2021.
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetCharactersListUseCaselTest {

    private lateinit var useCase: GetCharacterListUseCase

    @Mock
    private lateinit var repository: CharactersRepository

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        useCase = GetCharacterListUseCase(repository)
    }

    @Test
    fun `it should call service characters and success interactios`() = runBlocking {
        //given:
        val characterPage = CharactersPageApiModelFactory.createOne().toDomain()
        val limit = 20
        val offset = 0
        repository.stub { onBlocking { getCharacters(limit, offset) } doReturn characterPage }

        //when:
        val result = useCase.execute()

        //then:
        verify(repository).getCharacters(limit, offset)
        Assert.assertEquals(characterPage.results, result)
    }

    @Test
    fun `it should call service characters and error interactions`() = runBlocking {
        //given:
        val error = Throwable()
        val limit = 20
        val offset = 20
        repository.stub { onBlocking { getCharacters(limit, offset) } doAnswer { throw error } }

        //when:
        var result: Throwable? = null
        try {
            useCase.execute()
        } catch (t: Throwable) {
            result = t
        }
        //then:
        verify(repository).getCharacters(limit, offset)
        Assert.assertEquals(error, result)
    }
}