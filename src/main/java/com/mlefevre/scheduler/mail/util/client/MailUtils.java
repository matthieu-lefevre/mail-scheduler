package com.mlefevre.scheduler.mail.util.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MailMessage Utils
 * <br/><br/>
 * Contains all necessary methods to manage mails
 */
public class MailUtils {

    /**
     * Email Regex
     */
    private static final String emailRegEx = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";


    /**
     * Check an email according to a regular expression
     *
     * @param email
     * @return true or false if given email is good
     */
    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean isEmail = matcher.matches();

        return isEmail;
    }

}
