package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.repository.MemoRepository;
import com.sparta.week03.dto.MemoRequestDto;
import com.sparta.week03.sevice.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @PostMapping("/api/memos/{id}")
    public String checkPW(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.check(id, requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getMemos(@PathVariable Long id) {
        return memoRepository.findById(id);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }
}