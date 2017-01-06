package com.mvp.ptrade.Model.Responses;

import com.mvp.ptrade.Model.Basic.Mail;
import com.mvp.ptrade.Model.Basic.Response;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class MailResponse extends Response {
    private Mail mail;
    public Mail getMail() {
        return mail;
    }
    public void setMail(Mail mail) {
        this.mail = mail;
    }
}
