package com.ll.server.domain.user.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.server.domain.user.user.dto.UserRequest;
import com.ll.server.domain.user.user.entity.User;
import com.ll.server.domain.user.user.service.UserService;
import com.ll.server.global.rsData.RsData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ApiV1UserController {

    private final UserService userService;

    /**
     * 네이버 로그인 URL 생성 및 리다이렉트
     */
    @GetMapping("/login")
    public ResponseEntity<String> login() {
        try {
            // 네이버 인증 URL 생성
            String authorizeUrl = userService.getNaverAuthorizeUrl("authorize");
            return ResponseEntity.ok(authorizeUrl);
        } catch (Exception e) {
            // 에러 발생 시 적절한 응답 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate Naver authorization URL");
        }
    }
}



