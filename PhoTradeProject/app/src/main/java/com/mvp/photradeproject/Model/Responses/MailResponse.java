package com.mvp.photradeproject.Model.Responses;

import com.mvp.photradeproject.Model.Basic.Mail;
import com.mvp.photradeproject.Model.Basic.Response;

/**
 * Created by Zackzack on 17/12/2016.
 */

public class MailResponse extends Response{
    private Mail mail;
    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }
}
