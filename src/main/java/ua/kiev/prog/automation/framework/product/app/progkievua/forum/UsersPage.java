package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.awt.windows.WEmbeddedFrame;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.Widgets.UserWidget;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends ForumPageObject {
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='main_content_section']");
    }


    public UsersPage getUserPage () {
        By userTextLink = By.xpath("//a[@class='button_strip_view_all_members active']");
        WebElement allButton = this.driver().findElement(userTextLink);
        allButton.getText();

        return new UsersPage();
    }

    public UserWidget findUser (String userName)
    {
        //собрать записи
        List<WebElement> list = this.driver().findElements(By.xpath("//div[@id='mlist']/table//tbody/tr"));
        List<UserWidget> usersList = new ArrayList<>();
        for (int i = 1; i <= list.size(); i ++) {
            usersList.add(new UserWidget(this.driver(), By.xpath("//div[@id='mlist']/table//tbody/tr["+i+"]")));
        }
        //найти username
        UserWidget resultUser = null;
        for (UserWidget user : usersList) {
            if (userName.equals(user.getUserName()))
            {
                resultUser = user;
                break;
            }
        }
        //рекурсия если не найден, переход на след. страницу
        if (resultUser == null)
        {
            WebElement nextPage = this.driver().findElement(By.xpath("(//div[contains(@class, 'pagelinks')]//strong/following-sibling::a)[1]"));
            nextPage.click();
            return this.findUser(userName);
        }
        return resultUser;
    }
}

