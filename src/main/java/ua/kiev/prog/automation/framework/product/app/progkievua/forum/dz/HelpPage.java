package ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

public class HelpPage extends ForumPageObject {
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='main_content_section']");
    }

/*
    private By _text = By.xpath("//h3[@class='catbg']");

    public HelpPage getText ()
    {
       this.component().session().driver().findElement(_text).getText();
       return new HelpPage();
    }*/

    public HelpPage getHelpPage ()
    {
        By textLink = By.xpath("//a[@class='firstlevel']");
        WebElement headerText = this.driver().findElement(textLink);
        headerText.getText();

        return new HelpPage();
    }


}


