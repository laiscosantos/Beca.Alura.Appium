package com.alura.appium;

import static org.junit.Assert.assertTrue;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;


public class FeatureCadastro {

    @Test
    public void naoDeve_CadastrarUsuario_ComSenhasQueNaoConferem() {
        AppiumDriver driver =  AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void deve_CadatrarUsuario_ComSenhasQueConferem() throws NoSuchElementException {
        AppiumDriver driver =  AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Bugan", "123", "123");
        telaLogin.BuscarElementos();


    }



}
