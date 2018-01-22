import geb.Page
import org.openqa.selenium.InvalidElementStateException

class UnibetHomePage extends Page {

    static at = { title == "Unibet.fr : Paris sportifs, Turf, Hippiques et Poker en ligne." }

    static content = {
        loginBox { $("li#login-box") }
        accountUser { $("#meta-user span.ui-username", 0) }
        loginButton { $("input.button-login", 0) }
        acknowledgeArjelButton { $("a#modal-arjel-confirm") }
        username { $("input.form-username") }
        password { $("input.form-password") }
        dob { $("input.form-dob") }
    }

    def loading() {
        waitFor() { loginBox.displayed }
    }

    def acknowledgeArjel() {
        waitFor(10) { acknowledgeArjelButton.displayed }
        acknowledgeArjelButton.click()
    }

    void login(String user, String pass, String birth) {
        try {username = user} catch (InvalidElementStateException e) {}
        try {password = pass} catch (InvalidElementStateException e) {}
        try {dob = birth} catch (InvalidElementStateException e) {}
        loginButton.click()
    }
}
