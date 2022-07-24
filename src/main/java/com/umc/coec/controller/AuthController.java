package com.umc.coec.controller;

import com.umc.coec.dto.auth.EmailDupCheckDto;
import com.umc.coec.dto.auth.JoinDto;
import com.umc.coec.dto.auth.NicknameDupCheckDto;
import com.umc.coec.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AuthController {

      private final Logger logger= LoggerFactory.getLogger(getClass());
      private final AuthService authService;



      @GetMapping("/api/v1/auth/email/{emailDto}/exist")
      public ResponseEntity<?> checkEmailAvailable(@Validated @PathVariable EmailDupCheckDto emailDto){
            if(authService.isEmailAvailable(emailDto))  return new ResponseEntity<>("이미 사용중인 이메일입니다.",HttpStatus.CONFLICT);
            return new ResponseEntity<>("사용 가능한 이메일입니다.",HttpStatus.OK);
      }
      @GetMapping("/api/v1/auth/nickname/{nicknameDto}/exist")
      public ResponseEntity<?> checkNicknameAvailable(@Validated @PathVariable NicknameDupCheckDto nicknameDto){
            if(authService.isNicknameAvailable(nicknameDto))  return new ResponseEntity<>("이미 사용중인 닉네임입니다.",HttpStatus.CONFLICT);
            return new ResponseEntity<>("사용 가능한 닉네임입니다.",HttpStatus.OK);
      }

      @PostMapping("/api/v1/auth/join")
      public ResponseEntity<?> join(
                  @Validated @RequestBody JoinDto joinDto,
                  BindingResult bindingResult
      ){
            logger.info("joinDto : {}",joinDto.toString());

            //유효성 검사 실패시 어떤 필드가 실패했는지 반환하는 로직
            if(bindingResult.hasErrors()){
                  Map<String,String> errorMap = new HashMap<>();
                  for (FieldError error : bindingResult.getFieldErrors()){
                        errorMap.put(error.getField(),error.getDefaultMessage());
                  }
                  return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
            }

            if (authService.join(joinDto))return new ResponseEntity<>("회원가입이 완료되었습니다.",HttpStatus.CREATED);
            return new ResponseEntity<>("회원가입에 실패하였습니다.",HttpStatus.BAD_REQUEST);
      }

}
