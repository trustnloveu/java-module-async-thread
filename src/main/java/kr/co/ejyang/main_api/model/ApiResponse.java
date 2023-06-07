package kr.co.ejyang.main_api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    // 반환 메세지
    @NotNull
    private String message;

    // 응답 코드값
    @NotNull
    private String code;

    // HTTP 상태값
    @NotNull
    private Integer httpstatus;

    // 반환 데이
    private T data;

    /*******************************************************************************************
     * < 생성자 1 >
     *  - 메세지
     *  - 코드
     *  - HTTP 상태값
     *******************************************************************************************/
    public ApiResponse(String message, String code, Integer httpstatus) {
        this.message = message;
        this.code = code;
        this.httpstatus = httpstatus;
    }

    /*******************************************************************************************
     * < 생성자 2 >
     *  - 메세지
     *  - 코드
     *  - HTTP 상태값
     *  - 데이터
     *******************************************************************************************/
    public ApiResponse(String message, String code, Integer httpstatus, T data) {
        this.message = message;
        this.code = code;
        this.httpstatus = httpstatus;
        this.data = data;
    }

    /*******************************************************************************************
     * < 유틸 함수 >
     *  - 정상 응답 확인
     *  - 200 이상, 230 미만
     *******************************************************************************************/
    public boolean isSuccessReturn() {
        if (200 <= this.getHttpstatus() && this.getHttpstatus() < 230)
            return true;
        else
            return false;
    }

    /*******************************************************************************************
     * < 유틸 함수 >
     *  - ApiResponse 모델 Wrapper
     *  - ResponseEntity 객체로 치환
     *******************************************************************************************/
    public static ResponseEntity<?> returnByApiResponse(ApiResponse apiResponse) {
        return ResponseEntity.status(apiResponse.getHttpstatus()).body(apiResponse);
    }

}
