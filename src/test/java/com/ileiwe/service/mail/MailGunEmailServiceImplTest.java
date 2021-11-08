package com.ileiwe.service.mail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MailGunEmailServiceImplTest {
    @Autowired
    @Qualifier("mailgun")
    EmailService emailService;
@BeforeEach
    void setUp(){

}
@Test
    void sendEmailWithMailGunTest(){
    //create message
    Message mail= Message.builder()
            .from("kingsleynwafor54@gmail.com")
            .to("nuelhealth01@gmail.com")
            .subject("Test Email")
            .body("This is the body of my test email")
            .build();
    //call send method

    MailResponse response=emailService.send(mail);
    assertTrue(response.isSuccessful());
    //
}
}