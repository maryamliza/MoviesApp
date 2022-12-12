package com.mliza.moviesapp.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule

open class BaseTest {
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
}