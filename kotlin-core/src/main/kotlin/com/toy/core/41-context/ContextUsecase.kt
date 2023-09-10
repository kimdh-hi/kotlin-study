package com.toy.core.`41-context`

data class Won(val money: Int)
data class Dollar(val money: Int)

//외부 api 또는 라이브러리로 취급 (내부 조작 불가)
class ExchangeRateProvider {
  val wonToDollar = 1.3
  val dollarToWon = 1 / wonToDollar
}

interface ExchangeRateProviderContext {
  val exchangeRateProvider: ExchangeRateProvider
}

context(ExchangeRateProviderContext)
fun RavenueCalculator(): Won {
  val wonRevenue = Won(1300)
  val dollarRevenue = Dollar(5)
  return wonRevenue + dollarRevenue
}

context(ExchangeRateProviderContext)
operator fun Won.plus(dollar: Dollar): Won {
  return Won((this.money + dollar.money * exchangeRateProvider.dollarToWon).toInt())
}
