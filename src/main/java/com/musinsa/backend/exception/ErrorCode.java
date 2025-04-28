package com.musinsa.backend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 리소스입니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    INVALID_REQUEST_CATEGORY(HttpStatus.BAD_REQUEST , "카테고리 정보가 누락되었습니다."),
    INVALID_REQUEST_CATEGORY_NULL(HttpStatus.NOT_FOUND , "등록된 카테고리 정보가 없습니다."),
    INVALID_REQUEST_BRAND(HttpStatus.BAD_REQUEST , "브랜드 정보가 누락되었습니다."),
    INVALID_REQUEST_BRAND_NULL(HttpStatus.NOT_FOUND , "등록된 브랜드 정보가 없습니다."),
    REQUIRED_PARAMETER_MISSING(HttpStatus.BAD_REQUEST, "필수 조건이 누락된 요청입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "처리 중 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String message;

}