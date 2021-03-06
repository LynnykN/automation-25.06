package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.TestResultType;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.LoginPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.UsersPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.Widgets.UserWidget;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks.TopLinksBlock;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.dz.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class LoginTest extends Test
{


    @Override
    public String name()
    {
        return "Login to forum test";
    }


    @Override
    public void data(List<Map<String, String>> testCases)
    {
        Map<String, String> testCase1 = new HashMap<>();
        testCase1.put("username", "user1");
        testCase1.put("password", "pass1");
        testCase1.put("result",   TestResultType.FAILED.toString());
        testCases.add(testCase1);

        Map<String, String> testCase2 = new HashMap<>();
        testCase2.put("username", "n.yaroshenko072@gmail.com");
        testCase2.put("password", "kakulBka");
        testCase2.put("result",    TestResultType.SUCCESS.toString());
        testCases.add(testCase2);
    }


    @Override
        public void beforeTest()
        {
            // Вывод в консоль
            System.out.println("TEST_INFO: " + this.name() + " | PHASE: BEFORE RUN");
        }

    @Override
    public void test(Map<String, String> testCase) {

        String username = testCase.get("username");
        String password = testCase.get("password");
        String result   = testCase.get("result");

        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: TEST");

        // Получаем главную страницу
        MainPage mainPage   = Component.getSingleton(Forum.class).mainPage();
        // Переходим на страницу логина
        LoginPage loginPage = mainPage.getLoginPage();
        // Заходим на форум
        MainPageLoggedIn dashboard = loginPage.login(username, password);
        dashboard.takeScreenshot();
        this.assertEquals(result, dashboard.getResult());

        if (dashboard.getResult() == TestResultType.SUCCESS)
        {

            // Выводим в консоль имя пользователя на форуме
            System.out.println("Name: " + dashboard.getUsername());

            //  домашнее задание
            BoardPage board = dashboard.getBoardPage("QA Automation");
            TopicPage topic = board.getTopicPage("QA Automation Tetris 14 02 2018");
            List<String> authors = topic.getAuthors();
            for (String author : authors) {
                System.out.println("Author: " + author);
            }


            UsersPage users = topic.topLinks().getUsers();
            UserWidget user =  users.findUser("Alejandro");
            System.out.println(user.getRegistrationDate());


            /*  TopLinksBlock topLinksBlock = dashboard.topLinks();
            HelpPage helpPage = topLinksBlock.getHelp();
            UsersPage usersPage = topLinksBlock.getUsers();
            SearchPage searchPage = topLinksBlock.getSearch();
            SearchPage dashboard1 = searchPage.search("test");*/


            // Ждём 10 сек, с перехватом исключения на прерывание выполнения потока и игнорируем его
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) { /* Игнорируем */ }
        }
    }




    @Override
    public void afterTest()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
    }
}
