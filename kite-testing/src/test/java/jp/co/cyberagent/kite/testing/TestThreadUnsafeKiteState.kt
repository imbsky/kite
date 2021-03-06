package jp.co.cyberagent.kite.testing

import io.kotest.core.spec.style.StringSpec
import io.kotest.experimental.robolectric.RobolectricTest
import io.kotest.matchers.shouldBe
import jp.co.cyberagent.kite.core.state
import jp.co.cyberagent.kite.core.subscribe
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@RobolectricTest
class TestThreadUnsafeKiteState : StringSpec({

  "TestState should work like usual" {
    runTestKiteDsl {
      val state = state { "Kite" }
      state.value shouldBe "Kite"

      var subscriber = "Cat"
      subscribe {
        subscriber = state.value
      }
      subscriber shouldBe "Kite"
      state.value = "Kite Test"
      subscriber shouldBe "Kite Test"
    }
  }
})
