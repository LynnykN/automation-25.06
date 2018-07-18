package ua.kiev.prog.automation.framework;

import ua.kiev.prog.automation.framework.product.app.ProgKievUa;

public class App
{
    static private boolean _standalone;

    static public boolean isStandalone()
    {
        return _standalone;
    }

    static public void setUpChromeDriver()
    {
        if (!_standalone) {
            String propertyName = "webdriver.chrome.driver";
            String propertyValue = "C:\\chromedriver_win32\\chromedriver.exe";
            // Если параметер еще не установлен то установить его
            if (System.getProperty(propertyName) == null)
                System.setProperty(propertyName, propertyValue);
        }
    }


    static public void main (String[] args)
    {
        if (args.length > 0 && args[0].equals("standalone"))
            _standalone = true;
        setUpChromeDriver();
        ProgKievUa product = new ProgKievUa();
        product.forum().setURL("https://prog.kiev.ua/forum");
        product.runTests();

    }


}
