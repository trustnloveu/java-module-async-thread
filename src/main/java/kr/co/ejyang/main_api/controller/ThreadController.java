package kr.co.ejyang.main_api.controller;

import kr.co.ejyang.main_api.service.ThreadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

import static kr.co.ejyang.main_api.model.ApiResponse.returnByApiResponse;

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
public class ThreadController {

    private final ThreadService threadService;

    /*******************************************************************************************
     * 1번 쓰레드 호출
     *******************************************************************************************/
    @GetMapping("/sample-thread-a")
    public ResponseEntity<?> sampleControllerA() throws ExecutionException, InterruptedException {
        return returnByApiResponse(threadService.sampleServiceA().get());
    }

    /*******************************************************************************************
     * 2번 쓰레드 호출
     *******************************************************************************************/
    @PostMapping("/sample-thread-b")
    public ResponseEntity<?> sampleControllerB() throws ExecutionException, InterruptedException {
        return returnByApiResponse(threadService.sampleServiceB().get());
    }
}
