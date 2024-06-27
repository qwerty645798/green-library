package com.library.service.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmailSender {

    @Autowired
    private EmailService emailService;

    public void sendEmail(String to, String token) {
        String subject = "그린 도서관 이메일 인증 서비스";
        String emailBody = "링크를 클릭하여 비밀번호 초기화를 완료해주십시오 → http://localhost:8082/verify?token=" + token;
        
        String htmlEmailBody = convertUrlsToLinks(emailBody);
        
        emailService.sendEmail(to, subject, htmlEmailBody);
    }

    public String convertUrlsToLinks(String text) {
        String urlPattern = "(http[s]?://\\S+)";
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(text);
        
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String url = matcher.group(1);
            matcher.appendReplacement(result, "<a href=\"" + url + "\">" + url + "</a>");
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
