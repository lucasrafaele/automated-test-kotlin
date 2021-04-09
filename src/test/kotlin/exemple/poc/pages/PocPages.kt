package exemple.poc.pages

import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.MatcherAssert.assertThat
import exemple.poc.utils.ChromeConfig

class PocPages(
    private val chromeConfig: ChromeConfig
){
    fun openGoogle(){
        chromeConfig.driver.get("https://www.youtube.com");

        assertThat(chromeConfig.driver.getTitle(), containsString("YouTube"));
    }

    fun search(name: String?){
        chromeConfig.fillInput(name, chromeConfig.findElementByName("search_query"))
    }

    fun clickSearchIcon(){
        chromeConfig.click(chromeConfig.findElementById("search-icon-legacy"))
    }

    fun viewSuperMeiaChannel(name: String?){
        chromeConfig.findElementByText(name)
    }
}