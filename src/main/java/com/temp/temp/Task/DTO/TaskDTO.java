package com.temp.temp.Task.DTO;

import java.util.Date;

public record TaskDTO(String title, String description,String status, String priority, Date duedate, Date createddate, Date updateddate) {
    
}
