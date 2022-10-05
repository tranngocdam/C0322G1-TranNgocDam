package com.sprint2.service.impl;

import com.sprint2.model.AppUsers;
import com.sprint2.repository.IAppUsersRepository;
import com.sprint2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IAppUsersRepository iAppUsersRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public AppUsers findByName(String name) {
        return iAppUsersRepository.findAppUserByName(name);
    }

    @Override
    public String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException {
        String user = iAppUsersRepository.existsByUserName(username);
        AppUsers appUser = iAppUsersRepository.findAppUserByName(username);
        if (user != null) {
            sendVerificationEmailForResetPassWord(username, username);
        }
        return user;
    }

    @Override
    public void saveNewPassword(String password, String name) {
        this.iAppUsersRepository.saveNewPassword(password, name);
    }

    @Override
    public List<AppUsers> findAll() {
        return iAppUsersRepository.findAll();
    }

    @Override
    public void save(AppUsers appUsers) {
        iAppUsersRepository.save(appUsers.getUsername(), appUsers.getPassword());
    }

    @Override
    public Optional<AppUsers> findById(Integer id) {
        return iAppUsersRepository.findById(id);
    }

    @Override
    public void edit(AppUsers appUsers) {
        iAppUsersRepository.edit(appUsers.getUsername(), appUsers.getPassword(), appUsers.getId());
    }

    @Override
    public void deleteUser(int id) {
        iAppUsersRepository.deleteUser(id);
    }

    @Override
    public Boolean existsUsername(String username) {
        return username.equals(iAppUsersRepository.existsByUserName(username));
    }
    public void sendVerificationEmailForResetPassWord(String userName, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password/" + userName;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("sangnguyenjp97@gmail.com","CODE GYM");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link Xác thực( nhấn vào đây)!</a></h3>" +
                "<p>CODE GYM</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
