package kr.co.ejyang.main_api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import kr.co.ejyang.main_api.model.ApiResponse;

@Slf4j
@RequiredArgsConstructor
@Service
public class ThreadService {

    /*******************************************************************************************
     * < Thread ::: 'sampleThreadA' >
     *******************************************************************************************/
    @Async("sampleThreadA")
    public CompletableFuture<ApiResponse> sampleServiceA() {
        return CompletableFuture.supplyAsync(() -> {
            return new ApiResponse("Thread A Called", "0000", 200);
        });
    }

    /*******************************************************************************************
     * < Thread ::: 'sampleThreadB' >
     *******************************************************************************************/
    @Async("sampleThreadB")
    public CompletableFuture<ApiResponse> sampleServiceB() {
        return CompletableFuture.supplyAsync(() -> {
            return new ApiResponse("Thread B Called", "0000", 200);
        });
    }

}
