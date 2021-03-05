package com.srg.pruebamarvel.domain.features.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import com.srg.pruebamarvel.common.errors.APIErrorCode
import com.srg.pruebamarvel.common.errors.NetworkException
import com.srg.pruebamarvel.common.util.StateData
import com.srg.pruebamarvel.data.features.characters.mappers.toDomain
import com.srg.pruebamarvel.presentation.features.characters.details.CharacterDetailsViewModel
import com.srg.pruebamarvel.utils.CharacterApiModelFactory
import com.srg.pruebamarvel.utils.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.random.Random

/**
 * Created by sebrodgar on 05/03/2021.
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharacterDetailsViewModelTest {

    private lateinit var viewModel: CharacterDetailsViewModel

    @Mock
    private lateinit var useCase: GetCharacterUseCase

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = CharacterDetailsViewModel(useCase, coroutineTestRule.testCoroutineDispatcher)
    }

    @Test
    fun `it should call service get character use case and success interactios`() =
        coroutineTestRule.runBlockingTest {
            //given:
            val character = CharacterApiModelFactory.createOne().toDomain()
            val characterId = Random.nextLong()
            val params = GetCharacterUseCase.Params(characterId)
            useCase.stub { onBlocking { execute(params) } doReturn character }

            viewModel.character.observeForever(Observer {
                Assert.assertEquals(it is StateData.Content || it is StateData.Loading, true)
            })
            //when:
            viewModel.getCharacter(characterId)

            //then:
            verify(useCase).execute(params)

        }

    @Test
    fun `it should call service get character use case and error interactions`() =
        coroutineTestRule.runBlockingTest {
            //given:
            val error = NetworkException(409, APIErrorCode.CHARACTER_NOT_FOUND)
            val characterId = Random.nextLong()
            val params = GetCharacterUseCase.Params(characterId)
            useCase.stub { onBlocking { execute(params) } doAnswer { throw error } }

            viewModel.character.observeForever(Observer {
                Assert.assertEquals(it is StateData.Error || it is StateData.Loading, true)
            })

            //when:
            viewModel.getCharacter(characterId)

            //then:
            verify(useCase).execute(params)

        }
}