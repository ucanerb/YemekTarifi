package bilgeadam.controller;

import bilgeadam.dto.ForgotPasswordMailResponseDto;
import bilgeadam.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/mail")
@RestController
@RequiredArgsConstructor
public class MailSenderController {
    private final MailSenderService mailSenderService;

    @PostMapping("/forgot-password")
    public ResponseEntity<Boolean> forgotPasswordMail(@RequestBody ForgotPasswordMailResponseDto dto){
        return ResponseEntity.ok(mailSenderService.sendMailForgotPassword(dto));
    }
}
