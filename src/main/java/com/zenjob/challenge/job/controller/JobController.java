package com.zenjob.challenge.job.controller;

import com.zenjob.challenge.job.dto.JobRequestDto;
import com.zenjob.challenge.dto.ResponseDto;
import com.zenjob.challenge.job.dto.JobResponseDto;
import com.zenjob.challenge.job.entity.Job;
import com.zenjob.challenge.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping(path = "/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping(path = "/{jobId}/cancel")
    @ResponseBody
    public void cancelJobWithShifts(@PathVariable("jobId") UUID jobId) {
        /* FM: Steps
            1.

         */

        jobService.cancel(jobId);
    }


    @PostMapping
    @ResponseBody
    public ResponseDto<JobResponseDto> requestJob(@RequestBody @Valid JobRequestDto dto) {
        Job job = jobService.createJob(UUID.randomUUID(), dto.getStart(), dto.getEnd());
        return ResponseDto.<JobResponseDto>builder()
                .data(JobResponseDto.builder()
                        .jobId(job.getId())
                        .build())
                .build();
    }




}
