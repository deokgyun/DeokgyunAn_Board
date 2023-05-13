package com.example.task;

import com.example.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class TaskApplicationTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetTime(){
        log.info(boardMapper.getTime());
    }

}
