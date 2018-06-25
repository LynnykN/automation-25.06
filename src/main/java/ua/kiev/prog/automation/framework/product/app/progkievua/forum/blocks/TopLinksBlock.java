package ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.BlockObject;
import ua.kiev.prog.automation.framework.core.product.component.object.WidgetObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz.HelpPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz.SearchPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.UsersPage;

public class TopLinksBlock extends BlockObject
{
    private WidgetObject _source    = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_home']"));
    private WidgetObject _help      = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_help']"));
    private WidgetObject _search    = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_search']"));
    private WidgetObject _moderate  = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_moderate']"));
    private WidgetObject _profile   = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_profile']"));
    private WidgetObject _users     = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_mlist']"));
    private WidgetObject _logout    = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_logout']"));

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='main_menu']");
    }

    public MainPageLoggedIn getSource ()
    {
        _source.click();
        return new MainPageLoggedIn();
    }
    public HelpPage getHelp ()
    {
        _help.click();
        return new HelpPage();
    }

    public SearchPage getSearch ()
    {
        _search.click();
        return new SearchPage();
    }

    public void getModarate ()
    {
        _moderate.click();
        // TODO return
    }

    public void getProfile ()
    {
        _profile.click();
        // TODO return
    }

    public UsersPage getUsers ()
    {
        _users.click();
        return new UsersPage();
    }

    public void getLogout ()
    {
        _logout.click();
        // TODO return
    }
}
