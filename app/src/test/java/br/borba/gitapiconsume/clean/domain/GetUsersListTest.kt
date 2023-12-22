package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.data.repository.GetUsersException
import br.borba.gitapiconsume.clean.data.repository.MainRepository
import br.borba.gitapiconsume.clean.domain.GetUsersList
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetUsersListTest {

    private val repository = mockk<MainRepository>()
    private val getUsers = GetUsersList(repository)

    @Test
    fun getUsers_return_list_with_success() = runBlocking {
        // given
        coEvery { repository.getListUsers() } returns UsersFactory.users

        // when
        val result = getUsers()

        // then
        Assert.assertEquals(result.size + 1, UsersFactory.users.size)
    }

    @Test
    fun getUsers_return_list_with_error() = runBlocking {
        // given
        coEvery { repository.getListUsers() } throws GetUsersException()

        // when
        val result = getUsers()

        // then
        Assert.assertEquals(result.size, 0)
    }
}