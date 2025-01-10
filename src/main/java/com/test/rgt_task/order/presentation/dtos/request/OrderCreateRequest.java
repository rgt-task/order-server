package com.test.rgt_task.order.presentation.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrderCreateRequest(@NotBlank @Size(min = 2, max = 50) String name,

								 @NotBlank int quantity

) {
}


