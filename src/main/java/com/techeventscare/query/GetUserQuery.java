package com.techeventscare.query;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GetUserQuery {
    private UUID id;
}