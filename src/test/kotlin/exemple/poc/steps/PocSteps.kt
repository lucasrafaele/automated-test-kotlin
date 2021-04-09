package exemple.poc.steps

import exemple.poc.pages.PocPages
import io.cucumber.java.pt.Dado
import io.cucumber.java.pt.Quando
import exemple.poc.utils.ChromeConfig
import io.cucumber.java.pt.Entao

class PocSteps(
    private val basePocPages: PocPages,
    private val chromeConfig: ChromeConfig
) {

    @Dado("que acesso o youtube")
    fun que_acesso_o_youtube() {
        chromeConfig.startChorme()
        basePocPages.openGoogle()
        chromeConfig.stopChrome()
    }

    @Quando("digito <{string}>")
    fun digito(name: String?) {
        chromeConfig.startChorme()
        basePocPages.openGoogle()
        basePocPages.search(name)
        chromeConfig.stopChrome()
    }

    @Quando("clico em buscar <{string}>")
    fun clico_em_buscar(name: String?) {
        chromeConfig.startChorme()
        basePocPages.openGoogle()
        basePocPages.search(name)
        basePocPages.clickSearchIcon()
        chromeConfig.stopChrome()
    }

    @Entao("devo ver o canal do <{string}>")
    fun devo_ver_o_canal_do(name: String?)  {
        chromeConfig.startChorme()
        basePocPages.openGoogle()
        basePocPages.search(name)
        basePocPages.clickSearchIcon()
        basePocPages.viewSuperMeiaChannel(name)
        chromeConfig.stopChrome()
    }
}