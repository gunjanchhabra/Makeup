package com.data.network

import com.data.TestData.errorResponse
import com.data.TestData.productDomainModel
import com.data.TestData.productItemDto
import com.data.api.ApiService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException


class NetworkServiceImplTest {
    private val apiService: ApiService = mockk()

    private lateinit var networkService: NetworkService

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        networkService = NetworkServiceImpl(apiService, testDispatcher)
    }

    @Test
    fun `getProducts() returns  on success Result`() = runTest {
        coEvery { apiService.getProducts() } returns mutableListOf(productItemDto)
        val result = networkService.fetchProductList()
        assertEquals(result, Result.success(mutableListOf(productDomainModel)))
    }

    @Test
    fun `getProducts() on HttpException in api call returns failure Result with exception message`() =
        runBlocking {
            coEvery { apiService.getProducts() } throws HttpException(errorResponse)

            val result = networkService.fetchProductList()

            assert(result.isFailure)
        }

    @Test
    fun `getProductDetail() returns on success Result`() = runBlocking {
        coEvery {
            apiService.getProductDetail(1044)
        } returns productItemDto


        val result = networkService.fetchProductDetail(1044)

        assertEquals(result, Result.success(productDomainModel))
    }

    @Test
    fun `getProductDetail() on HttpException in api call returns failure Result with exception message`() =
        runBlocking {
            coEvery {
                apiService.getProductDetail(
                    1044,
                )
            } throws HttpException(
                errorResponse
            )

            val result = networkService.fetchProductDetail(1044)

            assert(result.isFailure)
        }

}