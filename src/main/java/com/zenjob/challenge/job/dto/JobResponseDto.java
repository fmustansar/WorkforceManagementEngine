package com.zenjob.challenge.job.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class JobResponseDto {
    UUID jobId;
}
