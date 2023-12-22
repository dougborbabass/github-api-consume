package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.data.repository.MainRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetDetailTest {

    private val repository = mockk<MainRepository>()
    private val getDetail = GetUserDetail(repository)


    @Test
    fun getUserDetail_return_with_success() = runBlocking {
        // given
        coEvery { repository.getUserDetail("Douglas") } returns UserDetailFactory.usersDetail

        // when
        val result = getDetail("Douglas")

        // then
        Assert.assertEquals(result.userName, UserDetailFactory.usersDetail.userName)
    }

    @Test
    fun getUserDetail_return_with_error() = runBlocking {
        // given
        coEvery { repository.getUserDetail("Douglas") } returns UserDetailFactory.usersDetail

        // when
        val result = getDetail("Douglas")

        // then
        Assert.assertEquals(result.userName, "")
    }

    @Test
    fun `parametro seguidores deve conter um numero real maior ou igual a zero`() = runBlocking {
        // given
        coEvery { repository.getUserDetail("Douglas") } returns UserDetailFactory.usersDetail

        // when
        val result = getDetail("Douglas")

        // then
        Assert.assertTrue(result.followers >= 0)
    }
}