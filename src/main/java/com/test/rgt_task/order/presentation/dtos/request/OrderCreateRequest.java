package com.test.rgt_task.order.presentation.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrderCreateRequest(@NotNull @NotBlank @Size(min = 2, max = 50) String food,

								 @Min(1) int quantity

) {
}


