package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends PageObjectBase {

    private MobileElement botaoCadastro;
    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void BuscarElementos() {
        botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);

    }
}
