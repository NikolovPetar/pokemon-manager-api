package com.demo.projects.exception.util;

import com.demo.projects.exception.BaseException;
import com.demo.projects.dto.error.ErrorDTO;
import com.demo.projects.dto.error.InvalidDetailDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExceptionUtils {

    private ExceptionUtils() {}

    public static ErrorDTO buildError(BaseException e, String source) {
        return ErrorDTO.builder()
                .code(e.getCode())
                .source(source)
                .message(e.getMessage())
                .details(buildInvalidDetails(e.getInvalidDetails()))
                .build();
    }
    private static List<InvalidDetailDTO> buildInvalidDetails(Map<String, String> invalidDetails) {
        if (invalidDetails == null) {
            return null;
        }
        var result = new ArrayList<InvalidDetailDTO>();
        for (var entry : invalidDetails.entrySet()) {
            result.add(InvalidDetailDTO.builder().name(entry.getKey()).reason(entry.getValue()).build());
        }
        return result;
    }
}