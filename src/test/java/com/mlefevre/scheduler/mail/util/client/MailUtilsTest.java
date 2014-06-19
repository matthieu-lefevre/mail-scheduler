package com.mlefevre.scheduler.mail.util.client;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailUtilsTest {

    @Test
    public void checkEmailTest_Success() {
        String emailToCheck = "matthieu.lefevre@soat.fr";

        assertTrue(MailUtils.checkEmail(emailToCheck));
    }

    @Test
    public void checkEmailTest_NoDomainFail() {
        String emailToCheck = "matthieu.lefevre";

        assertFalse(MailUtils.checkEmail(emailToCheck));
    }

    @Test
    public void checkEmailTest_NoExtensionFail() {
        String emailToCheck = "matthieu.lefevre@soat";

        assertFalse(MailUtils.checkEmail(emailToCheck));
    }

    @Test
    public void checkEmailTest_NoNameFail() {
        String emailToCheck = "@soat.fr";

        assertFalse(MailUtils.checkEmail(emailToCheck));
    }

    @Test
    public void checkEmailTest_NoAtSignFail() {
        String emailToCheck = "matthieu.lefevresoat.fr";

        assertFalse(MailUtils.checkEmail(emailToCheck));
    }

    @Test
    public void checkEmailTest_WrongCharacterFail() {
        assertFalse(MailUtils.checkEmail("matthieu.lefevre @soat.fr"));
        assertFalse(MailUtils.checkEmail("matthieu./lefevre@soat.fr"));
        assertFalse(MailUtils.checkEmail("matthieu.lefèvre@soat.fr"));
    }


}
