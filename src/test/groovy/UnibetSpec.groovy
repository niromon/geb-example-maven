import geb.spock.GebSpec

class UnibetSpec extends GebSpec {

    def "can get to log in unibet.fr"() {
        setup:
            to UnibetHomePage
            loading()
        when:
            login("niromon", "Cadremp1980", "01/03/1980")
        and:
            acknowledgeArjel()

        then:
            waitFor { accountUser.displayed }
            assert accountUser.text() == "niromon"

    }
}