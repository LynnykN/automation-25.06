package ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.widget.Button;
import ua.kiev.prog.automation.framework.core.product.component.object.widget.TextBox;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

public class SearchPage extends ForumPageObject{
    private TextBox _searchbox = new TextBox(this.driver(), By.xpath("//span[@class='enhanced']//input[@name='search']"));
    private Button _searchBtn = new Button(this.driver(), By.xpath("//input[@name='submit']"));


    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//div[@id='main_content_section']");
    }


    final public SearchPage search (String search)
    {
        _searchbox.setValue(search);
        System.out.println(_searchbox.getValue());
        _searchBtn.push();

        return new SearchPage();
    }
}
